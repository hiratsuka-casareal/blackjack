package com.example;

public class Referee {

    private boolean playerWantContinue;
    private boolean dealerWantContinue;

    public Referee() {
        playerWantContinue = true;
        dealerWantContinue = true;
    }

    public void askContinue(Player player) {
        if (playerWantContinue) {
            playerWantContinue = !player.isBusted() && player.wantToHit();
        }
    }

    public void askContinue(Dealer dealer) {
        if (dealerWantContinue) {
            dealerWantContinue = !dealer.isBusted() && dealer.wantToHit();
        }
    }

    public boolean shouldContinue() {
        return playerWantContinue || dealerWantContinue;
    }

    public boolean playerWantContinue() {
        return playerWantContinue;
    }

    public boolean dealerWantContinue() {
        return dealerWantContinue;
    }

    public GameResult judge(Player player, Dealer dealer) {
        if (player.isBusted() && dealer.isBusted()) {
            return GameResult.DEALER_WIN;
        }
        if (player.isBusted()) {
            return GameResult.DEALER_WIN;
        }
        if (dealer.isBusted()) {
            return GameResult.PLAYER_WIN;
        }

        int playerTotalPoint = player.getTotalPoint();
        int dealerTotalPoint = dealer.getTotalPoint();

        if (playerTotalPoint == dealerTotalPoint) {
            return GameResult.DRAW;
        }
        if (playerTotalPoint > dealerTotalPoint) {
            return GameResult.PLAYER_WIN;
        }

        return GameResult.DEALER_WIN;
    }

}
