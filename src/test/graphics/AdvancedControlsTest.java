package test.graphics;

import static org.junit.jupiter.api.Assertions.*;

import com.scorekeeper.model.scoreboard.ScoreboardImpl;
import com.scorekeeper.model.team.Player;
import com.scorekeeper.model.team.PlayerImpl;
import com.scorekeeper.model.team.TeamImpl;
import com.scorekeeper.model.timer.TimerImpl;

import org.junit.jupiter.api.Test;

import com.scorekeeper.model.graphics.AdvancedControls;

import java.awt.*;
import java.util.ArrayList;

class AdvancedControlsTest {
	TimerImpl t = new TimerImpl();
	ScoreboardImpl sb = new ScoreboardImpl();
	AdvancedControls ac = new AdvancedControls();
	ArrayList<Player> players1 = new ArrayList<Player>();
	ArrayList<Player> players2 = new ArrayList<Player>();
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
	 
	@Test
	void frame_test() {
		players1.add(p1);
		players1.add(p2);
		players1.add(p3);
		players1.add(p4);
		players1.add(p5);
		players1.add(p6);
		players1.add(p7);
		players1.add(p8);
		players1.add(p9);
		players1.add(p10);
		players1.add(p11);
		players1.add(p12);
		players1.add(p13);
		players1.add(p14);
		players1.add(p15);
		players1.add(p16);
		players1.add(p17);
		players1.add(p18);
		players1.add(p19);
		players1.add(p20);
		players1.add(p21);
		players2.add(p1);
		players2.add(p2);
		players2.add(p3);
		players2.add(p4);
		players2.add(p5);
		players2.add(p6);
		players2.add(p7);
		players2.add(p8);
		players2.add(p9);
		players2.add(p10);
		players2.add(p11);
		players2.add(p12);
		players2.add(p13);
		players2.add(p14);
		players2.add(p15);
		players2.add(p16);
		players2.add(p17);
		players2.add(p18);
		players2.add(p19);
		players2.add(p20);
		players2.add(p21);
		TeamImpl t1 = new TeamImpl("Team1", players1);
		TeamImpl t2 = new TeamImpl("Team2", players2);
		ac.start(t,sb,t1,t2);
		assertEquals("Quidditch Scorekeeper", ac.frame.getTitle());     //test frame title
		assertEquals(800, ac.frame.getHeight());     //test frame height
		assertEquals(1440, ac.frame.getWidth());     //test frame width
		Color frame_background;
		frame_background = new Color(153, 153, 153);
		assertEquals(frame_background, ac.frame.getContentPane().getBackground());     //test frame background color

	}

	@Test
    void show_hide_tests() {
		players1.add(p1);
		players1.add(p2);
		players1.add(p3);
		players1.add(p4);
		players1.add(p5);
		players1.add(p6);
		players1.add(p7);
		players1.add(p8);
		players1.add(p9);
		players1.add(p10);
		players1.add(p11);
		players1.add(p12);
		players1.add(p13);
		players1.add(p14);
		players1.add(p15);
		players1.add(p16);
		players1.add(p17);
		players1.add(p18);
		players1.add(p19);
		players1.add(p20);
		players1.add(p21);
		players2.add(p1);
		players2.add(p2);
		players2.add(p3);
		players2.add(p4);
		players2.add(p5);
		players2.add(p6);
		players2.add(p7);
		players2.add(p8);
		players2.add(p9);
		players2.add(p10);
		players2.add(p11);
		players2.add(p12);
		players2.add(p13);
		players2.add(p14);
		players2.add(p15);
		players2.add(p16);
		players2.add(p17);
		players2.add(p18);
		players2.add(p19);
		players2.add(p20);
		players2.add(p21);
		TeamImpl t1 = new TeamImpl("Team1", players1);
		TeamImpl t2 = new TeamImpl("Team2", players2);
	    ac.start(t,sb,t1,t2);
	    assert(ac.frame.isVisible());
	    ac.hide();
	    assert(!ac.frame.isVisible());
	    ac.show();
	    assert(ac.frame.isVisible());
    }
	
