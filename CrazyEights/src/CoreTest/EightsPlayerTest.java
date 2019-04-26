package CoreTest;

import Core.*;

public class EightsPlayerTest {


    public static void play(){

        System.out.println("----- TESTING EightsPlayer.play() -----");
        System.out.println("Creating new game with EightsPlayers...\n");
        EightsGame testGame = new EightsGame(4);
        System.out.println("Printing player's current hand... ");
        System.out.println(testGame.getCurrentPlayer().getHand());
        System.out.println("Playing first card in hand...");
        testGame.getCurrentPlayer().play(testGame.getCurrentPlayer().getHand().get(0));
        System.out.println("Printing player's hand after playing card... ");
        System.out.println(testGame.getCurrentPlayer().getHand());
    }


    public static void draw() {

        System.out.println("----- TESTING EightsPlayer.draw() -----");
        System.out.println("Creating new game with EightsPlayers...\n");
        EightsGame testGame = new EightsGame(4);
        System.out.println("Printing player's current hand... ");
        System.out.println(testGame.getCurrentPlayer().getHand());
        System.out.println("Drawing card from deck...");
        testGame.drawCard(); // Wrapper method for calling player.draw()
        System.out.println("Printing player's hand after drawing a card... ");
        System.out.println(testGame.getCurrentPlayer().getHand());

    }

    public static void updateScore() {

        System.out.println("----- TESTING EightsPlayer.updateScore -----");
        System.out.println("Creating new game with EightsPlayers...\n");
        EightsGame testGame = new EightsGame(4);
        System.out.println("Printing player's current score... ");
        System.out.println(testGame.getCurrentPlayer().getScore());
        System.out.println("Adding 5 points to player's score...");
        testGame.getCurrentPlayer().updateScore(5);
        System.out.println("Printing player's score after update... ");
        System.out.println(testGame.getCurrentPlayer().getScore());

    }
}