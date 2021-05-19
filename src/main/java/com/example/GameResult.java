package com.example;

public enum GameResult {
    PLAYER_WIN("プレイヤーの勝利です"),
    DEALER_WIN("ディーラーの勝利です"),
    DRAW("引き分けです");

    private String resultMessage;

    GameResult(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getResultMessage() {
        return resultMessage;
    }
}
