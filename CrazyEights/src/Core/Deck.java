package Core;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author quanicus
 */
public class Deck {

        private List<Card> cards;
        private List<Card> playDeck;

        public Deck() {
            cards = new ArrayList<>(52);
            for (Suit suit : Suit.items) {
                for (Face face : Face.items) {
                    cards.add(new Card(face, suit));
                }
            }
            playDeck = new ArrayList<>(cards);
        }

        public void shuffle(){

            Collections.shuffle(playDeck);
        }

        public void reset() {
            playDeck.clear();
            playDeck.addAll(cards);
            Collections.shuffle(playDeck);
        }

        public Card pop() {
            if (playDeck.isEmpty()) {
                return null;
            }
            return playDeck.remove(0);
        }

        public void push(Card card) {
            playDeck.add(card);
        }
        
        public boolean isEmpty(){
            return playDeck.isEmpty();
        }
    }
