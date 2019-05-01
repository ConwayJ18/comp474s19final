package com.scorekeeper.model.team;

import java.util.ArrayList;

import com.scorekeeper.model.graphics.Graphics;

public class TeamImpl implements Team
{
	String name;
	ArrayList<Player> players;
	ArrayList<Graphics> graphicsObservers;
	
	public TeamImpl()
	{
		this.name = "Team";
		this.players = new ArrayList<Player>();
		graphicsObservers = new ArrayList<Graphics>();
	}
	
	public TeamImpl(String name)
	{
		this.name = name;
		this.players = new ArrayList<Player>();
		graphicsObservers = new ArrayList<Graphics>();
	}
	
	public TeamImpl(String name, ArrayList<Player> players)
	{
		this.name = name;
		this.players = players;
		graphicsObservers = new ArrayList<Graphics>();
	}
	
	@Override
	public void setTeamName(String teamName)
	{
		this.name = teamName;
		notifyObservers();
	}

	@Override
	public String getTeamName()
	{
		return this.name;
	}

	@Override
	public void addPlayer(Player p)
	{
		this.players.add(p);
		notifyObservers();
	}
	
	public void addPlayers(ArrayList<Player> players)
	{
		for(Player p : players)
		{
			this.players.add(p);
		}
	}

	@Override
	public void removePlayer(Player p)
	{
		this.players.add(p);
		notifyObservers();
	}

	@Override
	public ArrayList<Player> getPlayers()
	{
		return this.players;
	}
	
	@Override
	public Player getPlayerByLastName(String name)
	{
		for(Player p : this.players)
		{
			if(p.getName().equals(name))
			{
				return p;
			}
		}
		return null;
	}

	@Override
	public Player getPlayerByNumber(int number)
	{
		for(Player p : this.players)
		{
			if(p.getNumber() == number)
			{
				return p;
			}
		}
		return null;
	}
	
	@Override
	public void addObserver(Graphics g)
	{
		graphicsObservers.add(g);		
	}
	
	@Override
	public void removeObserver(Graphics g)
	{
		graphicsObservers.remove(g);		
	}
	
	private void notifyObservers()
	{
		for(Graphics g : graphicsObservers)
		{
			g.updateTeams();
		}
	}
}
