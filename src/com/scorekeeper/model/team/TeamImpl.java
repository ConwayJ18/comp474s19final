package com.scorekeeper.model.team;

import java.util.ArrayList;
import java.util.HashMap;

public class TeamImpl implements Team
{
	String name;
	HashMap<String, Player> playersByName;
	HashMap<Integer, Player> playersByNumber;
	
	public TeamImpl(String name)
	{
		this.name = name;
		this.playersByName = new HashMap<String, Player>();
		this.playersByNumber = new HashMap<Integer, Player>();
	}
	
	@Override
	public void setTeamName(String teamName)
	{
		this.name = teamName;
	}

	@Override
	public String getTeamName()
	{
		return this.name;
	}

	@Override
	public void addPlayer(Player p)
	{
		this.playersByName.put(p.getName(), p);
		this.playersByNumber.put(p.getNumber(), p);
	}

	@Override
	public void removePlayer(Player p)
	{
		this.playersByName.put(p.getName(), p);
		this.playersByNumber.put(p.getNumber(), p);
	}

	@Override
	public ArrayList<Player> getPlayers()
	{
		ArrayList<Player> players = new ArrayList<Player>();
		for(Player p : playersByName.values())
		{
			players.add(p);
		}
		
		return players;
	}
	
	@Override
	public Player getPlayerByLastName(String name)
	{
		return this.playersByName.get(name);
	}

	@Override
	public Player getPlayerByNumber(int number)
	{
		return this.playersByNumber.get(number);
	}
	
}
