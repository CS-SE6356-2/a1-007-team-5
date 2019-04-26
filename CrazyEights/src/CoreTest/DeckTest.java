package CoreTest;


import Core.*;


public class DeckTest {


    public static void shuffle() {
        System.out.println("----- TESTING Deck.shuffle() -----");

        System.out.println("Creating new Deck...");
        Deck testDeck = new Deck();
        System.out.println(testDeck);

        System.out.println("Shuffling Deck... ");
        testDeck.shuffle();
        System.out.println(testDeck);
    }


    public static void reset() {

        System.out.println("----- TESTING Deck.reset() -----");

        System.out.println("Creating new Deck...");
        Deck testDeck = new Deck();
        System.out.println(testDeck);
        System.out.println("Changing deck by removing 5 cards...");
        for (int i = 0;  i < 5; i++){

            testDeck.pop();
        }
        System.out.println("Printing deck after changes...");
        System.out.println(testDeck);
        System.out.println("Resetting deck...");
        testDeck.reset();
        System.out.println("Printing deck after reset...");
        System.out.println(testDeck);
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


    public static void push() {

        System.out.println("----- TESTING Deck.push() -----");

        System.out.println("Creating new Deck...");
        Deck testDeck = new Deck();
        System.out.println(testDeck);

        System.out.println("Pushing 8spades and 8diamonds onto deck...");
        Card c = new Card(Face.EIGHT, Suit.SPADES);
        testDeck.push(c);
        c = new Card(Face.EIGHT, Suit.DIAMONDS);
        testDeck.push(c);
        System.out.println("Printing resulting deck...");
        System.out.println(testDeck);
    }


    public static void isEmpty() {

        System.out.println("----- TESTING Deck.isEmpty() -----");

        System.out.println("Creating new Deck...");
        Deck testDeck = new Deck();
        System.out.println(testDeck);
        System.out.println("Removing cards until deck is empty...");
        while(!testDeck.isEmpty()){

            testDeck.pop();
        }
        System.out.println("Printing deck after removing cards...");
        System.out.println(testDeck);
        System.out.println("Checking if deck is empty...");
        System.out.println(testDeck.isEmpty());


    }
}