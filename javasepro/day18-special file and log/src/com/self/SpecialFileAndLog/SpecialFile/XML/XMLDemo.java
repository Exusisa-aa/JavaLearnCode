package com.self.SpecialFileAndLog.SpecialFile.XML;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class XMLDemo {
    public static void main(String[] args) {
        //创建dom4j解析对象
        SAXReader reader = new SAXReader();

        //把XML文件读成Document文件
        Document document;
        try {
            document = reader.read("day18-special file and log\\src\\com\\self\\SpecialFileAndLog\\SpecialFile\\XML\\k.xml");
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }

        //获取根元素的对象
        Element rootElement = document.getRootElement();
        System.out.println(rootElement.getName());

        //获取所有一级元素对象
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            System.out.println(element.getName());
        }

        //获取一级对象下的信息
        for (Element element : elements) {
            System.out.println(element.getName() + element.attributeValue("id"));
            List<Element> elements1 = element.elements();
            for (Element element1 : elements1) {
                System.out.println(element1.getName() + "->" + element1.getText());
            }
        }
    }
}
