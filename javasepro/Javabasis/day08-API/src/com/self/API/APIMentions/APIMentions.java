package com.self.API.APIMentions;
import com.self.API.APIMentionsVisit1.Program;
import java.util.Scanner;
import java.util.Random;
public class APIMentions {
//    1.同一个包下的程序可以直接访问
    APIMentionsVisit s1 = new APIMentionsVisit();
//    2.访问其他包下的程序必须导报
    Program s2 = new Program();
//    3.访问java自带的程序需要导包,除了java.lang不用导包，可直接调用
    Scanner sc = new Scanner(System.in);
    Random r = new Random();
    String rr = "451"; //java.lang内的程序
//    4.访问多个包下的同名程序，只有一个要在顶部导包，另外的写全地址＋.程序名
    Program a = new Program();
    com.self.API.APIMentionsVisit2.Program aa = new com.self.API.APIMentionsVisit2.Program();
}
