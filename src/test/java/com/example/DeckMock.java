package com.example;

import java.util.List;

public class DeckMock extends Deck {

    private List<Card> mockDeck;

    public DeckMock(List<Card> mockDeck) {
        this.mockDeck = mockDeck;
    }

    @Override
    public Card getCard() {
        return mockDeck.remove(0);
    }
}
