

import java.util.*;

public class EightsGame{


    // Array List of Player class to hold players in the game
    private List<EightsPlayer> gamePlayers = new ArrayList<>();

    // Create card deck to draw from
    private Deck DrawDeck = new Deck();


    // Play Pile


    public void initializeGame(){

        // Add players to game
        EightsPlayer p1 = new EightsPlayer();
        gamePlayers.add(p1);
        EightsPlayer p2 = new EightsPlayer();
        gamePlayers.add(p2);
        EightsPlayer p3 = new EightsPlayer();
        gamePlayers.add(p3);
        EightsPlayer p4 = new EightsPlayer();
        gamePlayers.add(p4);

        // Deal a card a piece to each player
        for(int i = 0; i < 4; i++){

            gamePlayers.get(i).draw(DrawDeck);
        }

        // Turn over top card and place "starter" in separate pile.
        Card starterCard = DrawDeck.pop();

        // If eight add back to middle of deck.
        if(starterCard.getFace().getValue().equals("8")){

            // Place in middle of drawDeck
        }
        else {

            // Push card onto playPile
        }




    }

    public void takeTurn(EightsPlayer p){

        // Interact with GUI to ask for user input


    }

    public boolean canPlayCard(Card c){

        // Peek at card on top of play pile and check if it matches suit or denomination

        return false;
    }

    public boolean drawCard(EightsPlayer p){


        p.draw(DrawDeck);

        return false;

    }

    public boolean playCard(EightsPlayer p, Card c){

       p.discard(c);

       return false;

    }

    public void changeSuit(int s){


    }





}