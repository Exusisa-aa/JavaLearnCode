package com.hmall.item;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hmall.item.domain.po.Item;
import com.hmall.item.domain.po.ItemDoc;
import com.hmall.item.service.IItemService;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.lucene.search.function.CombineFunction;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.metrics.Stats;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@SpringBootTest(properties = "spring.profiles.active=local")
class ESClientTest {
    private  RestHighLevelClient client;

    @Autowired
    private IItemService itemService;

    @BeforeEach
    void init(){
        client = new RestHighLevelClient(RestClient.builder(
                HttpHost.create("192.168.247.134:9200")
        ));
    }

    @AfterEach
    void close(){
        try {
            client.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void printClient(){
        System.out.println("client:" + client);
    }

    @Test
    void testCreateIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("items");
        request.source(ITEMS_MAPPING, XContentType.JSON);
        client.indices().create(request, RequestOptions.DEFAULT);
    }

    @Test
    void testGetIndex() throws IOException {
        GetIndexRequest request = new GetIndexRequest("items");
        client.indices().get(request, RequestOptions.DEFAULT);
    }

    @Test
    void testDeleteIndex() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("items");
        client.indices().delete(request, RequestOptions.DEFAULT);
    }

    @Test
    void testInsertDocument() throws IOException {
        Item item = itemService.getById(4158256L);
        ItemDoc itemDoc = BeanUtil.copyProperties(item, ItemDoc.class);

        IndexRequest request = new IndexRequest("items").id(itemDoc.getId());
        request.source(JSONUtil.toJsonStr(itemDoc), XContentType.JSON);
        client.index(request, RequestOptions.DEFAULT);
    }

    @Test
    void testDeleteDocument() throws IOException {
        DeleteRequest request = new DeleteRequest("items","4158256");
        client.delete(request, RequestOptions.DEFAULT);
    }

    @Test
    void testGetDocument() throws IOException {
        GetRequest request = new GetRequest("items","4158256");
        GetResponse getResponse = client.get(request, RequestOptions.DEFAULT);
        ItemDoc itemDoc = JSONUtil.toBean(getResponse.getSourceAsString(), ItemDoc.class);
        System.out.println("doc:" +itemDoc );
    }

    @Test
    void testInsertBatch() throws IOException {
        int pageNo = 1;
        int pageSize = 500;
        while (true){
            Page<Item> page = itemService.lambdaQuery()
                    .eq(Item::getStatus, 1)
                    .page(Page.of(pageNo, pageSize));
            List<Item> records = page.getRecords();

            if(records == null || records.isEmpty()){
                return;
            }

            BulkRequest request = new BulkRequest();
            for (Item item : records){
                request.add(new IndexRequest("items")
                        .id(item.getId().toString())
                        .source(JSONUtil.toJsonStr(BeanUtil.copyProperties(item, ItemDoc.class)), XContentType.JSON));
            }
            client.bulk(request, RequestOptions.DEFAULT);
            pageNo++;
        }
    }

    @Test
    void testSearchAll() throws IOException {
        //链接索引库
        SearchRequest request = new SearchRequest("items");
        //构建搜索条件
        request.source()
                .query(QueryBuilders.matchAllQuery());
        //执行搜索
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        //解析结果
        parseResponse(response);
    }

    @Test
    void testBoolQuery() throws IOException {
        //链接索引库
        SearchRequest request = new SearchRequest("items");
        //构建搜索条件
//        request.source()
//                .query(QueryBuilders.matchQuery("name","华为"));
//        request.source()
//                .query(QueryBuilders.multiMatchQuery("华为","name","brand"));
//        request.source()
//                .query(QueryBuilders.termQuery("brand","华为"));
//        request.source()
//                .query(QueryBuilders.rangeQuery("price").gte(500000));
        request.source()
                .query(QueryBuilders.boolQuery()
                        .must(QueryBuilders.matchQuery("name","智能手机").analyzer("ik_smart"))
                        .filter(QueryBuilders.termQuery("brand","华为"))
                        .filter(QueryBuilders.rangeQuery("price").gte(90000).lte(159900)));
        //执行搜索
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        //解析结果
        parseResponse(response);
    }

    @Test
    void testFunctionScoreQuery() throws IOException {
        //链接索引库
        SearchRequest request = new SearchRequest("items");
        //构建搜索条件
        request.source()
                .query(QueryBuilders.functionScoreQuery(
                        QueryBuilders.matchQuery("name","手机"),
                        new FunctionScoreQueryBuilder.FilterFunctionBuilder[]{
                                new FunctionScoreQueryBuilder.FilterFunctionBuilder(
                                        QueryBuilders.termQuery("brand","华为"),
                                        ScoreFunctionBuilders.weightFactorFunction(10)
                                )
                        }
                ).boostMode(CombineFunction.MULTIPLY));
        //执行搜索
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        //解析结果
        parseResponse(response);
    }

    @Test
    void testSortQuery() throws IOException {
        int pageNo = 2;
        int pageSize = 3;
        //链接索引库
        SearchRequest request = new SearchRequest("items");
        //构建搜索条件
        request.source().query(QueryBuilders.matchAllQuery());
        request.source().sort("sold", SortOrder.DESC);
        request.source().sort("price", SortOrder.ASC);
        request.source().from((pageNo-1)*pageSize).size(pageSize);
        //执行搜索
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        //解析结果
        parseResponse(response);
    }

