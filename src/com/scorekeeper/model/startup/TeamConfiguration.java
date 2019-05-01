package com.scorekeeper.model.startup;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.scorekeeper.model.graphics.AdvancedControls;
import com.scorekeeper.model.graphics.BasicControls;
import com.scorekeeper.model.graphics.Graphics;
import com.scorekeeper.model.graphics.OutwardDisplay;
import com.scorekeeper.model.scoreboard.ScoreboardImpl;
import com.scorekeeper.model.team.Player;
import com.scorekeeper.model.team.PlayerImpl;
import com.scorekeeper.model.team.Team;
import com.scorekeeper.model.team.TeamImpl;
import com.scorekeeper.model.timer.TimerImpl;

public class TeamConfiguration extends JPanel implements ActionListener
{
	static JFrame teamFrame;
	static boolean buttonActionFlag = true;
	JTextField teamName1, team1playerName1, team1playerName2, team1playerName3, team1playerName4, team1playerName5, team1playerName6, team1playerName7;
	JTextField team1playerNumber1, team1playerNumber2, team1playerNumber3, team1playerNumber4, team1playerNumber5, team1playerNumber6, team1playerNumber7;
	JTextField teamName2, team2playerName1, team2playerName2, team2playerName3, team2playerName4, team2playerName5, team2playerName6, team2playerName7;
	JTextField team2playerNumber1, team2playerNumber2, team2playerNumber3, team2playerNumber4, team2playerNumber5, team2playerNumber6, team2playerNumber7;
	JButton save;
	JLabel instructions, team1NameLabel, team1NumberLabel, team2NameLabel, team2NumberLabel;
	
	TeamConfiguration()
	{
		super(new BorderLayout());
		
		teamName1 = new JTextField("Team 1");
		teamName2 = new JTextField("Team 2");
		
		//Set up the instructions.
        instructions = new JLabel("Please enter team information:");
        
        //Set up team names
        JPanel teamPanel = new JPanel(new GridLayout(1,2));
        teamPanel.add(teamName1);
        teamPanel.add(teamName2);
        
        //Set up the button
        save = new JButton("Save");
        save.addActionListener(this);
 
        this.setLayout(new GridLayout(3,1));
        add(instructions);
        add(teamPanel);
        add(save);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }
 
	TeamConfiguration(int flag)
	{
		super(new BorderLayout());
		buttonActionFlag = false;
		 
        //Create the radio buttons.
		teamName1 = new JTextField("Team 1");
        team1playerName1 = new JTextField();
        team1playerName2 = new JTextField();
        team1playerName3 = new JTextField();
        team1playerName4 = new JTextField();
        team1playerName5 = new JTextField();
        team1playerName6 = new JTextField();
        team1playerName7 = new JTextField();
        
        team1playerNumber1 = new JTextField();
        team1playerNumber2 = new JTextField();
        team1playerNumber3 = new JTextField();
        team1playerNumber4 = new JTextField();
        team1playerNumber5 = new JTextField();
        team1playerNumber6 = new JTextField();
        team1playerNumber7 = new JTextField();
        
        teamName2 = new JTextField("Team 2");
        team2playerName1 = new JTextField();
        team2playerName2 = new JTextField();
        team2playerName3 = new JTextField();
        team2playerName4 = new JTextField();
        team2playerName5 = new JTextField();
        team2playerName6 = new JTextField();
        team2playerName7 = new JTextField();
        
        team2playerNumber1 = new JTextField();
        team2playerNumber2 = new JTextField();
        team2playerNumber3 = new JTextField();
        team2playerNumber4 = new JTextField();
        team2playerNumber5 = new JTextField();
        team2playerNumber6 = new JTextField();
        team2playerNumber7 = new JTextField();

        //Set up the instructions.
        instructions = new JLabel("Please enter team information:");
        
        //Set up the labels
        team1NameLabel = new JLabel("Player Last Name");
        team1NumberLabel = new JLabel("Player Number");
        team2NameLabel = new JLabel("Player Last Name");
        team2NumberLabel = new JLabel("Player Number");
        
        
        //Set up team names
        JPanel teamPanel = new JPanel(new GridLayout(1,2));
        teamPanel.add(teamName1);
        teamPanel.add(teamName2);
 
        //Setup players
        JPanel playerPanel = new JPanel(new GridLayout(8,4));
        playerPanel.add(team1NameLabel);
        playerPanel.add(team1NumberLabel);
        playerPanel.add(team2NameLabel);
        playerPanel.add(team2NumberLabel);
        playerPanel.add(team1playerName1);
        playerPanel.add(team1playerNumber1);
        playerPanel.add(team2playerName1);
        playerPanel.add(team2playerNumber1);
        playerPanel.add(team1playerName2);
        playerPanel.add(team1playerNumber2);
        playerPanel.add(team2playerName2);
        playerPanel.add(team2playerNumber2);
        playerPanel.add(team1playerName2);
        playerPanel.add(team1playerNumber2);
        playerPanel.add(team2playerName2);
        playerPanel.add(team2playerNumber2);
        playerPanel.add(team1playerName3);
        playerPanel.add(team1playerNumber3);
        playerPanel.add(team2playerName3);
        playerPanel.add(team2playerNumber3);
        playerPanel.add(team1playerName4);
        playerPanel.add(team1playerNumber4);
        playerPanel.add(team2playerName4);
        playerPanel.add(team2playerNumber4);
        playerPanel.add(team1playerName5);
        playerPanel.add(team1playerNumber5);
        playerPanel.add(team2playerName5);
        playerPanel.add(team2playerNumber5);
        playerPanel.add(team1playerName6);
        playerPanel.add(team1playerNumber6);
        playerPanel.add(team2playerName6);
        playerPanel.add(team2playerNumber6);
        playerPanel.add(team1playerName7);
        playerPanel.add(team1playerNumber7);
        playerPanel.add(team2playerName7);
        playerPanel.add(team2playerNumber7);
        
        //Set up the button
        save = new JButton("Save");
        save.addActionListener(this);
 
        this.setLayout(new GridLayout(5,1));
        add(instructions);
        add(teamPanel);
        add(playerPanel);
        add(save);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
	}
	
