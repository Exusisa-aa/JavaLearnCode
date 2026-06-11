package com.hmall.gateway.filter;

import com.hmall.gateway.config.AuthProperties;
import com.hmall.gateway.utils.JwtTool;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    private final AuthProperties authProperties;

    private final JwtTool jwtTool;

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //拿到请求头
        ServerHttpRequest request = exchange.getRequest();
        //遍历排除路径
        for (String excludePath : authProperties.getExcludePaths()) {
            if(antPathMatcher.match(excludePath,request.getPath().toString())){
                //非登录需要的路径放行
                return chain.filter(exchange);
            }
        }
        //拿到token
        String token = null;
        List<String> authorization = request.getHeaders().get("authorization");
        if(authorization != null && !authorization.isEmpty()){
            token = authorization.get(0);
        }

        //解析token
        Long userId = null;
        try {
            userId = jwtTool.parseToken(token);
        }catch (Exception e){
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        //传递用户信息
        String userInfo = userId.toString();
        ServerWebExchange swe = exchange.mutate()
                .request(builder -> builder.header("user-info", userInfo))
                .build();

        //放行
        return chain.filter(swe);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