    @Test
	void timer_test() {
    	players1.add(p1);
    	players1.add(p2);
    	players1.add(p3);
    	players1.add(p4);
    	players1.add(p5);
    	players1.add(p6);
    	players1.add(p7);
    	players1.add(p8);
    	players1.add(p9);
    	players1.add(p10);
    	players1.add(p11);
    	players1.add(p12);
    	players1.add(p13);
    	players1.add(p14);
    	players1.add(p15);
    	players1.add(p16);
    	players1.add(p17);
    	players1.add(p18);
    	players1.add(p19);
    	players1.add(p20);
    	players1.add(p21);
    	players2.add(p1);
    	players2.add(p2);
    	players2.add(p3);
    	players2.add(p4);
    	players2.add(p5);
    	players2.add(p6);
    	players2.add(p7);
    	players2.add(p8);
    	players2.add(p9);
    	players2.add(p10);
    	players2.add(p11);
    	players2.add(p12);
    	players2.add(p13);
    	players2.add(p14);
    	players2.add(p15);
    	players2.add(p16);
    	players2.add(p17);
    	players2.add(p18);
    	players2.add(p19);
    	players2.add(p20);
    	players2.add(p21);
    	TeamImpl t1 = new TeamImpl("Team1", players1);
    	TeamImpl t2 = new TeamImpl("Team2", players2);
		ac.start(t,sb,t1,t2);
		assertEquals(425, ac.timer.getX());     //timerbox position test
		assertEquals(25, ac.timer.getY());     //timerbox position test
		assertEquals(600, ac.timer.getWidth());     //test timerbox width
		assertEquals(150, ac.timer.getHeight());     //test timerbox height
        Color timer_background;
        timer_background = new Color(243, 243, 243);
        assertEquals(timer_background, ac.timer.getBackground());     //test timerbox background color

	}

	@Test
    void scorebox1_test() {
		players1.add(p1);
		players1.add(p2);
		players1.add(p3);
		players1.add(p4);
		players1.add(p5);
		players1.add(p6);
		players1.add(p7);
		players1.add(p8);
		players1.add(p9);
		players1.add(p10);
		players1.add(p11);
		players1.add(p12);
		players1.add(p13);
		players1.add(p14);
		players1.add(p15);
		players1.add(p16);
		players1.add(p17);
		players1.add(p18);
		players1.add(p19);
		players1.add(p20);
		players1.add(p21);
		players2.add(p1);
		players2.add(p2);
		players2.add(p3);
		players2.add(p4);
		players2.add(p5);
		players2.add(p6);
		players2.add(p7);
		players2.add(p8);
		players2.add(p9);
		players2.add(p10);
		players2.add(p11);
		players2.add(p12);
		players2.add(p13);
		players2.add(p14);
		players2.add(p15);
		players2.add(p16);
		players2.add(p17);
		players2.add(p18);
		players2.add(p19);
		players2.add(p20);
		players2.add(p21);
		TeamImpl t1 = new TeamImpl("Team1", players1);
		TeamImpl t2 = new TeamImpl("Team2", players2);
	    ac.start(t,sb,t1,t2);
	    assertEquals(25, ac.scorebox1.getX());     //test scoreboard1 position
	    assertEquals(25, ac.scorebox1.getY());     //test scoreboard1 position
	    assertEquals(150, ac.scorebox1.getWidth());     //test scoreboard1 width
	    assertEquals(150, ac.scorebox1.getHeight());      //test scoreboard1 height
        Color scorebox1_background = new Color(243,243,243);
        assertEquals(scorebox1_background, ac.scorebox1.getBackground());     //test scoreboard1 background color

    }

    @Test
    void scorebox2_test() {
    	players1.add(p1);
    	players1.add(p2);
    	players1.add(p3);
    	players1.add(p4);
    	players1.add(p5);
    	players1.add(p6);
    	players1.add(p7);
    	players1.add(p8);
    	players1.add(p9);
    	players1.add(p10);
    	players1.add(p11);
    	players1.add(p12);
    	players1.add(p13);
    	players1.add(p14);
    	players1.add(p15);
    	players1.add(p16);
    	players1.add(p17);
    	players1.add(p18);
    	players1.add(p19);
    	players1.add(p20);
    	players1.add(p21);
    	players2.add(p1);
    	players2.add(p2);
    	players2.add(p3);
    	players2.add(p4);
    	players2.add(p5);
    	players2.add(p6);
    	players2.add(p7);
    	players2.add(p8);
    	players2.add(p9);
    	players2.add(p10);
    	players2.add(p11);
    	players2.add(p12);
    	players2.add(p13);
    	players2.add(p14);
    	players2.add(p15);
    	players2.add(p16);
    	players2.add(p17);
    	players2.add(p18);
    	players2.add(p19);
    	players2.add(p20);
    	players2.add(p21);
    	TeamImpl t1 = new TeamImpl("Team1", players1);
    	TeamImpl t2 = new TeamImpl("Team2", players2);
        ac.start(t,sb,t1,t2);
        assertEquals(1050, ac.scorebox2.getX());     //test scoreboard2 position
        assertEquals(25, ac.scorebox2.getY());     //test scoreboard2 position
        assertEquals(150, ac.scorebox2.getWidth());     //test scoreboard2 width
        assertEquals(150, ac.scorebox2.getHeight());      //test scoreboard2 height
        Color scorebox2_background = new Color(243,243,243);
        assertEquals(scorebox2_background, ac.scorebox1.getBackground());     //test scoreboard2 background color

    }
    
