import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Player {
    
    private List<Card> hand;

    //Player ID will be simply "1" or "2" and so on. It must be exactly this string for 1-4.
    private int playerID;

    //Constructor, must pass in a playerID string
    public Player(int id){
        hand = new ArrayList<>();
        playerID = id;
    }
    
    public List<Card> getHand(){
        return hand;
    }

    public int getHandSize() { return hand.size(); }
    
    public int getID(){
        return playerID;
    }

    public void setID(int id) {playerID = id;}

    public boolean play(Card card){

        return hand.remove(card);
    }

    /*Takes a Deck argument and draws a card from it. This method removes the "top" card from the deck and adds it
      to a player's hand. When the card is added to the hand, it is placed in order first by suit and then by face value.*/
    public Card draw(Deck deck){

        if(deck.isEmpty())
            return null;

        Card drawCard = deck.pop();
        if(hand.isEmpty()) {

            hand.add(drawCard);
        }
        else{

            ListIterator<Card> iterator = hand.listIterator();
            while(iterator.hasNext()){

                Card newCard = iterator.next();

                if(drawCard.getSuit().compareTo(newCard.getSuit()) < 0){

                    iterator.previous();
                    iterator.add(drawCard);
                }
                else if(drawCard.getSuit().equals(newCard.getSuit()) &&
                        (drawCard.getFace().compareTo(newCard.getFace()) < 0)){

                    iterator.previous();
                    iterator.add(drawCard);
                }
            }
            iterator.add(drawCard);
        }
        return drawCard;
    }
}
