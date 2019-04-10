import javax.swing.*;
import java.awt.*;
import java.util.List;


//EightsFrame class which encapsulates the main game GUI. Uses JFrame forms for structure. Due to the usage of JFrame forms,
//the .java file will seem incomplete
public class EightsFrame extends JFrame
{
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 800;

    private JPanel boardPanel;
    private JPanel playerPanel;
    private JPanel scorePanel;
    private JPanel centerPanel;
    private JPanel drawPanel;
    private JPanel spacePanel2;
    private JPanel playPanel;
    private JButton clubsButton;
    private JPanel changeSuitPanel;
    private JPanel handPanel;
    private JPanel actionPanel;
    private JButton drawButton;
    private JButton playButton;
    private JButton diamondsButton;
    private JButton heartsButton;
    private JButton spadesButton;
    private JPanel spacePanel1;
    private JButton card1Button, card2Button, card3Button, card4Button, card5Button, card6Button, card7Button ;

    private DummyEightsCore testCore;

    public EightsFrame()
    {

        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setContentPane(boardPanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        EightsGame game = new EightsGame();
        List<EightsPlayer> players = game.getPlayers();
        displayHand(players.get(0));
    }

    private void displayHand(EightsPlayer player){

        Hand hand = player.getHand();
        card1Button.setText(hand.getCard(0).toString());
        card2Button.setText(hand.getCard(1).toString());
        card3Button.setText(hand.getCard(2).toString());
        card4Button.setText(hand.getCard(3).toString());
        card5Button.setText(hand.getCard(4).toString());
        card6Button.setText(hand.getCard(5).toString());
        card7Button.setText(hand.getCard(6).toString());
    }

    private void createUIComponents()
    {
        // TODO: place custom component creation code here
    }
}