    @Test
    void teamName1_test() {
    	players1.add(p1);
    	players1.add(p2);
    	players1.add(p3);
    	players1.add(p4);
    	players1.add(p5);
    	players1.add(p6);
    	players1.add(p7);
    	players1.add(p8);
    	players1.add(p9);
    	players1.add(p10);
    	players1.add(p11);
    	players1.add(p12);
    	players1.add(p13);
    	players1.add(p14);
    	players1.add(p15);
    	players1.add(p16);
    	players1.add(p17);
    	players1.add(p18);
    	players1.add(p19);
    	players1.add(p20);
    	players1.add(p21);
    	players2.add(p1);
    	players2.add(p2);
    	players2.add(p3);
    	players2.add(p4);
    	players2.add(p5);
    	players2.add(p6);
    	players2.add(p7);
    	players2.add(p8);
    	players2.add(p9);
    	players2.add(p10);
    	players2.add(p11);
    	players2.add(p12);
    	players2.add(p13);
    	players2.add(p14);
    	players2.add(p15);
    	players2.add(p16);
    	players2.add(p17);
    	players2.add(p18);
    	players2.add(p19);
    	players2.add(p20);
    	players2.add(p21);
    	TeamImpl t1 = new TeamImpl("Team1", players1);
    	TeamImpl t2 = new TeamImpl("Team2", players2);
	    ac.start(t,sb,t1,t2);
	    assertEquals(25, ac.teamName1.getX());     //test scoreboard1 position
	    assertEquals(275, ac.teamName1.getY());     //test scoreboard1 position
	    assertEquals(575, ac.teamName1.getWidth());     //test scoreboard1 width
	    assertEquals(50, ac.teamName1.getHeight());      //test scoreboard1 height
        Color scorebox1_background = new Color(243,243,243);
        assertEquals(scorebox1_background, ac.scorebox1.getBackground());     //test scoreboard1 background color

    }

    @Test
    void teamName2_test() {
    	players1.add(p1);
    	players1.add(p2);
    	players1.add(p3);
    	players1.add(p4);
    	players1.add(p5);
    	players1.add(p6);
    	players1.add(p7);
    	players1.add(p8);
    	players1.add(p9);
    	players1.add(p10);
    	players1.add(p11);
    	players1.add(p12);
    	players1.add(p13);
    	players1.add(p14);
    	players1.add(p15);
    	players1.add(p16);
    	players1.add(p17);
    	players1.add(p18);
    	players1.add(p19);
    	players1.add(p20);
    	players1.add(p21);
    	players2.add(p1);
    	players2.add(p2);
    	players2.add(p3);
    	players2.add(p4);
    	players2.add(p5);
    	players2.add(p6);
    	players2.add(p7);
    	players2.add(p8);
    	players2.add(p9);
    	players2.add(p10);
    	players2.add(p11);
    	players2.add(p12);
    	players2.add(p13);
    	players2.add(p14);
    	players2.add(p15);
    	players2.add(p16);
    	players2.add(p17);
    	players2.add(p18);
    	players2.add(p19);
    	players2.add(p20);
    	players2.add(p21);
    	TeamImpl t1 = new TeamImpl("Team1", players1);
    	TeamImpl t2 = new TeamImpl("Team2", players2);
        ac.start(t,sb,t1,t2);
        assertEquals(750, ac.teamName2.getX());     //test scoreboard2 position
        assertEquals(275, ac.teamName2.getY());     //test scoreboard2 position
        assertEquals(575, ac.teamName2.getWidth());     //test scoreboard2 width
        assertEquals(50, ac.teamName2.getHeight());      //test scoreboard2 height
        Color scorebox2_background = new Color(243,243,243);
        assertEquals(scorebox2_background, ac.scorebox1.getBackground());     //test scoreboard2 background color

    }

    @Test
    void starttime_test() {
    	players1.add(p1);
    	players1.add(p2);
    	players1.add(p3);
    	players1.add(p4);
    	players1.add(p5);
    	players1.add(p6);
    	players1.add(p7);
    	players1.add(p8);
    	players1.add(p9);
    	players1.add(p10);
    	players1.add(p11);
    	players1.add(p12);
    	players1.add(p13);
    	players1.add(p14);
    	players1.add(p15);
    	players1.add(p16);
    	players1.add(p17);
    	players1.add(p18);
    	players1.add(p19);
    	players1.add(p20);
    	players1.add(p21);
    	players2.add(p1);
    	players2.add(p2);
    	players2.add(p3);
    	players2.add(p4);
    	players2.add(p5);
    	players2.add(p6);
    	players2.add(p7);
    	players2.add(p8);
    	players2.add(p9);
    	players2.add(p10);
    	players2.add(p11);
    	players2.add(p12);
    	players2.add(p13);
    	players2.add(p14);
    	players2.add(p15);
    	players2.add(p16);
    	players2.add(p17);
    	players2.add(p18);
    	players2.add(p19);
    	players2.add(p20);
    	players2.add(p21);
    	TeamImpl t1 = new TeamImpl("Team1", players1);
    	TeamImpl t2 = new TeamImpl("Team2", players2);
	    ac.start(t,sb,t1,t2);
	    assertEquals(425, ac.startTime.getX());     //test starttime position
	    assertEquals(190, ac.startTime.getY());     //test starttime position
	    assertEquals(80, ac.startTime.getWidth());     //test starttime width
	    assertEquals(70, ac.startTime.getHeight());     //test starttime height
        Color starttime_background = new Color(217,234,211);
        assertEquals(starttime_background, ac.startTime.getBackground());     //test starttime background color

    }

