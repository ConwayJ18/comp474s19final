package com.scorekeeper.model.team;

import java.util.ArrayList;

public class PlayerImpl implements Player
{
	String name;
	int number;
	ArrayList<Card> cards;
	boolean inPenaltyBox;
	boolean inPlay;
	int playTimeInSeconds;
	int plusMinus;
	
	PlayerImpl(String name)
	{
		this.name=name;
		this.cards = new ArrayList<Card>();
		this.inPenaltyBox = false;
		this.inPlay = false;
		this.playTimeInSeconds=0;
		this.plusMinus=0;
	}
	
	PlayerImpl(int number)
	{
		this.number=number;
		this.cards = new ArrayList<Card>();
		this.inPenaltyBox = false;
		this.inPlay = false;
		this.playTimeInSeconds=0;
		this.plusMinus=0;
	}

	public PlayerImpl(String name, int number)
	{
		this.name=name;
		this.number = number;
		this.cards = new ArrayList<Card>();
		this.inPenaltyBox = false;
		this.inPlay = false;
		this.playTimeInSeconds=0;
		this.plusMinus=0;
	}
	
	@Override
	public String getName()
	{
		return this.name;
	}

	@Override
	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public int getNumber()
	{
		return this.number;
	}

	@Override
	public void setNumber(int number)
	{
		if(isValidNumber(number))
		{
			this.number = number;
		}
	}

	@Override
	public void addCard(Card card)
	{
		this.cards.add(card);
	}

	@Override
	public void removeCard(Card card)
	{
		this.cards.remove(card);
	}

	@Override
	public boolean inPenaltyBox()
	{
		return this.inPenaltyBox;
	}
	
	@Override
	public void sendToPenaltyBox()
	{
		this.inPenaltyBox = true;
	}

	@Override
	public void releaseFromPenaltyBox()
	{
		this.inPenaltyBox = false;;
	}
	
	@Override
	public boolean inPlay()
	{
		return this.inPlay;
	}
	
	@Override
	public void putInPlay()
	{
		this.inPlay = true;
	}

	@Override
	public void removeFromPlay()
	{
		this.inPlay = false;
	}

	@Override
	public String getPlayTime()
	{
		String ret = "";
		
		ret = (this.playTimeInSeconds % 60) + ret;
		ret = (Math.floor(this.playTimeInSeconds/60)) + ":" + ret;
		ret = (Math.floor(this.playTimeInSeconds/3600)) + ":" + ret;
		
		return ret;
	}
	
	@Override
	public void incrementPlayTime()
	{
		this.playTimeInSeconds++;
	}
	
	private boolean isValidNumber(int number)
	{
		if(number >= 0 && number <= 99)
		{
			return true;
		}
		
		return false;
	}

	@Override
	public int getPlusMinus()
	{
		return this.plusMinus;
	}

	@Override
	public void incrementPlusMinus()
	{
		this.plusMinus+=10;
		
	}

	@Override
	public void decrementPlusMinus()
	{
		this.plusMinus-=10;
	}
}
