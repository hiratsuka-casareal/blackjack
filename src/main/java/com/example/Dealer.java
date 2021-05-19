package com.example;

public class Dealer {

    private Hands hands;

    public Dealer() {
        hands = new Hands();
    }

    public void addCard(Card card) {
        hands.addCard(card);
    }

    public boolean isBusted() {
        return hands.isBusted();
    }

    public int getTotalPoint() {
        return hands.getTotalPoint();
    }

    public boolean wantToHit() {
        return getTotalPoint() <= 17;
    }

    public void showHands() {
        System.out.println(hands);
    }
}
