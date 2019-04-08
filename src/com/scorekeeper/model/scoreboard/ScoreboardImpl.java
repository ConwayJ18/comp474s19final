package com.scorekeeper.model.scoreboard;

import javax.swing.JOptionPane;

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
		if(isValid(score1)) //Check score1 validity
		{
			this.score1 = score1;
		}
		else
		{
			this.score1 = 0; //Set to 0 otherwise
		}

		if(isValid(score2)) //Check score2 validity
		{
			this.score2 = score2;
		}
		else
		{
			this.score2 = 0; //Set to 0 otherwise
		}
	}
	
	/**
	 * @return the score1
	 */
	public int getScore1()
	{
		return score1;
	}

	/**
	 * @param score1 the score1 to set
	 */
	public int setScore1(int score1)
	{
		if(isValid(score1)) //Update if valid
		{
			this.score1 = score1;
		}

		return this.score1; //Return new score
	}

	/**
	 * @return the score2
	 */
	public int getScore2()
	{
		return score2;
	}

	/**
	 * @param score2 the score1 to set , must be multiples of 10
	 */
	public int setScore2(int score2)
	{
		if(isValid(score2)) //Update if valid
		{
			this.score2 = score2;
		}

		return this.score2; //Return new score
	}
	
	@Override
	public int incrementScore1()
	{
        if (this.score1 < 990) { //If score can be incremented
            this.score1 += 10; //Increment score
        }
        return this.score1;
	}
	
	@Override
	public int incrementScore2()
	{
        if (this.score2 < 990) { //If score can be incremented
            this.score2 += 10; //Increment score
        }
        return this.score2;
	}
	
	@Override
	public int decrementScore1()
	{
		if (this.score1 > 0) { //If score can be decremented
			this.score1 -= 10; //Decrement score
		}
		return this.score1;
	}
	
	@Override
	public int decrementScore2()
	{
		if (this.score2 > 0) { //If score can be decremented
			this.score2 -= 10; //Decrement score
		}
		return this.score2;
	}

	@Override
	public void resetScore1()
	{
        this.score1 = 0; //Reset score1 to 0
	}
	
	@Override
	public void resetScore2()
	{
        this.score2 = 0; //Reset score2 to 0
	}
	
	@Override
	public void resetScores()
	{
		this.score1 = 0; //Reset scores to 0
		this.score2 = 0;
	}
	
	/*
	 * FUNCTION: Decides if a score is valid according to requirements doc
	 * INPUT: An integer score
	 * OUTPUT: Boolean result of validity test
	 */
	//TODO Make this private before release
	public boolean isValid(int score)
	{
		if(score%10 == 0 //Checks that score is a multiple of 10
		&& score>=0  //Checks that score is non-negative
		&& score<=990) //Checks that score is at or below upper-bound
		{
			return true; //Return true if all conditions are met
		}
		else //Otherwise input is invalid
		{
			JOptionPane.showMessageDialog(null, "Please enter a valid value for score."); //Alert
			return false;
		}
	}
}