    @Test
    void stopReset_test() {
    	players1.add(p1);
    	players1.add(p2);
    	players1.add(p3);
    	players1.add(p4);
    	players1.add(p5);
    	players1.add(p6);
    	players1.add(p7);
    	players1.add(p8);
    	players1.add(p9);
    	players1.add(p10);
    	players1.add(p11);
    	players1.add(p12);
    	players1.add(p13);
    	players1.add(p14);
    	players1.add(p15);
    	players1.add(p16);
    	players1.add(p17);
    	players1.add(p18);
    	players1.add(p19);
    	players1.add(p20);
    	players1.add(p21);
    	players2.add(p1);
    	players2.add(p2);
    	players2.add(p3);
    	players2.add(p4);
    	players2.add(p5);
    	players2.add(p6);
    	players2.add(p7);
    	players2.add(p8);
    	players2.add(p9);
    	players2.add(p10);
    	players2.add(p11);
    	players2.add(p12);
    	players2.add(p13);
    	players2.add(p14);
    	players2.add(p15);
    	players2.add(p16);
    	players2.add(p17);
    	players2.add(p18);
    	players2.add(p19);
    	players2.add(p20);
    	players2.add(p21);
    	TeamImpl t1 = new TeamImpl("Team1", players1);
    	TeamImpl t2 = new TeamImpl("Team2", players2);
	    ac.start(t,sb,t1,t2);
	    assertEquals(510, ac.stopReset.getX());     //test stopReset position
	    assertEquals(190, ac.stopReset.getY());     //test stopReset position
	    assertEquals(80, ac.stopReset.getWidth());     //test stopReset width
	    assertEquals(70, ac.stopReset.getHeight());     //test stopReset height
        Color stopReset_background = new Color(244,204,204);
	    assertEquals(stopReset_background, ac.stopReset.getBackground());     //test stopReset background color

    }

    @Test
    void inputTime_test() {
    	players1.add(p1);
    	players1.add(p2);
    	players1.add(p3);
    	players1.add(p4);
    	players1.add(p5);
    	players1.add(p6);
    	players1.add(p7);
    	players1.add(p8);
    	players1.add(p9);
    	players1.add(p10);
    	players1.add(p11);
    	players1.add(p12);
    	players1.add(p13);
    	players1.add(p14);
    	players1.add(p15);
    	players1.add(p16);
    	players1.add(p17);
    	players1.add(p18);
    	players1.add(p19);
    	players1.add(p20);
    	players1.add(p21);
    	players2.add(p1);
    	players2.add(p2);
    	players2.add(p3);
    	players2.add(p4);
    	players2.add(p5);
    	players2.add(p6);
    	players2.add(p7);
    	players2.add(p8);
    	players2.add(p9);
    	players2.add(p10);
    	players2.add(p11);
    	players2.add(p12);
    	players2.add(p13);
    	players2.add(p14);
    	players2.add(p15);
    	players2.add(p16);
    	players2.add(p17);
    	players2.add(p18);
    	players2.add(p19);
    	players2.add(p20);
    	players2.add(p21);
    	TeamImpl t1 = new TeamImpl("Team1", players1);
    	TeamImpl t2 = new TeamImpl("Team2", players2);
	    ac.start(t,sb,t1,t2);
	    assertEquals(600, ac.inputTime.getX());     //test inputTime position
	    assertEquals(190, ac.inputTime.getY());     //test inputTime position
        assertEquals(210, ac.inputTime.getWidth());     //test inputTime width
        assertEquals(70, ac.inputTime.getHeight());     //test inputTime width
        Color inputTime_background = new Color(243,243,243);
        assertEquals(inputTime_background, ac.inputTime.getBackground());     //test inputTime background color

    }

    @Test
    void setTime_test() {
    	players1.add(p1);
    	players1.add(p2);
    	players1.add(p3);
    	players1.add(p4);
    	players1.add(p5);
    	players1.add(p6);
    	players1.add(p7);
    	players1.add(p8);
    	players1.add(p9);
    	players1.add(p10);
    	players1.add(p11);
    	players1.add(p12);
    	players1.add(p13);
    	players1.add(p14);
    	players1.add(p15);
    	players1.add(p16);
    	players1.add(p17);
    	players1.add(p18);
    	players1.add(p19);
    	players1.add(p20);
    	players1.add(p21);
    	players2.add(p1);
    	players2.add(p2);
    	players2.add(p3);
    	players2.add(p4);
    	players2.add(p5);
    	players2.add(p6);
    	players2.add(p7);
    	players2.add(p8);
    	players2.add(p9);
    	players2.add(p10);
    	players2.add(p11);
    	players2.add(p12);
    	players2.add(p13);
    	players2.add(p14);
    	players2.add(p15);
    	players2.add(p16);
    	players2.add(p17);
    	players2.add(p18);
    	players2.add(p19);
    	players2.add(p20);
    	players2.add(p21);
    	TeamImpl t1 = new TeamImpl("Team1", players1);
    	TeamImpl t2 = new TeamImpl("Team2", players2);
	    ac.start(t,sb,t1,t2);
	    assertEquals(815, ac.setTime.getX());     //test setTime position
	    assertEquals(190, ac.setTime.getY());     //test setTime position
        assertEquals(210, ac.setTime.getWidth());     //test setTime width
        assertEquals(70, ac.setTime.getHeight());     //test setTime height
        Color setTime_background = new Color(201,218,248);
        assertEquals(setTime_background, ac.setTime.getBackground());     //test setTime background color

    }

