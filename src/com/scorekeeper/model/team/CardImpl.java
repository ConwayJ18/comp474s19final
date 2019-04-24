package com.scorekeeper.model.team;

public class CardImpl implements Card
{
	private int cardType; //1=Blue, 2=Yellow, 3=Second Yellow, 4=Red
	private String cardTime;
	
	public CardImpl(int cardType, String cardTime)
	{
		if(isValidCardType(cardType))
		{
			this.cardType = cardType;
			this.cardTime = cardTime;
		}
	}

	@Override
	public int getCardType()
	{
		return this.cardType;
	}

	@Override
	public void setCardType(int type)
	{
		if(type<=4 && type >=1)
		{
			this.cardType = type;
		}
	}

	@Override
	public String getCardColor() {
		if(this.cardType == 1)
		{
			return "Blue";
		}
		else if(this.cardType == 2)
		{
			return "Yellow";
		}
		else if(this.cardType == 3)
		{
			return "Second Yellow";
		}
		else if(this.cardType == 4)
		{
			return "Red";
		}
		
		return null;
	}

	@Override
	public void setCardColor(String color) {
		if(color.toUpperCase().equals("BLUE") || color.toUpperCase().equals("B"))
		{
			this.cardType = 1;
		}
		else if(color.toUpperCase().equals("YELLOW") || color.toUpperCase().equals("Y"))
		{
			this.cardType = 2;
		}
		else if(color.toUpperCase().equals("SECOND YELLOW") || color.toUpperCase().equals("2ND YELLOW") || color.toUpperCase().equals("2Y"))
		{
			this.cardType = 3;
		}
		else if(color.toUpperCase().equals("RED") || color.toUpperCase().equals("R"))
		{
			this.cardType = 4;
		}
	}

	@Override
	public String getCardTime()
	{
		return this.cardTime;
	}

	@Override
	public void setCardTime(String time)
	{
		if(isValidCardTime(time))
		{
			this.cardTime = time;
		}
	}
	
	private boolean isValidCardType(int cardType)
	{
		if(cardType >= 1 && cardType <=4)
		{
			return true;
		}
		
		return false;
	}
	
	private boolean isValidCardTime(String cardTime)
	{
		String[] temp = cardTime.split(":", 4);
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

		if(parts[0] >= 0 && parts[0] <= 99
		&& parts[1] >= 0 && parts[1] <= 59
		&& parts[2] >= 0 && parts[2] <= 59)
		{
			return true;
		}
		
		return false;
	}
}
