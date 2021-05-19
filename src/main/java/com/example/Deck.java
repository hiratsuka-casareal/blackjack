package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {

    private final List<Card> deck;

    public Deck() {
        deck = new ArrayList<>(Arrays.asList(Card.values()));
        Collections.shuffle(deck);
    }

    public Card getCard() {
        return deck.remove(0);
    }
}
