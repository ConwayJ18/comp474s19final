package com.scorekeeper.model.scoreboard;

public class ScoreboardImpl implements Scoreboard
{
	int score1;
	int score2;
	
	/**
	 * Default constructor
	 */
	public ScoreboardImpl()
	{
		this.score1 = 0;
		this.score2 = 0;
	}
	
	/**
	 * @param score1
	 * @param score2
	 */
	public ScoreboardImpl(int score1, int score2)
	{
		//TODO
		this.score1 = score1;
		this.score2 = score2;
	}
	
	/**
	 * @return the score1
	 */
	public int getScore1()
	{
		return score1;
	}

	/**
	 * 1 set score success, 0 fail
	 *
	 * @param score1 the score1 to set , must be multiples of 10
	 */
	public int setScore1(int score1)
	{
		//TODO
		if (score1 % 10 == 0) {
			this.score1 = score1;
		}
		return this.score1;
	}

	/**
	 * @return the score2
	 */
	public int getScore2()
	{
		return score2;
	}

	/**
	 * 1 set score success, 0 fail
	 *
	 * @param score2 the score1 to set , must be multiples of 10
	 */
	public int setScore2(int score2)
	{
		//TODO
		if (score2 % 10 == 0) {
			this.score2 = score2;
		}
		return this.score2;
	}
	
	@Override
	public int incrementScore1()
	{
		//TODO
		return 0;
	}
	
	@Override
	public int incrementScore2()
	{
		//TODO
		return 0;
	}
	
	@Override
	public int decrementScore1()
	{
		//TODO
		return 0;
	}
	
	@Override
	public int decrementScore2()
	{
		//TODO
		return 0;
	}

	@Override
	public void resetScore1()
	{
		//TODO
	}
	
	@Override
	public void resetScore2()
	{
		//TODO
	}
	
	@Override
	public void resetScores()
	{
		//TODO
	}
}
