package com.self.sqlist;
public class sqList {
    private static final int MAXSIZE = 100;
    private int[] data;
    private int length;

    // 构造函数
    public sqList() {
        this.data = new int[MAXSIZE];
        this.length = 0;
    }

    // 获取长度
    public int getLength(){
        return this.length;
    }

    // 添加元素
    public void add(int n){
        this.data[this.length] = n;
        this.length++;
    }

    // 插入元素
    public void insert(int x, int index) {
        if (index - 1 < 0 || index - 1 > this.length) {
            System.out.println("out of index");
            return;
        }

        for (int i = this.length; i > index - 1; i--) {
            this.data[i] = this.data[i - 1]; // 最多插在末尾
        }

        this.data[index - 1] = x;
        this.length++;
    }

    // 打印元素
    public void printSqList() {
        for (int i = 0; i < this.length; i++) {
            System.out.print((this.data[i] + " "));
        }
        System.out.println();
    }

    // 判断是否为空
    public void isEmpty() {
        if (this.length == 0) {
            System.out.println("empty");
        }else{
            System.out.println(("not empty"));
        }
    }

    // 打印特定元素
    public void printByIndex(int index) {
        if (index - 1 < 0 || index - 1 >= this.length) {
            System.out.println(("out of index"));
            return;
        }
        System.out.println((this.data[index - 1]));
    }

    // 查找
    public void isExist(int x) {
        for (int i = 0; i < this.length; i++) {
            if (this.data[i] == x) {
                System.out.println(("Element exists on NO." + (i + 1)));
                return;
            }
        }
        System.out.println(("Element does not exist"));
    }

    // 删除元素
    public void delete(int index)
    {
        if (index - 1 < 0 || index - 1 >= this.length) {
            System.out.println(("out of index"));
            return;
        }

        for (int i = index - 1; i < this.length; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.length--;
    }


}
