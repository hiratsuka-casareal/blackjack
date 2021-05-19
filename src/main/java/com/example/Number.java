package com.example;

public enum Number {
    ACE(1, 1),
    TWO(2, 2),
    THREE(3, 3),
    FOUR(4, 4),
    FIVE(5, 5),
    SIX(6, 6),
    SEVEN(7, 7),
    EIGHT(8, 8),
    NINE(9, 9),
    TEN(10, 10),
    JACK(11, 10),
    QUEEN(12, 10),
    KING(13, 10);

    private int value;
    private int point;

    Number(int value, int point) {
        this.value = value;
        this.point = point;
    }

    public int getValue() {
        return value;
    }

    public int getPoint() {
        return point;
    }

}
