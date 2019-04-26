package CoreTest;

import Core.EightsPlayer;

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
        DeckTest.shuffle();
        DeckTest.reset();
        DeckTest.pop();
        DeckTest.push();
        DeckTest.isEmpty();
        EightsPlayerTest.play();
        EightsPlayerTest.draw();
        EightsPlayerTest.updateScore();

    }
}
