package GUI;

import Core.*;

import javax.swing.*;
import javax.swing.ImageIcon;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
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
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel drawPanel;
    private JPanel namePanel;
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
    private JLabel drawLabel;
    private JPanel countPanel;
    private JPanel scorePanel;
    private JPanel spacePanel3;
    private JLabel playedCard;
    private JLabel playerName;

    private int playerCount;

    private ArrayList<JLabel> countList;
    private ArrayList<JLabel> scoreList;

    private List<EightsPlayer> players;

    private ArrayList<JButton> gHand;

    private Card selectedCard;

    private EightsGame game;

    public EightsFrame(int count)
    {
        playerCount = count;

        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setContentPane(boardPanel);
        drawButton.addActionListener(new DrawButtonClicked());
        playButton.addActionListener(new PlayButtonClicked(this));
        passButton.addActionListener(new PassButtonClicked());
        clubsButton.addActionListener(new SuitButtonClicked(Suit.CLUBS));
        heartsButton.addActionListener(new SuitButtonClicked(Suit.HEARTS));
        diamondsButton.addActionListener(new SuitButtonClicked(Suit.DIAMONDS));
        spadesButton.addActionListener(new SuitButtonClicked(Suit.SPADES));

        //Frame deletes when window is closed
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initialize();
    }

    private void initialize()
    {
        changeSuitPanel.setVisible(false);
        passButton.setVisible(false);
        playButton.setVisible(false);

        //Construct necessary data for game
        game = new EightsGame(playerCount);

        //Get list of players
        players = game.getPlayers();

        playerName = new JLabel();
        updateName();
        playerName.setVisible(true);
        namePanel.add(playerName);

        countList = new ArrayList<>();
        scoreList = new ArrayList<>();

        //Initialize score and count panels
        for(int i = 0; i < playerCount; i++)
        {
            JLabel cLabel = new JLabel();
            JLabel sLabel = new JLabel();
            countList.add(cLabel);
            scoreList.add(sLabel);

            cLabel.setPreferredSize(new Dimension(160, 20));
            cLabel.setText("Player " + (i+1) + "'s Card Count: " + players.get(i).getHandSize());
            countPanel.add(cLabel);
            cLabel.setVisible(true);

            sLabel.setPreferredSize(new Dimension(160, 20));
            sLabel.setText("Score: " + players.get(i).getScore());
            scorePanel.add(sLabel);
            sLabel.setVisible(true);

        }

        //Paints first players hand
        paintHand();

        //Paints top card of play pile
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

    private CardButton makeGCardPlayer(Card card)
    {

        String path = "./CrazyEights/src/resources/PNG-cards-82X164/" + card.getFace().getValue() + "_of_" + card.getSuit().getValue() + ".png";
        ImageIcon cardImage = new ImageIcon(path);

        CardButton tmp = new CardButton(card);

        tmp.setIcon(cardImage);

        tmp.setPreferredSize(new Dimension(82,164));

        return tmp;

    }

    private JLabel makeGPlayPile(Card card)
    {

        String path = "./CrazyEights/src/resources/PNG-cards-82X164/" + card.getFace().getValue() + "_of_" + card.getSuit().getValue() + ".png";
        ImageIcon cardImage = new ImageIcon(path);

        JLabel tmp = new JLabel(cardImage);

        tmp.setPreferredSize(new Dimension(100,200));

        return tmp;
    }

    public void nextPlayer(){

        resetButtons();
        handPanel.setVisible(false);
        playerName.setVisible(false);
        JOptionPane.showMessageDialog(boardPanel, "Core.Player " + game.getCurrentPlayer().getID() + "'s Turn!");
        playerName.setText("Core.Player " + game.getCurrentPlayer().getID() + "'s " + "Turn");
        playerName.setVisible(true);
        handPanel.setVisible(true);
        paintHand();

    }

    public void resetButtons(){

        updateScore();
        playButton.setVisible(false);

        if(game.canDrawCard()) {
            drawButton.setVisible(true);
            passButton.setVisible(false);
        }
        else{
            drawButton.setVisible(false);
            passButton.setVisible(true);
        }
    }

    //Given a player, paints their hand of card buttons on the proper panel
    private void paintHand()
    {
        handPanel.removeAll();

        List<Card> hand = game.getCurrentPlayer().getHand();
        for(Card card: hand){

            CardButton cButton = makeGCardPlayer(card);
            cButton.setVisible(true);
            handPanel.add(cButton);
        }
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
            resetButtons();

            if (game.isDeckEmpty()){
                //Core.Player winner = game.endGame();
                endGUI();
            }
        }
    }

    public class PassButtonClicked implements ActionListener
    {

        public void actionPerformed(ActionEvent e) {

            game.pass();
            nextPlayer();
        }
    }

    public class PlayButtonClicked implements ActionListener
    {
        //Needed to perform actions on the frame
        EightsFrame frame;

        public PlayButtonClicked(EightsFrame f)
        {
            frame = f;
        }

        public void actionPerformed(ActionEvent e) {

            int resultCode = game.playCard(selectedCard);

            //Core.Player sheds their entire hand
            if(resultCode == -1)
            {
                //Core.Player winner = game.endGame();
                frame.endGUI();
            }

            //Eights card was played
            if(resultCode == 1)
            {
                changeSuitPanel.setVisible(true);
                actionPanel.setVisible(false);
            }

            //Other card
            else
            {
                paintPlayPile();
                nextPlayer();

            }
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

    public class SuitButtonClicked implements ActionListener
    {
        //Needed to perform actions on the frame
        Suit suit;

        public SuitButtonClicked(Suit s)
        {
            suit = s;
        }

        public void actionPerformed(ActionEvent e)
        {
            game.changeSuit(suit);
            paintPlayPile();
            nextPlayer();
            actionPanel.setVisible(true);
            changeSuitPanel.setVisible(false);
        }
    }

    //Updates players scores in their JLabels at the top of the screen
    public void updateScore()
    {
        for(int i = 0; i < playerCount; i++)
        {
            countList.get(i).setText("Core.Player " + (i+1) + "'s Core.Card Count: " + players.get(i).getHandSize());
            scoreList.get(i).setText("Score: " + players.get(i).getScore());
        }

        //TODO ADD SCORE PANEL UPDATE HERE
    }

    //Updates current playerID on screen
    public void updateName()
    {
        playerName.setText("Core.Player " + game.getCurrentPlayer().getID() + "'s " +
                "Turn");
    }

    public void endGUI()
    {
        StringBuilder endMsg = new StringBuilder("Core.Player " + game.getWinner().getID() + " won this round!\n\n");

        for(EightsPlayer player: players)
            endMsg.append(String.format("%-15s", "Core.Player " + player.getID() + ":"));

        endMsg.append("\n");

        for(EightsPlayer player: players)
            endMsg.append(String.format("%-15d", player.getScore()));

        endMsg.append("\n");

        int pointsWon = 0;

        for(EightsPlayer player: players){
            if(player != game.getWinner())
                pointsWon += player.getHand().size();
        }

        for(EightsPlayer player: players){
            if(player != game.getWinner())
                endMsg.append(String.format("%-15d", -player.getHand().size()));
            else
                endMsg.append(String.format("%-+15d", pointsWon));
        }

        endMsg.append("\n\n");
        game.calcScore();

        for(EightsPlayer player: players)
            endMsg.append(String.format("%-15s", player.getScore()));

        endMsg.append("Total\n\n Play another round?");

        int a=JOptionPane.showConfirmDialog(boardPanel,endMsg.toString());

        if(a == JOptionPane.YES_OPTION)
        {
            game.newRound();
            paintHand();
            resetButtons();
        }
        else
        {
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }

}
