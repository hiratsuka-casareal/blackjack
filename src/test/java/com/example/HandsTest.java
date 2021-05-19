package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandsTest {

    @Nested
    @DisplayName("数字がそのままポイントになるパターン")
    class NormalPattern {
        @Test
        void add1card() {
            List<Card> dummyCardList = new ArrayList<>(List.of(Card.CLUB_2, Card.CLUB_6, Card.CLUB_9));
            DeckMock deckMock = new DeckMock(dummyCardList);

            Hands hands = new Hands();
            hands.addCard(deckMock.getCard());
            assertEquals(2, hands.getTotalPoint());

        }

        @Test
        void add3cards() {
            List<Card> dummyCardList = new ArrayList<>(List.of(Card.CLUB_2, Card.CLUB_6, Card.CLUB_9));
            DeckMock deckMock = new DeckMock(dummyCardList);

            Hands hands = new Hands();
            hands.addCard(deckMock.getCard());
            hands.addCard(deckMock.getCard());
            hands.addCard(deckMock.getCard());
            assertEquals(17, hands.getTotalPoint());
        }
    }

    @Nested
    @DisplayName("絵札を含む場合")
    class containsJQK {

        @Test
        void containsJ() {
            List<Card> dummyCardList = new ArrayList<>(List.of(Card.CLUB_J, Card.CLUB_6, Card.CLUB_9));
            DeckMock deckMock = new DeckMock(dummyCardList);

            Hands hands = new Hands();
            hands.addCard(deckMock.getCard());
            hands.addCard(deckMock.getCard());
            hands.addCard(deckMock.getCard());
            assertEquals(25, hands.getTotalPoint());
        }

        @Test
        void containsQ() {
            List<Card> dummyCardList = new ArrayList<>(List.of(Card.CLUB_Q, Card.CLUB_6, Card.CLUB_9));
            DeckMock deckMock = new DeckMock(dummyCardList);

            Hands hands = new Hands();
            hands.addCard(deckMock.getCard());
            hands.addCard(deckMock.getCard());
            hands.addCard(deckMock.getCard());
            assertEquals(25, hands.getTotalPoint());
        }

        @Test
        void containsK() {
            List<Card> dummyCardList = new ArrayList<>(List.of(Card.CLUB_K, Card.CLUB_6, Card.CLUB_9));
            DeckMock deckMock = new DeckMock(dummyCardList);

            Hands hands = new Hands();
            hands.addCard(deckMock.getCard());
            hands.addCard(deckMock.getCard());
            hands.addCard(deckMock.getCard());
            assertEquals(25, hands.getTotalPoint());
        }
    }

    @Nested
    @DisplayName("Aを含む場合")
    class containsA {

        @Test
        @DisplayName("11を採用するパターン")
        void useEleven() {
            List<Card> dummyCardList = new ArrayList<>(List.of(Card.CLUB_A, Card.CLUB_6, Card.CLUB_3));
            DeckMock deckMock = new DeckMock(dummyCardList);

            Hands hands = new Hands();
            hands.addCard(deckMock.getCard());
            hands.addCard(deckMock.getCard());
            hands.addCard(deckMock.getCard());
            assertEquals(20, hands.getTotalPoint());
        }

        @Test
        @DisplayName("11を採用するパターン(ちょうど21になる)")
        void useEleven_just21() {
            List<Card> dummyCardList = new ArrayList<>(List.of(Card.CLUB_A, Card.CLUB_7, Card.CLUB_3));
            DeckMock deckMock = new DeckMock(dummyCardList);

            Hands hands = new Hands();
            hands.addCard(deckMock.getCard());
            hands.addCard(deckMock.getCard());
            hands.addCard(deckMock.getCard());
            assertEquals(21, hands.getTotalPoint());
        }

        @Test
        @DisplayName("1を採用するパターン")
        void useOne() {
            List<Card> dummyCardList = new ArrayList<>(List.of(Card.CLUB_A, Card.CLUB_7, Card.CLUB_9));
            DeckMock deckMock = new DeckMock(dummyCardList);

            Hands hands = new Hands();
            hands.addCard(deckMock.getCard());
            hands.addCard(deckMock.getCard());
            hands.addCard(deckMock.getCard());
            assertEquals(17, hands.getTotalPoint());
        }

        @Test
        @DisplayName("1を採用するパターン(ちょうど21になる)")
        void useOne_just21() {
            List<Card> dummyCardList = new ArrayList<>(List.of(Card.CLUB_A, Card.CLUB_10, Card.DIAMOND_10));
            DeckMock deckMock = new DeckMock(dummyCardList);

            Hands hands = new Hands();
            hands.addCard(deckMock.getCard());
            hands.addCard(deckMock.getCard());
            hands.addCard(deckMock.getCard());
            assertEquals(21, hands.getTotalPoint());
        }

    }

    @Nested
    @DisplayName("Aが2枚含まれる場合")
    class containsA2 {

        @Test
        void useOne() {
            List<Card> dummyCardList = new ArrayList<>(List.of(Card.CLUB_A, Card.SPADE_A, Card.DIAMOND_10));
            DeckMock deckMock = new DeckMock(dummyCardList);

            Hands hands = new Hands();
            hands.addCard(deckMock.getCard());
            hands.addCard(deckMock.getCard());
            hands.addCard(deckMock.getCard());
            assertEquals(12, hands.getTotalPoint());
        }

        @Test
        void useEleven() {
            List<Card> dummyCardList = new ArrayList<>(List.of(Card.CLUB_A, Card.SPADE_A, Card.DIAMOND_2));
            DeckMock deckMock = new DeckMock(dummyCardList);

            Hands hands = new Hands();
            hands.addCard(deckMock.getCard());
            hands.addCard(deckMock.getCard());
            hands.addCard(deckMock.getCard());
            assertEquals(14, hands.getTotalPoint());
        }

    }

}
