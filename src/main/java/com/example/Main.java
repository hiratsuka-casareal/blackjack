package com.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("ゲームの始まり");

        Deck deck = new Deck();
        Player player = new Player();
        Dealer dealer = new Dealer();
        Referee referee = new Referee();

        while (referee.shouldContinue()) {
            if (referee.playerWantContinue()) {
                player.addCard(deck.getCard());
                System.out.print("現在の手札 ");
                player.showHands();
                System.out.println("現在の合計値 : " + player.getTotalPoint());
            }
            if (referee.dealerWantContinue()) {
                dealer.addCard(deck.getCard());
            }

            referee.askContinue(player);
            referee.askContinue(dealer);
        }
        System.out.print("プレイヤーの手札 ");
        player.showHands();
        System.out.println("プレイヤーの合計値 : " + player.getTotalPoint());
        System.out.print("ディーラーの手札 ");
        dealer.showHands();
        System.out.println("ディーラーの合計値 : " + dealer.getTotalPoint());
        System.out.println(referee.judge(player, dealer).getResultMessage());

        System.out.println("ゲームの終わり");
    }
}
