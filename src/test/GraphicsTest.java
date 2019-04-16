package test;

import static org.junit.jupiter.api.Assertions.*;

import com.scorekeeper.model.graphics.Graphics;
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
		assertEquals(1440, GH.frame.getWidth());     //test frame width
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

    @Test
    void inputTime_test() {
	    GH.start();
	    assertEquals(1100, GH.inputTime.getX());     //test inputTime position
	    assertEquals(25, GH.inputTime.getY());     //test inputTime position
        assertEquals(325, GH.inputTime.getWidth());     //test inputTime width
        assertEquals(70, GH.inputTime.getHeight());     //test inputTime width
        Color inputTime_background = new Color(243,243,243);
        assertEquals(inputTime_background, GH.inputTime.getBackground());     //test inputTime background color

    }

    @Test
    void setTime_test() {
	    GH.start();
	    assertEquals(1100, GH.setTime.getX());     //test setTime position
	    assertEquals(105, GH.setTime.getY());     //test setTime position
        assertEquals(325, GH.setTime.getWidth());     //test setTime width
        assertEquals(70, GH.setTime.getHeight());     //test setTime height
        Color setTime_background = new Color(201,218,248);
        assertEquals(setTime_background, GH.setTime.getBackground());     //test setTime background color

    }

    @Test
    void incrementScore1_test() {
	    GH.start();
	    assertEquals(25, GH.incrementScore1.getX());     //test incrementScore1 position
        assertEquals(610, GH.incrementScore1.getY());     //test incrementScore1 position
        assertEquals(100, GH.incrementScore1.getWidth());     //test incrementScore1 width
        assertEquals(100, GH.incrementScore1.getHeight());     //test incrementScore1 height
        Color incrementScore1_background = new Color(217,234,211);
        assertEquals(incrementScore1_background, GH.incrementScore1.getBackground());     //test incrementScore1 background color

    }

    @Test
    void decrementScore1_test() {
	    GH.start();
	    assertEquals(130, GH.decrementScore1.getX());     //test decrementScore1 position
	    assertEquals(610, GH.decrementScore1.getY());     //test decrementScore1 position
	    assertEquals(100, GH.decrementScore1.getWidth());     //test decrementScore1 width
	    assertEquals(100, GH.decrementScore1.getHeight());     //test decrementScore1 height
        Color decrementScore1_background = new Color(244,204,204);
        assertEquals(decrementScore1_background, GH.decrementScore1.getBackground());     //test decrementScore1 background color

    }

    @Test
    void inputScore1_test() {
	    GH.start();
	    assertEquals(240, GH.inputScore1.getX());     //test inputScore1 position
	    assertEquals(610, GH.inputScore1.getY());     //test inputScore1 position
	    assertEquals(210, GH.inputScore1.getWidth());     //test inputScore1 width
	    assertEquals(100, GH.inputScore1.getHeight());     //test inputScore1 height
	    Color inputScore1_background = new Color(243,243,243);
	    assertEquals(inputScore1_background, GH.inputScore1.getBackground());     //test inputScore1 background color

    }

    @Test
    void setScore1() {
	    GH.start();
	    assertEquals(490, GH.setScore1.getX());     //test setScore1 position
        assertEquals(610, GH.setScore1.getY());     //test setScore1 position
        assertEquals(210, GH.setScore1.getWidth());     //test setScore1 width
        assertEquals(100, GH.setScore1.getHeight());     //test setScore1 height
        Color setScore1_background = new Color(201,218,248);
        assertEquals(setScore1_background, GH.setScore1.getBackground());     //test setScore1 background color

    }

    @Test
    void incrementScore2_test() {
        GH.start();
        assertEquals(750, GH.incrementScore2.getX());     //test incrementScore2 position
        assertEquals(610, GH.incrementScore2.getY());     //test incrementScore2 position
        assertEquals(100, GH.incrementScore2.getWidth());     //test incrementScore2 width
        assertEquals(100, GH.incrementScore2.getHeight());     //test incrementScore2 height
        Color incrementScore1_background = new Color(217, 234, 211);
        assertEquals(incrementScore1_background, GH.incrementScore2.getBackground());     //test incrementScore2 background color

    }

    @Test
    void decrementScore2_test() {
	    GH.start();
	    assertEquals(860, GH.decrementScore2.getX());     //test decrementScore2 position
        assertEquals(610, GH.decrementScore2.getY());     //test decrementScore2 position
        assertEquals(100, GH.decrementScore2.getWidth());     //test decrementScore2 width
        assertEquals(100, GH.decrementScore2.getHeight());     //test decrementScore2 height
        Color decrementScore2_background = new Color(244,204,204);
        assertEquals(decrementScore2_background, GH.decrementScore2.getBackground());     //test decrementScore2 background color

    }

    @Test
    void inputScore2_test() {
        GH.start();
        assertEquals(970, GH.inputScore2.getX());     //test inputScore2 position
        assertEquals(610, GH.inputScore2.getY());     //test inputScore2 position
        assertEquals(210, GH.inputScore2.getWidth());     //test inputScore2 width
        assertEquals(100, GH.inputScore2.getHeight());     //test inputScore2 height
        Color inputScore1_background = new Color(243,243,243);
        assertEquals(inputScore1_background, GH.inputScore2.getBackground());     //test inputScore2 background color

    }

    @Test
    void setScore2_test() {
        GH.start();
        assertEquals(1210, GH.setScore2.getX());     //test setScore2 position
        assertEquals(610, GH.setScore2.getY());     //test setScore2 position
        assertEquals(210, GH.setScore2.getWidth());     //test setScore2 width
        assertEquals(100, GH.setScore2.getHeight());     //test setScore2 height
        Color setScore1_background = new Color(201,218,248);
        assertEquals(setScore1_background, GH.setScore2.getBackground());     //test setScore2 background color

    }

    @Test
    void notifications_test() {
	    GH.start();
	    assertEquals(25, GH.notifications.getX());     //test notifications position
	    assertEquals(720, GH.notifications.getY());     //test notifications position
	    assertEquals(1000, GH.notifications.getWidth());     //test notifications width
	    assertEquals(50, GH.notifications.getHeight());     //test notifications height
	    Color notification_background = new Color(243,243,243);
	    assertEquals(notification_background, GH.notifications.getBackground());     //test notifications background color

    }

    @Test
    void acknowledge_test() {
	    GH.start();
	    assertEquals(1035, GH.acknowledge.getX());     //test acknowledge position
        assertEquals(720, GH.acknowledge.getY());     //test acknowledge position
        assertEquals(390, GH.acknowledge.getWidth());     //test acknowledge width
        assertEquals(50, GH.acknowledge.getHeight());     //test acknowledge height
        Color acknowledge_background = new Color(217,234,211);
        assertEquals(acknowledge_background, GH.acknowledge.getBackground());     //test acknowledge background color

    }
}
