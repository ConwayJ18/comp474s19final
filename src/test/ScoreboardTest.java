package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.scorekeeper.model.scoreboard.ScoreboardImpl;

class ScoreboardTest {

	ScoreboardImpl sb = new ScoreboardImpl(); //Used for all non-constructor tests

	/*
	 * These verify that the scoreboard constructors and getters work
	 */
	@Test
	void constructorAndGetterTests()
	{
		ScoreboardImpl sbDefault = new ScoreboardImpl(); //Uses default constructor, sets score1 = score2 = 0
		ScoreboardImpl sbWorking = new ScoreboardImpl(110, 580); //Uses other constructor, sets score1 = 110, score2 = 580
		ScoreboardImpl sbBroken1 = new ScoreboardImpl(-5, 100); //Uses other constructor the wrong way, should set score1 = 0, score 2 = 100
		ScoreboardImpl sbBroken2 = new ScoreboardImpl(700, 10000); //Uses other constructor the wrong way, should set score1 = 700, score 2 = 0
		ScoreboardImpl sbBrokenBoth = new ScoreboardImpl(995, -350); //Uses other constructor the wrong way, should set score1 = 0, score 2 = 0
	
		assertEquals(sbDefault.getScore1(), 0); //Tests for sbDefault
		assertEquals(sbDefault.getScore2(), 0);
		
		assertEquals(sbWorking.getScore1(), 110); //Tests for sbWorking
		assertEquals(sbWorking.getScore2(), 580);
		
		assertEquals(sbBroken1.getScore1(), 0); //Tests for sbBroken1
		assertEquals(sbBroken1.getScore2(), 100);
		
		assertEquals(sbBroken2.getScore1(), 700); //Tests for sbBroken2
		assertEquals(sbBroken2.getScore2(), 0);
		
		assertEquals(sbBrokenBoth.getScore1(), 0); //Tests for sbBrokenBoth
		assertEquals(sbBrokenBoth.getScore2(), 0);
	}

	private void assertEquals(int score2, int i) {
	}

	/*
	 * These verify the scoreboard setters work
	 */
	@Test
	void setterTests()
	{
		/*
		 * These tests should return the new values of score1
		 */
		assertEquals(sb.setScore1(0), 0); //0 is valid
		assertEquals(sb.setScore1(10), 10); //10 is valid
		assertEquals(sb.setScore1(980), 980); //980 is valid
		assertEquals(sb.setScore1(990), 990); //990 is valid
		
		/*
		 * These tests should return 990 since
		 * that's what the scores were most recently set to above
		 * (This indicates failure, as wanted)
		 */
		assertEquals(sb.setScore1(-10), 990); //Negative
		assertEquals(sb.setScore1(-5), 990); //Negative and not divisible by 10
		assertEquals(sb.setScore1(5), 990); //Not divisible by 10
		assertEquals(sb.setScore1(985), 990); //Not divisible by 10
		assertEquals(sb.setScore1(995), 990); //Greater than 990 and not visible by 10
		assertEquals(sb.setScore1(1000), 990); //Greater than 990
		
		/*
		 * Repeat the above for score2
		 */
		
		/*
		 * These tests should return the new values
		 */
		assertEquals(sb.setScore2(0), 0); //0 is valid
		assertEquals(sb.setScore2(10), 10); //10 is valid
		assertEquals(sb.setScore2(980), 980); //980 is valid
		assertEquals(sb.setScore2(990), 990); //990 is valid
		
		/*
		 * These tests should return 990 since
		 * that's what the scores were most recently set to above
		 * (This indicates failure, as wanted)
		 */
		assertEquals(sb.setScore2(-10), 990); //Negative
		assertEquals(sb.setScore2(-5), 990); //Negative and not divisible by 10
		assertEquals(sb.setScore2(5), 990); //Not divisible by 10
		assertEquals(sb.setScore2(985), 990); //Not divisible by 10
		assertEquals(sb.setScore2(995), 990); //Greater than 990 and not visible by 10
		assertEquals(sb.setScore2(1000), 990); //Greater than 990
	}
	
	/*
	 * These verify that the scoreboard reset methods work
	 */
	@Test
	void resetTests()
	{
		sb.resetScore1();
		sb.resetScore2();
		
		assertEquals(sb.getScore1(), 0);
		assertEquals(sb.getScore2(), 0);
		
		sb.setScore1(110);
		sb.setScore2(570);
		sb.resetScores();
		
		assertEquals(sb.getScore1(), 0);
		assertEquals(sb.getScore2(), 0);
	}
	
	/*
	 * These verify that the scoreboard increment and decrement methods work
	 */
	@Test
	void incrementDecrementTests()
	{
		/*
		 * These tests shouldn't do anything because the scores are already 0
		 */
		assertEquals(sb.decrementScore1(),0);
		assertEquals(sb.decrementScore2(),0);
		
		/*
		 * These tests should increment the scores from 0 to 10
		 */
		assertEquals(sb.incrementScore1(),10);
		assertEquals(sb.incrementScore2(),10);
		
		sb.setScore1(990); //Set scores to 990
		sb.setScore2(990); //We know this works because of earlier tests
		
		/*
		 * These tests shouldn't do anything because the scores are already 990
		 */
		assertEquals(sb.incrementScore1(),990);
		assertEquals(sb.incrementScore2(),990);
		
		/*
		 * These tests should decrement the scores from 990 to 980
		 */
		assertEquals(sb.decrementScore1(),980);
		assertEquals(sb.decrementScore2(), 980);
	}
	
	/*
	 * These verify that the scoreboard verify method works
	 */
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
