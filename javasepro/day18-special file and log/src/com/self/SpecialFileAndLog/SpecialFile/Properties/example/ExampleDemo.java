package com.self.SpecialFileAndLog.SpecialFile.Properties.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

public class ExampleDemo {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();

        prop.load(new FileReader("day18-special file and log\\src\\com\\self\\SpecialFileAndLog\\SpecialFile\\Properties\\example\\k.properties"));
        if (prop.containsKey("小明")) {
            prop.setProperty("小明","26");
        }

        prop.store(new FileWriter("day18-special file and log\\src\\com\\self\\SpecialFileAndLog\\SpecialFile\\Properties\\example\\k.properties"),"saved");

        prop.load(new FileReader("day18-special file and log\\src\\com\\self\\SpecialFileAndLog\\SpecialFile\\Properties\\example\\k.properties"));
        prop.forEach((k,v) -> System.out.println(k + "=" + v));
    }
}
