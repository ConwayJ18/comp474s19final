package com.scorekeeper.model.startup;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.scorekeeper.model.graphics.AdvancedControls;
import com.scorekeeper.model.graphics.Graphics;
import com.scorekeeper.model.graphics.OutwardDisplay;
import com.scorekeeper.model.scoreboard.ScoreboardImpl;
import com.scorekeeper.model.team.Player;
import com.scorekeeper.model.team.PlayerImpl;
import com.scorekeeper.model.team.TeamImpl;
import com.scorekeeper.model.timer.TimerImpl;
 
public class AdvancedTeamConfiguration 
{
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    static JFrame teamFrame;
    JTextField teamName1, team1playerName1, team1playerName2, team1playerName3, team1playerName4, team1playerName5, team1playerName6, team1playerName7, team1playerName8, team1playerName9, team1playerName10;
    JTextField team1playerName11, team1playerName12, team1playerName13, team1playerName14, team1playerName15, team1playerName16, team1playerName17, team1playerName18, team1playerName19, team1playerName20, team1playerName21;
	JTextField team1playerNumber1, team1playerNumber2, team1playerNumber3, team1playerNumber4, team1playerNumber5, team1playerNumber6, team1playerNumber7, team1playerNumber8, team1playerNumber9, team1playerNumber10;
	JTextField team1playerNumber11, team1playerNumber12, team1playerNumber13, team1playerNumber14, team1playerNumber15, team1playerNumber16, team1playerNumber17, team1playerNumber18, team1playerNumber19, team1playerNumber20, team1playerNumber21;
	JTextField teamName2, team2playerName1, team2playerName2, team2playerName3, team2playerName4, team2playerName5, team2playerName6, team2playerName7, team2playerName8, team2playerName9, team2playerName10;
    JTextField team2playerName11, team2playerName12, team2playerName13, team2playerName14, team2playerName15, team2playerName16, team2playerName17, team2playerName18, team2playerName19, team2playerName20, team2playerName21;
	JTextField team2playerNumber1, team2playerNumber2, team2playerNumber3, team2playerNumber4, team2playerNumber5, team2playerNumber6, team2playerNumber7, team2playerNumber8, team2playerNumber9, team2playerNumber10;
	JTextField team2playerNumber11, team2playerNumber12, team2playerNumber13, team2playerNumber14, team2playerNumber15, team2playerNumber16, team2playerNumber17, team2playerNumber18, team2playerNumber19, team2playerNumber20, team2playerNumber21;
	JLabel instructions, team1NameLabel, team1NumberLabel, team2NameLabel, team2NumberLabel;
	JButton save;
 
    private void addComponentsToPane(Container pane)
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
	    
	    teamName1 = new JTextField("Team 1");
        team1NameLabel = new JLabel("Player Last Name", JLabel.CENTER);
        team1playerName1 = new JTextField("");
        team1playerName2 = new JTextField("");
        team1playerName3 = new JTextField("");
        team1playerName4 = new JTextField("");
        team1playerName5 = new JTextField("");
        team1playerName6 = new JTextField("");
        team1playerName7 = new JTextField("");
        team1playerName8 = new JTextField("");
        team1playerName9 = new JTextField("");
        team1playerName10 = new JTextField("");
        team1playerName11 = new JTextField("");
        team1playerName12 = new JTextField("");
        team1playerName13 = new JTextField("");
        team1playerName14 = new JTextField("");
        team1playerName15 = new JTextField("");
        team1playerName16 = new JTextField("");
        team1playerName17 = new JTextField("");
        team1playerName18 = new JTextField("");
        team1playerName19 = new JTextField("");
        team1playerName20 = new JTextField("");
        team1playerName21 = new JTextField("");
        team1NumberLabel = new JLabel("Player Number", JLabel.CENTER);
        team1playerNumber1 = new JTextField("0");
        team1playerNumber2 = new JTextField("0");
        team1playerNumber3 = new JTextField("0");
        team1playerNumber4 = new JTextField("0");
        team1playerNumber5 = new JTextField("0");
        team1playerNumber6 = new JTextField("0");
        team1playerNumber7 = new JTextField("0");
        team1playerNumber8 = new JTextField("0");
        team1playerNumber9 = new JTextField("0");
        team1playerNumber10 = new JTextField("0");
        team1playerNumber11 = new JTextField("0");
        team1playerNumber12 = new JTextField("0");
        team1playerNumber13 = new JTextField("0");
        team1playerNumber14 = new JTextField("0");
        team1playerNumber15 = new JTextField("0");
        team1playerNumber16 = new JTextField("0");
        team1playerNumber17 = new JTextField("0");
        team1playerNumber18 = new JTextField("0");
        team1playerNumber19 = new JTextField("0");
        team1playerNumber20 = new JTextField("0");
        team1playerNumber21 = new JTextField("0");
        
