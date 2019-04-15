

import java.util.*;

public class EightsGame{


    // Array List of Player class to hold players in the game
    private List<EightsPlayer> gamePlayers;

    // Create card deck to draw from
    private Deck drawDeck;


    // Play Pile
    private Card playPile;

    // Suit var to hold suit for eights card played that player chose
    private String currentSuit;


    public EightsGame(){

        //initialize and shuffle deck
        drawDeck = new Deck();
        drawDeck.shuffle();

        // Add players to game
        gamePlayers = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            gamePlayers.add(new EightsPlayer(Integer.toString(i+1)));
            for(int j = 0; j < 7; j++)
                drawCard(gamePlayers.get(i));
        }

        Card turn_card;

        do{

            // Turn over top card and check
            turn_card = drawDeck.pop();

            // If eight add back to middle of deck.
            if(turn_card.getFace() == Face.EIGHT){

                // Place back in deck and shuffle
                drawDeck.push(turn_card);
                drawDeck.shuffle();


            }
            else {

                // Push card onto playPile
                playPile = turn_card;
            }

        }while (turn_card.getFace() == Face.EIGHT);



    }

    public List<EightsPlayer> getPlayers(){ return gamePlayers;}

    public void takeTurn(EightsPlayer p){

        // Interact with GUI to ask for user input


    }

    // Method to check if selected card can be played by user
    public boolean canPlayCard(Card c){

        // Peek at card on top of play pile and check if it matches suit or denomination
        return playPile.getSuit() == c.getSuit() || playPile.getFace() == c.getFace();

    }


    // Return true if deck is empty otherwise false
    public boolean drawCard(EightsPlayer p){

        if(drawDeck.isEmpty()){

            return  true;
        }
        else{

            p.draw(drawDeck);

            return false;

        }

    }

    //Player p plays a card c, if it is an eights card, return true. Else return false;
    public boolean playCard(EightsPlayer p, Card c){

       // Discard card
        if(p.getHand().removeCard(c)){

            // Set to top of playPile
            playPile = c;

        }


       // Return based on if played card is eight
       if(playPile.getFace() == Face.EIGHT)
       {
           return true;
       }

       return false;

    }

    public void changeSuit(int s) {

        switch(s){

            case 1:
                currentSuit = "CLUBS";
                break;
            case 2:
                currentSuit = "DIAMONDS";
                break;
            case 3:
                currentSuit = "SPADES";
                break;
            case 4:
                currentSuit = "HEARTS";
                break;
            default:
                break;

        }


    }



    public Card getTopCard()
    {
        return playPile;
    }
}