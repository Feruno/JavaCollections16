package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game {

    List<Player> playersReg = new ArrayList<>();

    /*
    public List registeredPlayer() {
        List<String> playersReg = new ArrayList<>();
        playersReg.add("Петя");
        playersReg.add("Олег");
        playersReg.add("Василий");

        return playersReg;
    }*/

    public void register(Player player) {
        playersReg.add(player);

    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;

        for (Player player : playersReg) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }

        }

        if (player1 == null) {
            throw new NotRegisteredException("не зарегистрирован: " + playerName1);
        } else if (player2 == null) {
            throw new NotRegisteredException("не зарегистрирован: " + playerName2);
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }
}
