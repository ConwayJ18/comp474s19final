package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.scorekeeper.model.timer.TimerImpl;

class TimerTest {

	private TimerImpl timer;	// TimerImpl variable to access its methods and variables
	private int hours = 6;		// Test Data: hours
	private int minutes = 12;	// Test Data: minutes
	private int seconds = 24;	// Test Data: seconds
	
	/** Initializes the test cases */
	@BeforeEach
	void initialize() {
		System.out.println("Initializing...");
		timer = new TimerImpl();			// Create TimerImpl's instance
	}

	/** Test case for TimerImpl's startTime method */
	@Test
	void testStartTime() {
		
		int[] oldTime = timer.getTimeArray();	// Get the initial time
		timer.startTime();					// Start timer
		
		sleep(3);							// Wait for 3 seconds as timer's thread keeps running
		
		int[] newTime = timer.getTimeArray();	// Get the latest time
				
		// Find difference and if time difference is greater than 0, then timer has started
		assertTrue("Timer hasn't started", findTimeDifference(oldTime, newTime) > 0);
		
	}
	
	/** Returns time difference in seconds. */
	long findTimeDifference(int[] oldTime, int[] newTime) {
		
		// Convert Array Time to String
		String oldTimeString = oldTime[0] + ":" + oldTime[1] + ":" + oldTime[2];
		String newTimeString = newTime[0] + ":" + newTime[1] + ":" +  newTime[2];
		
		// Set Date Formatter
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
		
		// Parse the time strings and find the difference in seconds
		try {
			Date oldTimeDate = dateFormat.parse(oldTimeString);
			Date newTimeDate = dateFormat.parse(newTimeString);
			
			long diff = newTimeDate.getTime() - oldTimeDate.getTime();	// Get difference in milliseconds
			
			return TimeUnit.MILLISECONDS.toSeconds(diff);		// Convert milliseconds difference to seconds and return the value
		}
		catch(ParseException pe) {
			System.out.println("Exception caught: " + pe.getMessage());
		}
		
		return -1;	// By default return -1, which isn't possible, so -1 value can also be treated as some error by its invoker method
	}
	
	/** Applies Thread sleep in seconds */
	void sleep(int seconds) {
		
		try {
			Thread.sleep(seconds * 1000);	// Convert milliseconds to seconds
		}
		catch(InterruptedException ie) {
			System.out.println("Exception caught: " + ie.getMessage());
		}
	}
	
	/** Test case for TimerImpl's stopTime method */
	@Test
	void testStopTime() {
		
		timer.startTime();					// Start the timer
		sleep(3);							// Wait for 3 seconds
		
		int[] oldTime = timer.getTimeArray();	// Get the time before it's stopped
		
		timer.stopTime();					// Stop the timer
		sleep(3);							// Wait for 3 seconds
		
		int[] newTime = timer.getTimeArray();	// Get the new time
		
		// Find the time difference, and if the difference is 0, then timer has stopped 
		assertTrue("Timer hasn't stopped", findTimeDifference(oldTime, newTime) == 0);
		
	}
	
	/** Test case for TimerImpl's setTime(int, int, int) method */
	@Test
	void testSetTime() {
		
		timer.setTime(hours + ":" + minutes + ":" + seconds);	// Set the time as per test data
		
		int[] time = timer.getTimeArray();			// Get the time
		
		// Compare test data with actual time
		assertEquals(hours, time[0], "Hours aren't set correctly");
		assertEquals(minutes, time[1], "Minutes aren't set correctly");
		assertEquals(seconds, time[2], "Seconds aren't set correctly");

	}
	
	/** Test case for TimerImpl's setTime(String) method */
	@Test
	void testSetTimeString() {
				
		String timeString = hours + ":" + minutes + ":" + seconds;	// Set the test data in string format
		timer.setTime(timeString);				// Set the time in timer
		
		int[] time = timer.getTimeArray();			// Get the time
		
		// Compare the test data with actual time
		assertEquals(hours, time[0], "Hours aren't set correctly");
		assertEquals(minutes, time[1], "Minutes aren't set correctly");
		assertEquals(seconds, time[2], "Seconds aren't set correctly");

	}
	
	/** Test case for TimerImpl's getTime method */
	@Test
	void testGetTime() {
				
		assertGetTime(0, 0, 0);				// Get the time and assert it with test data 0, 0 and 0 as in start, time is 00:00:00
		
		timer.setTime(hours + ":" + minutes + ":" + seconds);	// Set the time with test data	
		assertGetTime(hours, seconds, minutes);	// Get the time and assert it with test data
	}
	
	/** Asserts time returned by TimerImpl's getTimeArray() with parameters */
	void assertGetTime(int hours, int seconds, int minutes) {
		
		int[] time = timer.getTimeArray();		// Get current time
		 
		// Compare current time with arguments given
		assertEquals(hours, time[0], "Not getting correct Hours");
		assertEquals(minutes, time[1], "Not getting correct Minutes");
		assertEquals(seconds, time[2], "Not getting correct Seconds");
	}
	
	/** Performs closing operations after test case finishes its execution */
	@AfterEach
	void close() {
		System.out.println("Test Completed");
	}
}