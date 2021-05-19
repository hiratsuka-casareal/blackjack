package com.example;

import java.util.Scanner;

public class Player {

    private Hands hands;

    public Player() {
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("続けて引きますか？(y/n) : ");
        String command = scanner.nextLine();
        return command.toLowerCase().equals("y");
    }

    public void showHands() {
        System.out.println(hands);
    }
}
