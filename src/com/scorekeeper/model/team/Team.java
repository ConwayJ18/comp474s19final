package com.scorekeeper.model.team;

import java.util.ArrayList;

public interface Team
{
	void setTeamName(String teamName);
	String getTeamName();
	void addPlayer(Player p);
	void removePlayer(Player p);
	ArrayList<Player> getPlayers();
	Player getPlayerByLastName(String name);
	Player getPlayerByNumber(int number);
}
