package com.scorekeeper.model.graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

import com.scorekeeper.model.scoreboard.Scoreboard;
import com.scorekeeper.model.scoreboard.ScoreboardImpl;
import com.scorekeeper.model.timer.TimerImpl;

public class GraphicsImpl implements Graphics
{
	public JFrame frame;
    public Scoreboard scoreboard;
	public TimerImpl timer;
	public QTextField timebox, scorebox1, scorebox2, inputTime, inputScore1, inputScore2, notifications; //Text Fields
	public QButton startTime, stopReset;	//Timer controls
    public QButton incrementScore1, incrementScore2, decrementScore1, decrementScore2; //Score controls
    public QButton setTime, setScore1, setScore2; //Setter buttons
    public QButton acknowledge; //Acknowledges notifications
	
	public void start()
	{
		frame = new JFrame("Quidditch Scorekeeper"); //Create window with title "Quidditch Scorekeeper"
		frame.setSize(1450, 800); //Set window size
		frame.getContentPane().setBackground(new Color(153,153,153)); //Dark gray
		scoreboard = new ScoreboardImpl(); //Creates a scoreboard object for use
		timer = new TimerImpl(); //Creates a timer object for use
		timer.addObserver(this);
		timer.setBackground(new Color(243,243,243)); //Light gray
		timer.setBounds(425, 25, 600, 150);
		
		/*
		 * Begin creation of buttons & windows
		 */
		//Create timebox
		timebox = new QTextField("00:00:00", 1, 425, 25, 600, 150);
		
		//Create scoreboxes
		scorebox1=new QTextField("0", 2, 25, 200, 675, 400); //Set default value & position
	    scorebox2=new QTextField("0", 2, 750, 200, 675, 400); //Set default value & position
		
	    //Create time controls
	    startTime=new QButton("Start", 1, 25, 25, 150, 150); //This is the start button
	    stopReset=new QButton("Stop/Reset", 3, 185, 25, 150, 150); //This is the stop/reset button
	    inputTime = new QTextField("00:00:00", 3, 1100, 25, 325, 70); //Add textbox for setTime to use
	    setTime=new QButton("Set Time", 4, 1100, 105, 325, 70); //This is the setTime button

	    //Create score1 controls
	    incrementScore1=new QButton("+10", 1, 25, 610, 100, 100); //This button increments score1
	    decrementScore1=new QButton("-10", 3, 130, 610, 100, 100); //This button decrements score1
	    inputScore1 = new QTextField("000", 4, 240, 610, 210, 100); //Add textbox for setScore1 to use
	    setScore1=new QButton("Set Score", 4, 490, 610, 210, 100); //This button sets score1
	    
	    //Create score2 controls
	    incrementScore2=new QButton("+10", 1, 750, 610, 100, 100); //This button increments score2
	    decrementScore2=new QButton("-10", 3, 860, 610, 100, 100); //This button decrements score2
	    inputScore2 = new QTextField("000", 4, 970, 610, 210, 100); //Add textbox for setScore2 to use
	    setScore2=new QButton("Set Score", 4, 1210, 610, 210, 100); //This button sets score2
	    
	    //Create notification box & acknowledgement button
	    notifications = new QTextField("", 5, 25, 720, 1000, 50); //Add textbox for setScore2 to use
	    acknowledge=new QButton("Acknowledge", 1, 1035, 720, 390, 50); //This button sets score2
	    /*
		 * End creation of buttons & windows
		 */
		
	    /*
		 * Begin assignment of button functions
		 */
	    //Controls to update timer
	    startTime.addActionListener(new ActionListener() //Dictates what happens when startTime button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {  
	        	timer.startTime();
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
	        	scorebox1.setText(String.valueOf(scoreboard.incrementScore1()));
	        }  
	    }); 
	    decrementScore1.addActionListener(new ActionListener() //Dictates what happens when decrementScore1 button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {  
	        	scorebox1.setText(String.valueOf(scoreboard.decrementScore1()));
	        }  
	    }); 
	    setScore1.addActionListener(new ActionListener() //Dictates what happens when setScore1 button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {  
	        	scorebox1.setText(String.valueOf(scoreboard.setScore1(Integer.valueOf(inputScore1.getText()))));
	        }  
	    }); 
	    
	    //Controls to update scorebox2
	    incrementScore2.addActionListener(new ActionListener() //Dictates what happens when incrementScore2 button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {  
	        	scorebox2.setText(String.valueOf(scoreboard.incrementScore2()));
	        }  
	    }); 
	    decrementScore2.addActionListener(new ActionListener() //Dictates what happens when decrementScore2 button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {  
	        	scorebox2.setText(String.valueOf(scoreboard.decrementScore2()));
	        }  
	    }); 
	    setScore2.addActionListener(new ActionListener() //Dictates what happens when setScore2 button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {
	        	scorebox2.setText(String.valueOf(scoreboard.setScore2(Integer.valueOf(inputScore2.getText()))));
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
	    /*
		 * End assignment of button functions
		 */
	    
	    /*
		 * Begin adding items to window
		 */
		frame.add(timebox); //Add timer to window
	    //frame.add(timer);
		
		frame.add(startTime); //Add timer controls to window
	    frame.add(stopReset); 
	    frame.add(inputTime);
	    frame.add(setTime);
		
	    frame.add(scorebox1); //Add scoreboxes to window
	    frame.add(scorebox2);
	    
	    frame.add(startTime); //Add score controls to window
	    frame.add(stopReset); 
	    frame.add(setTime);
	    frame.add(incrementScore1); 
	    frame.add(decrementScore1); 
	    frame.add(inputScore1);
	    frame.add(setScore1);
	    frame.add(incrementScore2); 
	    frame.add(decrementScore2); 
	    frame.add(inputScore2);
	    frame.add(setScore2);
	    
	    frame.add(notifications); //Add notification functions
	    frame.add(acknowledge);
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
		
		scorebox1.setBounds(25*frameWidth/1450, 200*frameHeight/800, 675*frameWidth/1450, 400*frameHeight/800, Math.min(256*frameWidth/1450,256*frameHeight/800));
		incrementScore1.setBounds(25*frameWidth/1450, 610*frameHeight/800, 100*frameWidth/1450, 100*frameHeight/800);
	    decrementScore1.setBounds(130*frameWidth/1450, 610*frameHeight/800, 100*frameWidth/1450, 100*frameHeight/800);
	    inputScore1.setBounds(240*frameWidth/1450, 610*frameHeight/800, 210*frameWidth/1450, 100*frameHeight/800, Math.min(72*frameWidth/1450,72*frameHeight/800));
	    setScore1.setBounds(490*frameWidth/1450, 610*frameHeight/800, 210*frameWidth/1450, 100*frameHeight/800);
	    
	    scorebox2.setBounds(750*frameWidth/1450, 200*frameHeight/800, 675*frameWidth/1450, 400*frameHeight/800, Math.min(256*frameWidth/1450,256*frameHeight/800));
	    incrementScore2.setBounds(750*frameWidth/1450, 610*frameHeight/800, 100*frameWidth/1450, 100*frameHeight/800);
	    decrementScore2.setBounds(860*frameWidth/1450, 610*frameHeight/800, 100*frameWidth/1450, 100*frameHeight/800);
	    inputScore2.setBounds(970*frameWidth/1450, 610*frameHeight/800, 210*frameWidth/1450, 100*frameHeight/800, Math.min(72*frameWidth/1450,72*frameHeight/800));
	    setScore2.setBounds(1210*frameWidth/1450, 610*frameHeight/800, 210*frameWidth/1450, 100*frameHeight/800);
		
		timebox.setBounds(425*frameWidth/1450, 25*frameHeight/800, 600*frameWidth/1450, 150*frameHeight/800, Math.min(126*frameWidth/1450,126*frameHeight/800));
		startTime.setBounds(25*frameWidth/1450, 25*frameHeight/800, 150*frameWidth/1450, 150*frameHeight/800);
	    stopReset.setBounds(185*frameWidth/1450, 25*frameHeight/800, 150*frameWidth/1450, 150*frameHeight/800);
	    inputTime.setBounds(1100*frameWidth/1450, 25*frameHeight/800, 325*frameWidth/1450, 70*frameHeight/800, Math.min(48*frameWidth/1450,48*frameHeight/800));
	    setTime.setBounds(1100*frameWidth/1450, 105*frameHeight/800, 325*frameWidth/1450, 70*frameHeight/800);
	    
	    notifications.setBounds(25*frameWidth/1450, 720*frameHeight/800, 1000*frameWidth/1450, 50*frameHeight/800, Math.min(24*frameWidth/1450,24*frameHeight/800));
	    acknowledge.setBounds(1035*frameWidth/1450, 720*frameHeight/800, 390*frameWidth/1450, 50*frameHeight/800);
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