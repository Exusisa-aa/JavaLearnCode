package com.self.more_API.Lambda.ProMax.StaticSite;

public class Method {
    public static int CompareUp(Double a, Double b) {
        if(a > b){
            return 1;
        } else if (b > a) {
            return -1;
        }
        return 0;
    }

    public static int CompareDown(Double a, Double b) {
        if(a > b){
            return -1;
        } else if (b > a) {
            return 1;
        }
        return 0;
    }
}
