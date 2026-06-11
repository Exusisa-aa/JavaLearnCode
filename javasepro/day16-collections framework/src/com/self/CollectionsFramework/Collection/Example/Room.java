package com.self.CollectionsFramework.Collection.Example;

import java.util.*;

public class Room {
    private final List<Card> newCards = new ArrayList<>();
    private final List<Player> players = new ArrayList<>();



    public Room() {
        String[] numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        String[] colors = {"♥️","♠️","♦️","♣️"};
        int size = 0;

        for (String number : numbers) {
            size++;
            for (String color : colors) {
                newCards.add(new Card(number, color, size));
            }
        }

        newCards.add(new Card("joker","♝",++size));
        newCards.add(new Card("JOKER","♛",++size));

        Player p1 = new Player();
        p1.setName("陈");
        Player p2 = new Player();
        p2.setName("张");
        Player p3 = new Player();
        p3.setName("卓");
        Collections.addAll(players, p1, p2, p3);
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        //洗牌
        Collections.shuffle(newCards);
        System.out.println("洗牌后：" + newCards);
        //发牌
        for (int i = 0; i < newCards.size() - 3; i++) {
            Card c = newCards.get(i);
            if (i % 3 == 0){
                players.get(0).getCards().add(c);
            }else if(i % 3 == 1){
                players.get(1).getCards().add(c);
            }else {
                players.get(2).getCards().add(c);
            }
        }

        //地主牌
        List<Card> LastThreeCards;
        LastThreeCards = newCards.subList(newCards.size() - 3,newCards.size());


        System.out.println("玩家一：" + players.get(0).getName());
        System.out.println("玩家二：" + players.get(1).getName());
        System.out.println("玩家三：" + players.get(2).getName());
        System.out.println("抢地主环节开始！");


        OUT:
        while (true) {
            System.out.print("请输入名称指定地主：");
            String name = sc.nextLine();
            for (int i = 0; i < newCards.size(); i++) {
                if (Objects.equals(name, players.get(i).getName())) {
                    System.out.println(players.get(i).getName() + "抢地主！");
                    for (Card lastThreeCard : LastThreeCards) {
                        players.get(i).getCards().add(lastThreeCard);
                    }
                    break OUT;
                } else if(i == 2){
                    System.out.println("没有该玩家~~~");
                    continue OUT;
                }
            }
        }


        //排序和看牌
        for (int i = 0; i < 3; i++) {
            sortCards(players.get(i).getCards());
            System.out.println(players.get(i).getName() + ":" + players.get(i).getCards());
        }



    }

    public void sortCards(List<Card> cards) {
        cards.sort(Comparator.comparing(Card::getRank));
    }


}
