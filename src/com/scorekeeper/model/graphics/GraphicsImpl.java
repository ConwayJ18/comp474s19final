package com.scorekeeper.model.graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.scorekeeper.model.scoreboard.Scoreboard;
import com.scorekeeper.model.scoreboard.ScoreboardImpl;
import com.scorekeeper.model.timer.TimerImpl;

public class GraphicsImpl implements Graphics
{
	public void start()
	{
		JFrame frame= new JFrame("Quidditch Scorekeeper"); //Create window with title "Quidditch Scorekeeper"
		frame.setSize(1450, 800); //Set window size
		frame.getContentPane().setBackground(new Color(153,153,153)); //Dark gray
		final Scoreboard sb = new ScoreboardImpl(); //Creates a scoreboard object for use
		final TimerImpl t = new TimerImpl(); //Creates a timer object for use
		t.setBackground(new Color(243,243,243)); //Light gray
		
		/*
		 * Begin creation of buttons & windows
		 */
		//Create scoreboxes
		final QTextField scorebox1=new QTextField("0", 2, 25, 200, 675, 400); //Set default value & position
	    final QTextField scorebox2=new QTextField("0", 2, 750, 200, 675, 400); //Set default value & position
		
	    //Create time controls
	    QButton startTime=new QButton("Start", 1, 25, 25, 150, 150); //This is the start button
	    QButton stopReset=new QButton("Stop/Reset", 3, 185, 25, 150, 150); //This is the stop/reset button
	    QTextField inputTime = new QTextField("00:00:00", 3, frame.getWidth()-350, 25, 325, 70); //Add textbox for setTime to use
	    QButton setTime=new QButton("Set Time", 4, frame.getWidth()-350, 105, 325, 70); //This is the setTime button

	    //Create score1 controls
	    QButton incrementScore1=new QButton("+10", 1, 25, 610, 100, 100); //This button increments score1
	    QButton decrementScore1=new QButton("-10", 3, 130, 610, 100, 100); //This button decrements score1
	    QTextField inputScore1 = new QTextField("000", 4, 240, 610, 210, 100); //Add textbox for setScore1 to use
	    QButton setScore1=new QButton("Set Score", 4, 490, 610, 210, 100); //This button sets score1
	    
	    //Create score2 controls
	    QButton incrementScore2=new QButton("+10", 1, 750, 610, 100, 100); //This button increments score2
	    QButton decrementScore2=new QButton("-10", 3, 860, 610, 100, 100); //This button decrements score2
	    QTextField inputScore2 = new QTextField("000", 4, 970, 610, 210, 100); //Add textbox for setScore2 to use
	    QButton setScore2=new QButton("Set Score", 4, 1210, 610, 210, 100); //This button sets score2
	    
	    //Create notification box & acknowledgement button
	    QTextField notifications = new QTextField("", 5, 25, frame.getHeight()-80, 1000, 50); //Add textbox for setScore2 to use
	    QButton acknowledge=new QButton("Clear Notification", 1, 1035, frame.getHeight()-80, 390, 50); //This button sets score2
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
	        	t.startTime();
	        	stopReset.setBackground(new Color(254,242,204)); //Yellow
	        }  
	    }); 
	    stopReset.addActionListener(new ActionListener() //Dictates what happens when stopReset button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {  
	        	if(t.isRunning())
	        	{
	        		t.stopTime();
	        		stopReset.setBackground(new Color(244,204,204)); //Red
	        	}
	        	else
	        	{
	        		t.resetTime();
	        	}
	        }  
	    }); 
	    setTime.addActionListener(new ActionListener() //Dictates what happens when setTime button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {  
	        	t.setTime(inputTime.getText());
	        }  
	    }); 
	    
	    //Controls to update scorebox1
	    incrementScore1.addActionListener(new ActionListener() //Dictates what happens when incrementScore1 button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {  
	        	scorebox1.setText(String.valueOf(sb.incrementScore1()));
	        }  
	    }); 
	    decrementScore1.addActionListener(new ActionListener() //Dictates what happens when decrementScore1 button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {  
	        	scorebox1.setText(String.valueOf(sb.decrementScore1()));
	        }  
	    }); 
	    setScore1.addActionListener(new ActionListener() //Dictates what happens when setScore1 button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {  
	        	scorebox1.setText(String.valueOf(sb.setScore1(Integer.valueOf(inputScore1.getText()))));
	        }  
	    }); 
	    
	    //Controls to update scorebox2
	    incrementScore2.addActionListener(new ActionListener() //Dictates what happens when incrementScore2 button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {  
	        	scorebox2.setText(String.valueOf(sb.incrementScore2()));
	        }  
	    }); 
	    decrementScore2.addActionListener(new ActionListener() //Dictates what happens when decrementScore2 button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {  
	        	scorebox2.setText(String.valueOf(sb.decrementScore2()));
	        }  
	    }); 
	    setScore2.addActionListener(new ActionListener() //Dictates what happens when setScore2 button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {
	        	scorebox2.setText(String.valueOf(sb.setScore2(Integer.valueOf(inputScore2.getText()))));
	        }  
	    }); 
	    
	    //Control to clear notification
	    acknowledge.addActionListener(new ActionListener() //Dictates what happens when acknowledge button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {
		        notifications.setText("");
	        }  
	    }); 
	    /*
		 * End assignment of button functions
		 */
	    
	    /*
		 * Begin adding items to window
		 */
		//frame.add(timebox); //Add timer to window
	    frame.add(t);
		
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
		frame.setResizable(false); //Disallows resizing the window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Makes program quit when the window closes
		frame.setVisible(true); //Makes the window visible
	}
}