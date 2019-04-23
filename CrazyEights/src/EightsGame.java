

import java.util.*;

public class EightsGame{

    private final int MAX_HAND_SIZE = 13;
    private int numPlayers;

    // Array List of Player class to hold players in the game
    private List<EightsPlayer> gamePlayers;
    private EightsPlayer currentPlayer;
    private EightsPlayer winner;

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

    public List<Card> getCurrentHand() { return currentPlayer.getHand(); }

    public EightsPlayer getCurrentPlayer() { return currentPlayer; }

    public EightsPlayer getWinner() { return winner; }

    // Method to check if selected card can be played by user
    public boolean canPlayCard(Card c){

        // Peek at card on top of play pile and check if it matches suit or denomination
        return(playPile.getSuit() == c.getSuit() || playPile.getFace() == c.getFace());
    }

    public boolean canDrawCard(){

        return currentPlayer.getHandSize() < MAX_HAND_SIZE;
    }

    public boolean isDeckEmpty(){

        return drawDeck.isEmpty();
    }
    // Return true if deck is empty otherwise false
    public void drawCard(){

        currentPlayer.draw(drawDeck);
        if(drawDeck.isEmpty()){
            findWinner();
        }
    }

    //Player p plays a card c. Return 1 if it is an eights card, 0 if not an eight, or -1 if it's the player's last card;
    public int playCard(Card c){

       // Discard card
        if(currentPlayer.play(c)){
            // Set to top of playPile
            playPile = c;
        }

        if(currentPlayer.getHandSize() == 0){

            winner = currentPlayer;;
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

    //Game ends by playing the last card in the hand
    public Player calcScore(){

        for(EightsPlayer player: gamePlayers){

            if (player != winner){

                int points = player.getHandSize();
                player.updateScore(-points);
                winner.updateScore(points);
            }
        }

        return winner;
    }

    //Game ends by drawing the last card in the deck
    public void findWinner(){

        winner = gamePlayers.get(0);
        for(EightsPlayer player: gamePlayers){

            if(player.getHandSize() < winner.getHandSize()){
                winner = player;
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