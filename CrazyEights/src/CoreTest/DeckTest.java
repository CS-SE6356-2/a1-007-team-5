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
    public void pop() {

        Deck testDeck = new Deck();

        Card c = new Card(Face.ACE, Suit.CLUBS);

        testDeck.push(c);

        assertEquals(c, testDeck.pop());


    }

    @Test
    public void push() {
    }

    @Test
    public void isEmpty() {
    }
}