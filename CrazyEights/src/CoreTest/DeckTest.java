package CoreTest;

import org.junit.Test;

import Core.*;


import static org.junit.Assert.*;

public class DeckTest {

    @Test
    public void shuffle() {
    }

    @Test
    public void reset() {
    }

    @Test
    public static void pop() {

        System.out.println("----- TESTING Deck.pop() -----");

        System.out.println("Creating new Deck...");
        Deck testDeck = new Deck();
        System.out.println(testDeck);

        System.out.println("Popping...");
        while(!testDeck.isEmpty()){

            System.out.println(testDeck.pop());
        }

        System.out.println("Popping empty Deck...");
        System.out.println(testDeck.pop());
    }

    @Test
    public void push() {
    }

    @Test
    public void isEmpty() {
    }
}