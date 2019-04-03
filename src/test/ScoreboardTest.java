package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.scorekeeper.model.scoreboard.ScoreboardImpl;

class ScoreboardTest {

	ScoreboardImpl sb = new ScoreboardImpl();

	@Test
	void setterTests()
	{
		fail("Not implemented yet");
	}
	
	@Test
	void getterTests()
	{
		fail("Not implemented yet");
	}
	
	@Test
	void incrementDecrementTests()
	{
		fail("Not implemented yet");
	}
	
	@Test
	void resetTests()
	{
		fail("Not implemented yet");
	}
	
	@Test
	void isValidTests()
	{
		/*
		 * These tests should return true
		 */
		assert(sb.isValid(0)); //0 is valid
		assert(sb.isValid(10)); //10 is valid
		assert(sb.isValid(980)); //980 is valid
		assert(sb.isValid(990)); //990 is valid
		
		/*
		 * These tests should return false
		 */
		assertFalse(sb.isValid(-10)); //Negative
		assertFalse(sb.isValid(-5)); //Negative and not divisible by 10
		assertFalse(sb.isValid(5)); //Not divisible by 10
		assertFalse(sb.isValid(985)); //Not divisible by 10
		assertFalse(sb.isValid(995)); //Greater than 990 and not visible by 10
		assertFalse(sb.isValid(1000)); //Greater than 990
	}

}
