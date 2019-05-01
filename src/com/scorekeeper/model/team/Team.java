package com.scorekeeper.model.team;

import java.util.ArrayList;

import com.scorekeeper.model.graphics.Graphics;

public interface Team
{
	void setTeamName(String teamName);
	String getTeamName();
	void addPlayer(Player p);
	void removePlayer(Player p);
	ArrayList<Player> getPlayers();
	Player getPlayerByLastName(String name);
	Player getPlayerByNumber(int number);
	void addObserver(Graphics g);
	void removeObserver(Graphics g);
}
