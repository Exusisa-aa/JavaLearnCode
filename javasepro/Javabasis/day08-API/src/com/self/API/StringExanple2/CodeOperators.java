package com.self.API.StringExanple2;
import java.util.Scanner;

public class CodeOperators {
    private Code code;
    public CodeOperators(){

    }

    public CodeOperators(Code codes){
        this.code = codes;
    }



    public void YZM(){
        Scanner sc =  new Scanner(System.in);
        while (true){
            System.out.println(this.code.getCode());
            System.out.print("请输入验证码：");
            if(sc.next().equalsIgnoreCase(this.code.getCode())){
                System.out.println("输入正确");
                break;
            }else {
                System.out.println("输入错误");
                this.code.setCode();
            }
        }
    }
}
