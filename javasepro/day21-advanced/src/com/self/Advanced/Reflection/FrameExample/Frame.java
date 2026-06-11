package com.self.Advanced.Reflection.FrameExample;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class Frame {
    public static void saveObject(Object obj) {
        try (
                PrintStream ps = new PrintStream(new FileOutputStream("day21-advanced\\src\\com\\self\\Advanced\\Reflection\\FrameExample\\data.txt",true))
        ){
            Class c = obj.getClass();
            ps.println("----------" + c.getSimpleName() + "--------------");
            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String name = field.getName();
                String value = field.get(obj) + "";
                ps.println(name + ":" + value);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
