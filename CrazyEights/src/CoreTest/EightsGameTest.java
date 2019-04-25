package CoreTest;

import Core.*;

import java.util.List;


public class EightsGameTest {

    @org.junit.Test
    public static void newRound() {

        EightsGame game = new EightsGame(4);
        List<EightsPlayer> list = game.getPlayers();

        for(EightsPlayer player: list){

            System.out.println("Player " + player + ":\nHand: " + player.getHand() + "\n");
        }

        System.out.println("After newRound()");
        game.newRound();
        for(EightsPlayer player: list){

            System.out.println("Player " + player + ":\nHand: " + player.getHand() + "\n");
        }
    }

    @org.junit.Test
    public static void canPlayCard() {
    }

    @org.junit.Test
    public static void canDrawCard() {
    }

    @org.junit.Test
    public static void isDeckEmpty() {
    }

    @org.junit.Test
    public void drawCard() {
    }

    @org.junit.Test
    public void playCard() {
    }

    @org.junit.Test
    public void pass() {
    }

    @org.junit.Test
    public void calcScore() {
    }

    @org.junit.Test
    public void findWinner() {
    }

    @org.junit.Test
    public void changeSuit() {
    }

}