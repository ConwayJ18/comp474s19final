package com.scorekeeper.model.graphics;

import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

import com.scorekeeper.model.scoreboard.Scoreboard;
import com.scorekeeper.model.scoreboard.ScoreboardImpl;
import com.scorekeeper.model.team.TeamImpl;
import com.scorekeeper.model.timer.TimerImpl;

public class OutwardDisplay implements Graphics
{
	public JFrame frame;
    public Scoreboard scoreboard;
	public TimerImpl timer;
	public QTextField timebox, scorebox1, scorebox2, teamName1, teamName2, notifications; //Text Fields
	public TeamImpl team1, team2;
	
	public void start(TimerImpl t, ScoreboardImpl s, TeamImpl t1, TeamImpl t2)
	{
		frame = new JFrame("Quidditch Scorekeeper"); //Create window with title "Quidditch Scorekeeper"
		frame.setSize(1450, 800); //Set window size
		frame.getContentPane().setBackground(new Color(153,153,153)); //Dark gray
		timer = t;
		timer.setBackground(new Color(243,243,243)); //Light gray
		timer.setBounds(425, 25, 600, 150);
		scoreboard = s; //Creates a scoreboard object for use
		
		/*
		 * Begin creation of buttons & windows
		 */
		//Create timebox
		timebox = new QTextField("00:00:00", 1, 425, 25, 600, 150);
		
		//Create scoreboxes
		scorebox1=new QTextField("0", 2, 25, 200, 675, 450); //Set default value & position
	    scorebox2=new QTextField("0", 2, 750, 200, 675, 450); //Set default value & position
	    teamName1=new QTextField("Team 1", 4, 25, 660, 675, 100);
	    teamName2=new QTextField("Team 2", 4, 750, 660, 675, 100);
	    /*
		 * End creation of buttons & windows
		 */
		
	    /*
		 * Begin adding items to window
		 */
		frame.add(timebox); //Add timer to window
		
	    frame.add(scorebox1); //Add scoreboxes to window
	    frame.add(scorebox2);
	    frame.add(teamName1);
	    frame.add(teamName2);
	    /*
		 * End adding items to window
		 */
	    
	    //These things need to go last to prevent loading lag
		frame.setLocationRelativeTo(null); //Centers window on screen
		frame.setLayout(null); //Allows us to manually set item locations
		//frame.setResizable(false); //Disallows resizing the window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Makes program quit when the window closes
		frame.setVisible(true); //Makes the window visible
		
		/*
		 * Add detection of window size
		 */
		frame.addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent componentEvent) {
		    	resizeComponents();
		    }
		});
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	private void resizeComponents()
	{
		int frameWidth = frame.getWidth();
		int frameHeight = frame.getHeight();
		
		scorebox1.setBounds(25*frameWidth/1450, 200*frameHeight/800, 675*frameWidth/1450, 450*frameHeight/800, Math.min(256*frameWidth/1450,256*frameHeight/800));	    
	    scorebox2.setBounds(750*frameWidth/1450, 200*frameHeight/800, 675*frameWidth/1450, 450*frameHeight/800, Math.min(256*frameWidth/1450,256*frameHeight/800));
	    teamName1.setBounds(25*frameWidth/1450, 660*frameHeight/800, 675*frameWidth/1450, 100*frameHeight/800, Math.min(256*frameWidth/1450,72*frameHeight/800));	    
	    teamName2.setBounds(750*frameWidth/1450, 660*frameHeight/800, 675*frameWidth/1450, 100*frameHeight/800, Math.min(256*frameWidth/1450,72*frameHeight/800));
		timebox.setBounds(425*frameWidth/1450, 25*frameHeight/800, 600*frameWidth/1450, 150*frameHeight/800, Math.min(126*frameWidth/1450,126*frameHeight/800));
	}
	
	@Override
	public void updateTimer(String currentTime)
	{
		timebox.setText(currentTime);
	}
	
	@Override
	public void updateNotification(String string) {}

	@Override
	public void updateScore()
	{
		scorebox1.setText(String.valueOf(scoreboard.getScore1()));
		scorebox2.setText(String.valueOf(scoreboard.getScore2()));
	}
	
	@Override
	public void updateTeams()
	{
		teamName1.setText(team1.getTeamName());
		teamName2.setText(team2.getTeamName());
	}
	
	@Override
	public void hide()
	{
		frame.setVisible(false);
	}

	@Override
	public void show()
	{
		frame.setVisible(true);
	}
}