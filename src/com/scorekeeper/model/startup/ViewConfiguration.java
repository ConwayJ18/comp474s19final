package com.scorekeeper.model.startup;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ViewConfiguration extends JPanel implements ActionListener {
    JRadioButton simpleButton, advancedButton;
    static JFrame viewFrame;
    JLabel instructions;
    JButton okay;
 
    public ViewConfiguration()
    {
        super(new BorderLayout());
 
        //Create the radio buttons.
        simpleButton = new JRadioButton("Basic");
        simpleButton.setMnemonic(KeyEvent.VK_B);
        simpleButton.setSelected(true);
 
        advancedButton = new JRadioButton("Advanced");
        advancedButton.setMnemonic(KeyEvent.VK_A);
        
        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(simpleButton);
        group.add(advancedButton);

        //Set up the label.
        instructions = new JLabel("Please select a display mode:");
        
        //Set up the button
        okay = new JButton("Select");
        okay.addActionListener(this);
 
        //Put the radio buttons in a column in a panel.
        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.add(simpleButton);
        radioPanel.add(advancedButton);
 
        add(instructions, BorderLayout.NORTH);
        add(radioPanel, BorderLayout.CENTER);
        add(okay, BorderLayout.SOUTH);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }
 
    /** Listens to the radio buttons. */
    public void actionPerformed(ActionEvent e)
    {
    	if(simpleButton.isSelected())
    	{
    		BasicTeamConfiguration.start();
    		viewFrame.dispose();
    	}
    	else
    	{
    		AdvancedTeamConfiguration.start();
    		viewFrame.dispose();
    	}
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI()
    {
        //Create and set up the window.
        viewFrame = new JFrame("Configuration Select");
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        JComponent newContentPane = new ViewConfiguration();
        newContentPane.setOpaque(true); //content panes must be opaque
        viewFrame.setContentPane(newContentPane);
        viewFrame.setLocationRelativeTo(null);
 
        //Display the window.
        viewFrame.pack();
        viewFrame.setVisible(true);
    }
 
    public static void start()
    {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}