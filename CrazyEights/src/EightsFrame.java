import javax.swing.*;
import javax.swing.ImageIcon;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
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
    private JButton card1Button;
    private JPanel actionPanel;
    private JButton drawButton;
    private JButton playButton;
    private JButton diamondsButton;
    private JButton heartsButton;
    private JButton spadesButton;
    private JPanel spacePanel1;

    private ArrayList<JButton> gHand1;
    private ArrayList<JButton> gHand2;
    private ArrayList<JButton> gHand3;
    private ArrayList<JButton> gHand4;


    public EightsFrame()
    {
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setContentPane(boardPanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Construct necessary data for game
        EightsGame game = new EightsGame();
        gHand1 = new ArrayList<>();
        gHand2 = new ArrayList<>();
        gHand3 = new ArrayList<>();
        gHand4 = new ArrayList<>();

        //Get list of players
        //TODO Change implementation to keep players as private members of EightsGame
        List<EightsPlayer> players = game.getPlayers();

        Hand pHand1 = players.get(0).getHand();
        Hand pHand2 = players.get(1).getHand();
        Hand pHand3 = players.get(2).getHand();
        Hand pHand4 = players.get(3).getHand();

        //Populate graphical hand of players initially
        for(int i = 0; i < 7; i++)
        {
            gHand1.add(makeGCardPlayer(pHand1.getCard(i)));
            gHand2.add(makeGCardPlayer(pHand1.getCard(i)));
            gHand3.add(makeGCardPlayer(pHand1.getCard(i)));
            gHand4.add(makeGCardPlayer(pHand1.getCard(i)));
        }

        //Initialize first players hand
        //paintHand(game.getCurrentPlayer());

    }

    //TODO make this common to all systems
    private JButton makeGCardPlayer(Card card)
    {

        String path = "com/team5/PNG-cards-82X164";
        //String path = "/Users/Coop/IdeaProjects/a1-007-team-5/CrazyEights/scr/com/team5/PNG-cards-82X164";

        ImageIcon cardImage = new ImageIcon(path+card.getFace()+"_of_"+card.getSuit()+".png");

        JButton card1Button = new JButton(cardImage);

        drawButton.setBounds(640,400, 82,164);

        return drawButton;

    }

    //TODO make this common to all systems
    private JButton makeGCardCenter(Card card)
    {

        String path = "com/team5/PNG-cards";
        //String path = "/Users/Coop/IdeaProjects/a1-007-team-5/CrazyEights/scr/com/team5/PNG-cards";

        ImageIcon cardImage = new ImageIcon(path+card.getFace()+"_of_"+card.getSuit()+".png");

        JButton card1Button = new JButton(cardImage);

        drawButton.setBounds(640,400, 100,200);

        return drawButton;

    }

    //Given a player, paints their hand of card buttons on the proper panel
    private void paintHand(EightsPlayer player)
    {
        switch(player.getID())
        {
            case "Player 1":
            {
                for(int i = 0; i < gHand1.size(); i++)
                {
                    handPanel.add(gHand1.get(i));
                }
                break;
            }

            case "Player 2":
            {
                for(int i = 0; i < gHand1.size(); i++)
                {
                    handPanel.add(gHand1.get(i));
                }
                break;
            }

            case "Player 3":
            {
                for(int i = 0; i < gHand1.size(); i++)
                {
                    handPanel.add(gHand1.get(i));
                }
                break;
            }

            case "Player 4":
            {
                for(int i = 0; i < gHand1.size(); i++)
                {
                    handPanel.add(gHand1.get(i));
                }
                break;
            }
        }
    }

    //Clears the handPanel of all card components
    private void clearHand()
    {
        handPanel.removeAll();
        handPanel.revalidate();
        handPanel.repaint();
    }

    private void createUIComponents()
    {
        // TODO: place custom component creation code here
    }
}
