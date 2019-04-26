package CoreTest;

import Core.*;

import java.util.List;


public class EightsGameTest {


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


    public static void pass() {

        System.out.println("----- TESTING EightsGame.pass() -----");
        EightsGame game = new EightsGame(4);
        EightsPlayer p = game.getCurrentPlayer();
        System.out.println("Current Player ID: " + p.getID());
        game.pass();
        p = game.getCurrentPlayer();
        System.out.println("New Current Player ID: " + p.getID());

    }


    public static void calcScore() {

        System.out.println("----- TESTING EightsGame.calcScore() -----");
        EightsGame game = new EightsGame(4);
        game.calcScore(game.getCurrentPlayer());
        System.out.println("Winner's score should be 15 while other players scores should be -5.");
        List<EightsPlayer> p = game.getPlayers();
        for(int i = 0; i < p.size(); i++){

            System.out.println("Player " + (i + 1) + " Score: " + p.get(i).getScore());

        }


    }




    public static void changeSuit() {

        System.out.println("----- TESTING EightsGame.changeSuit() -----");
        EightsGame game = new EightsGame(4);
        System.out.println("Current play pile face card is " + game.getPlayPile().toString());
        System.out.println("Changing suit...");
        Suit s = game.getPlayPile().getSuit();
        if(s != Suit.SPADES){

            s = Suit.SPADES;
        }else{

            s = Suit.DIAMONDS;
        }
        System.out.println("Should results in the card being an eight of " + s);
        game.changeSuit(s);
        System.out.println("New play pile face card is " + game.getPlayPile().toString());
    }

}