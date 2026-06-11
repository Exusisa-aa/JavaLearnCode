package com.self.learnFile.pojo.implement;

import com.self.learnFile.pojo.Collection;

import java.util.*;

public class CollectionImp implements Collection {
    private int[] array;
    private List<String> list;
    private Set<String> set;
    private Map<String, String> map;
    private Properties properties;

    public void setArray(int[] array) {
        this.array = array;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "CollectionImp{" +
                "array=" + Arrays.toString(array) +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }

    @Override
    public void print() {
        System.out.println("array: " + array);
        System.out.println("list: " + list);
        System.out.println("set: " + set);
        System.out.println("map: " + map);
        System.out.println("properties: " + properties);
    }
}
