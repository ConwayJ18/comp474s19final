package com.scorekeeper.model.graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.scorekeeper.model.scoreboard.Scoreboard;
import com.scorekeeper.model.scoreboard.ScoreboardImpl;
import com.scorekeeper.model.timer.Timer;
import com.scorekeeper.model.timer.TimerImpl;

public class GraphicsImpl implements Graphics
{
	public void start()
	{
		JFrame frame= new JFrame("Quidditch Scorekeeper"); //Create window with title "Quidditch Scorekeeper"
		frame.setSize(1450, 800); //Set window size
		final Scoreboard sb = new ScoreboardImpl(); //Creates a scoreboard object for use
		final TimerImpl t = new TimerImpl(); //Creates a timer object for use
		
		/*
		 * Begin creation of buttons & windows
		 */
		//Create timebox
		//final QTextField timebox = new QTextField("00:00:00", 1, 425, 25, 600, 150);
		
		//Create scoreboxes
		final QTextField scorebox1=new QTextField("0", 2, 25, 200, 675, 400); //Set default value & position
	    final QTextField scorebox2=new QTextField("0", 2, 750, 200, 675, 400); //Set default value & position
		
	    //Create time controls
	    JButton startTime=new JButton("Start"); //This is the start button
	    startTime.setBounds(25,25,150,150); //Set startTime's location
	    JButton stopReset=new JButton("Stop/Reset"); //This is the stop/reset button
	    stopReset.setBounds(185,25,150,150); //Set stop/reset's location
	    QTextField inputTime = new QTextField("00:00:00", 3, frame.getWidth()-350, 25, 325, 70); //Add textbox for setTime to use
	    JButton setTime=new JButton("Set Time"); //This is the setTime button 
	    setTime.setBounds(frame.getWidth()-350,105,325,70); //Set setTime's location

	    //Create score1 controls
	    JButton incrementScore1=new JButton("+10"); //This button increments score1
	    incrementScore1.setBounds(25,610,100,100); //Set incrementScore1's location
	    JButton decrementScore1=new JButton("-10"); //This button decrements score1
	    decrementScore1.setBounds(130,610,100,100); //Set decrementScore1's location
	    QTextField inputScore1 = new QTextField("000", 4, 240, 610, 210, 100); //Add textbox for setScore1 to use
	    JButton setScore1=new JButton("Set Score"); //This button sets score1
	    setScore1.setBounds(490,610,210,100); //Set setScore1's location
	    
	    //Create score2 controls
	    JButton incrementScore2=new JButton("+10"); //This button increments score2
	    incrementScore2.setBounds(750,610,100,100); //Set incrementScore2's location
	    JButton decrementScore2=new JButton("-10"); //This button decrements score2
	    decrementScore2.setBounds(860,610,100,100); //Set decrementScore2's location
	    QTextField inputScore2 = new QTextField("000", 4, 970, 610, 210, 100); //Add textbox for setScore2 to use
	    JButton setScore2=new JButton("Set Score"); //This button sets score2
	    setScore2.setBounds(1210,610,210,100); //Set setScore2's location
	    
	    //Create notification box & acknowledgement button
	    QTextField notifications = new QTextField("", 5, 25, frame.getHeight()-80, 1000, 50); //Add textbox for setScore2 to use
	    JButton acknowledge=new JButton("Clear Notification"); //This button sets score2
	    acknowledge.setBounds(1035, frame.getHeight()-80, 390, 50); //Set setScore2's location
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
	        }  
	    }); 
	    stopReset.addActionListener(new ActionListener() //Dictates what happens when stopReset button is clicked
	    {  
	        public void actionPerformed(ActionEvent e)
	        {  
	        	if(t.isRunning())
	        	{
	        		t.stopTime();
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