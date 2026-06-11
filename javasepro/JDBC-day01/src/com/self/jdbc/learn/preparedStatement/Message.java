package com.self.jdbc.learn.preparedStatement;

public enum Message {
    URL("jdbc:mysql://127.0.0.1:3306/ex?useServerPrepStmts=true"),
    USERNAME("root"),
    PASSWORD("Aa2447439574");

    private final String message;

    Message(String info){
        this.message = info;
    }

    public String getMessage(){
        return this.message;
    }
}
