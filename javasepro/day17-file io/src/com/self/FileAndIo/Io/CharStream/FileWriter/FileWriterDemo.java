package com.self.FileAndIo.Io.CharStream.FileWriter;

import java.io.FileWriter;
import java.io.Writer;

public class FileWriterDemo {
    public static void main(String[] args) {
        //字符输出流写出数据后，需要刷新或者关闭流，写出的数据才生效
        //flush刷新  close关闭
        //写入一堆数据时,系统先把数据全部调到缓冲区，当缓冲区接收到刷新或者关闭的命令时，将缓冲区的数据一次写入文件，防止多次调用文件而造成的性能问题


        try (
                //覆盖原数据
//                Writer fw = new FileWriter("day17-file io\\src\\com\\self\\FileAndIo\\Io\\CharStream\\FileWriter\\222.txt")
                //追加新数据
                Writer fw = new FileWriter("day17-file io\\src\\com\\self\\FileAndIo\\Io\\CharStream\\FileWriter\\222.txt",true)
        ) {
            //写入一个字符
            fw.write('a');
            fw.write(97);
            fw.write('陈');
            fw.write("\r\n");
            //写入一个字符串
            fw.write("今年的top1是donk");
            fw.write("\r\n");
            //写入一个字符串的一部分
            fw.write("今年的top2是monesy1111111",0,14);
            fw.write("\r\n");
            //写入一个字符数组
            char[] buffer = {'今','年','的','t','o','p','3','是','z','y','w','o','o'};
            fw.write(buffer);
            fw.write("\r\n");
            //写入一个字符数组一部分
            char[] buffer0 = {'今','年','的','t','o','p','4','是','n','i','k','o','1'};
            fw.write(buffer0,0,12);
            fw.write("\r\n");
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
