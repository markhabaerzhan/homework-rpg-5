package com.narxoz.rpg.facade;

public class RewardService {
    public String determineReward(AdventureResult battleResult) {
        if (battleResult == null) {
            return "No reward";
        }
        String winner = battleResult.getWinner();
        if (winner == null) {
            return "No reward";
        }
        if (winner.equals("Draw")) {
            return "Small reward: 10 gold";
        }
        if (winner.contains("Hero")) {
            return "Victory reward: 100 gold + rare item";
        }
        return "No reward";
    }
}
