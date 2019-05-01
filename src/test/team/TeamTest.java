package test.team;

import static org.junit.jupiter.api.Assertions.*;

import com.scorekeeper.model.graphics.Graphics;
import org.junit.jupiter.api.Test;

import com.scorekeeper.model.graphics.OutwardDisplay;
import com.scorekeeper.model.scoreboard.ScoreboardImpl;
import com.scorekeeper.model.team.Player;
import com.scorekeeper.model.team.PlayerImpl;
import com.scorekeeper.model.team.Team;
import com.scorekeeper.model.team.TeamImpl;
import com.scorekeeper.model.timer.TimerImpl;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class TeamTest
{
	@Test
	void getterTests()
	{
		ArrayList<Player> players = new ArrayList<Player>();
		Player p1 = new PlayerImpl("Player1", 1);
		Player p2 = new PlayerImpl("Player2", 2);
		Player p3 = new PlayerImpl("Player3", 3);
		Player p4 = new PlayerImpl("Player4", 4);
		Player p5 = new PlayerImpl("Player5", 5);
		Player p6 = new PlayerImpl("Player6", 6);
		Player p7 = new PlayerImpl("Player7", 7);
		Player p8 = new PlayerImpl("Player8", 8);
		Player p9 = new PlayerImpl("Player9", 9);
		Player p10 = new PlayerImpl("Player10", 10);
		Player p11 = new PlayerImpl("Player11", 11);
		Player p12 = new PlayerImpl("Player12", 12);
		Player p13 = new PlayerImpl("Player13", 13);
		Player p14 = new PlayerImpl("Player14", 14);
		Player p15 = new PlayerImpl("Player15", 15);
		Player p16 = new PlayerImpl("Player16", 16);
		Player p17 = new PlayerImpl("Player17", 17);
		Player p18 = new PlayerImpl("Player18", 18);
		Player p19 = new PlayerImpl("Player19", 19);
		Player p20 = new PlayerImpl("Player20", 20);
		Player p21 = new PlayerImpl("Player21", 21);
		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);
		players.add(p5);
		players.add(p6);
		players.add(p7);
		players.add(p8);
		players.add(p9);
		players.add(p10);
		players.add(p11);
		players.add(p12);
		players.add(p13);
		players.add(p14);
		players.add(p15);
		players.add(p16);
		players.add(p17);
		players.add(p18);
		players.add(p19);
		players.add(p20);
		players.add(p21);
		
		Team testTeam = new TeamImpl("TeamName", players);
		assertEquals(testTeam.getTeamName(), "TeamName");
		assertEquals(testTeam.getPlayers(), players);
		assertEquals(testTeam.getPlayerByLastName("Player1"), p1);
		assertEquals(testTeam.getPlayerByNumber(1), p1);
	}
	
	@Test
	void setterTests()
	{
		ArrayList<Player> players1 = new ArrayList<Player>();
		ArrayList<Player> players2 = new ArrayList<Player>();
		Player p1 = new PlayerImpl("Player1", 1);
		Player p2 = new PlayerImpl("Player2", 2);
		players1.add(p1);
		players2.add(p1);
		players2.add(p2);
		Team testTeam = new TeamImpl("", players1);
		testTeam.setTeamName("TeamName");
		assertEquals(testTeam.getTeamName(), "TeamName");
		testTeam.addPlayer(p2);
		assertEquals(testTeam.getPlayers(), players2);
		testTeam.removePlayer(p2);
		assertEquals(testTeam.getPlayers(), players1);
	}
}
