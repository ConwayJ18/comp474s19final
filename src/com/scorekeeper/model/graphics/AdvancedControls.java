package com.scorekeeper.model.graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentAdapter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.scorekeeper.model.scoreboard.Scoreboard;
import com.scorekeeper.model.scoreboard.ScoreboardImpl;
import com.scorekeeper.model.timer.TimerImpl;

import com.scorekeeper.model.team.TeamImpl;

public class AdvancedControls implements Graphics
{
	public JFrame frame;
    public Scoreboard scoreboard;
	public TimerImpl timer;
	public TeamImpl team1, team2;
	public QTextField timebox, scorebox1, scorebox2, inputTime, inputScore1, inputScore2, notifications; //Text Fields
	public QTextField teamName1, team1player1, team1player2, team1player3, team1player4, team1player5, team1player6, team1player7;
	public QButton editTeamName1, swapTeam1Player1, cardTeam1Player1, statsTeam1Player1;
	public QButton swapTeam1Player2, cardTeam1Player2, statsTeam1Player2;
	public QButton swapTeam1Player3, cardTeam1Player3, statsTeam1Player3;
	public QButton swapTeam1Player4, cardTeam1Player4, statsTeam1Player4;
	public QButton swapTeam1Player5, cardTeam1Player5, statsTeam1Player5;
	public QButton swapTeam1Player6, cardTeam1Player6, statsTeam1Player6;
	public QButton swapTeam1Player7, cardTeam1Player7, statsTeam1Player7;
	public QTextField teamName2, team2player1, team2player2, team2player3, team2player4, team2player5, team2player6, team2player7;
	public QButton editTeamName2, swapTeam2Player1, cardTeam2Player1, statsTeam2Player1;
	public QButton swapTeam2Player2, cardTeam2Player2, statsTeam2Player2;
	public QButton swapTeam2Player3, cardTeam2Player3, statsTeam2Player3;
	public QButton swapTeam2Player4, cardTeam2Player4, statsTeam2Player4;
	public QButton swapTeam2Player5, cardTeam2Player5, statsTeam2Player5;
	public QButton swapTeam2Player6, cardTeam2Player6, statsTeam2Player6;
	public QButton swapTeam2Player7, cardTeam2Player7, statsTeam2Player7;
	public QButton startTime, stopReset;	//Timer controls
    public QButton incrementScore1, incrementScore2, decrementScore1, decrementScore2; //Score controls
    public QButton setTime, setScore1, setScore2; //Setter buttons
    public QButton acknowledge; //Acknowledges notifications
	
	public void start(TimerImpl t, ScoreboardImpl s, TeamImpl t1, TeamImpl t2)
	{
		initializeParts(t, s, t1, t2);
		initializeActions();
		buildScreen();
		enableResizing();
	}
	
