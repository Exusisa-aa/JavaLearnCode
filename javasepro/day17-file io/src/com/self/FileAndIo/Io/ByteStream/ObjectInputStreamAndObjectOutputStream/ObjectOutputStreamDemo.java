package com.self.FileAndIo.Io.ByteStream.ObjectInputStreamAndObjectOutputStream;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class ObjectOutputStreamDemo {
    public static void main(String[] args) {
        try (
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("day17-file io\\src\\com\\self\\FileAndIo\\Io\\ByteStream\\ObjectInputStreamAndObjectOutputStream\\222.txt"))
        ) {
            ArrayList<User> list= new ArrayList<>();
            User u1 = new User("ex1",20,"zhandkf546");
            User u2 = new User("ex2",21,"csdc21");
            User u3 = new User("ex3",22,"gr5g1handk6");
            User u4 = new User("ex4",23,"fjjftgfjtf5");
            User u5 = new User("ex5",24,"drhdhd5");
            Collections.addAll(list,u1,u2,u3,u4,u5);
            oos.writeObject(list);
        }catch (Exception e) {
            e.getStackTrace();
        }
    }
}
