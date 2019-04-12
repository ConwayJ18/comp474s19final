package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.scorekeeper.model.graphics.GraphicsImpl;

import javax.swing.*;
import java.awt.*;

class GraphicsTest {
	GraphicsImpl GH = new GraphicsImpl();

	@Test
	void frame_test() {
		GH.start();
		assertEquals("Quidditch Scorekeeper", GH.frame.getTitle());     //test frame title
		assertEquals(800, GH.frame.getHeight());     //test frame height
		assertEquals(1450, GH.frame.getWidth());     //test frame width
		Color frame_background;
		frame_background = new Color(153, 153, 153);
		assertEquals(frame_background, GH.frame.getContentPane().getBackground());     //test frame background color

	}

    @Test
	void timer_test() {
		GH.start();
		assertEquals(425, GH.timer.getX());     //timerbox position test
		assertEquals(25, GH.timer.getY());     //timerbox position test
		assertEquals(600, GH.timer.getWidth());     //test timerbox width
		assertEquals(150, GH.timer.getHeight());     //test timerbox height
        Color timer_background;
        timer_background = new Color(243, 243, 243);
        assertEquals(timer_background, GH.timer.getBackground());     //test timerbox background color

	}

	@Test
    void scorebox1_test() {
	    GH.start();
	    assertEquals(25, GH.scorebox1.getX());     //test scoreboard1 position
	    assertEquals(200, GH.scorebox1.getY());     //test scoreboard1 position
	    assertEquals(675, GH.scorebox1.getWidth());     //test scoreboard1 width
	    assertEquals(400, GH.scorebox1.getHeight());      //test scoreboard1 height
        Color scorebox1_background = new Color(243,243,243);
        assertEquals(scorebox1_background, GH.scorebox1.getBackground());     //test scoreboard1 background color

    }

    @Test
    void scorebox2_test() {
        GH.start();
        assertEquals(750, GH.scorebox2.getX());     //test scoreboard2 position
        assertEquals(200, GH.scorebox2.getY());     //test scoreboard2 position
        assertEquals(675, GH.scorebox2.getWidth());     //test scoreboard2 width
        assertEquals(400, GH.scorebox2.getHeight());      //test scoreboard2 height
        Color scorebox2_background = new Color(243,243,243);
        assertEquals(scorebox2_background, GH.scorebox1.getBackground());     //test scoreboard2 background color

    }

    @Test
    void starttime_test() {
	    GH.start();
	    assertEquals(25, GH.startTime.getX());     //test starttime position
	    assertEquals(25, GH.startTime.getY());     //test starttime position
	    assertEquals(150, GH.startTime.getWidth());     //test starttime width
	    assertEquals(150, GH.startTime.getHeight());     //test starttime height
        Color starttime_background = new Color(217,234,211);
        assertEquals(starttime_background, GH.startTime.getBackground());     //test starttime background color

    }

    @Test
    void stopReset_test() {
	    GH.start();
	    assertEquals(185, GH.stopReset.getX());     //test stopReset position
	    assertEquals(25, GH.stopReset.getY());     //test stopReset position
	    assertEquals(150, GH.stopReset.getWidth());     //test stopReset width
	    assertEquals(150, GH.stopReset.getHeight());     //test stopReset height
        Color stopReset_background = new Color(244,204,204);
	    assertEquals(stopReset_background, GH.stopReset.getBackground());     //test stopReset background color

    }
}
