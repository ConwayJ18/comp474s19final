package com.scorekeeper.model.team;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.scorekeeper.model.graphics.PlayerStats;

public class PlayerImpl implements Player
{
	String name;
	int number;
	ArrayList<Card> cards;
	boolean inPenaltyBox;
	boolean inPlay;
	int playTimeInSeconds;
	int penaltyTimeInSeconds;
	int plusMinus;
	int blueCards;
	int yellowCards;
	int redCards;
	
	PlayerImpl(String name)
	{
		this.name=name;
		this.cards = new ArrayList<Card>();
		this.inPenaltyBox = false;
		this.inPlay = false;
		this.playTimeInSeconds=0;
		this.plusMinus=0;
		this.blueCards=0;
		this.yellowCards=0;
		this.redCards=0;
	}
	
	PlayerImpl(int number)
	{
		this.number=number;
		this.cards = new ArrayList<Card>();
		this.inPenaltyBox = false;
		this.inPlay = false;
		this.playTimeInSeconds=0;
		this.plusMinus=0;
		this.blueCards=0;
		this.yellowCards=0;
		this.redCards=0;
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
		this.blueCards=0;
		this.yellowCards=0;
		this.redCards=0;
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
		
		if(card.getCardType()==1)
		{
			this.blueCards++;
		}
		else if(card.getCardType()==2)
		{
			this.yellowCards++;
		}
		else if(card.getCardType()==3)
		{
			this.yellowCards++;
			this.redCards++;
		}
		else if(card.getCardType()==4)
		{
			this.redCards++;
		}
	}

	@Override
	public void removeCard(Card card)
	{
		this.cards.remove(card);
		if(card.getCardType()==1)
			this.blueCards--;
		else if(card.getCardType()==2)
			this.yellowCards--;
		else if(card.getCardType()==3)
		{
			this.yellowCards--;
			this.redCards--;
		}
		else if(card.getCardType()==4)
			this.redCards--;
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
		this.inPenaltyBox = false;
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
		if(!this.inPenaltyBox())
		{
			this.inPlay = false;
		}
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
		if(this.inPenaltyBox())
		{
			this.incrementPenaltyTime();
		}
	}
	
	@Override
	public String getPenaltyTime()
	{
		String ret = "";
		
		ret = (this.penaltyTimeInSeconds % 60) + ret;
		ret = (Math.floor(this.penaltyTimeInSeconds/60)) + ":" + ret;
		ret = (Math.floor(this.penaltyTimeInSeconds/3600)) + ":" + ret;
		
		return ret;
	}
	
	@Override
	public void incrementPenaltyTime()
	{
		this.penaltyTimeInSeconds++;
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

	@Override
	public void showStats()
	{
		PlayerStats.start(this);
	}

	@Override
	public int getBlueCards()
	{
		return this.blueCards;
	}

	@Override
	public int getYellowCards()
	{
		return this.yellowCards;
	}

	@Override
	public int getRedCards()
	{
		return this.redCards;
	}

	@Override
	public void cardPlayer(String time)
	{
		String[] cards = {"Blue", "Yellow", "Second Yellow", "Red"};
		int cardType = JOptionPane.showOptionDialog(null, "What type of card should be issued?",
                "Give a card",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, cards, null) + 1;
		this.addCard(new CardImpl(cardType, time));
	}	
}
