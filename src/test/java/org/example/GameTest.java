package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void shouldNotRegisteredExceptionFirst() {
        Player playerl1 = new Player(10, "Олег", 15);
        Player playerl2 = new Player(11, "Вася", 15);
        Game games = new Game();

        games.register(playerl2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            games.round(playerl1.getName(), playerl2.getName());
        });
    }

    @Test
    public void shouldNotRegisteredExceptionSecond() {
        Player playerl1 = new Player(10, "Андрей", 15);
        Player playerl2 = new Player(11, "Василий", 15);
        Game games = new Game();

        games.register(playerl1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            games.round(playerl1.getName(), playerl2.getName());
        });
    }

    @Test
    public void shouldFirstPlayerStrengthOverSecondPlayerStrength() {
        Player playerl1 = new Player(10, "Олег", 25);
        Player playerl2 = new Player(11, "Василий", 15);
        Game games = new Game();

        games.register(playerl1);
        games.register(playerl2);

        int res = games.round(playerl1.getName(), playerl2.getName());
        int expected = 1;

        System.out.println(res);
        Assertions.assertEquals(expected, res);
    }

    @Test
    public void shouldSecondPlayerStrengthOverFirstPlayerStrength() {
        Player playerl1 = new Player(10, "Олег", 25);
        Player playerl2 = new Player(11, "Василий", 45);
        Game games = new Game();

        games.register(playerl1);
        games.register(playerl2);

        int res = games.round(playerl1.getName(), playerl2.getName());
        int expected = 2;

        System.out.println(res);
        Assertions.assertEquals(expected, res);
    }

    @Test
    public void shouldPlayerStrengthSame() {
        Player playerl1 = new Player(10, "Олег", 45);
        Player playerl2 = new Player(11, "Василий", 45);
        Game games = new Game();

        games.register(playerl1);
        games.register(playerl2);

        int res = games.round(playerl1.getName(), playerl2.getName());
        int expected = 0;

        System.out.println(res);
        Assertions.assertEquals(expected, res);
    }

}