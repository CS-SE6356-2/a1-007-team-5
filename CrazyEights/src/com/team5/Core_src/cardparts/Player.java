/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardparts;

/**
 *
 * @author quanicus
 */
public class Player {
    
    private Hand hand;
    private String playerID;
    
    public Player(){
        hand = new Hand();
    }
    
    public Hand getHand(){
        return hand;
    }
    
    public String getID(){
        return playerID;
    }
    
    public void draw(Deck deck){
        Card drawCard = deck.pop();
        hand.addCard(drawCard);
    }

}
