package test;

import static org.junit.jupiter.api.Assertions.*;

import com.scorekeeper.model.graphics.Graphics;
import com.scorekeeper.model.scoreboard.ScoreboardImpl;
import com.scorekeeper.model.timer.TimerImpl;

import org.junit.jupiter.api.Test;

import com.scorekeeper.model.graphics.ControlDisplay;

import javax.swing.*;
import java.awt.*;

class GraphicsTest {
	TimerImpl t = new TimerImpl();
	ScoreboardImpl sb = new ScoreboardImpl();
	ControlDisplay cd = new ControlDisplay();
	
	@Test
	void frame_test() {
		cd.start(t,sb);
		assertEquals("Quidditch Scorekeeper", cd.frame.getTitle());     //test frame title
		assertEquals(800, cd.frame.getHeight());     //test frame height
		assertEquals(1440, cd.frame.getWidth());     //test frame width
		Color frame_background;
		frame_background = new Color(153, 153, 153);
		assertEquals(frame_background, cd.frame.getContentPane().getBackground());     //test frame background color

	}

	@Test
    void show_hide_tests() {
	    cd.start(t,sb);
	    assert(cd.frame.isVisible());
	    cd.hide();
	    assert(!cd.frame.isVisible());
	    cd.show();
	    assert(cd.frame.isVisible());
    }
	
    @Test
	void timer_test() {
		cd.start(t,sb);
		assertEquals(425, cd.timer.getX());     //timerbox position test
		assertEquals(25, cd.timer.getY());     //timerbox position test
		assertEquals(600, cd.timer.getWidth());     //test timerbox width
		assertEquals(150, cd.timer.getHeight());     //test timerbox height
        Color timer_background;
        timer_background = new Color(243, 243, 243);
        assertEquals(timer_background, cd.timer.getBackground());     //test timerbox background color

	}

	@Test
    void scorebox1_test() {
	    cd.start(t,sb);
	    assertEquals(25, cd.scorebox1.getX());     //test scoreboard1 position
	    assertEquals(200, cd.scorebox1.getY());     //test scoreboard1 position
	    assertEquals(675, cd.scorebox1.getWidth());     //test scoreboard1 width
	    assertEquals(400, cd.scorebox1.getHeight());      //test scoreboard1 height
        Color scorebox1_background = new Color(243,243,243);
        assertEquals(scorebox1_background, cd.scorebox1.getBackground());     //test scoreboard1 background color

    }

    @Test
    void scorebox2_test() {
        cd.start(t,sb);
        assertEquals(750, cd.scorebox2.getX());     //test scoreboard2 position
        assertEquals(200, cd.scorebox2.getY());     //test scoreboard2 position
        assertEquals(675, cd.scorebox2.getWidth());     //test scoreboard2 width
        assertEquals(400, cd.scorebox2.getHeight());      //test scoreboard2 height
        Color scorebox2_background = new Color(243,243,243);
        assertEquals(scorebox2_background, cd.scorebox1.getBackground());     //test scoreboard2 background color

    }

    @Test
    void starttime_test() {
	    cd.start(t,sb);
	    assertEquals(25, cd.startTime.getX());     //test starttime position
	    assertEquals(25, cd.startTime.getY());     //test starttime position
	    assertEquals(150, cd.startTime.getWidth());     //test starttime width
	    assertEquals(150, cd.startTime.getHeight());     //test starttime height
        Color starttime_background = new Color(217,234,211);
        assertEquals(starttime_background, cd.startTime.getBackground());     //test starttime background color

    }

    @Test
    void stopReset_test() {
	    cd.start(t,sb);
	    assertEquals(185, cd.stopReset.getX());     //test stopReset position
	    assertEquals(25, cd.stopReset.getY());     //test stopReset position
	    assertEquals(150, cd.stopReset.getWidth());     //test stopReset width
	    assertEquals(150, cd.stopReset.getHeight());     //test stopReset height
        Color stopReset_background = new Color(244,204,204);
	    assertEquals(stopReset_background, cd.stopReset.getBackground());     //test stopReset background color

    }

    @Test
    void inputTime_test() {
	    cd.start(t,sb);
	    assertEquals(1100, cd.inputTime.getX());     //test inputTime position
	    assertEquals(25, cd.inputTime.getY());     //test inputTime position
        assertEquals(325, cd.inputTime.getWidth());     //test inputTime width
        assertEquals(70, cd.inputTime.getHeight());     //test inputTime width
        Color inputTime_background = new Color(243,243,243);
        assertEquals(inputTime_background, cd.inputTime.getBackground());     //test inputTime background color

    }

    @Test
    void setTime_test() {
	    cd.start(t,sb);
	    assertEquals(1100, cd.setTime.getX());     //test setTime position
	    assertEquals(105, cd.setTime.getY());     //test setTime position
        assertEquals(325, cd.setTime.getWidth());     //test setTime width
        assertEquals(70, cd.setTime.getHeight());     //test setTime height
        Color setTime_background = new Color(201,218,248);
        assertEquals(setTime_background, cd.setTime.getBackground());     //test setTime background color

    }

    @Test
    void incrementScore1_test() {
	    cd.start(t,sb);
	    assertEquals(25, cd.incrementScore1.getX());     //test incrementScore1 position
        assertEquals(610, cd.incrementScore1.getY());     //test incrementScore1 position
        assertEquals(100, cd.incrementScore1.getWidth());     //test incrementScore1 width
        assertEquals(100, cd.incrementScore1.getHeight());     //test incrementScore1 height
        Color incrementScore1_background = new Color(217,234,211);
        assertEquals(incrementScore1_background, cd.incrementScore1.getBackground());     //test incrementScore1 background color

    }