    @Test
    void testSearchAfter() throws IOException {
        int pageSize = 3;
        Object[] searchAfter = null;

        // 模拟翻页:获取前3页数据
        for (int page = 1; page <= 3; page++) {
            System.out.println("========== 第" + page + "页 ==========");

            // 链接索引库
            SearchRequest request = new SearchRequest("items");

            // 构建搜索条件
            request.source().query(QueryBuilders.matchAllQuery());

            // 注意:必须在sort中包含唯一字段(_id)保证排序稳定性
            request.source().sort("sold", SortOrder.DESC);
            request.source().sort("price", SortOrder.ASC);
            request.source().sort("_id", SortOrder.ASC);

            // 设置size和searchAfter
            request.source().size(pageSize);
            if (searchAfter != null) {
                request.source().searchAfter(searchAfter);
            }

            // 执行搜索
            SearchResponse response = client.search(request, RequestOptions.DEFAULT);

            // 解析结果
            parseResponse(response);

            // 获取最后一条记录的sort值作为下一页的searchAfter
            SearchHit[] hits = response.getHits().getHits();
            if (hits.length > 0) {
                searchAfter = hits[hits.length - 1].getSortValues();
            }

            // 如果没有更多数据,退出循环
            if (hits.length < pageSize) {
                break;
            }
        }
    }

    @Test
    void testHighLightQuery() throws IOException {
        //链接索引库
        SearchRequest request = new SearchRequest("items");
        //构建搜索条件
        request.source().query(QueryBuilders.matchQuery("name","手机"));
        request.source().highlighter(
                SearchSourceBuilder.highlight()
                        .field("name")
                        .preTags("<em>")
                        .postTags("</em>"));
        //执行搜索
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        //解析结果
        parseResponse(response);
    }

    @Test
    void testAgg() throws IOException {
        //链接索引库
        SearchRequest request = new SearchRequest("items");
        //构建搜索条件
        request.source()
                .query(QueryBuilders.boolQuery()
                        .filter(QueryBuilders.termQuery("category","手机")));
        request.source().size(0);
        request.source().aggregation(
                AggregationBuilders.terms("cate_agg")
                        .field("brand")
                        .size(10)
                        .subAggregation(
                                AggregationBuilders.stats("cate_stats")
                                        .field("price")
                        )
        );
        //执行搜索
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        //解析结果
        parseResponse(response);
    }



    private static void parseResponse(SearchResponse response) {
        //获取聚合结果
        Aggregations aggregations = response.getAggregations();
        if (aggregations != null && !aggregations.asMap().isEmpty()){
            //获取桶聚合结果
            Terms cateAgg = aggregations.get("cate_agg");
            List<? extends Terms.Bucket> buckets = cateAgg.getBuckets();
            //遍历桶聚合结果
            for (Terms.Bucket bucket : buckets) {
                System.out.println("KEY:"+bucket.getKeyAsString());
                Stats cateStats = bucket.getAggregations().get("cate_stats");
                System.out.println("Count:"+cateStats.getCount());
                System.out.println("Min:"+cateStats.getMin());
                System.out.println("Max:"+cateStats.getMax());
                System.out.println("Avg:"+cateStats.getAvg());
                System.out.println("Sum:"+cateStats.getSum());
            }
        }

        //第一层hit
        SearchHits searchHits = response.getHits();
        //获取总条数
        long value = searchHits.getTotalHits().value;
        System.out.println("总条数:" + value);
        //第二层hit
        SearchHit[] hits = searchHits.getHits();
        //遍历
        for (SearchHit hit : hits) {
            //获取文档内容
            String json = hit.getSourceAsString();
            //转换成对象
            ItemDoc itemDoc = JSONUtil.toBean(json, ItemDoc.class);
            //获取高亮字段
            Map<String, HighlightField> hlf = hit.getHighlightFields();
            //判断是否为空
            if(hlf != null && !hlf.isEmpty()){
                //获取name字段
                String name = hlf.get("name").getFragments()[0].toString();
                //设置name字段
                itemDoc.setName(name);
            }
            System.out.println("itemDoc:" + itemDoc);
        }
    }


    private static final String ITEMS_MAPPING = "{\n" +
            "  \"mappings\": {\n" +
            "    \"properties\": {\n" +
            "      \"id\": {\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"name\":{\n" +
            "        \"type\": \"text\",\n" +
            "        \"analyzer\": \"ik_max_word\"\n" +
            "      },\n" +
            "      \"price\":{\n" +
            "        \"type\": \"integer\"\n" +
            "      },\n" +
            "      \"stock\":{\n" +
            "        \"type\": \"integer\"\n" +
            "      },\n" +
            "      \"image\":{\n" +
            "        \"type\": \"keyword\",\n" +
            "        \"index\": false\n" +
            "      },\n" +
            "      \"category\":{\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"brand\":{\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"sold\":{\n" +
            "        \"type\": \"integer\"\n" +
            "      },\n" +
            "      \"commentCount\":{\n" +
            "        \"type\": \"integer\",\n" +
            "        \"index\": false\n" +
            "      },\n" +
            "      \"isAD\":{\n" +
            "        \"type\": \"boolean\"\n" +
            "      },\n" +
            "      \"updateTime\":{\n" +
            "        \"type\": \"date\"\n" +
            "      }\n" +
            "    }\n" +
            "  }\n" +
            "}";


}