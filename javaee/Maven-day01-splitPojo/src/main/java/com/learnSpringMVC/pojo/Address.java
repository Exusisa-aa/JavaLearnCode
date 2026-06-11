package com.learnSpringMVC.pojo;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Repository;

@Repository("address")
@Alias("Address")
public class Address {
    private String city;
    private String province;



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}
