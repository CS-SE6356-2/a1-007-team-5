import javax.swing.*;
import java.awt.*;
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
    }

    public class SuitButtonClicked implements ActionListener
    {
        StartFrame startFrame;

        public SuitButtonClicked(StartFrame s)
        {
            startFrame = s;
        }

        public void actionPerformed(ActionEvent e)
        {
            int playerCount;
            try
            {
                String result = JOptionPane.showInputDialog(startFrame,"Enter number of players between 2 and 4");

                playerCount = Integer.parseInt(result);

                if(playerCount < 2 || playerCount > 4)
                {
                    throw new NumberFormatException();
                }

                startFrame.setVisible(false);
                EightsFrame gui = new EightsFrame(playerCount);
                gui.setVisible(true);

            }
            catch(NumberFormatException excep)
            {
                JOptionPane.showMessageDialog(startFrame, "Error: Please enter a valid number of players between 2 and 4");
            }

        }
    }
}