    @Test
    void decrementScore1_test() {
	    cd.start(t,sb);
	    assertEquals(130, cd.decrementScore1.getX());     //test decrementScore1 position
	    assertEquals(610, cd.decrementScore1.getY());     //test decrementScore1 position
	    assertEquals(100, cd.decrementScore1.getWidth());     //test decrementScore1 width
	    assertEquals(100, cd.decrementScore1.getHeight());     //test decrementScore1 height
        Color decrementScore1_background = new Color(244,204,204);
        assertEquals(decrementScore1_background, cd.decrementScore1.getBackground());     //test decrementScore1 background color

    }

    @Test
    void inputScore1_test() {
	    cd.start(t,sb);
	    assertEquals(240, cd.inputScore1.getX());     //test inputScore1 position
	    assertEquals(610, cd.inputScore1.getY());     //test inputScore1 position
	    assertEquals(210, cd.inputScore1.getWidth());     //test inputScore1 width
	    assertEquals(100, cd.inputScore1.getHeight());     //test inputScore1 height
	    Color inputScore1_background = new Color(243,243,243);
	    assertEquals(inputScore1_background, cd.inputScore1.getBackground());     //test inputScore1 background color

    }

    @Test
    void setScore1() {
	    cd.start(t,sb);
	    assertEquals(490, cd.setScore1.getX());     //test setScore1 position
        assertEquals(610, cd.setScore1.getY());     //test setScore1 position
        assertEquals(210, cd.setScore1.getWidth());     //test setScore1 width
        assertEquals(100, cd.setScore1.getHeight());     //test setScore1 height
        Color setScore1_background = new Color(201,218,248);
        assertEquals(setScore1_background, cd.setScore1.getBackground());     //test setScore1 background color

    }

    @Test
    void incrementScore2_test() {
        cd.start(t,sb);
        assertEquals(750, cd.incrementScore2.getX());     //test incrementScore2 position
        assertEquals(610, cd.incrementScore2.getY());     //test incrementScore2 position
        assertEquals(100, cd.incrementScore2.getWidth());     //test incrementScore2 width
        assertEquals(100, cd.incrementScore2.getHeight());     //test incrementScore2 height
        Color incrementScore1_background = new Color(217, 234, 211);
        assertEquals(incrementScore1_background, cd.incrementScore2.getBackground());     //test incrementScore2 background color

    }

    @Test
    void decrementScore2_test() {
	    cd.start(t,sb);
	    assertEquals(860, cd.decrementScore2.getX());     //test decrementScore2 position
        assertEquals(610, cd.decrementScore2.getY());     //test decrementScore2 position
        assertEquals(100, cd.decrementScore2.getWidth());     //test decrementScore2 width
        assertEquals(100, cd.decrementScore2.getHeight());     //test decrementScore2 height
        Color decrementScore2_background = new Color(244,204,204);
        assertEquals(decrementScore2_background, cd.decrementScore2.getBackground());     //test decrementScore2 background color

    }

    @Test
    void inputScore2_test() {
        cd.start(t,sb);
        assertEquals(970, cd.inputScore2.getX());     //test inputScore2 position
        assertEquals(610, cd.inputScore2.getY());     //test inputScore2 position
        assertEquals(210, cd.inputScore2.getWidth());     //test inputScore2 width
        assertEquals(100, cd.inputScore2.getHeight());     //test inputScore2 height
        Color inputScore1_background = new Color(243,243,243);
        assertEquals(inputScore1_background, cd.inputScore2.getBackground());     //test inputScore2 background color

    }

    @Test
    void setScore2_test() {
        cd.start(t,sb);
        assertEquals(1210, cd.setScore2.getX());     //test setScore2 position
        assertEquals(610, cd.setScore2.getY());     //test setScore2 position
        assertEquals(210, cd.setScore2.getWidth());     //test setScore2 width
        assertEquals(100, cd.setScore2.getHeight());     //test setScore2 height
        Color setScore1_background = new Color(201,218,248);
        assertEquals(setScore1_background, cd.setScore2.getBackground());     //test setScore2 background color

    }

    @Test
    void notifications_test() {
	    cd.start(t,sb);
	    assertEquals(25, cd.notifications.getX());     //test notifications position
	    assertEquals(720, cd.notifications.getY());     //test notifications position
	    assertEquals(1000, cd.notifications.getWidth());     //test notifications width
	    assertEquals(50, cd.notifications.getHeight());     //test notifications height
	    Color notification_background = new Color(243,243,243);
	    assertEquals(notification_background, cd.notifications.getBackground());     //test notifications background color

    }

    @Test
    void acknowledge_test() {
	    cd.start(t,sb);
	    assertEquals(1035, cd.acknowledge.getX());     //test acknowledge position
        assertEquals(720, cd.acknowledge.getY());     //test acknowledge position
        assertEquals(390, cd.acknowledge.getWidth());     //test acknowledge width
        assertEquals(50, cd.acknowledge.getHeight());     //test acknowledge height
        Color acknowledge_background = new Color(217,234,211);
        assertEquals(acknowledge_background, cd.acknowledge.getBackground());     //test acknowledge background color

    }
}
