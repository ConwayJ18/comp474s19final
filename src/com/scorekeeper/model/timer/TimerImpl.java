package com.scorekeeper.model.timer;

import java.awt.Font;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.scorekeeper.model.graphics.Graphics;
import com.scorekeeper.model.graphics.QTextField;

public class TimerImpl extends JPanel implements Timer {

	private QTextField hoursField, minutesField, secondsField, colonLabel1, colonLabel2;	// TextFields to show and modify actual values of HH MM SS
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
		initComponents();					// Initialize frame components
	}

	// Initialize Timer Thread
	public void initializeThread() {

		timerThread = new Thread() {	// Create thread

			@Override
			public void run() {				// Executes when thread is started
				while(true) {					// Keep looping these statements forever
					try{
						Thread.sleep(10);			// Sleep for 10 milliseconds
					} catch(Exception e) {
						System.out.println(e.getMessage());
					}
					updateFrame();					// Update the frame
				}
			}
		};
	}

	// Initialize the frame components
	public void initComponents() {
		this.setBounds(425, 25, 600, 150);

        // Initialize hours field
        hoursField = new QTextField("00", 1);
        format(hoursField);
        add(hoursField);		// Add hours field to timer panel

        // Initialize colon
        colonLabel1 = new QTextField(":", 1);
        format(colonLabel1);
        add(colonLabel1);

        // Initialize minutes field
        minutesField = new QTextField("00", 1);
        format(minutesField);
        add(minutesField);

        // Initialize colon
        colonLabel2 = new QTextField(":", 1);
        format(colonLabel2);
        add(colonLabel2);

        // Initialize seconds field
        secondsField = new QTextField("00", 1);
        format(secondsField);
        add(secondsField);
        
        
	}

	// Update the frame and data, which is held in this frame
	public void updateFrame() {
		if(!isPaused) {		// If unpaused

			if (millisecondsCount > 999) {	// milliseconds are counted to 1000

				millisecondsCount = 0;			// reset milliseconds count

				// Parse seconds value to int type
				String secondsText = secondsField.getText();	// Get value in Seconds Field
				if (!secondsText.equals("")) {					// If the value isn't empty string
					seconds = Integer.parseInt(secondsText);		// Then, parse string value to int
				}

				// Parse minutes value to int type
				String minutesText = minutesField.getText();
				if (!minutesText.equals("")) {
					minutes = Integer.parseInt(minutesText);
				}

				// Parse hours value to int type
				String hoursText = hoursField.getText();
				if (!hoursText.equals("")) {
					hours = Integer.parseInt(hoursText);
				}

				seconds++;			// Increment seconds by 1 as milliseconds are counted to 1000

				if (hours > 98 && minutes > 58 && seconds > 58) {		// If max numbers are reached for HH MM and SS
					updateSeconds();										// Update seconds value for one last time
					JOptionPane.showMessageDialog(null, "The Timer is stopped"); // Show user that timer is stopped
					stopTime();											// Stop the timer
					return;													// return out of the method
				}

				if (seconds > 59) {			// If seconds > 59
					minutes++;					// Increment minutes by 1
					seconds = 0;				// Reset seconds to 1
					updateMinutes();			// Update minutes field
					updateHours();				// Update hours field
				}
				if(minutes > 59) {			// If minutes > 59
					hours++;					// Increment hours and reset minutes and seconds
					minutes = 0;
					seconds = 0;
					updateMinutes();			// Update the fields
					updateHours();
				}

				updateSeconds();			// Update seconds field

				if(seconds % 6 == 0) {		// If seconds value is a multiple of 6
					updateMinutes();			// Update minutes field to get 2-digit value
					updateHours();				// Update hours field to get 2-digit value
				}
				
				if(alertNecessary())
				{
					alert();
				}
			}

			millisecondsCount += 10;		// Increment milliseconds count by 10 as this method is called every 10 milliseconds for better accuracy when pausing and unpausing
		}
	}

	// Update Hours, Minutes and Seconds TextFields
	public void updateTime() {
		updateHours();
		updateMinutes();
		updateSeconds();
		
		if(alertNecessary())
		{
			alert();
		}
	}

	// Update Hours TextField
	public void updateHours() {
		String hoursString = String.format("%02d", hours);
		hoursField.setText(hoursString);
	}

	// Update Minutes TextField
	public void updateMinutes() {
		String minutesString = String.format("%02d", minutes);
		minutesField.setText(minutesString);
	}

	// Update Seconds TextField
	public void updateSeconds() {
		String secondsString = String.format("%02d", seconds);
		secondsField.setText(secondsString);
	}

	// Validate the input given in int[] parts, where parts[0] is hours, [1] is minutes, [2] is seconds
	public void validateInput(int[] parts)
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
        	updateTime();
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
		hoursField.setText("00");
		minutesField.setText("00");
		secondsField.setText("00");
		millisecondsCount = 0;
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
	public void setTime(int hours, int minutes, int seconds) {
		validateInput(new int[]{hours, minutes, seconds});
	}

	@Override
	public int[] getTime() {
		return new int[]{hours, minutes, seconds};
	}

	private void format(QTextField field)
	{
		Font fieldFont = new Font("MarkerFelt-Wide", Font.PLAIN, 126);
		field.setFont(fieldFont);
        field.setEditable(false);
        field.setHorizontalAlignment(QTextField.CENTER);
        field.setBorder(null);
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
	
	private void alert() 
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
		notifyObservers();
	}
	
	public void acknowledge() //Clears notification panel
	{
		alertMessages.remove();
		notifyObservers();
	}
	
	public void addObserver(Graphics g) //Standard for observer patterns
	{
		this.graphicsObservers.add(g);
	}
	
	public void notifyObservers() //Standard for observer pattern
	{
		for(Graphics g : graphicsObservers)
		{
			g.updateNotification(alertMessages.peek());
		}
	}
}