    @Test
    void incrementScore1_test() {
    	players1.add(p1);
    	players1.add(p2);
    	players1.add(p3);
    	players1.add(p4);
    	players1.add(p5);
    	players1.add(p6);
    	players1.add(p7);
    	players1.add(p8);
    	players1.add(p9);
    	players1.add(p10);
    	players1.add(p11);
    	players1.add(p12);
    	players1.add(p13);
    	players1.add(p14);
    	players1.add(p15);
    	players1.add(p16);
    	players1.add(p17);
    	players1.add(p18);
    	players1.add(p19);
    	players1.add(p20);
    	players1.add(p21);
    	players2.add(p1);
    	players2.add(p2);
    	players2.add(p3);
    	players2.add(p4);
    	players2.add(p5);
    	players2.add(p6);
    	players2.add(p7);
    	players2.add(p8);
    	players2.add(p9);
    	players2.add(p10);
    	players2.add(p11);
    	players2.add(p12);
    	players2.add(p13);
    	players2.add(p14);
    	players2.add(p15);
    	players2.add(p16);
    	players2.add(p17);
    	players2.add(p18);
    	players2.add(p19);
    	players2.add(p20);
    	players2.add(p21);
    	TeamImpl t1 = new TeamImpl("Team1", players1);
    	TeamImpl t2 = new TeamImpl("Team2", players2);
	    ac.start(t,sb,t1,t2);
	    assertEquals(185, ac.incrementScore1.getX());     //test incrementScore1 position
        assertEquals(25, ac.incrementScore1.getY());     //test incrementScore1 position
        assertEquals(100, ac.incrementScore1.getWidth());     //test incrementScore1 width
        assertEquals(70, ac.incrementScore1.getHeight());     //test incrementScore1 height
        Color incrementScore1_background = new Color(217,234,211);
        assertEquals(incrementScore1_background, ac.incrementScore1.getBackground());     //test incrementScore1 background color

    }

    @Test
    void decrementScore1_test() {
    	players1.add(p1);
    	players1.add(p2);
    	players1.add(p3);
    	players1.add(p4);
    	players1.add(p5);
    	players1.add(p6);
    	players1.add(p7);
    	players1.add(p8);
    	players1.add(p9);
    	players1.add(p10);
    	players1.add(p11);
    	players1.add(p12);
    	players1.add(p13);
    	players1.add(p14);
    	players1.add(p15);
    	players1.add(p16);
    	players1.add(p17);
    	players1.add(p18);
    	players1.add(p19);
    	players1.add(p20);
    	players1.add(p21);
    	players2.add(p1);
    	players2.add(p2);
    	players2.add(p3);
    	players2.add(p4);
    	players2.add(p5);
    	players2.add(p6);
    	players2.add(p7);
    	players2.add(p8);
    	players2.add(p9);
    	players2.add(p10);
    	players2.add(p11);
    	players2.add(p12);
    	players2.add(p13);
    	players2.add(p14);
    	players2.add(p15);
    	players2.add(p16);
    	players2.add(p17);
    	players2.add(p18);
    	players2.add(p19);
    	players2.add(p20);
    	players2.add(p21);
    	TeamImpl t1 = new TeamImpl("Team1", players1);
    	TeamImpl t2 = new TeamImpl("Team2", players2);
	    ac.start(t,sb,t1,t2);
	    assertEquals(185, ac.decrementScore1.getX());     //test decrementScore1 position
	    assertEquals(105, ac.decrementScore1.getY());     //test decrementScore1 position
	    assertEquals(100, ac.decrementScore1.getWidth());     //test decrementScore1 width
	    assertEquals(70, ac.decrementScore1.getHeight());     //test decrementScore1 height
        Color decrementScore1_background = new Color(244,204,204);
        assertEquals(decrementScore1_background, ac.decrementScore1.getBackground());     //test decrementScore1 background color

    }