        teamName2 = new JTextField("Team 2");
        team2NameLabel = new JLabel("Player Last Name", JLabel.CENTER);
        team2playerName1 = new JTextField("");
        team2playerName2 = new JTextField("");
        team2playerName3 = new JTextField("");
        team2playerName4 = new JTextField("");
        team2playerName5 = new JTextField("");
        team2playerName6 = new JTextField("");
        team2playerName7 = new JTextField("");
        team2playerName8 = new JTextField("");
        team2playerName9 = new JTextField("");
        team2playerName10 = new JTextField("");
        team2playerName11 = new JTextField("");
        team2playerName12 = new JTextField("");
        team2playerName13 = new JTextField("");
        team2playerName14 = new JTextField("");
        team2playerName15 = new JTextField("");
        team2playerName16 = new JTextField("");
        team2playerName17 = new JTextField("");
        team2playerName18 = new JTextField("");
        team2playerName19 = new JTextField("");
        team2playerName20 = new JTextField("");
        team2playerName21 = new JTextField("");
        team2NumberLabel = new JLabel("Player Number", JLabel.CENTER);
        team2playerNumber1 = new JTextField("0");
        team2playerNumber2 = new JTextField("0");
        team2playerNumber3 = new JTextField("0");
        team2playerNumber4 = new JTextField("0");
        team2playerNumber5 = new JTextField("0");
        team2playerNumber6 = new JTextField("0");
        team2playerNumber7 = new JTextField("0");
        team2playerNumber8 = new JTextField("0");
        team2playerNumber9 = new JTextField("0");
        team2playerNumber10 = new JTextField("0");
        team2playerNumber11 = new JTextField("0");
        team2playerNumber12 = new JTextField("0");
        team2playerNumber13 = new JTextField("0");
        team2playerNumber14 = new JTextField("0");
        team2playerNumber15 = new JTextField("0");
        team2playerNumber16 = new JTextField("0");
        team2playerNumber17 = new JTextField("0");
        team2playerNumber18 = new JTextField("0");
        team2playerNumber19 = new JTextField("0");
        team2playerNumber20 = new JTextField("0");
        team2playerNumber21 = new JTextField("0");

        //Add the instructions.
        instructions = new JLabel("Please enter team information (List starters first):", JLabel.CENTER);
        c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 0;       //reset to default
	    c.anchor = GridBagConstraints.PAGE_END; //bottom of space
	    c.insets = new Insets(10,0,10,0);  //top padding
	    c.gridx = 0;       //aligned left
	    c.gridy = 0;       //first row
	    c.gridwidth = 5;   //4 columns wide
	    pane.add(instructions, c);
        
        //Add team names
        c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 0;       //reset to default
	    c.anchor = GridBagConstraints.PAGE_END; //bottom of space
	    c.insets = new Insets(0,0,0,25);  //right padding
	    c.gridx = 0;       //aligned left
	    c.gridy = 1;       //second row
	    c.gridwidth = 2;   //2 columns wide
        pane.add(teamName1, c);
        c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 0;       //reset to default
	    c.anchor = GridBagConstraints.PAGE_END; //bottom of space
	    c.insets = new Insets(0,25,0,0);  //left padding
	    c.gridx = 3;       //fourth column
	    c.gridy = 1;       //second row
	    c.gridwidth = 2;   //2 columns wide
        pane.add(teamName2, c);
	    
