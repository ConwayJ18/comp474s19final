package com.scorekeeper.model.timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.scorekeeper.model.graphics.QTextField;

public class TimerImpl extends JPanel implements Timer {

	private QTextField hoursField, minutesField, secondsField, colonLabel1, colonLabel2;	// TextFields to show and modify actual values of HH MM SS
	private int millisecondsCount;					// Keeps a count of milliseconds passed to provide higher level of accuracy when pausing and unpausing in fractions of seconds
	private int hours, seconds, minutes;			// Holds int values
	private boolean isTimerOn, isPaused;			// If timer is started, If timer is currently paused or not
	private Thread timerThread;						// Thread responsible for the timer's functionality

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
		setBounds(425, 25, 600, 150);
		setBackground(Color.WHITE);

        // Initialize hours field
        hoursField = new QTextField("00", 1);
        format(hoursField);
        hoursField.addKeyListener(new KeyListener() {	// Add Key listener to listen keyboard input

			@Override
			public void keyTyped(KeyEvent e) {		// It is invoked when a key is typed
				validateInput(hoursField, e);
			}

			@Override
			public void keyPressed(KeyEvent e) {}	// Implement Method from interface

			@Override
			public void keyReleased(KeyEvent e) {}	// Implement Method from interface

		});
        add(hoursField);		// Add hours field to timer panel

        // Initialize colon
        colonLabel1 = new QTextField(":", 1);
        format(colonLabel1);
        add(colonLabel1);

        // Initialize minutes field
        minutesField = new QTextField("00", 1);
        format(minutesField);
        minutesField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				validateInput(minutesField, e);
			}

			@Override
			public void keyPressed(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {}

		});

        add(minutesField);

        // Initialize colon
        colonLabel2 = new QTextField(":", 1);
        format(colonLabel2);
        add(colonLabel2);

        // Initialize seconds field
        secondsField = new QTextField("00", 1);
        format(secondsField);
        secondsField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				validateInput(secondsField, e);
			}

			@Override
			public void keyPressed(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {}

		});
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
			}

			millisecondsCount += 10;		// Increment milliseconds count by 10 as this method is called every 10 milliseconds for better accuracy when pausing and unpausing
		}
	}

	// Update Hours, Minutes and Seconds TextFields
	public void updateTime() {
		updateHours();
		updateMinutes();
		updateSeconds();
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

	// Validate the input given in TextField
	public void validateInput(QTextField field, KeyEvent e) {

		boolean isValueChanged = true;		// Considering it validated at first

		char c = e.getKeyChar();			// Get the keyboard character input

		String fieldText = field.getText();	// Get the data in textfield

        if(fieldText.length() >= 2 || !Character.isDigit(c)			// If number of characters > 2, non-digit characters are entered and the input character is not Backspace or Delete Key
                && !(c == KeyEvent.VK_DELETE || c == KeyEvent.VK_BACK_SPACE)) {
            getToolkit().beep();										// Then, input isn't valid. So make a beep sound
            e.consume();												// Consume the keypress event and it won't be processed further
            isValueChanged = false;										// Changing variable to flag invalid input
        }

        if(!fieldText.equals("")) {				// If textfield is not blank
        	int number = Integer.parseInt(fieldText);	// Parse string input to int

            if(!(field == hoursField) && number > 59) { // If the field isn't hours field and number entered is greater than 59
            	updateTime();								// Update time to change the fields accordingly
            }
        }

        if(!isValueChanged) {			// If Invalid input, then alert user
        	JOptionPane.showMessageDialog(null, "Please enter a valid value for time.");
        }
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
}