    @Test
    void inputScore1_test() {
    	players1.add(p1);
    	players1.add(p2);
    	players1.add(p3);
    	players1.add(p4);
    	players1.add(p5);
    	players1.add(p6);
    	players1.add(p7);
    	players1.add(p8);
    	players1.add(p9);
    	players1.add(p10);
    	players1.add(p11);
    	players1.add(p12);
    	players1.add(p13);
    	players1.add(p14);
    	players1.add(p15);
    	players1.add(p16);
    	players1.add(p17);
    	players1.add(p18);
    	players1.add(p19);
    	players1.add(p20);
    	players1.add(p21);
    	players2.add(p1);
    	players2.add(p2);
    	players2.add(p3);
    	players2.add(p4);
    	players2.add(p5);
    	players2.add(p6);
    	players2.add(p7);
    	players2.add(p8);
    	players2.add(p9);
    	players2.add(p10);
    	players2.add(p11);
    	players2.add(p12);
    	players2.add(p13);
    	players2.add(p14);
    	players2.add(p15);
    	players2.add(p16);
    	players2.add(p17);
    	players2.add(p18);
    	players2.add(p19);
    	players2.add(p20);
    	players2.add(p21);
    	TeamImpl t1 = new TeamImpl("Team1", players1);
    	TeamImpl t2 = new TeamImpl("Team2", players2);
	    ac.start(t,sb,t1,t2);
	    assertEquals(295, ac.inputScore1.getX());     //test inputScore1 position
	    assertEquals(25, ac.inputScore1.getY());     //test inputScore1 position
	    assertEquals(100, ac.inputScore1.getWidth());     //test inputScore1 width
	    assertEquals(70, ac.inputScore1.getHeight());     //test inputScore1 height
	    Color inputScore1_background = new Color(243,243,243);
	    assertEquals(inputScore1_background, ac.inputScore1.getBackground());     //test inputScore1 background color

    }

    @Test
    void setScore1() {
    	players1.add(p1);
    	players1.add(p2);
    	players1.add(p3);
    	players1.add(p4);
    	players1.add(p5);
    	players1.add(p6);
    	players1.add(p7);
    	players1.add(p8);
    	players1.add(p9);
    	players1.add(p10);
    	players1.add(p11);
    	players1.add(p12);
    	players1.add(p13);
    	players1.add(p14);
    	players1.add(p15);
    	players1.add(p16);
    	players1.add(p17);
    	players1.add(p18);
    	players1.add(p19);
    	players1.add(p20);
    	players1.add(p21);
    	players2.add(p1);
    	players2.add(p2);
    	players2.add(p3);
    	players2.add(p4);
    	players2.add(p5);
    	players2.add(p6);
    	players2.add(p7);
    	players2.add(p8);
    	players2.add(p9);
    	players2.add(p10);
    	players2.add(p11);
    	players2.add(p12);
    	players2.add(p13);
    	players2.add(p14);
    	players2.add(p15);
    	players2.add(p16);
    	players2.add(p17);
    	players2.add(p18);
    	players2.add(p19);
    	players2.add(p20);
    	players2.add(p21);
    	TeamImpl t1 = new TeamImpl("Team1", players1);
    	TeamImpl t2 = new TeamImpl("Team2", players2);
	    ac.start(t,sb,t1,t2);
	    assertEquals(295, ac.setScore1.getX());     //test setScore1 position
        assertEquals(105, ac.setScore1.getY());     //test setScore1 position
        assertEquals(105, ac.setScore1.getWidth());     //test setScore1 width
        assertEquals(70, ac.setScore1.getHeight());     //test setScore1 height
        Color setScore1_background = new Color(201,218,248);
        assertEquals(setScore1_background, ac.setScore1.getBackground());     //test setScore1 background color

    }

    @Test
    void incrementScore2_test() {
    	players1.add(p1);
    	players1.add(p2);
    	players1.add(p3);
    	players1.add(p4);
    	players1.add(p5);
    	players1.add(p6);
    	players1.add(p7);
    	players1.add(p8);
    	players1.add(p9);
    	players1.add(p10);
    	players1.add(p11);
    	players1.add(p12);
    	players1.add(p13);
    	players1.add(p14);
    	players1.add(p15);
    	players1.add(p16);
    	players1.add(p17);
    	players1.add(p18);
    	players1.add(p19);
    	players1.add(p20);
    	players1.add(p21);
    	players2.add(p1);
    	players2.add(p2);
    	players2.add(p3);
    	players2.add(p4);
    	players2.add(p5);
    	players2.add(p6);
    	players2.add(p7);
    	players2.add(p8);
    	players2.add(p9);
    	players2.add(p10);
    	players2.add(p11);
    	players2.add(p12);
    	players2.add(p13);
    	players2.add(p14);
    	players2.add(p15);
    	players2.add(p16);
    	players2.add(p17);
    	players2.add(p18);
    	players2.add(p19);
    	players2.add(p20);
    	players2.add(p21);
    	TeamImpl t1 = new TeamImpl("Team1", players1);
    	TeamImpl t2 = new TeamImpl("Team2", players2);
        ac.start(t,sb,t1,t2);
        assertEquals(1210, ac.incrementScore2.getX());     //test incrementScore2 position
        assertEquals(25, ac.incrementScore2.getY());     //test incrementScore2 position
        assertEquals(100, ac.incrementScore2.getWidth());     //test incrementScore2 width
        assertEquals(70, ac.incrementScore2.getHeight());     //test incrementScore2 height
        Color incrementScore1_background = new Color(217, 234, 211);
        assertEquals(incrementScore1_background, ac.incrementScore2.getBackground());     //test incrementScore2 background color

    }