        //Add players
        JPanel team1Panel = new JPanel(new GridLayout(22,2));
        team1Panel.add(team1NameLabel);
        team1Panel.add(team1NumberLabel);
        team1Panel.add(team1playerName1);
        team1Panel.add(team1playerNumber1);
        team1Panel.add(team1playerName2);
        team1Panel.add(team1playerNumber2);
        team1Panel.add(team1playerName2);
        team1Panel.add(team1playerNumber2);
        team1Panel.add(team1playerName3);
        team1Panel.add(team1playerNumber3);
        team1Panel.add(team1playerName4);
        team1Panel.add(team1playerNumber4);
        team1Panel.add(team1playerName5);
        team1Panel.add(team1playerNumber5);
        team1Panel.add(team1playerName6);
        team1Panel.add(team1playerNumber6);
        team1Panel.add(team1playerName7);
        team1Panel.add(team1playerNumber7);
        team1Panel.add(team1playerName8);
        team1Panel.add(team1playerNumber8);
        team1Panel.add(team1playerName9);
        team1Panel.add(team1playerNumber9);
        team1Panel.add(team1playerName10);
        team1Panel.add(team1playerNumber10);
        team1Panel.add(team1playerName11);
        team1Panel.add(team1playerNumber11);
        team1Panel.add(team1playerName12);
        team1Panel.add(team1playerNumber12);
        team1Panel.add(team1playerName12);
        team1Panel.add(team1playerNumber12);
        team1Panel.add(team1playerName13);
        team1Panel.add(team1playerNumber13);
        team1Panel.add(team1playerName14);
        team1Panel.add(team1playerNumber14);
        team1Panel.add(team1playerName15);
        team1Panel.add(team1playerNumber15);
        team1Panel.add(team1playerName16);
        team1Panel.add(team1playerNumber16);
        team1Panel.add(team1playerName17);
        team1Panel.add(team1playerNumber17);
        team1Panel.add(team1playerName18);
        team1Panel.add(team1playerNumber18);
        team1Panel.add(team1playerName19);
        team1Panel.add(team1playerNumber19);
        team1Panel.add(team1playerName20);
        team1Panel.add(team1playerNumber20);
        team1Panel.add(team1playerName21);
        team1Panel.add(team1playerNumber21);
        c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 0;       //reset to default
	    c.anchor = GridBagConstraints.PAGE_END; //bottom of space
	    c.insets = new Insets(0,0,0,25);  //right padding
	    c.gridx = 0;       //aligned left
	    c.gridy = 2;       //third row
	    c.gridwidth = 2;   //2 columns wide
	    pane.add(team1Panel, c);
	    
	    JPanel playerCountPanel = new JPanel(new GridLayout(22,1));
	    JTextField playerCount = new JTextField(" ");
	    playerCount.setVisible(false);
    	playerCountPanel.add(playerCount);
	    for(int i=1; i<=21; i++)
	    {
	    	playerCount = new JTextField(String.valueOf(i));
	    	playerCount.setHorizontalAlignment(JTextField.CENTER);
	    	playerCount.setBackground(null);
	    	playerCount.setBorder(null);
	    	playerCount.setEditable(false);
	    	playerCountPanel.add(playerCount, BorderLayout.CENTER);
	    }
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 0;       //reset to default
	    c.anchor = GridBagConstraints.CENTER; //bottom of space
	    c.insets = new Insets(0,0,0,0);  //right padding
	    c.gridx = 2;       //third column
	    c.gridy = 2;       //third row
	    c.gridwidth = 1;   //2 columns wide
	    pane.add(playerCountPanel, c);
	    
	    JPanel team2Panel = new JPanel(new GridLayout(22,2));
        team2Panel.add(team2NameLabel);
        team2Panel.add(team2NumberLabel);
        team2Panel.add(team2playerName1);
        team2Panel.add(team2playerNumber1);
        team2Panel.add(team2playerName2);
        team2Panel.add(team2playerNumber2);
        team2Panel.add(team2playerName2);
        team2Panel.add(team2playerNumber2);
        team2Panel.add(team2playerName3);
        team2Panel.add(team2playerNumber3);
        team2Panel.add(team2playerName4);
        team2Panel.add(team2playerNumber4);
        team2Panel.add(team2playerName5);
        team2Panel.add(team2playerNumber5);
        team2Panel.add(team2playerName6);
        team2Panel.add(team2playerNumber6);
        team2Panel.add(team2playerName7);
        team2Panel.add(team2playerNumber7);
        team2Panel.add(team2playerName8);
        team2Panel.add(team2playerNumber8);
        team2Panel.add(team2playerName9);
        team2Panel.add(team2playerNumber9);
        team2Panel.add(team2playerName10);
        team2Panel.add(team2playerNumber10);
        team2Panel.add(team2playerName11);
        team2Panel.add(team2playerNumber11);
        team2Panel.add(team2playerName12);
        team2Panel.add(team2playerNumber12);
        team2Panel.add(team2playerName12);
        team2Panel.add(team2playerNumber12);
        team2Panel.add(team2playerName13);
        team2Panel.add(team2playerNumber13);
        team2Panel.add(team2playerName14);
        team2Panel.add(team2playerNumber14);
        team2Panel.add(team2playerName15);
        team2Panel.add(team2playerNumber15);
        team2Panel.add(team2playerName16);
        team2Panel.add(team2playerNumber16);
        team2Panel.add(team2playerName17);
        team2Panel.add(team2playerNumber17);
        team2Panel.add(team2playerName18);
        team2Panel.add(team2playerNumber18);
        team2Panel.add(team2playerName19);
        team2Panel.add(team2playerNumber19);
        team2Panel.add(team2playerName20);
        team2Panel.add(team2playerNumber20);
        team2Panel.add(team2playerName21);
        team2Panel.add(team2playerNumber21);
        c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 0;       //reset to default
	    c.anchor = GridBagConstraints.PAGE_END; //bottom of space
	    c.insets = new Insets(0,25,0,0);  //left padding
	    c.gridx = 3;       //fourth column
	    c.gridy = 2;       //third row
	    c.gridwidth = 2;   //2 columns wide
	    pane.add(team2Panel, c);
	 
