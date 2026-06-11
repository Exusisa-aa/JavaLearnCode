package com.self.jdbc.learn.basis;

public enum Message {
    URL("jdbc:mysql://127.0.0.1:3306/ex"),
    USERNAME("root"),
    PASSWORD("Aa2447439574");

    private final String message;

    Message(String s) {
        message = s;
    }


    public String getMessage(){
        return this.message;
    }
}
