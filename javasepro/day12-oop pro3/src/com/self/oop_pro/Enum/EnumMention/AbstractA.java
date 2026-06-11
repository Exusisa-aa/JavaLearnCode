package com.self.oop_pro.Enum.EnumMention;

public enum AbstractA {
    X("张三"){
      @Override
      public void print(){
          System.out.println(AbstractA.X.getName() + "在打球");
      }
    },Y("小红"){
        @Override
        public void print(){
            System.out.println(AbstractA.Y.getName() + "在打球");
        }
    },Z(){
        @Override
        public void print(){
            System.out.println(AbstractA.Z.getName() + "在打球");
        }
    };
    public abstract void print();

    private String name;

    AbstractA() {
    }

    AbstractA(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