    @Test
    void decrementScore2_test() {
    	players1.add(p1);
    	players1.add(p2);
    	players1.add(p3);
    	players1.add(p4);
    	players1.add(p5);
    	players1.add(p6);
    	players1.add(p7);
    	players1.add(p8);
    	players1.add(p9);
    	players1.add(p10);
    	players1.add(p11);
    	players1.add(p12);
    	players1.add(p13);
    	players1.add(p14);
    	players1.add(p15);
    	players1.add(p16);
    	players1.add(p17);
    	players1.add(p18);
    	players1.add(p19);
    	players1.add(p20);
    	players1.add(p21);
    	players2.add(p1);
    	players2.add(p2);
    	players2.add(p3);
    	players2.add(p4);
    	players2.add(p5);
    	players2.add(p6);
    	players2.add(p7);
    	players2.add(p8);
    	players2.add(p9);
    	players2.add(p10);
    	players2.add(p11);
    	players2.add(p12);
    	players2.add(p13);
    	players2.add(p14);
    	players2.add(p15);
    	players2.add(p16);
    	players2.add(p17);
    	players2.add(p18);
    	players2.add(p19);
    	players2.add(p20);
    	players2.add(p21);
    	TeamImpl t1 = new TeamImpl("Team1", players1);
    	TeamImpl t2 = new TeamImpl("Team2", players2);
	    ac.start(t,sb,t1,t2);
	    assertEquals(1210, ac.decrementScore2.getX());     //test decrementScore2 position
        assertEquals(105, ac.decrementScore2.getY());     //test decrementScore2 position
        assertEquals(100, ac.decrementScore2.getWidth());     //test decrementScore2 width
        assertEquals(70, ac.decrementScore2.getHeight());     //test decrementScore2 height
        Color decrementScore2_background = new Color(244,204,204);
        assertEquals(decrementScore2_background, ac.decrementScore2.getBackground());     //test decrementScore2 background color

    }

    @Test
    void inputScore2_test() {
    	players1.add(p1);
    	players1.add(p2);
    	players1.add(p3);
    	players1.add(p4);
    	players1.add(p5);
    	players1.add(p6);
    	players1.add(p7);
    	players1.add(p8);
    	players1.add(p9);
    	players1.add(p10);
    	players1.add(p11);
    	players1.add(p12);
    	players1.add(p13);
    	players1.add(p14);
    	players1.add(p15);
    	players1.add(p16);
    	players1.add(p17);
    	players1.add(p18);
    	players1.add(p19);
    	players1.add(p20);
    	players1.add(p21);
    	players2.add(p1);
    	players2.add(p2);
    	players2.add(p3);
    	players2.add(p4);
    	players2.add(p5);
    	players2.add(p6);
    	players2.add(p7);
    	players2.add(p8);
    	players2.add(p9);
    	players2.add(p10);
    	players2.add(p11);
    	players2.add(p12);
    	players2.add(p13);
    	players2.add(p14);
    	players2.add(p15);
    	players2.add(p16);
    	players2.add(p17);
    	players2.add(p18);
    	players2.add(p19);
    	players2.add(p20);
    	players2.add(p21);
    	TeamImpl t1 = new TeamImpl("Team1", players1);
    	TeamImpl t2 = new TeamImpl("Team2", players2);
        ac.start(t,sb,t1,t2);
        assertEquals(1320, ac.inputScore2.getX());     //test inputScore2 position
        assertEquals(25, ac.inputScore2.getY());     //test inputScore2 position
        assertEquals(100, ac.inputScore2.getWidth());     //test inputScore2 width
        assertEquals(70, ac.inputScore2.getHeight());     //test inputScore2 height
        Color inputScore1_background = new Color(243,243,243);
        assertEquals(inputScore1_background, ac.inputScore2.getBackground());     //test inputScore2 background color

    }

