package test;

import static org.junit.jupiter.api.Assertions.*;

import com.scorekeeper.model.graphics.Graphics;
import org.junit.jupiter.api.Test;

import com.scorekeeper.model.graphics.OutwardDisplay;
import com.scorekeeper.model.scoreboard.ScoreboardImpl;
import com.scorekeeper.model.timer.TimerImpl;

import javax.swing.*;
import java.awt.*;

class OutwardDisplayTest {
	TimerImpl t = new TimerImpl();
	ScoreboardImpl sb = new ScoreboardImpl();
	OutwardDisplay od = new OutwardDisplay();

	@Test
	void frame_test() {
		od.start(t,sb);
		assertEquals("Quidditch Scorekeeper", od.frame.getTitle());     //test frame title
		assertEquals(800, od.frame.getHeight());     //test frame height
		assertEquals(1440, od.frame.getWidth());     //test frame width
		Color frame_background;
		frame_background = new Color(153, 153, 153);
		assertEquals(frame_background, od.frame.getContentPane().getBackground());     //test frame background color

	}

	@Test
    void show_hide_tests() {
	    od.start(t,sb);
	    assert(od.frame.isVisible());
	    od.hide();
	    assert(!od.frame.isVisible());
	    od.show();
	    assert(od.frame.isVisible());
    }
	
    @Test
	void timer_test() {
		od.start(t,sb);
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
	    od.start(t,sb);
	    assertEquals(25, od.scorebox1.getX());     //test scoreboard1 position
	    assertEquals(200, od.scorebox1.getY());     //test scoreboard1 position
	    assertEquals(675, od.scorebox1.getWidth());     //test scoreboard1 width
	    assertEquals(450, od.scorebox1.getHeight());      //test scoreboard1 height
        Color scorebox1_background = new Color(243,243,243);
        assertEquals(scorebox1_background, od.scorebox1.getBackground());     //test scoreboard1 background color
    }
	
	@Test
    void scorebox2_test() {
	    od.start(t,sb);
	    assertEquals(750, od.scorebox2.getX());     //test scoreboard1 position
	    assertEquals(200, od.scorebox2.getY());     //test scoreboard1 position
	    assertEquals(675, od.scorebox2.getWidth());     //test scoreboard1 width
	    assertEquals(450, od.scorebox2.getHeight());      //test scoreboard1 height
        Color scorebox2_background = new Color(243,243,243);
        assertEquals(scorebox2_background, od.scorebox1.getBackground());     //test scoreboard1 background color
    }

    @Test
    void team1_test() {
        od.start(t,sb);
        assertEquals(25, od.team1.getX());     //test scoreboard2 position
        assertEquals(660, od.team1.getY());     //test scoreboard2 position
        assertEquals(675, od.team1.getWidth());     //test scoreboard2 width
        assertEquals(100, od.team1.getHeight());      //test scoreboard2 height
        Color team1_background = new Color(243,243,243);
        assertEquals(team1_background, od.scorebox1.getBackground());     //test scoreboard2 background color

    }
    
    @Test
    void team2_test() {
        od.start(t,sb);
        assertEquals(750, od.team2.getX());     //test scoreboard2 position
        assertEquals(660, od.team2.getY());     //test scoreboard2 position
        assertEquals(675, od.team2.getWidth());     //test scoreboard2 width
        assertEquals(100, od.team2.getHeight());      //test scoreboard2 height
        Color  team2_background = new Color(243,243,243);
        assertEquals(team2_background, od.scorebox1.getBackground());     //test scoreboard2 background color

    }
}
