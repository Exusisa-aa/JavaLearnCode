package com.self.more.Regex.RegexFindBasis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void main(String[] args) {
        String date = "来黑马程序员学习java，\n" +
                      "电话：18666668888,18699997777，\n" +
                      "或者邮箱联系：boniu@itcast.com.cn，\n" +
                      "座机电话：01036547895,010-989851256，\n" +
                      "邮箱：bozai@itcast.com，\n" +
                      "邮箱：dlei0009@163.cn，\n" +
                      "热线电话：400-618-9090,400-618-4000,4006184000,4006189090";

        String regex = "(1[3-9]\\d{9})|(0\\d{2,7}-?[1-9]\\d{4,19})|\\w{2,}@\\w{2,20}(\\.\\w{2,10}){1,2}|(400-?\\d{3,7}-?\\d{3,7})";

        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(date);

        while (m.find()){
            System.out.println(m.group());
        }
    }
}
