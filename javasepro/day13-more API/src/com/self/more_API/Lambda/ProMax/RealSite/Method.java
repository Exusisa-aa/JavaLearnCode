package com.self.more_API.Lambda.ProMax.RealSite;

public class Method {
    public int CompareUp(Double a, Double b) {
        if(a > b){
            return 1;
        } else if (b > a) {
            return -1;
        }
        return 0;
    }

    public int CompareDown(Double a, Double b) {
        if(a > b){
            return -1;
        } else if (b > a) {
            return 1;
        }
        return 0;
    }
}
