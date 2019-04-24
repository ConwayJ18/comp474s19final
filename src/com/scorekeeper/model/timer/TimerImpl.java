package com.scorekeeper.model.timer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.scorekeeper.model.graphics.Graphics;

public class TimerImpl extends JPanel implements Timer
{
	private String hoursString="00", minutesString="00", secondsString="00";
	private int millisecondsCount;					// Keeps a count of milliseconds passed to provide higher level of accuracy when pausing and unpausing in fractions of seconds
	private int hours, seconds, minutes;			// Holds int values
	private boolean isTimerOn, isPaused;			// If timer is started, If timer is currently paused or not
	private Queue<String> alertMessages = new LinkedList<String>();	// Holds uncleared alert messages
	private Thread timerThread;						// Thread responsible for the timer's functionality
	private ArrayList<Graphics> graphicsObservers = new ArrayList<>(); // Needed for notification functionality

	// TimerImpl Constructor
	public TimerImpl()
	{
		initializeThread();					// Initialize timer thread
	}

	// Initialize Timer Thread
	private void initializeThread()
	{
		timerThread = new Thread() {	// Create thread

			@Override
			public void run() {				// Executes when thread is started
				while(true) {					// Keep looping these statements forever
					try{
						Thread.sleep(10);			// Sleep for 10 milliseconds
					} catch(Exception e) {
						System.out.println(e.getMessage());
					}
					updateTime();					// Update the time
				}
			}
		};
	}

	// Update the frame and data, which is held in this frame
	private void updateTime()
	{
		if(!isPaused){		// If unpaused

			if (millisecondsCount > 999) {	// milliseconds are counted to 1000

				millisecondsCount = 0;			// reset milliseconds count
				seconds++;			// Increment seconds by 1 as milliseconds are counted to 1000

				if (hours > 98 && minutes > 58 && seconds > 58) {		// If max numbers are reached for HH MM and SS
					updateDisplay();										// Update time display one last time
					JOptionPane.showMessageDialog(null, "The Timer is stopped"); // Show user that timer is stopped
					stopTime();											// Stop the timer
					return;													// return out of the method
				}

				if (seconds > 59) {			// If seconds > 59
					minutes++;					// Increment minutes by 1
					seconds = 0;				// Reset seconds to 0
				}
				if(minutes > 59) {			// If minutes > 59
					hours++;					// Increment hours and reset minutes and seconds
					minutes = 0;
					seconds = 0;
				}
				
				updateDisplay(); //Update time
			}

			millisecondsCount += 10;		// Increment milliseconds count by 10 as this method is called every 10 milliseconds for better accuracy when pausing and unpausing
		}
	}

	// Update Hours, Minutes and Seconds TextFields
	private void updateDisplay() {
		hoursString = String.format("%02d", hours);
		minutesString = String.format("%02d", minutes);
		secondsString = String.format("%02d", seconds);
		
		if(alertNecessary())
		{
			updateAlerts();
		}
		notifyObservers();
	}

	// Validate the input given in int[] parts, where parts[0] is hours, [1] is minutes, [2] is seconds
	private void validateInput(int[] parts)
	{

		boolean isValueChanged = true;		// Considering it validated at first
		int tempHours = 0;
		int tempMinutes = 0;
		int tempSeconds = 0;

		if(parts[2] > 59)
		{
			parts[1] += parts[2]/60; //Carry the extra minutes
			tempSeconds = parts[2]%60;
		}
		else if(parts[2] >= 0)
		{
			tempSeconds = parts[2];
		}
		else
		{
			isValueChanged = false;
		}

		if(parts[1] > 59)
		{
			parts[0] += parts[1]/60; //Carry the extra hours
			tempMinutes = parts[1]%60;
		}
		else if(parts[1] >= 0)
		{
			tempMinutes = parts[1];
		}
		else
		{
			isValueChanged = false;
		}

		if(parts[0] <= 99 && parts[0] >= 0)
		{
			tempHours = parts[0];
		}
		else
		{
			isValueChanged = false;
		}

        if(isValueChanged) //If valid input, update values and display
        {
        	hours = tempHours;
        	minutes = tempMinutes;
        	seconds = tempSeconds;
        	updateDisplay();
        }
        else //Else alert the user
        {
        	getToolkit().beep();
        	JOptionPane.showMessageDialog(null, "Please enter a valid value for time.");
        }
	}

	public void startTime() {
		if(isTimerOn) {		// If timer is started at least once before
			isPaused = false;		// Unpause
		}
		else {				// else
			timerThread.start();	// Start timer
			isTimerOn = true;		// Set the variable to true
		}
	}

	public void stopTime() {
		isPaused = true;	// Pause timer
	}

	// Reset all the text fields and count variables
	public void resetTime() {
		hours=0;
		minutes=0;
		seconds=0;
		millisecondsCount = 0;
		updateDisplay();
	}

	//Return timer status
	public boolean isRunning()
	{
		if(isPaused)
		{
			return false;
		}

		return true;
	}

	@Override
	public void setTime(String time)
	{
		String[] temp = time.split(":", 4);
		int[] parts = new int[3];
		int i = 0;
		for(String s : temp)
		{
			if(i<3)
			{
				parts[i] = Integer.valueOf(s);
			}
			i++;
		}

		validateInput(parts);
	}

	@Override
	public String getTime() {
		return hoursString + ":" + minutesString + ":" + secondsString;
	}
	
	private boolean alertNecessary()
	{
		if(hours==0 && seconds==0)
		{
			if(minutes == 16 || minutes == 17 || minutes == 18)
			{
				return true;
			}
		}
		
		return false;
	}
	
	private void updateAlerts() 
	{
		if(minutes == 16)
		{
			alertMessages.add("Snitch Report!");
		}
		else if(minutes == 17)
		{
			alertMessages.add("Snitch Released! Seekers Report!");
		}
		else if(minutes == 18)
		{
			alertMessages.add("Seekers Released!");
		}
	}
	
	public void acknowledge() //Clears notification panel
	{
		if(!alertMessages.isEmpty())
		{
			alertMessages.remove();
		}
		notifyObservers();
	}
	
	public void addObserver(Graphics g) //Standard for observer patterns
	{
		this.graphicsObservers.add(g);
	}
	
	private void notifyObservers() //Standard for observer pattern
	{
		for(Graphics g : graphicsObservers)
		{
			g.updateTimer(hoursString + ":" + minutesString + ":" + secondsString);
			g.updateNotification(alertMessages.peek());
		}
	}
	
	public int[] getTimeArray()
	{
		return new int[]{hours, minutes, seconds};
	}
}