    @Test
    void setScore2_test() {
    	players1.add(p1);
    	players1.add(p2);
    	players1.add(p3);
    	players1.add(p4);
    	players1.add(p5);
    	players1.add(p6);
    	players1.add(p7);
    	players1.add(p8);
    	players1.add(p9);
    	players1.add(p10);
    	players1.add(p11);
    	players1.add(p12);
    	players1.add(p13);
    	players1.add(p14);
    	players1.add(p15);
    	players1.add(p16);
    	players1.add(p17);
    	players1.add(p18);
    	players1.add(p19);
    	players1.add(p20);
    	players1.add(p21);
    	players2.add(p1);
    	players2.add(p2);
    	players2.add(p3);
    	players2.add(p4);
    	players2.add(p5);
    	players2.add(p6);
    	players2.add(p7);
    	players2.add(p8);
    	players2.add(p9);
    	players2.add(p10);
    	players2.add(p11);
    	players2.add(p12);
    	players2.add(p13);
    	players2.add(p14);
    	players2.add(p15);
    	players2.add(p16);
    	players2.add(p17);
    	players2.add(p18);
    	players2.add(p19);
    	players2.add(p20);
    	players2.add(p21);
    	TeamImpl t1 = new TeamImpl("Team1", players1);
    	TeamImpl t2 = new TeamImpl("Team2", players2);
        ac.start(t,sb,t1,t2);
        assertEquals(1320, ac.setScore2.getX());     //test setScore2 position
        assertEquals(105, ac.setScore2.getY());     //test setScore2 position
        assertEquals(100, ac.setScore2.getWidth());     //test setScore2 width
        assertEquals(70, ac.setScore2.getHeight());     //test setScore2 height
        Color setScore1_background = new Color(201,218,248);
        assertEquals(setScore1_background, ac.setScore2.getBackground());     //test setScore2 background color

    }

    @Test
    void notifications_test() {
    	players1.add(p1);
    	players1.add(p2);
    	players1.add(p3);
    	players1.add(p4);
    	players1.add(p5);
    	players1.add(p6);
    	players1.add(p7);
    	players1.add(p8);
    	players1.add(p9);
    	players1.add(p10);
    	players1.add(p11);
    	players1.add(p12);
    	players1.add(p13);
    	players1.add(p14);
    	players1.add(p15);
    	players1.add(p16);
    	players1.add(p17);
    	players1.add(p18);
    	players1.add(p19);
    	players1.add(p20);
    	players1.add(p21);
    	players2.add(p1);
    	players2.add(p2);
    	players2.add(p3);
    	players2.add(p4);
    	players2.add(p5);
    	players2.add(p6);
    	players2.add(p7);
    	players2.add(p8);
    	players2.add(p9);
    	players2.add(p10);
    	players2.add(p11);
    	players2.add(p12);
    	players2.add(p13);
    	players2.add(p14);
    	players2.add(p15);
    	players2.add(p16);
    	players2.add(p17);
    	players2.add(p18);
    	players2.add(p19);
    	players2.add(p20);
    	players2.add(p21);
    	TeamImpl t1 = new TeamImpl("Team1", players1);
    	TeamImpl t2 = new TeamImpl("Team2", players2);
	    ac.start(t,sb,t1,t2);
	    assertEquals(25, ac.notifications.getX());     //test notifications position
	    assertEquals(720, ac.notifications.getY());     //test notifications position
	    assertEquals(1000, ac.notifications.getWidth());     //test notifications width
	    assertEquals(50, ac.notifications.getHeight());     //test notifications height
	    Color notification_background = new Color(243,243,243);
	    assertEquals(notification_background, ac.notifications.getBackground());     //test notifications background color

    }

    @Test
    void acknowledge_test() {
    	players1.add(p1);
    	players1.add(p2);
    	players1.add(p3);
    	players1.add(p4);
    	players1.add(p5);
    	players1.add(p6);
    	players1.add(p7);
    	players1.add(p8);
    	players1.add(p9);
    	players1.add(p10);
    	players1.add(p11);
    	players1.add(p12);
    	players1.add(p13);
    	players1.add(p14);
    	players1.add(p15);
    	players1.add(p16);
    	players1.add(p17);
    	players1.add(p18);
    	players1.add(p19);
    	players1.add(p20);
    	players1.add(p21);
    	players2.add(p1);
    	players2.add(p2);
    	players2.add(p3);
    	players2.add(p4);
    	players2.add(p5);
    	players2.add(p6);
    	players2.add(p7);
    	players2.add(p8);
    	players2.add(p9);
    	players2.add(p10);
    	players2.add(p11);
    	players2.add(p12);
    	players2.add(p13);
    	players2.add(p14);
    	players2.add(p15);
    	players2.add(p16);
    	players2.add(p17);
    	players2.add(p18);
    	players2.add(p19);
    	players2.add(p20);
    	players2.add(p21);
    	TeamImpl t1 = new TeamImpl("Team1", players1);
    	TeamImpl t2 = new TeamImpl("Team2", players2);
	    ac.start(t,sb,t1,t2);
	    assertEquals(1035, ac.acknowledge.getX());     //test acknowledge position
        assertEquals(720, ac.acknowledge.getY());     //test acknowledge position
        assertEquals(390, ac.acknowledge.getWidth());     //test acknowledge width
        assertEquals(50, ac.acknowledge.getHeight());     //test acknowledge height
        Color acknowledge_background = new Color(217,234,211);
        assertEquals(acknowledge_background, ac.acknowledge.getBackground());     //test acknowledge background color

    }
}
