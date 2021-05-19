package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RefereeTest {

    @Nested
    @DisplayName("バーストが含まれる場合のテスト")
    class Busted {

        @Test
        @DisplayName("双方がバーストしていたらディーラーの勝ち")
        void bothBusted() {
            Player playerMock = mock(Player.class);
            Dealer dealerMock = mock(Dealer.class);
            when(playerMock.isBusted()).thenReturn(true);
            when(dealerMock.isBusted()).thenReturn(true);

            Referee referee = new Referee();
            assertEquals(GameResult.DEALER_WIN, referee.judge(playerMock, dealerMock));
        }

        @Test
        @DisplayName("プレイヤーがバーストしていたらディーラーの勝ち")
        void playerBusted() {
            Player playerMock = mock(Player.class);
            Dealer dealerMock = mock(Dealer.class);
            when(playerMock.isBusted()).thenReturn(true);
            when(dealerMock.isBusted()).thenReturn(false);

            Referee referee = new Referee();
            assertEquals(GameResult.DEALER_WIN, referee.judge(playerMock, dealerMock));
        }

        @Test
        @DisplayName("ディーラーがバーストしていたらプレイヤーの勝ち")
        void dealerBusted() {
            Player playerMock = mock(Player.class);
            Dealer dealerMock = mock(Dealer.class);
            when(playerMock.isBusted()).thenReturn(false);
            when(dealerMock.isBusted()).thenReturn(true);

            Referee referee = new Referee();
            assertEquals(GameResult.PLAYER_WIN, referee.judge(playerMock, dealerMock));
        }

    }

    @Nested
    @DisplayName("バーストしていない場合")
    class Normal {

        @Test
        void draw() {
            Player playerMock = mock(Player.class);
            Dealer dealerMock = mock(Dealer.class);
            when(playerMock.getTotalPoint()).thenReturn(10);
            when(dealerMock.getTotalPoint()).thenReturn(10);

            Referee referee = new Referee();
            assertEquals(GameResult.DRAW, referee.judge(playerMock, dealerMock));
        }

        @Test
        void playerWin() {
            Player playerMock = mock(Player.class);
            Dealer dealerMock = mock(Dealer.class);
            when(playerMock.getTotalPoint()).thenReturn(10);
            when(dealerMock.getTotalPoint()).thenReturn(9);

            Referee referee = new Referee();
            assertEquals(GameResult.PLAYER_WIN, referee.judge(playerMock, dealerMock));
        }

        @Test
        void dealerWin() {
            Player playerMock = mock(Player.class);
            Dealer dealerMock = mock(Dealer.class);
            when(playerMock.getTotalPoint()).thenReturn(10);
            when(dealerMock.getTotalPoint()).thenReturn(11);

            Referee referee = new Referee();
            assertEquals(GameResult.DEALER_WIN, referee.judge(playerMock, dealerMock));
        }
    }

}
