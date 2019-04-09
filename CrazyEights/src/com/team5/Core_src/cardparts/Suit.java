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
public enum Suit{
        CLUBS("♣"), DIAMONDS("♦"), HEARTS("♥"), SPADES("♠");

        private final String value;

        private Suit(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static Suit[] items = new Suit[]{
            CLUBS, DIAMONDS, HEARTS, SPADES
        };
    }
