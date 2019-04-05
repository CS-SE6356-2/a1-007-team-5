package com.team5;

import javax.swing.*;
import java.awt.*;


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

    private DummyEightsCore testCore;

    public EightsFrame()
    {
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setContentPane(boardPanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        testCore = new DummyEightsCore();
    }

    private void createUIComponents()
    {
        // TODO: place custom component creation code here
    }
}
