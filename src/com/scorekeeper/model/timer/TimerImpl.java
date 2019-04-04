package com.scorekeeper.model.timer;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class TimerImpl extends JFrame implements Timer {
	
	private JPanel mainPanel, timerPanel;			// Panels to hold components
	private JLabel colonLabel1, colonLabel2;		// Labels to display : in HH:MM:SS
	private JTextField hoursField, minutesField, secondsField;	// TextFields to show and modify actual values of HH MM SS
	private JButton startButton, stopButton, resetButton;	// Buttons to interact with application
	private int millisecondsCount;					// Keeps a count of milliseconds passed to provide higher level of accuracy when pausing and unpausing in fractions of seconds
	private int hours, seconds, minutes;			// Holds int values
	private boolean isTimerOn, isPaused;			// If timer is started, If timer is currently paused or not
	private Thread timerThread;						// Thread responsible for the timer's functionality
	
	// TimerImpl's Constructor
	public TimerImpl() {
		setSize(1024, 768);			// Set the frame size
		setTitle("Timer App");		// Set the title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// Set default close operation, i.e. when clicked on X at top right corner
        setLayout(new BorderLayout());		// Set layout for frame
        setLocationRelativeTo(null);		// Center the frame horizontally and vertically
        
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
		mainPanel = new JPanel(null);	// Main Panel with null Layout
		
		timerPanel = new JPanel(null);	// Timer Panel with null Layout
		timerPanel.setBounds(150, 110, 720, 450);
		
		// Create a titled border
		TitledBorder border = new TitledBorder("Timer");
        border.setTitleFont(new Font("Tahoma", Font.BOLD, 30));
        timerPanel.setBorder(border);
        
        // Set default fonts for labels, fields and buttons
        Font labelFont = new Font("Tahoma", Font.BOLD, 36);
        Font fieldFont = new Font("Tahoma", Font.BOLD, 36);
        Font buttonFont = new Font("Tahoma", Font.PLAIN, 24);
        
        // Initialize hours field
        hoursField = new JTextField("00");
        hoursField.setBounds(120, 100, 100, 120);
        hoursField.setFont(fieldFont);
        hoursField.setHorizontalAlignment(JTextField.CENTER);
        hoursField.addKeyListener(new KeyListener() {	// Add Key listener to listen keyboard input
			
			@Override
			public void keyTyped(KeyEvent e) {		// It is invoked when a key is typed
				hoursFieldKeyPressed(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {}	// Implement Method from interface

			@Override
			public void keyReleased(KeyEvent e) {}	// Implement Method from interface
			
		});
        timerPanel.add(hoursField);		// Add hours field to timer panel

        // Initialize colon
        colonLabel1 = new JLabel(":");
        colonLabel1.setBounds(261, 132, 30, 40);
        colonLabel1.setFont(labelFont);
        timerPanel.add(colonLabel1);
        
        // Initialize minutes field
        minutesField = new JTextField("00");
        minutesField.setBounds(312, 100, 100, 120);
        minutesField.setFont(fieldFont);
        minutesField.setHorizontalAlignment(JTextField.CENTER);
        minutesField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				minutesFieldKeyPressed(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {}
			
		});

        timerPanel.add(minutesField);
                
        // Initialize colon
        colonLabel2 = new JLabel(":");
        colonLabel2.setBounds(450, 132, 30, 40);
        colonLabel2.setFont(labelFont);
        timerPanel.add(colonLabel2);

        // Initialize seconds field
        secondsField = new JTextField("00");
        secondsField.setBounds(501, 100, 100, 120);
        secondsField.setFont(fieldFont);
        secondsField.setHorizontalAlignment(JTextField.CENTER);
        secondsField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				secondsFieldKeyPressed(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {}
			
		});

        timerPanel.add(secondsField);

        // Initialize start button
        startButton = new JButton("Start");
        startButton.setBounds(60, 270, 180, 90);
        startButton.setFont(buttonFont);
        startButton.addActionListener(new ActionListener(){		// Add ActionListener to listen button clicks
        
            @Override
            public void actionPerformed(ActionEvent e) {			// It is invoked when the button is clicked
                startButtonActionPerformed(e);
            }
        });
        timerPanel.add(startButton);
        
        // Initialize stop button
        stopButton = new JButton("Stop");
        stopButton.setBounds(270, 270, 180, 90);
        stopButton.setFont(buttonFont);
        stopButton.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                stopButtonActionPerformed(e);
            }
        });
        timerPanel.add(stopButton);
        
        // Initialize reset button
        resetButton = new JButton("Reset");
        resetButton.setBounds(480, 270, 180, 90);
        resetButton.setFont(buttonFont);
        resetButton.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                resetButtonActionPerformed(e);
            }
        });
        timerPanel.add(resetButton);

        mainPanel.add(timerPanel);		// Add timer panel to main panel
        add(mainPanel, BorderLayout.CENTER);	// Add main panel to frame with Border Layout and positioning it to center
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
					stopTimer();											// Stop the timer
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
	
	public void hoursFieldKeyPressed(KeyEvent e) {
		validateInput(hoursField, e);
	}
	
	public void minutesFieldKeyPressed(KeyEvent e) {
		validateInput(minutesField, e);
	}
	
	public void secondsFieldKeyPressed(KeyEvent e) {
		validateInput(secondsField, e);
	}
	
	// Validate the input given in TextField
	public void validateInput(JTextField field, KeyEvent e) {
		
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
	
	public void startButtonActionPerformed(ActionEvent e) {
		startTimer();	// Start the timer
	}
	
	public void startTimer() {		
		if(isTimerOn) {		// If timer is started at least once before
			isPaused = false;		// Unpause
		}
		else {				// else
			timerThread.start();	// Start timer
			isTimerOn = true;		// Set the variable to true
		}
	}
	
	public void stopButtonActionPerformed(ActionEvent e) {
		stopTimer();	// Stop the timer
	}
	
	public void stopTimer() {
		isPaused = true;	// Pause timer
	}
	
	public void resetButtonActionPerformed(ActionEvent e) {
		stopTimer();	// Stop the timer
		resetTimer();	// Reset the timer
	}
	
	// Reset all the text fields and count variables
	public void resetTimer() {
		hoursField.setText("00");
		minutesField.setText("00");
		secondsField.setText("00");
		millisecondsCount = 0;
	}

	@Override
	public void startTime() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopTime() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTime(String time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTime(int hours, int minutes, int seconds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int[] getTime() {
		// TODO Auto-generated method stub
		return null;
	}
}
