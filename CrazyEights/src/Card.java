/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author quanicus
 */
public class Card {

        private Suit suit;
        private Face face;

        public Card(Face face, Suit suit) {
            this.suit = suit;
            this.face = face;
        }

        public Suit getSuit() {
            return suit;
        }

        public Face getFace() {
            return face;
        }
        
        public String toString(){
            return face.getValue() + suit.getValue();
        }
    }
