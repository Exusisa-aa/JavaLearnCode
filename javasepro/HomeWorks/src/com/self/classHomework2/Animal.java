package com.self.classHomework2;

abstract class Animal {
    protected String type;

    public Animal() {
    }

    public Animal(String type) {
        this.type = type;
    }

    public abstract void sound();

    @Override
    public String toString() {
        return "这是一只" + type;
    }
}
