package test.graphics;

import static org.junit.jupiter.api.Assertions.*;

import com.scorekeeper.model.graphics.Graphics;
import org.junit.jupiter.api.Test;

import com.scorekeeper.model.graphics.OutwardDisplay;
import com.scorekeeper.model.scoreboard.ScoreboardImpl;
import com.scorekeeper.model.team.TeamImpl;
import com.scorekeeper.model.timer.TimerImpl;

import javax.swing.*;
import java.awt.*;

class OutwardDisplayTest {
	TimerImpl t = new TimerImpl();
	ScoreboardImpl sb = new ScoreboardImpl();
	OutwardDisplay od = new OutwardDisplay();
	TeamImpl t1 = new TeamImpl("Team 1");
	TeamImpl t2 = new TeamImpl("Team 1");
	
	@Test
	void frame_test() {
		od.start(t,sb,t1,t2);
		assertEquals("Quidditch Scorekeeper", od.frame.getTitle());     //test frame title
		assertEquals(800, od.frame.getHeight());     //test frame height
		assertEquals(1440, od.frame.getWidth());     //test frame width
		Color frame_background;
		frame_background = new Color(153, 153, 153);
		assertEquals(frame_background, od.frame.getContentPane().getBackground());     //test frame background color

	}

	@Test
    void show_hide_tests() {
		od.start(t,sb,t1,t2);
		assert(od.frame.isVisible());
	    od.hide();
	    assert(!od.frame.isVisible());
	    od.show();
	    assert(od.frame.isVisible());
    }
	
    @Test
	void timer_test() {
    	od.start(t,sb,t1,t2);
    	assertEquals(425, od.timer.getX());     //timerbox position test
		assertEquals(25, od.timer.getY());     //timerbox position test
		assertEquals(600, od.timer.getWidth());     //test timerbox width
		assertEquals(150, od.timer.getHeight());     //test timerbox height
        Color timer_background;
        timer_background = new Color(243, 243, 243);
        assertEquals(timer_background, od.timer.getBackground());     //test timerbox background color

	}

	@Test
    void scorebox1_test() {
		od.start(t,sb,t1,t2);
		assertEquals(750, od.scorebox1.getX());     //test scoreboard1 position
	    assertEquals(200, od.scorebox1.getY());     //test scoreboard1 position
	    assertEquals(675, od.scorebox1.getWidth());     //test scoreboard1 width
	    assertEquals(450, od.scorebox1.getHeight());      //test scoreboard1 height
        Color scorebox1_background = new Color(243,243,243);
        assertEquals(scorebox1_background, od.scorebox1.getBackground());     //test scoreboard1 background color
    }
	
	@Test
    void scorebox2_test() {
		od.start(t,sb,t1,t2);
		assertEquals(25, od.scorebox2.getX());     //test scoreboard1 position
	    assertEquals(200, od.scorebox2.getY());     //test scoreboard1 position
	    assertEquals(675, od.scorebox2.getWidth());     //test scoreboard1 width
	    assertEquals(450, od.scorebox2.getHeight());      //test scoreboard1 height
        Color scorebox2_background = new Color(243,243,243);
        assertEquals(scorebox2_background, od.scorebox1.getBackground());     //test scoreboard1 background color
    }

    @Test
    void team1_test() {
    	od.start(t,sb,t1,t2);
    	assertEquals(750, od.teamName1.getX());     //test scoreboard2 position
        assertEquals(660, od.teamName1.getY());     //test scoreboard2 position
        assertEquals(675, od.teamName1.getWidth());     //test scoreboard2 width
        assertEquals(100, od.teamName1.getHeight());      //test scoreboard2 height
        Color teamName1_background = new Color(243,243,243);
        assertEquals(teamName1_background, od.scorebox1.getBackground());     //test scoreboard2 background color

    }
    
    @Test
    void teamName2_test() {
        od.start(t,sb,t1,t2);
        assertEquals(25, od.teamName2.getX());     //test scoreboard2 position
        assertEquals(660, od.teamName2.getY());     //test scoreboard2 position
        assertEquals(675, od.teamName2.getWidth());     //test scoreboard2 width
        assertEquals(100, od.teamName2.getHeight());      //test scoreboard2 height
        Color  teamName2_background = new Color(243,243,243);
        assertEquals(teamName2_background, od.scorebox1.getBackground());     //test scoreboard2 background color

    }
}
