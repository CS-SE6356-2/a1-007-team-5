package GUI;

import Core.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame extends JFrame
{

    private static final int WIDTH = 1280;
    private static final int HEIGHT = 800;
    private JPanel startPanel;
    private JButton startButton;
    private JLabel authors;
    private JLabel title;
    private JButton rulesButton;

    public StartFrame()
    {
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setContentPane(startPanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        startButton.addActionListener(new SuitButtonClicked(this));
        rulesButton.addActionListener(new RulesButtonClicked(this));
    }

    public class SuitButtonClicked implements ActionListener
    {
        StartFrame startFrame;

        SuitButtonClicked(StartFrame s)
        {
            startFrame = s;
        }

        public void actionPerformed(ActionEvent e)
        {
            int playerCount;
            try
            {
                String[] options = {"OK"};
                JPanel panel = new JPanel();
                JLabel lbl = new JLabel("Please enter how many players you want between 2 and 4: ");
                JTextField txt = new JTextField(10);
                panel.add(lbl);
                panel.add(txt);
                int selectedOption = JOptionPane.showOptionDialog(startFrame, panel, "The Title", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);

                if(selectedOption == 0)
                {
                    String text = txt.getText();
                    playerCount = Integer.parseInt(text);

                    if(playerCount < 2 || playerCount > 4)
                    {
                        throw new NumberFormatException();
                    }

                    startFrame.setVisible(false);
                    EightsFrame gui = new EightsFrame(playerCount);
                    gui.setVisible(true);
                }

            }
            catch(NumberFormatException excep)
            {
                JOptionPane.showMessageDialog(startFrame, "Error: Please enter a valid number of players between 2 and 4");
            }

        }
    }

    public class RulesButtonClicked implements ActionListener
    {
        StartFrame startFrame;

        RulesButtonClicked(StartFrame s)
        {
            startFrame = s;
        }

        public void actionPerformed(ActionEvent e)
        {
            String rules = "1.) Discard all cards in your hand to win! Or have the least cards when the deck runs out!\n"
                    + "2.) Each player begins with 5 cards. To play a card, click a card in your hand, and if it matches\n" +
                    "\tthe card in suit or value, press the play button, else you may draw until you have 13 cards or pass\n" +
                    "3.) You may play any \'8\' cards at any time in your turn. If you do, you may change the suit of the\n" +
                    "\t\'8\' card\n" +
                    "4.) See game manual for further rules and gameplay examples.";

            JOptionPane.showMessageDialog(startFrame, rules);
        }
    }
}
