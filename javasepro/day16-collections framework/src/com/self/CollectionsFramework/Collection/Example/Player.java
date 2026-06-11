package com.self.CollectionsFramework.Collection.Example;

import java.util.ArrayList;

public class Player {
    private final ArrayList<Card> cards = new ArrayList<>();
    private String name;
    private boolean king;

    public Player(String name, boolean king) {
        this.name = name;
        this.king = king;
    }

    public Player() {
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public boolean isKing() {
        return king;
    }

    public void setKing(boolean king) {
        this.king = king;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
