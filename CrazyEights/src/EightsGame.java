

import java.util.*;

public class EightsGame{


    // Array List of Player class to hold players in the game
    private List<EightsPlayer> gamePlayers;

    // Create card deck to draw from
    private Deck drawDeck;


    // Play Pile
    private Card playPile;


    public EightsGame(){

        //initialize and shuffle deck
        drawDeck = new Deck();
        drawDeck.shuffle();

        // Add players to game
        gamePlayers = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            gamePlayers.add(new EightsPlayer());
            for(int j = 0; j < 7; j++)
                drawCard(gamePlayers.get(i));
        }


        // Turn over top card and place "starter" in separate pile.
        playPile = drawDeck.pop();

        // If eight add back to middle of deck.
        if(playPile.getFace() == Face.EIGHT){

            // Place in middle of drawDeck
        }
        else {

            // Push card onto playPile
        }

    }

    public List<EightsPlayer> getPlayers(){ return gamePlayers;}

    public void takeTurn(EightsPlayer p){

        // Interact with GUI to ask for user input


    }

    public boolean canPlayCard(Card c){

        // Peek at card on top of play pile and check if it matches suit or denomination

        return false;
    }

    public boolean drawCard(EightsPlayer p){


        p.draw(drawDeck);

        return false;

    }

    public boolean playCard(EightsPlayer p, Card c){

       p.discard(c);

       return false;

    }

    public void changeSuit(int s){


    }





}