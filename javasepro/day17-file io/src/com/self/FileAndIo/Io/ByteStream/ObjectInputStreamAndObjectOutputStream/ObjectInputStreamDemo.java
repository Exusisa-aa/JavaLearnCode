package com.self.FileAndIo.Io.ByteStream.ObjectInputStreamAndObjectOutputStream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ObjectInputStreamDemo {
    public static void main(String[] args) {
        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("day17-file io\\src\\com\\self\\FileAndIo\\Io\\ByteStream\\ObjectInputStreamAndObjectOutputStream\\222.txt"))
        ) {
            ArrayList<User> list = (ArrayList<User>) ois.readObject();
            list.forEach(System.out::println);
        }catch (Exception e) {
            e.getStackTrace();
        }
    }
}
