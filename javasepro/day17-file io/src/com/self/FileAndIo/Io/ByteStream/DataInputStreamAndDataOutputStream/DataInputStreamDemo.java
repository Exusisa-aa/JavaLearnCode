package com.self.FileAndIo.Io.ByteStream.DataInputStreamAndDataOutputStream;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataInputStreamDemo {
    public static void main(String[] args) {
        try (
                DataInputStream dis = new DataInputStream(new FileInputStream("day17-file io\\src\\com\\self\\FileAndIo\\Io\\ByteStream\\DataInputStreamAndDataOutputStream\\222.txt"))
        ) {
            System.out.println(dis.readByte());
            System.out.println(dis.readInt());
            System.out.println(dis.readDouble());
            System.out.println(dis.readUTF());
            System.out.println(dis.readBoolean());
        }catch (Exception e) {
            e.getStackTrace();
        }
    }
}
