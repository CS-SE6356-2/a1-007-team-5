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
            startFrame.setVisible(false);
            EightsFrame gui = new EightsFrame();
            gui.setVisible(true);
        }
    }
}
