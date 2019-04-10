/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author quanicus
 */
public class Hand {
    
    private List<Card> hand;
    
    public Hand(){
        hand = new ArrayList<>();
    }
    
    public void addCard(Card card){
        if(hand.isEmpty())
            hand.add(card);
        else{
            
            ListIterator<Card> iterator = hand.listIterator();
            while(iterator.hasNext()){
                
                Card newCard = iterator.next();
                
                if(card.getSuit().compareTo(newCard.getSuit()) < 0){
                    
                    iterator.previous();
                    iterator.add(card);
                    return;                    
                }
                else if(card.getSuit().equals(newCard.getSuit()) && 
                       (card.getFace().compareTo(newCard.getFace()) < 0)){
                    
                    iterator.previous();
                    iterator.add(card);
                    return;
                }
            }
            iterator.add(card);
        }           
    }
    
    @Override
    public String toString(){
        
        if(hand.size() == 1)
            return "[" + hand.get(0) + "]";
        
        StringBuilder output = new StringBuilder("[");
        for(Card card: hand){
            output.append(card.toString() + ", ");
        }
        output.replace(output.length()-2, output.length(), "]");
        
        return output.toString();
    }
}
