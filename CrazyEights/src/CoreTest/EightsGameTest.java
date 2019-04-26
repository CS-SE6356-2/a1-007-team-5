package CoreTest;

import Core.*;

import java.util.List;


public class EightsGameTest {

    @org.junit.Test
    public static void newRound() {

        System.out.println("----- TESTING EightsGame.newRound() -----");
        System.out.println("Creating new EightsGame...\n");
        EightsGame game = new EightsGame(4);
        List<EightsPlayer> list = game.getPlayers();

        System.out.println("Before newRound()");
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

        System.out.println("----- TESTING EightsGame.canPlayCard() -----");

        EightsGame game = new EightsGame(4);
        System.out.println("Current playPile: " + game.getPlayPile() + "\n");
        for (Suit suit : Suit.items) {
            for (Face face : Face.items) {
                Card testCard = new Card(face, suit);
                System.out.println("canPlay(" + testCard + "): " + game.canPlayCard(testCard));

            }
        }
        try{
            game.canPlayCard(null);
        }
        catch(NullPointerException e){
            System.out.println("canPlayCard() NullPointerException\n");
        }
    }

    @org.junit.Test
    public static void canDrawCard() {

        System.out.println("----- TESTING EightsGame.canDrawCard()");
        EightsGame game = new EightsGame(4);
        List<Card> hand = game.getCurrentPlayer().getHand();

        while(game.canDrawCard()){
            game.drawCard();
            System.out.println("Current hand: " + hand);
            System.out.println("canDrawCard(): " + game.canDrawCard() + "\n");
        }
    }

    @org.junit.Test
    public static void drawCard() {

        System.out.println("----- TESTING EightsGame.drawCard -----");
        EightsGame game = new EightsGame(4);
        List<Card> hand = game.getCurrentPlayer().getHand();
        System.out.println("Current hand: " + hand);

        while(!game.drawCard()){
            System.out.println("Hand after draw:\n" + hand);
        }
        System.out.println();
    }

    @org.junit.Test
    public static void playCard() {

        System.out.println("----- TESTING EightsGame.playCard() -----");
        EightsGame game = new EightsGame(4);
        Card card;
        System.out.println("Adding an EIGHT to player's hand...");
        game.getCurrentPlayer().getHand().add(0, new Card(Face.EIGHT, Suit.SPADES));

        while(game.getCurrentPlayer().getHandSize() != 0){
            System.out.println("Current playPile: " + game.getPlayPile());
            System.out.println("Current hand: " + game.getCurrentPlayer().getHand());
            card = game.getCurrentPlayer().getHand().get(0);
            System.out.println("playCard(" + card + "): " + game.playCard(card));
            System.out.println("New playPile: " + game.getPlayPile() + "\n");

        }
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