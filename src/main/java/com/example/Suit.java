package com.example;

public enum Suit {
    SPADE("♠"),
    CLUB("♣"),
    HEART("♥"),
    DIAMOND("♦");

    private final String symbol;

    Suit(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