	private void initializeParts(TimerImpl t, ScoreboardImpl s, TeamImpl t1, TeamImpl t2)
	{
		frame = new JFrame("Quidditch Scorekeeper"); //Create window with title "Quidditch Scorekeeper"
		frame.setSize(1450, 800); //Set window size
		frame.getContentPane().setBackground(new Color(153,153,153)); //Dark gray
		timer = t;
		timer.setBackground(new Color(243,243,243)); //Light gray
		timer.setBounds(425, 25, 600, 150);
		scoreboard = s; //Creates a scoreboard object for use
		team1 = t1;
		team2 = t2;
		
		/*
		 * Begin creation of buttons & windows
		 */
		//Create timebox
		timebox = new QTextField("00:00:00", 1, 425, 25, 600, 150);
		
		//Create scoreboxes
		scorebox1=new QTextField("0", 6, 25, 25, 150, 150); //Set default value & position
	    scorebox2=new QTextField("0", 6, 1050, 25, 150, 150); //Set default value & position
		
	    //Create time controls
	    startTime=new QButton("Start", 1, 425, 190, 80, 70); //This is the start button
	    stopReset=new QButton("Reset", 3, 510, 190, 80, 70); //This is the stop/reset button
	    inputTime = new QTextField("00:00:00", 3, 600, 190, 210, 70); //Add textbox for setTime to use
	    setTime=new QButton("Set Time", 4, 815, 190, 210, 70); //This is the setTime button

	    //Create score1 controls
	    incrementScore1=new QButton("+10", 1, 185, 25, 100, 70); //This button increments score1
	    decrementScore1=new QButton("-10", 3, 185, 105, 100, 70); //This button decrements score1
	    inputScore1 = new QTextField("000", 7, 295, 25, 100, 70); //Add textbox for setScore1 to use
	    setScore1=new QButton("Set", 4, 295, 105, 105, 70); //This button sets score1
	    
	    //Create score2 controls
	    incrementScore2=new QButton("+10", 1, 1210, 25, 100, 70); //This button increments score1
	    decrementScore2=new QButton("-10", 3, 1210, 105, 100, 70); //This button decrements score1
	    inputScore2 = new QTextField("000", 7, 1320, 25, 100, 70); //Add textbox for setScore1 to use
	    setScore2=new QButton("Set", 4, 1320, 105, 100, 70); //This button sets score1
	    
	    //Create notification box & acknowledgement button
	    notifications = new QTextField("", 5, 25, 720, 1000, 50); //Add textbox for setScore2 to use
	    acknowledge=new QButton("Acknowledge", 1, 1035, 720, 390, 50); //This button sets score2
	    
	    //Create Team 1 boxes
	    teamName1 = new QTextField(team1.getTeamName(), 8, 25, 275, 575, 50);
	    editTeamName1 = new QButton("Edit", 4, 605, 275, 95, 50);
	    team1player1=new QTextField(team1.getPlayers().get(0).getName(), 8, 25, 335, 375, 50);
	    swapTeam1Player1 = new QButton("Swap", 4, 405, 335, 95, 50);
	    cardTeam1Player1 = new QButton("Card", 4, 505, 335, 95, 50);
	    statsTeam1Player1 = new QButton("Stats", 4, 605, 335, 95, 50);
	    team1player2=new QTextField(team1.getPlayers().get(1).getName(), 8, 25, 390, 375, 50);
	    swapTeam1Player2 = new QButton("Swap", 4, 405, 390, 95, 50);
	    cardTeam1Player2 = new QButton("Card", 4, 505, 390, 95, 50);
	    statsTeam1Player2 = new QButton("Stats", 4, 605, 390, 95, 50);
	    team1player3=new QTextField(team1.getPlayers().get(2).getName(), 8, 25, 445, 375, 50);
	    swapTeam1Player3 = new QButton("Swap", 4, 405, 445, 95, 50);
	    cardTeam1Player3 = new QButton("Card", 4, 505, 445, 95, 50);
	    statsTeam1Player3 = new QButton("Stats", 4, 605, 445, 95, 50);
	    team1player4=new QTextField(team1.getPlayers().get(3).getName(), 8, 25, 500, 375, 50);
	    swapTeam1Player4 = new QButton("Swap", 4, 405, 500, 95, 50);
	    cardTeam1Player4 = new QButton("Card", 4, 505, 500, 95, 50);
	    statsTeam1Player4 = new QButton("Stats", 4, 605, 500, 95, 50);
	    team1player5=new QTextField(team1.getPlayers().get(4).getName(), 8, 25, 555, 375, 50);
	    swapTeam1Player5 = new QButton("Swap", 4, 405, 555, 95, 50);
	    cardTeam1Player5 = new QButton("Card", 4, 505, 555, 95, 50);
	    statsTeam1Player5 = new QButton("Stats", 4, 605, 555, 95, 50);
	    team1player6=new QTextField(team1.getPlayers().get(5).getName(), 8, 25, 610, 375, 50);
	    swapTeam1Player6 = new QButton("Swap", 4, 405, 610, 95, 50);
	    cardTeam1Player6 = new QButton("Card", 4, 505, 610, 95, 50);
	    statsTeam1Player6 = new QButton("Stats", 4, 605, 610, 95, 50);
	    team1player7=new QTextField(team1.getPlayers().get(6).getName(), 8, 25, 665, 375, 50);
	    swapTeam1Player7 = new QButton("Swap", 4, 405, 665, 95, 50);
	    cardTeam1Player7 = new QButton("Card", 4, 505, 665, 95, 50);
	    statsTeam1Player7 = new QButton("Stats", 4, 605, 665, 95, 50);
	    
	    //Create Team 2 boxes
	    teamName2 = new QTextField(team2.getTeamName(), 8, 750, 275, 575, 50);
	    editTeamName2 = new QButton("Edit", 4, 1330, 275, 95, 50);
	    team2player1=new QTextField(team2.getPlayers().get(0).getName(), 8, 750, 335, 375, 50);
	    swapTeam2Player1 = new QButton("Swap", 4, 1130, 335, 95, 50);
	    cardTeam2Player1 = new QButton("Card", 4, 1230, 335, 95, 50);
	    statsTeam2Player1 = new QButton("Stats", 4, 1330, 335, 95, 50);
	    team2player2=new QTextField(team2.getPlayers().get(1).getName(), 8, 750, 390, 375, 50);
	    swapTeam2Player2 = new QButton("Swap", 4, 1130, 390, 95, 50);
	    cardTeam2Player2 = new QButton("Card", 4, 1230, 390, 95, 50);
	    statsTeam2Player2 = new QButton("Stats", 4, 1330, 390, 95, 50);
	    team2player3=new QTextField(team2.getPlayers().get(2).getName(), 8, 750, 445, 375, 50);
	    swapTeam2Player3 = new QButton("Swap", 4, 1130, 445, 95, 50);
	    cardTeam2Player3 = new QButton("Card", 4, 1230, 445, 95, 50);
	    statsTeam2Player3 = new QButton("Stats", 4, 1330, 445, 95, 50);
	    team2player4=new QTextField(team2.getPlayers().get(3).getName(), 8, 750, 500, 375, 50);
	    swapTeam2Player4 = new QButton("Swap", 4, 1130, 500, 95, 50);
	    cardTeam2Player4 = new QButton("Card", 4, 1230, 500, 95, 50);
	    statsTeam2Player4 = new QButton("Stats", 4, 1330, 500, 95, 50);
	    team2player5=new QTextField(team2.getPlayers().get(4).getName(), 8, 750, 555, 375, 50);
	    swapTeam2Player5 = new QButton("Swap", 4, 1130, 555, 95, 50);
	    cardTeam2Player5 = new QButton("Card", 4, 1230, 555, 95, 50);
	    statsTeam2Player5 = new QButton("Stats", 4, 1330, 555, 95, 50);
	    team2player6=new QTextField(team2.getPlayers().get(5).getName(), 8, 750, 610, 375, 50);
	    swapTeam2Player6 = new QButton("Swap", 4, 1130, 610, 95, 50);
	    cardTeam2Player6 = new QButton("Card", 4, 1230, 610, 95, 50);
	    statsTeam2Player6 = new QButton("Stats", 4, 1330, 610, 95, 50);
	    team2player7=new QTextField(team2.getPlayers().get(6).getName(), 8, 750, 665, 375, 50);
	    swapTeam2Player7 = new QButton("Swap", 4, 1130, 665, 95, 50);
	    cardTeam2Player7 = new QButton("Card", 4, 1230, 665, 95, 50);
	    statsTeam2Player7 = new QButton("Stats", 4, 1330, 665, 95, 50);
	    /*
		 * End creation of buttons & windows
		 */
	}	
	
