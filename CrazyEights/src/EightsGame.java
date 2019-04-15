

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


    // Method to check if selected card can be played by user
    public boolean canPlayCard(Card c){

        // Peek at card on top of play pile and check if it matches suit or denomination
        return(playPile.getSuit() == c.getSuit() || playPile.getFace() == c.getFace());


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

    public void changeSuit(Suit s) {

        switch(s){

            case CLUBS:
                playPile = new Card(Face.EIGHT, Suit.CLUBS);
                break;
            case DIAMONDS:
                playPile = new Card(Face.EIGHT, Suit.DIAMONDS);
                break;
            case HEARTS:
                playPile = new Card(Face.EIGHT, Suit.HEARTS);
                break;
            case SPADES:
                playPile = new Card(Face.EIGHT, Suit.SPADES);
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