package com.self.FileAndIo.Io.ByteStream.FileOutputStream;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class FileOutputStreamDemo {
    public static void main(String[] args) throws Exception{
        //覆盖原数据
//        OutputStream os = new FileOutputStream("day17-file io\\src\\com\\self\\FileAndIo\\Io\\ByteStream\\FileOutputStream\\eee.txt");
        //追加新数据
        OutputStream os = new FileOutputStream("day17-file io\\src\\com\\self\\FileAndIo\\Io\\ByteStream\\FileOutputStream\\eee.txt",true);

        os.write("\r\n".getBytes());
        os.write(97);
        os.write('e');
        os.write('定');//不能输入一个汉字，汉字为三个字节，而该方法仅仅只能输入一个字节，否则出现乱码


        //写入数组
        os.write("今年的top1是donk".getBytes());
        os.write("\r\n".getBytes());
        os.write("今年的top2是monesy ".getBytes());
        os.write("\r\n".getBytes());
        os.write("今年的top3是zywoo111111".getBytes(),0,21);

        os.close();
    }
}
