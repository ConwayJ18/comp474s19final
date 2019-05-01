package com.scorekeeper.model.graphics;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.scorekeeper.model.team.Player;

public class PlayerStats
{
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    static JFrame statsFrame;
	JLabel instructions;
	JLabel plusMinusLabel, gameTimeLabel, penaltyTimeLabel, blueCardLabel, yellowCardLabel, redCardLabel,
	plusMinus, gameTime, penaltyTime, blueCard, yellowCard, redCard;
	JButton save;
 
    private void addComponentsToPane(Container pane, Player player)
    {	
        if (RIGHT_TO_LEFT)
        {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
 
	    pane.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    
	    if (shouldFill)
	    {
		    //natural height, maximum width
		    c.fill = GridBagConstraints.HORIZONTAL;
	    }

        //Add the instructions.
        instructions = new JLabel("Stats for #" + player.getNumber() + ",  " + player.getName(), JLabel.CENTER);
        c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 0;       //reset to default
	    c.anchor = GridBagConstraints.PAGE_END; //bottom of space
	    c.insets = new Insets(10,0,10,0);  //top padding
	    c.gridx = 0;       //aligned left
	    c.gridy = 0;       //first row
	    c.gridwidth = 2;   //2 columns wide
	    pane.add(instructions, c);
	    
        JPanel statsLabels = new JPanel(new GridLayout(6,1));
        plusMinusLabel = new JLabel("+/-");
        gameTimeLabel = new JLabel("Game Time");
        penaltyTimeLabel = new JLabel("Penalty Time");
        blueCardLabel = new JLabel("Blue Cards");
        yellowCardLabel = new JLabel("Yellow Cards");
        redCardLabel = new JLabel("Red Cards");
        statsLabels.add(plusMinusLabel);
        statsLabels.add(gameTimeLabel);
        statsLabels.add(penaltyTimeLabel);
        statsLabels.add(blueCardLabel);
        statsLabels.add(yellowCardLabel);
        statsLabels.add(redCardLabel);
        c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 0;       //reset to default
	    c.anchor = GridBagConstraints.PAGE_END; //bottom of space
	    c.insets = new Insets(0,0,0,25);  //right padding
	    c.gridx = 0;       //aligned left
	    c.gridy = 1;       //second row
	    c.gridwidth = 1;   //1 column wide
	    pane.add(statsLabels, c);
	    
	    JPanel actualStats = new JPanel(new GridLayout(6,1));
	    plusMinus = new JLabel(String.valueOf(player.getPlusMinus()));
        gameTime = new JLabel(player.getPlayTime());
        penaltyTime = new JLabel(player.getPenaltyTime());
        blueCard = new JLabel(String.valueOf(player.getBlueCards()));
        yellowCard = new JLabel(String.valueOf(player.getYellowCards()));
        redCard = new JLabel(String.valueOf(player.getRedCards()));
        actualStats.add(plusMinus);
        actualStats.add(gameTime);
        actualStats.add(penaltyTime);
        actualStats.add(blueCard);
        actualStats.add(yellowCard);
        actualStats.add(redCard);
        c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 0;       //reset to default
	    c.anchor = GridBagConstraints.PAGE_END; //bottom of space
	    c.insets = new Insets(0,25,0,0);  //right padding
	    c.gridx = 1;       //aligned left
	    c.gridy = 1;       //second row
	    c.gridwidth = 1;   //1 column wide
	    pane.add(actualStats, c);
        
	    save = new JButton("Close");
	    save.addActionListener(new ActionListener() //Dictates what happens when acknowledge button is clicked
	    	    {  
	    	        public void actionPerformed(ActionEvent e)
	    	        {
	    	        	close();
	    	        }  
	    	    }); 
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 0;       //reset to default
	    c.anchor = GridBagConstraints.PAGE_END; //bottom of space
	    c.insets = new Insets(0,0,0,0);  //no padding
	    c.gridx = 0;       //aligned left
	    c.gridy = 2;       //third row
	    c.gridwidth = 2;   //2 columns wide
	    pane.add(save, c);
    }
    
    private void close()
    {
    	statsFrame.dispose();
    }
 
    public static void start(Player player)
    {
    	//Create and set up the window.
        statsFrame = new JFrame("Player Stats");
        statsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        statsFrame.setLocationRelativeTo(null);
 
        //Set up the content pane.
        PlayerStats ps = new PlayerStats();
        ps.addComponentsToPane(statsFrame.getContentPane(), player);
 
        //Display the window.
        statsFrame.pack();
        statsFrame.setVisible(true);
    }
}
