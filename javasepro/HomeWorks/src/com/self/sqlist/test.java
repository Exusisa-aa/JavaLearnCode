package com.self.sqlist;

public class test {
    public static void main(String[] args) {
        // 1.初始化顺序表
        sqList list = new sqList();

        // 2.依次插入1,2,3,4,5
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // 3.打印顺序表
        list.printSqList();

        // 4.打印长度
        System.out.println(list.getLength());

        // 5.判断是否为空
        list.isEmpty();

        // 6.打印第三个元素
        list.printByIndex(3);

        // 7.查找元素5
        list.isExist(5);

        // 8.在第四个元素位置插上6
        list.insert(6, 4);

        // 9.打印顺序表
        list.printSqList();

        // 10.删除第三个元素
        list.delete(3);

        // 11.打印顺序表
        list.printSqList();

    }
}