	    save = new JButton("Save");
	    save.addActionListener(new ActionListener() //Dictates what happens when acknowledge button is clicked
	    	    {  
	    	        public void actionPerformed(ActionEvent e)
	    	        {
	    	        	submit();
	    	        }  
	    	    }); 
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 0;       //reset to default
	    c.anchor = GridBagConstraints.PAGE_END; //bottom of space
	    c.insets = new Insets(0,0,0,0);  //no padding
	    c.gridx = 0;       //aligned left
	    c.gridy = 3;       //fourth row
	    c.gridwidth = 5;   //5 columns wide
	    pane.add(save, c);
    }
    
    private void submit()
    {
    	ArrayList<Player> team1players = new ArrayList<Player>();
		team1players.add(new PlayerImpl(team1playerName1.getText(), Integer.valueOf(team1playerNumber1.getText())));
		team1players.add(new PlayerImpl(team1playerName2.getText(), Integer.valueOf(team1playerNumber2.getText())));
		team1players.add(new PlayerImpl(team1playerName3.getText(), Integer.valueOf(team1playerNumber3.getText())));
		team1players.add(new PlayerImpl(team1playerName4.getText(), Integer.valueOf(team1playerNumber4.getText())));
		team1players.add(new PlayerImpl(team1playerName5.getText(), Integer.valueOf(team1playerNumber5.getText())));
		team1players.add(new PlayerImpl(team1playerName6.getText(), Integer.valueOf(team1playerNumber6.getText())));
		team1players.add(new PlayerImpl(team1playerName7.getText(), Integer.valueOf(team1playerNumber7.getText())));
		team1players.add(new PlayerImpl(team1playerName8.getText(), Integer.valueOf(team1playerNumber8.getText())));
		team1players.add(new PlayerImpl(team1playerName9.getText(), Integer.valueOf(team1playerNumber9.getText())));
		team1players.add(new PlayerImpl(team1playerName10.getText(), Integer.valueOf(team1playerNumber10.getText())));
		team1players.add(new PlayerImpl(team1playerName11.getText(), Integer.valueOf(team1playerNumber11.getText())));
		team1players.add(new PlayerImpl(team1playerName12.getText(), Integer.valueOf(team1playerNumber12.getText())));
		team1players.add(new PlayerImpl(team1playerName13.getText(), Integer.valueOf(team1playerNumber13.getText())));
		team1players.add(new PlayerImpl(team1playerName14.getText(), Integer.valueOf(team1playerNumber14.getText())));
		team1players.add(new PlayerImpl(team1playerName15.getText(), Integer.valueOf(team1playerNumber15.getText())));
		team1players.add(new PlayerImpl(team1playerName16.getText(), Integer.valueOf(team1playerNumber16.getText())));
		team1players.add(new PlayerImpl(team1playerName17.getText(), Integer.valueOf(team1playerNumber17.getText())));
		team1players.add(new PlayerImpl(team1playerName18.getText(), Integer.valueOf(team1playerNumber18.getText())));
		team1players.add(new PlayerImpl(team1playerName19.getText(), Integer.valueOf(team1playerNumber19.getText())));
		team1players.add(new PlayerImpl(team1playerName20.getText(), Integer.valueOf(team1playerNumber20.getText())));
		team1players.add(new PlayerImpl(team1playerName21.getText(), Integer.valueOf(team1playerNumber21.getText())));
		ArrayList<Player> team2players = new ArrayList<Player>();
		team2players.add(new PlayerImpl(team2playerName1.getText(), Integer.valueOf(team2playerNumber1.getText())));
		team2players.add(new PlayerImpl(team2playerName2.getText(), Integer.valueOf(team2playerNumber2.getText())));
		team2players.add(new PlayerImpl(team2playerName3.getText(), Integer.valueOf(team2playerNumber3.getText())));
		team2players.add(new PlayerImpl(team2playerName4.getText(), Integer.valueOf(team2playerNumber4.getText())));
		team2players.add(new PlayerImpl(team2playerName5.getText(), Integer.valueOf(team2playerNumber5.getText())));
		team2players.add(new PlayerImpl(team2playerName6.getText(), Integer.valueOf(team2playerNumber6.getText())));
		team2players.add(new PlayerImpl(team2playerName7.getText(), Integer.valueOf(team2playerNumber7.getText())));
		team2players.add(new PlayerImpl(team2playerName8.getText(), Integer.valueOf(team2playerNumber8.getText())));
		team2players.add(new PlayerImpl(team2playerName9.getText(), Integer.valueOf(team2playerNumber9.getText())));
		team2players.add(new PlayerImpl(team2playerName10.getText(), Integer.valueOf(team2playerNumber10.getText())));
		team2players.add(new PlayerImpl(team2playerName11.getText(), Integer.valueOf(team2playerNumber11.getText())));
		team2players.add(new PlayerImpl(team2playerName12.getText(), Integer.valueOf(team2playerNumber12.getText())));
		team2players.add(new PlayerImpl(team2playerName13.getText(), Integer.valueOf(team2playerNumber13.getText())));
		team2players.add(new PlayerImpl(team2playerName14.getText(), Integer.valueOf(team2playerNumber14.getText())));
		team2players.add(new PlayerImpl(team2playerName15.getText(), Integer.valueOf(team2playerNumber15.getText())));
		team2players.add(new PlayerImpl(team2playerName16.getText(), Integer.valueOf(team2playerNumber16.getText())));
		team2players.add(new PlayerImpl(team2playerName17.getText(), Integer.valueOf(team2playerNumber17.getText())));
		team2players.add(new PlayerImpl(team2playerName18.getText(), Integer.valueOf(team2playerNumber18.getText())));
		team2players.add(new PlayerImpl(team2playerName19.getText(), Integer.valueOf(team2playerNumber19.getText())));
		team2players.add(new PlayerImpl(team2playerName20.getText(), Integer.valueOf(team2playerNumber20.getText())));
		team2players.add(new PlayerImpl(team2playerName21.getText(), Integer.valueOf(team2playerNumber21.getText())));
		
		Graphics controlDisplay = new AdvancedControls();
		Graphics outwardDisplay = new OutwardDisplay();
		TimerImpl t = new TimerImpl();
		t.addObserver(controlDisplay);
		t.addObserver(outwardDisplay);
		ScoreboardImpl s = new ScoreboardImpl();
		s.addObserver(controlDisplay);
		s.addObserver(outwardDisplay);
		TeamImpl t1 = new TeamImpl(teamName1.getText());
		t1.addObserver(controlDisplay);
		t1.addObserver(outwardDisplay);
		t1.addPlayers(team1players);
		TeamImpl t2 = new TeamImpl(teamName2.getText());
		t2.addObserver(controlDisplay);
		t2.addObserver(outwardDisplay);
		t2.addPlayers(team2players);
		controlDisplay.start(t, s, t1, t2);
		outwardDisplay.start(t, s, t1, t2);
		teamFrame.dispose();
    }
 
    public static void start()
    {
    	//Create and set up the window.
        teamFrame = new JFrame("Team Setup");
        teamFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        teamFrame.setLocationRelativeTo(null);
 
        //Set up the content pane.
        AdvancedTeamConfiguration atc = new AdvancedTeamConfiguration();
        atc.addComponentsToPane(teamFrame.getContentPane());
 
        //Display the window.
        teamFrame.pack();
        teamFrame.setVisible(true);
    }
}
