package Core;

import Core.Card;
import Core.Deck;
import Core.Face;
import Core.Suit;

import java.util.*;

public class EightsGame{

    private final int MAX_HAND_SIZE = 13;
    private int numPlayers;

    // Array List of Core.Player class to hold players in the game
    private List<EightsPlayer> gamePlayers;
    private EightsPlayer currentPlayer;

    // Create card deck to draw from
    private Deck drawDeck;


    // Play Pile
    private Card playPile;


    public EightsGame(int n){

        numPlayers = n;

        //initialize and shuffle deck
        drawDeck = new Deck();

        // Add players to game
        gamePlayers = new ArrayList<>();
        for(int i = 0; i < numPlayers; i++){

            gamePlayers.add(new EightsPlayer(i+1));
        }

        newRound();
    }

    public void newRound(){

        drawDeck.reset();

        for(EightsPlayer player: gamePlayers){

            player.getHand().clear();
            for(int i = 0; i < 5; i++)
                player.draw(drawDeck);
        }
        currentPlayer = gamePlayers.get(0);

        Card turn_card = drawDeck.pop();
        while (turn_card.getFace() == Face.EIGHT){

            drawDeck.push(turn_card);
            drawDeck.shuffle();
            turn_card = drawDeck.pop();
        }
        playPile = turn_card;
    }

    public List<EightsPlayer> getPlayers() { return gamePlayers; }

    public EightsPlayer getCurrentPlayer() { return currentPlayer; }


    public EightsPlayer endGame(){

        EightsPlayer winner = getWinner();
        if(winner == null)
            return null;

        return winner;
    }

    // Method to check if selected card can be played by user
    public boolean canPlayCard(Card c){

        // Peek at card on top of play pile and check if it matches suit or denomination
        return(playPile.getSuit() == c.getSuit() || playPile.getFace() == c.getFace());
    }

    public boolean canDrawCard(){

        return currentPlayer.getHandSize() < MAX_HAND_SIZE;
    }

    // Return true if deck is empty otherwise false
    public boolean drawCard(){

        currentPlayer.draw(drawDeck);

        return drawDeck.isEmpty();
    }

    //Core.Player p plays a card c. Return 1 if it is an eights card, 0 if not an eight, or -1 if it's the player's last card;
    public int playCard(Card c){

       // Discard card
        if(currentPlayer.play(c)){
            // Set to top of playPile
            playPile = c;
        }

        if(currentPlayer.getHandSize() == 0){

            return -1;
        }
        nextPlayer();
       // Return based on if played card is eight
       if(playPile.getFace() == Face.EIGHT)
           return 1;
       else
           return 0;
    }

    public void pass(){
        nextPlayer();
    }

    //Sets winner equal to the player with smallest hand size
    private EightsPlayer getWinner(){

        //set winner equal to player with smallest hand size
        EightsPlayer winner = gamePlayers.get(0);
        for(EightsPlayer player: gamePlayers){

            if(player.getHandSize() < winner.getHandSize()){
                winner = player;
            }
        }
        //set winner to null if more than 1 player has the lowest hand size
        for(EightsPlayer player: gamePlayers){

            if(player != winner && player.getHandSize() == winner.getHandSize())
                winner = null;
        }
        return winner;
    }

    public void calcScore(EightsPlayer winner){

        //Calculate and update player's scores
        for(EightsPlayer player: gamePlayers){

            if (player != winner){

                int points = player.getHandSize();
                player.updateScore(-points);
                winner.updateScore(points);
            }
        }
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

    public Card getPlayPile()
    {
        return playPile;
    }

    private void nextPlayer(){

        int id = currentPlayer.getID();
        currentPlayer = gamePlayers.get((id) % numPlayers);
    }
}