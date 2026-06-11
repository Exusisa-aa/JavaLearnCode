package com.self.API.StringExanple2;

import java.util.Random;

public class Code {
    private String code;

    public Code(){

    }

    public Code(String code){
        this.code = code;
    }

    public void setCode(){
        Random r = new Random();
        String codes = "";
        String a = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (int i = 1; i <= 6; i++) {
            codes += a.charAt(r.nextInt(a.length()));
        }
        this.code = codes;
    }

    public String getCode(){
        return code;
    }
}
