import javax.swing.*;
import javax.swing.ImageIcon;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JPanel actionPanel;
    private JButton drawButton;
    private JButton playButton;
    private JButton diamondsButton;
    private JButton heartsButton;
    private JButton spadesButton;
    private JPanel spacePanel1;
    private JButton passButton;
    private JLabel playedCard;

    private List<EightsPlayer> players;

    private ArrayList<JButton> gHand;
    private ArrayList<JButton> gHand1;
    private ArrayList<JButton> gHand2;
    private ArrayList<JButton> gHand3;
    private ArrayList<JButton> gHand4;


    private Card selectedCard;

    private EightsGame game;

    private int currentPlayerIndex;

    public EightsFrame()
    {
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setContentPane(boardPanel);
        drawButton.addActionListener(new DrawButtonClicked());
        playButton.addActionListener(new PlayButtonClicked());
        passButton.addActionListener(new PassButtonClicked());

        //Frame deletes when window is closed
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        playButton.setVisible(false);

        //Construct necessary data for game
        game = new EightsGame(3);
        gHand = new ArrayList<>();
        /*gHand1 = new ArrayList<>();
        gHand2 = new ArrayList<>();
        gHand3 = new ArrayList<>();
        gHand4 = new ArrayList<>();*/

        //Get list of players
        //TODO Change implementation to keep players as private members of EightsGame
        players = game.getPlayers();

        /*pHand1 = players.get(0).getHand();
        pHand2 = players.get(1).getHand();
        pHand3 = players.get(2).getHand();
        pHand4 = players.get(3).getHand();*/

        //Populate graphical hand of players initially
        /*for(int i = 0; i < 7; i++)
        {
            gHand1.add(makeGCardPlayer(pHand1.getCard(i)));
            gHand2.add(makeGCardPlayer(pHand2.getCard(i)));
            gHand3.add(makeGCardPlayer(pHand3.getCard(i)));
            gHand4.add(makeGCardPlayer(pHand4.getCard(i)));
        }*/


        paintHand();

        paintPlayPile();

    }

    public class CardButton extends JButton
    {
        private Card card;

        public CardButton(Card c)
        {
            card = c;
            this.addActionListener(new CardButtonClicked(this));
        }

        public Card bGetCard()
        {
            return card;
        }
    }

    //TODO make this common to all systems with images
    private CardButton makeGCardPlayer(Card card)
    {

        String path = "./CrazyEights/src/resources/PNG-cards-82X164/" + card.getFace().getValue() + "_of_" + card.getSuit().getValue() + ".png";
        ImageIcon cardImage = new ImageIcon(path);

        CardButton tmp = new CardButton(card);

        tmp.setIcon(cardImage);

        tmp.setPreferredSize(new Dimension(82,164));

        return tmp;

    }

    //TODO make this common to all systems
    private JLabel makeGPlayPile(Card card)
    {

        String path = "./CrazyEights/src/resources/PNG-cards-82X164/" + card.getFace().getValue() + "_of_" + card.getSuit().getValue() + ".png";
        ImageIcon cardImage = new ImageIcon(path);

        JLabel tmp = new JLabel(cardImage);

        tmp.setPreferredSize(new Dimension(100,200));

        return tmp;
    }

    //Given a player, paints their hand of card buttons on the proper panel
    private void paintHand()
    {
        handPanel.removeAll();
        List<Card> hand = game.getCurrentHand();
        for(Card card: hand){

            CardButton cButton = makeGCardPlayer(card);
            cButton.setVisible(true);
            handPanel.add(cButton);
        }
        handPanel.revalidate();
        handPanel.repaint();

        if(game.canDrawCard()) {
            drawButton.setVisible(true);
            passButton.setVisible(false);
        }
        else{
            drawButton.setVisible(false);
            passButton.setVisible(true);
        }

        /*switch(player.getID())
        {
            case "1":
            {
                for(int i = 0; i < gHand1.size(); i++)
                {
                    gHand1.get(i).setVisible(true);
                    handPanel.add(gHand1.get(i));
                }
                break;
            }

            case "2":
            {
                for(int i = 0; i < gHand1.size(); i++)
                {
                    gHand2.get(i).setVisible(true);
                    handPanel.add(gHand1.get(i));
                }
                break;
            }

            case "3":
            {
                for(int i = 0; i < gHand1.size(); i++)
                {
                    gHand3.get(i).setVisible(true);
                    handPanel.add(gHand1.get(i));
                }
                break;
            }

            case "4":
            {
                for(int i = 0; i < gHand1.size(); i++)
                {
                    gHand4.get(i).setVisible(true);
                    handPanel.add(gHand1.get(i));
                }
                break;
            }
        }*/
    }

    //Clears the handPanel of all card components
    private void clearHand()
    {
        handPanel.removeAll();
        handPanel.revalidate();
        handPanel.repaint();
    }

    //Clears the playpanel, and then paints the play pile;
    private void paintPlayPile()
    {
        Card playPile = game.getPlayPile();
        playPanel.removeAll();
        JLabel temp = makeGPlayPile(playPile);
        temp.setVisible(true);
        playPanel.add(temp);
        playPanel.revalidate();
        playPanel.repaint();
    }

    //When the drawbutton is clicked
    //TODO check if deck is empty and end game
    //TODO figure out why there is a delay
    public class DrawButtonClicked implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            game.drawCard();
            paintHand();

            if (game.isDeckEmpty()){
                game.endGame();
            }
        }
    }

    public class PassButtonClicked implements ActionListener
    {

        public void actionPerformed(ActionEvent e) {

            game.pass();
            paintHand();
        }
    }

    public class PlayButtonClicked implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {

            game.playCard(selectedCard);
            paintPlayPile();
            paintHand();
            playButton.setVisible(false);
        }
    }

    //When any card button is clicked update the selected card member and check if its playable
    public class CardButtonClicked implements ActionListener
    {
        CardButton gCard;

        public CardButtonClicked(CardButton c)
        {
            gCard = c;
        }

        public void actionPerformed(ActionEvent e)
        {
            selectedCard = gCard.bGetCard();

            if(game.canPlayCard(selectedCard) || selectedCard.getFace() == Face.EIGHT)
            {
                playButton.setVisible(true);
            }
            else
            {
                playButton.setVisible(false);
            }
        }
    }

}