	private void initializeActions()
	{
	    /*
		 * Begin assignment of button functions
		 */
	    //Controls to update timer
	    startTime.addActionListener(new ActionListener() //Dictates what happens when startTime button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {  
	        	timer.startTime();
	        	stopReset.setText("Stop");
	        	stopReset.setBackground(new Color(254,242,204)); //Yellow
	        }  
	    }); 
	    stopReset.addActionListener(new ActionListener() //Dictates what happens when stopReset button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {  
	        	if(timer.isRunning())
	        	{
	        		timer.stopTime();
	        		stopReset.setText("Reset");
	        		stopReset.setBackground(new Color(244,204,204)); //Red
	        	}
	        	else
	        	{
	        		timer.resetTime();
	        	}
	        }  
	    }); 
	    setTime.addActionListener(new ActionListener() //Dictates what happens when setTime button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {  
	        	timer.setTime(inputTime.getText());
	        }  
	    }); 
	    
	    //Controls to update scorebox1
	    incrementScore1.addActionListener(new ActionListener() //Dictates what happens when incrementScore1 button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {  
	        	scoreboard.incrementScore1();
	        }  
	    }); 
	    decrementScore1.addActionListener(new ActionListener() //Dictates what happens when decrementScore1 button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {  
	        	scoreboard.decrementScore1();
	        }  
	    }); 
	    setScore1.addActionListener(new ActionListener() //Dictates what happens when setScore1 button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {  
	        	scoreboard.setScore1(Integer.valueOf(inputScore1.getText()));
	        }  
	    }); 
	    
	    //Controls to update scorebox2
	    incrementScore2.addActionListener(new ActionListener() //Dictates what happens when incrementScore2 button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {  
	        	scoreboard.incrementScore2();
	        }  
	    }); 
	    decrementScore2.addActionListener(new ActionListener() //Dictates what happens when decrementScore2 button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {  
	        	scoreboard.decrementScore2();
	        }  
	    }); 
	    setScore2.addActionListener(new ActionListener() //Dictates what happens when setScore2 button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {
	        	scoreboard.setScore2(Integer.valueOf(inputScore2.getText()));
	        }  
	    }); 
	    
	    //Control to acknowledge notification
	    acknowledge.addActionListener(new ActionListener() //Dictates what happens when acknowledge button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {
		        timer.acknowledge();
	        }  
	    }); 
	    
	    //Control to edit team1 name
	    editTeamName1.addActionListener(new ActionListener() //Dictates what happens when acknowledge button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {
	        	team1.setTeamName(JOptionPane.showInputDialog(frame,"Enter New Team Name"));
	        }  
	    }); 
	    
	    //Control to edit team2 name
	    editTeamName2.addActionListener(new ActionListener() //Dictates what happens when acknowledge button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {
	        	team2.setTeamName(JOptionPane.showInputDialog(frame,"Enter New Team Name"));
	        }  
	    }); 
	    
	    //Control to card team1player1
	    cardTeam1Player1.addActionListener(new ActionListener() //Dictates what happens when acknowledge button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {
	        	team1.getPlayerByLastName(team1player1.getText()).cardPlayer(timer.getTime());
	        }  
	    }); 
	    
	    //Control to show team1player1 stats
	    statsTeam1Player1.addActionListener(new ActionListener() //Dictates what happens when acknowledge button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {
	        	team1.getPlayerByLastName(team1player1.getText()).showStats();;
	        }  
	    }); 
	    /*
		 * End assignment of button functions
		 */
	}
	
	private void buildScreen()
	{
	    /*
		 * Begin adding items to window
		 */
		frame.add(timebox); //Add timer to window
		
		frame.add(startTime); //Add timer controls to window
	    frame.add(stopReset); 
	    frame.add(inputTime);
	    frame.add(setTime);
		
	    frame.add(scorebox1); //Add scoreboxes to window
	    frame.add(scorebox2);

	    frame.add(incrementScore1); //Add score controls to window
	    frame.add(decrementScore1); 
	    frame.add(inputScore1);
	    frame.add(setScore1);
	    frame.add(incrementScore2); 
	    frame.add(decrementScore2); 
	    frame.add(inputScore2);
	    frame.add(setScore2);
	    
	    frame.add(notifications); //Add notification functions
	    frame.add(acknowledge);
	    
	    frame.add(teamName1); //Add team 1
	    frame.add(editTeamName1);
	    frame.add(team1player1);
	    frame.add(swapTeam1Player1);
	    frame.add(cardTeam1Player1);
	    frame.add(statsTeam1Player1);
	    frame.add(team1player2);
	    frame.add(swapTeam1Player2);
	    frame.add(cardTeam1Player2);
	    frame.add(statsTeam1Player2);
	    frame.add(team1player3);
	    frame.add(swapTeam1Player3);
	    frame.add(cardTeam1Player3);
	    frame.add(statsTeam1Player3);
	    frame.add(team1player4);
	    frame.add(swapTeam1Player4);
	    frame.add(cardTeam1Player4);
	    frame.add(statsTeam1Player4);
	    frame.add(team1player5);
	    frame.add(swapTeam1Player5);
	    frame.add(cardTeam1Player5);
	    frame.add(statsTeam1Player5);
	    frame.add(team1player6);
	    frame.add(swapTeam1Player6);
	    frame.add(cardTeam1Player6);
	    frame.add(statsTeam1Player6);
	    frame.add(team1player7);
	    frame.add(swapTeam1Player7);
	    frame.add(cardTeam1Player7);
	    frame.add(statsTeam1Player7);
	    
	    frame.add(teamName2); //Add team 2
	    frame.add(editTeamName2);
	    frame.add(team2player1);
	    frame.add(swapTeam2Player1);
	    frame.add(cardTeam2Player1);
	    frame.add(statsTeam2Player1);
	    frame.add(team2player2);
	    frame.add(swapTeam2Player2);
	    frame.add(cardTeam2Player2);
	    frame.add(statsTeam2Player2);
	    frame.add(team2player3);
	    frame.add(swapTeam2Player3);
	    frame.add(cardTeam2Player3);
	    frame.add(statsTeam2Player3);
	    frame.add(team2player4);
	    frame.add(swapTeam2Player4);
	    frame.add(cardTeam2Player4);
	    frame.add(statsTeam2Player4);
	    frame.add(team2player5);
	    frame.add(swapTeam2Player5);
	    frame.add(cardTeam2Player5);
	    frame.add(statsTeam2Player5);
	    frame.add(team2player6);
	    frame.add(swapTeam2Player6);
	    frame.add(cardTeam2Player6);
	    frame.add(statsTeam2Player6);
	    frame.add(team2player7);
	    frame.add(swapTeam2Player7);
	    frame.add(cardTeam2Player7);
	    frame.add(statsTeam2Player7);
	    /*
		 * End adding items to window
		 */
	    
	    //These things need to go last to prevent loading lag
		frame.setLocationRelativeTo(null); //Centers window on screen
		frame.setLayout(null); //Allows us to manually set item locations
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Makes program quit when the window closes
		frame.setVisible(true); //Makes the window visible
	}
	
	private void enableResizing()
	{
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
	    
		scorebox1.setBounds(25*frameWidth/1450, 25*frameHeight/800, 150*frameWidth/1450, 150*frameHeight/800, Math.min(75*frameWidth/1450,75*frameHeight/800));
		incrementScore1.setBounds(185*frameWidth/1450, 25*frameHeight/800, 100*frameWidth/1450, 70*frameHeight/800);
	    decrementScore1.setBounds(185*frameWidth/1450, 105*frameHeight/800, 100*frameWidth/1450, 70*frameHeight/800);
	    inputScore1.setBounds(295*frameWidth/1450, 25*frameHeight/800, 100*frameWidth/1450, 70*frameHeight/800, Math.min(50*frameWidth/1450,50*frameHeight/800));
	    setScore1.setBounds(295*frameWidth/1450, 105*frameHeight/800, 100*frameWidth/1450, 70*frameHeight/800);
	    
	    scorebox2.setBounds(1050*frameWidth/1450, 25*frameHeight/800, 150*frameWidth/1450, 150*frameHeight/800, Math.min(75*frameWidth/1450,75*frameHeight/800));
	    incrementScore2.setBounds(1210*frameWidth/1450, 25*frameHeight/800, 100*frameWidth/1450, 70*frameHeight/800);
	    decrementScore2.setBounds(1210*frameWidth/1450, 105*frameHeight/800, 100*frameWidth/1450, 70*frameHeight/800);
	    inputScore2.setBounds(1320*frameWidth/1450, 25*frameHeight/800, 100*frameWidth/1450, 70*frameHeight/800, Math.min(50*frameWidth/1450,50*frameHeight/800));
	    setScore2.setBounds(1320*frameWidth/1450, 105*frameHeight/800, 100*frameWidth/1450, 70*frameHeight/800);
	    
		timebox.setBounds(425*frameWidth/1450, 25*frameHeight/800, 600*frameWidth/1450, 150*frameHeight/800, Math.min(126*frameWidth/1450,126*frameHeight/800));
		startTime.setBounds(425*frameWidth/1450, 190*frameHeight/800, 80*frameWidth/1450, 70*frameHeight/800);
	    stopReset.setBounds(510*frameWidth/1450, 190*frameHeight/800, 80*frameWidth/1450, 70*frameHeight/800);
	    inputTime.setBounds(600*frameWidth/1450, 190*frameHeight/800, 210*frameWidth/1450, 70*frameHeight/800, Math.min(48*frameWidth/1450,48*frameHeight/800));
	    setTime.setBounds(815*frameWidth/1450, 190*frameHeight/800, 210*frameWidth/1450, 70*frameHeight/800);
	    
	    notifications.setBounds(25*frameWidth/1450, 720*frameHeight/800, 1000*frameWidth/1450, 50*frameHeight/800, Math.min(24*frameWidth/1450,24*frameHeight/800));
	    acknowledge.setBounds(1035*frameWidth/1450, 720*frameHeight/800, 390*frameWidth/1450, 50*frameHeight/800);
	    
	    teamName1.setBounds(25*frameWidth/1450, 275*frameHeight/800, 575*frameWidth/1450, 50*frameHeight/800, Math.min(36*frameWidth/1450,36*frameHeight/800));
	    editTeamName1.setBounds(605*frameWidth/1450, 275*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    team1player1.setBounds(25*frameWidth/1450, 335*frameHeight/800, 375*frameWidth/1450, 50*frameHeight/800, Math.min(36*frameWidth/1450,36*frameHeight/800));
	    swapTeam1Player1.setBounds(405*frameWidth/1450, 335*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    cardTeam1Player1.setBounds(505*frameWidth/1450, 335*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    statsTeam1Player1.setBounds(605*frameWidth/1450, 335*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    team1player2.setBounds(25*frameWidth/1450, 390*frameHeight/800, 375*frameWidth/1450, 50*frameHeight/800, Math.min(36*frameWidth/1450,36*frameHeight/800));
	    swapTeam1Player2.setBounds(405*frameWidth/1450, 390*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    cardTeam1Player2.setBounds(505*frameWidth/1450, 390*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    statsTeam1Player2.setBounds(605*frameWidth/1450, 390*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    team1player3.setBounds(25*frameWidth/1450, 445*frameHeight/800, 375*frameWidth/1450, 50*frameHeight/800, Math.min(36*frameWidth/1450,36*frameHeight/800));
	    swapTeam1Player3.setBounds(405*frameWidth/1450, 445*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    cardTeam1Player3.setBounds(505*frameWidth/1450, 445*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    statsTeam1Player3.setBounds(605*frameWidth/1450, 445*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    team1player4.setBounds(25*frameWidth/1450, 500*frameHeight/800, 375*frameWidth/1450, 50*frameHeight/800, Math.min(36*frameWidth/1450,36*frameHeight/800));
	    swapTeam1Player4.setBounds(405*frameWidth/1450, 500*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    cardTeam1Player4.setBounds(505*frameWidth/1450, 500*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    statsTeam1Player4.setBounds(605*frameWidth/1450, 500*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    team1player5.setBounds(25*frameWidth/1450, 555*frameHeight/800, 375*frameWidth/1450, 50*frameHeight/800, Math.min(36*frameWidth/1450,36*frameHeight/800));
	    swapTeam1Player5.setBounds(405*frameWidth/1450, 555*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    cardTeam1Player5.setBounds(505*frameWidth/1450, 555*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    statsTeam1Player5.setBounds(605*frameWidth/1450, 555*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    team1player6.setBounds(25*frameWidth/1450, 610*frameHeight/800, 375*frameWidth/1450, 50*frameHeight/800, Math.min(36*frameWidth/1450,36*frameHeight/800));
	    swapTeam1Player6.setBounds(405*frameWidth/1450, 610*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    cardTeam1Player6.setBounds(505*frameWidth/1450, 610*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    statsTeam1Player6.setBounds(605*frameWidth/1450, 610*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    team1player7.setBounds(25*frameWidth/1450, 665*frameHeight/800, 375*frameWidth/1450, 50*frameHeight/800, Math.min(36*frameWidth/1450,36*frameHeight/800));
	    swapTeam1Player7.setBounds(405*frameWidth/1450, 665*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    cardTeam1Player7.setBounds(505*frameWidth/1450, 665*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    statsTeam1Player7.setBounds(605*frameWidth/1450, 665*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    
	    teamName2.setBounds(750*frameWidth/1450, 275*frameHeight/800, 575*frameWidth/1450, 50*frameHeight/800, Math.min(36*frameWidth/1450,36*frameHeight/800));
	    editTeamName2.setBounds(1330*frameWidth/1450, 275*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    team2player1.setBounds(750*frameWidth/1450, 335*frameHeight/800, 375*frameWidth/1450, 50*frameHeight/800, Math.min(36*frameWidth/1450,36*frameHeight/800));
	    swapTeam2Player1.setBounds(1130*frameWidth/1450, 335*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    cardTeam2Player1.setBounds(1230*frameWidth/1450, 335*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    statsTeam2Player1.setBounds(1330*frameWidth/1450, 335*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    team2player2.setBounds(750*frameWidth/1450, 390*frameHeight/800, 375*frameWidth/1450, 50*frameHeight/800, Math.min(36*frameWidth/1450,36*frameHeight/800));
	    swapTeam2Player2.setBounds(1130*frameWidth/1450, 390*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    cardTeam2Player2.setBounds(1230*frameWidth/1450, 390*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    statsTeam2Player2.setBounds(1330*frameWidth/1450, 390*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    team2player3.setBounds(750*frameWidth/1450, 445*frameHeight/800, 375*frameWidth/1450, 50*frameHeight/800, Math.min(36*frameWidth/1450,36*frameHeight/800));
	    swapTeam2Player3.setBounds(1130*frameWidth/1450, 445*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    cardTeam2Player3.setBounds(1230*frameWidth/1450, 445*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    statsTeam2Player3.setBounds(1330*frameWidth/1450, 445*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    team2player4.setBounds(750*frameWidth/1450, 500*frameHeight/800, 375*frameWidth/1450, 50*frameHeight/800, Math.min(36*frameWidth/1450,36*frameHeight/800));
	    swapTeam2Player4.setBounds(1130*frameWidth/1450, 500*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    cardTeam2Player4.setBounds(1230*frameWidth/1450, 500*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    statsTeam2Player4.setBounds(1330*frameWidth/1450, 500*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    team2player5.setBounds(750*frameWidth/1450, 555*frameHeight/800, 375*frameWidth/1450, 50*frameHeight/800, Math.min(36*frameWidth/1450,36*frameHeight/800));
	    swapTeam2Player5.setBounds(1130*frameWidth/1450, 555*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    cardTeam2Player5.setBounds(1230*frameWidth/1450, 555*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    statsTeam2Player5.setBounds(1330*frameWidth/1450, 555*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    team2player6.setBounds(750*frameWidth/1450, 610*frameHeight/800, 375*frameWidth/1450, 50*frameHeight/800, Math.min(36*frameWidth/1450,36*frameHeight/800));
	    swapTeam2Player6.setBounds(1130*frameWidth/1450, 610*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    cardTeam2Player6.setBounds(1230*frameWidth/1450, 610*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    statsTeam2Player6.setBounds(1330*frameWidth/1450, 610*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    team2player7.setBounds(750*frameWidth/1450, 665*frameHeight/800, 375*frameWidth/1450, 50*frameHeight/800, Math.min(36*frameWidth/1450,36*frameHeight/800));
	    swapTeam2Player7.setBounds(1130*frameWidth/1450, 665*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    cardTeam2Player7.setBounds(1230*frameWidth/1450, 665*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	    statsTeam2Player7.setBounds(1330*frameWidth/1450, 665*frameHeight/800, 95*frameWidth/1450, 50*frameHeight/800);
	}
	
	@Override
	public void updateTimer(String currentTime)
	{
		timebox.setText(currentTime);
	}
	
	@Override
	public void updateNotification(String alertMessage)
	{
		notifications.setText(alertMessage);
	}
	
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