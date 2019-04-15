/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author quanicus
 */
public class Player {
    
    private Hand hand;

    //Player ID will be simply "1" or "2" and so on. It must be exactly this string for 1-4.
    private String playerID;

    //Constructor, must pass in a playerID string
    public Player(String id){
        hand = new Hand();
        playerID = id;
    }
    
    public Hand getHand(){
        return hand;
    }
    
    public String getID(){
        return playerID;
    }

    public void setID(String id) {playerID = id;}
    
    public Card draw(Deck deck){
        Card drawCard = deck.pop();
        hand.addCard(drawCard);

        return drawCard;
    }

}
