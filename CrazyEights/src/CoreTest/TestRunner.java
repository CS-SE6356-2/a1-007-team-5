package CoreTest;

public class TestRunner {

    public static void main(String args[]){

        EightsGameTest.newRound();
        EightsGameTest.canPlayCard();
        EightsGameTest.canDrawCard();
        EightsGameTest.drawCard();
        EightsGameTest.playCard();
        EightsGameTest.pass();
        EightsGameTest.calcScore();
        EightsGameTest.changeSuit();
        DeckTest.pop();
    }
}
