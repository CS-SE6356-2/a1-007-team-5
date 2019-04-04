package com.team5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EightsFrame extends JFrame
{
    private JButton start;
    private JPanel boardPanel;
    private JPanel startPanel;

    DummyEightsCore dummyCore = new DummyEightsCore();

    public EightsFrame()
    {
        //Program ends when JFrame window is closed
        setDefaultCloseOperation(EightsFrame.EXIT_ON_CLOSE);

        add(boardPanel);
        add(startPanel);

        setTitle("This is a test frame");
        setSize(650,500);

        //Unsure if action listener should be within the constructor of the GUI, but I'm rollin' with it for the moment
        start.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dummyCore.initializeGame();
                start.setVisible(false);
                startPanel.setVisible(false);
            }
        });
    }
}
