package com.self.classHomework;

public class Rect {
    protected double length;
    protected double width;

    public Rect(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double area(){
        return length * width;
    }

    public double perimeter(){
        return 2*(length + width);
    }


}