    /** Listens to the radio buttons. */
    public void actionPerformed(ActionEvent e)
    {
    	if(buttonActionFlag)
    	{
    		Graphics controlDisplay = new BasicControls();
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
    		TeamImpl t2 = new TeamImpl(teamName2.getText());
    		t2.addObserver(controlDisplay);
    		t2.addObserver(outwardDisplay);
    		controlDisplay.start(t, s, t1, t2);
    		outwardDisplay.start(t, s, t1, t2);
    	}
    	else
    	{
    		ArrayList<Player> team1players = new ArrayList<Player>();
    		team1players.add(new PlayerImpl(team1playerName1.getText(), Integer.valueOf(team1playerNumber1.getText())));
    		team1players.add(new PlayerImpl(team1playerName2.getText(), Integer.valueOf(team1playerNumber2.getText())));
    		team1players.add(new PlayerImpl(team1playerName3.getText(), Integer.valueOf(team1playerNumber3.getText())));
    		team1players.add(new PlayerImpl(team1playerName4.getText(), Integer.valueOf(team1playerNumber4.getText())));
    		team1players.add(new PlayerImpl(team1playerName5.getText(), Integer.valueOf(team1playerNumber5.getText())));
    		team1players.add(new PlayerImpl(team1playerName6.getText(), Integer.valueOf(team1playerNumber6.getText())));
    		team1players.add(new PlayerImpl(team1playerName7.getText(), Integer.valueOf(team1playerNumber7.getText())));
    		ArrayList<Player> team2players = new ArrayList<Player>();
    		team2players.add(new PlayerImpl(team2playerName1.getText(), Integer.valueOf(team2playerNumber1.getText())));
    		team2players.add(new PlayerImpl(team2playerName2.getText(), Integer.valueOf(team2playerNumber2.getText())));
    		team2players.add(new PlayerImpl(team2playerName3.getText(), Integer.valueOf(team2playerNumber3.getText())));
    		team2players.add(new PlayerImpl(team2playerName4.getText(), Integer.valueOf(team2playerNumber4.getText())));
    		team2players.add(new PlayerImpl(team2playerName5.getText(), Integer.valueOf(team2playerNumber5.getText())));
    		team2players.add(new PlayerImpl(team2playerName6.getText(), Integer.valueOf(team2playerNumber6.getText())));
    		team2players.add(new PlayerImpl(team2playerName7.getText(), Integer.valueOf(team2playerNumber7.getText())));
    		
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
    	}
    }
	
	public static void start(boolean simpleInterface)
	{
		if(simpleInterface)
		{
			launchBasicSetup();
		}
		else
		{
			launchAdvancedSetup();
		}
	}
	
	private static void launchBasicSetup()
	{
        //Create and set up the window.
        teamFrame = new JFrame("Team Setup");
        teamFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        JComponent newContentPane = new TeamConfiguration();
        newContentPane.setOpaque(true); //content panes must be opaque
        teamFrame.setContentPane(newContentPane);
        teamFrame.setLocationRelativeTo(null);
 
        //Display the window.
        teamFrame.pack();
        teamFrame.setVisible(true);
        
        teamFrame = new JFrame("Configuration Select");
        teamFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private static void launchAdvancedSetup()
	{
        //Create and set up the window.
        teamFrame = new JFrame("Team Setup");
        teamFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        JComponent newContentPane = new TeamConfiguration(1);
        newContentPane.setOpaque(true); //content panes must be opaque
        teamFrame.setContentPane(newContentPane);
        teamFrame.setLocationRelativeTo(null);
 
        //Display the window.
        teamFrame.pack();
        teamFrame.setVisible(true);
        
        teamFrame = new JFrame("Configuration Select");
        teamFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
