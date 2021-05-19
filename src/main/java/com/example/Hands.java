package com.example;

import java.util.ArrayList;
import java.util.List;

public class Hands {
    private List<Card> hands;
    private final int MAX_POINT = 21;

    public Hands() {
        hands = new ArrayList<>();
    }

    public void addCard(Card card) {
        hands.add(card);
    }

    public int getTotalPoint() {

        int aceAsOnePoint = hands.stream()
                .mapToInt(h -> h.getNumber().getPoint())
                .sum();

        boolean hasAce = hands.stream()
                .anyMatch(h -> h.getNumber().getValue() == 1);

        if (!hasAce) {
            return aceAsOnePoint;
        }

        // Aが2枚以上11扱いになることはないので、1枚分のポイントを加算
        int aceAsElevenPoint = aceAsOnePoint + 10;
        if (aceAsElevenPoint > MAX_POINT) {
            return aceAsOnePoint;
        }

        return Math.max(aceAsOnePoint, aceAsElevenPoint);
    }

    public boolean isBusted() {
        return getTotalPoint() > MAX_POINT;
    }

    @Override
    public String toString() {
        return hands.toString();
    }
}
