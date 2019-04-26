package CoreTest;


import Core.*;


public class DeckTest {


    public void shuffle() {
    }


    public void reset() {
    }


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


    public void push() {
    }


    public void isEmpty() {
    }
}