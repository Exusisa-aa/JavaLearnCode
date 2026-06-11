package com.self.learnFile.pojo.implement;

import com.self.learnFile.pojo.Worker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository("maintainer")
public class Maintainer implements Worker {
    @Value("${driverClassName}")
    private String name;
    @Value("${url}")
    private String url;
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

    @Override
    public void work() {
        System.out.println(" maintainer work..." + name + url + username + password);
    }
}
