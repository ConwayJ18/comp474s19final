package test;

import static org.junit.jupiter.api.Assertions.*;

import com.scorekeeper.model.scoreboard.ScoreboardImpl;
import com.scorekeeper.model.team.TeamImpl;
import com.scorekeeper.model.timer.TimerImpl;

import org.junit.jupiter.api.Test;

import com.scorekeeper.model.graphics.BasicControls;

import java.awt.*;

class GraphicsTest {
	TimerImpl t = new TimerImpl();
	ScoreboardImpl sb = new ScoreboardImpl();
	BasicControls bc = new BasicControls();
	TeamImpl t1 = new TeamImpl();
	TeamImpl t2 = new TeamImpl();
	 
	@Test
	void frame_test() {
		bc.start(t,sb,t1,t2);
		assertEquals("Quidditch Scorekeeper", bc.frame.getTitle());     //test frame title
		assertEquals(800, bc.frame.getHeight());     //test frame height
		assertEquals(1440, bc.frame.getWidth());     //test frame width
		Color frame_background;
		frame_background = new Color(153, 153, 153);
		assertEquals(frame_background, bc.frame.getContentPane().getBackground());     //test frame background color

	}

	@Test
    void show_hide_tests() {
	    bc.start(t,sb,t1,t2);
	    assert(bc.frame.isVisible());
	    bc.hide();
	    assert(!bc.frame.isVisible());
	    bc.show();
	    assert(bc.frame.isVisible());
    }
	
    @Test
	void timer_test() {
		bc.start(t,sb,t1,t2);
		assertEquals(425, bc.timer.getX());     //timerbox position test
		assertEquals(25, bc.timer.getY());     //timerbox position test
		assertEquals(600, bc.timer.getWidth());     //test timerbox width
		assertEquals(150, bc.timer.getHeight());     //test timerbox height
        Color timer_background;
        timer_background = new Color(243, 243, 243);
        assertEquals(timer_background, bc.timer.getBackground());     //test timerbox background color

	}

	@Test
    void scorebox1_test() {
	    bc.start(t,sb,t1,t2);
	    assertEquals(25, bc.scorebox1.getX());     //test scoreboard1 position
	    assertEquals(200, bc.scorebox1.getY());     //test scoreboard1 position
	    assertEquals(675, bc.scorebox1.getWidth());     //test scoreboard1 width
	    assertEquals(350, bc.scorebox1.getHeight());      //test scoreboard1 height
        Color scorebox1_background = new Color(243,243,243);
        assertEquals(scorebox1_background, bc.scorebox1.getBackground());     //test scoreboard1 background color

    }

    @Test
    void scorebox2_test() {
        bc.start(t,sb,t1,t2);
        assertEquals(750, bc.scorebox2.getX());     //test scoreboard2 position
        assertEquals(200, bc.scorebox2.getY());     //test scoreboard2 position
        assertEquals(675, bc.scorebox2.getWidth());     //test scoreboard2 width
        assertEquals(350, bc.scorebox2.getHeight());      //test scoreboard2 height
        Color scorebox2_background = new Color(243,243,243);
        assertEquals(scorebox2_background, bc.scorebox1.getBackground());     //test scoreboard2 background color

    }
    
    @Test
    void teamName1_test() {
	    bc.start(t,sb,t1,t2);
	    assertEquals(25, bc.teamName1.getX());     //test scoreboard1 position
	    assertEquals(550, bc.teamName1.getY());     //test scoreboard1 position
	    assertEquals(675, bc.teamName1.getWidth());     //test scoreboard1 width
	    assertEquals(50, bc.teamName1.getHeight());      //test scoreboard1 height
        Color scorebox1_background = new Color(243,243,243);
        assertEquals(scorebox1_background, bc.scorebox1.getBackground());     //test scoreboard1 background color

    }

    @Test
    void teamName2_test() {
        bc.start(t,sb,t1,t2);
        assertEquals(750, bc.teamName2.getX());     //test scoreboard2 position
        assertEquals(550, bc.teamName2.getY());     //test scoreboard2 position
        assertEquals(675, bc.teamName2.getWidth());     //test scoreboard2 width
        assertEquals(50, bc.teamName2.getHeight());      //test scoreboard2 height
        Color scorebox2_background = new Color(243,243,243);
        assertEquals(scorebox2_background, bc.scorebox1.getBackground());     //test scoreboard2 background color

    }

    @Test
    void starttime_test() {
	    bc.start(t,sb,t1,t2);
	    assertEquals(25, bc.startTime.getX());     //test starttime position
	    assertEquals(25, bc.startTime.getY());     //test starttime position
	    assertEquals(150, bc.startTime.getWidth());     //test starttime width
	    assertEquals(150, bc.startTime.getHeight());     //test starttime height
        Color starttime_background = new Color(217,234,211);
        assertEquals(starttime_background, bc.startTime.getBackground());     //test starttime background color

    }

    @Test
    void stopReset_test() {
	    bc.start(t,sb,t1,t2);
	    assertEquals(185, bc.stopReset.getX());     //test stopReset position
	    assertEquals(25, bc.stopReset.getY());     //test stopReset position
	    assertEquals(150, bc.stopReset.getWidth());     //test stopReset width
	    assertEquals(150, bc.stopReset.getHeight());     //test stopReset height
        Color stopReset_background = new Color(244,204,204);
	    assertEquals(stopReset_background, bc.stopReset.getBackground());     //test stopReset background color

    }

    @Test
    void inputTime_test() {
	    bc.start(t,sb,t1,t2);
	    assertEquals(1100, bc.inputTime.getX());     //test inputTime position
	    assertEquals(25, bc.inputTime.getY());     //test inputTime position
        assertEquals(325, bc.inputTime.getWidth());     //test inputTime width
        assertEquals(70, bc.inputTime.getHeight());     //test inputTime width
        Color inputTime_background = new Color(243,243,243);
        assertEquals(inputTime_background, bc.inputTime.getBackground());     //test inputTime background color

    }

    @Test
    void setTime_test() {
	    bc.start(t,sb,t1,t2);
	    assertEquals(1100, bc.setTime.getX());     //test setTime position
	    assertEquals(105, bc.setTime.getY());     //test setTime position
        assertEquals(325, bc.setTime.getWidth());     //test setTime width
        assertEquals(70, bc.setTime.getHeight());     //test setTime height
        Color setTime_background = new Color(201,218,248);
        assertEquals(setTime_background, bc.setTime.getBackground());     //test setTime background color

    }

    @Test
    void incrementScore1_test() {
	    bc.start(t,sb,t1,t2);
	    assertEquals(25, bc.incrementScore1.getX());     //test incrementScore1 position
        assertEquals(610, bc.incrementScore1.getY());     //test incrementScore1 position
        assertEquals(100, bc.incrementScore1.getWidth());     //test incrementScore1 width
        assertEquals(100, bc.incrementScore1.getHeight());     //test incrementScore1 height
        Color incrementScore1_background = new Color(217,234,211);
        assertEquals(incrementScore1_background, bc.incrementScore1.getBackground());     //test incrementScore1 background color

    }

    @Test
    void decrementScore1_test() {
	    bc.start(t,sb,t1,t2);
	    assertEquals(130, bc.decrementScore1.getX());     //test decrementScore1 position
	    assertEquals(610, bc.decrementScore1.getY());     //test decrementScore1 position
	    assertEquals(100, bc.decrementScore1.getWidth());     //test decrementScore1 width
	    assertEquals(100, bc.decrementScore1.getHeight());     //test decrementScore1 height
        Color decrementScore1_background = new Color(244,204,204);
        assertEquals(decrementScore1_background, bc.decrementScore1.getBackground());     //test decrementScore1 background color

    }

    @Test
    void inputScore1_test() {
	    bc.start(t,sb,t1,t2);
	    assertEquals(240, bc.inputScore1.getX());     //test inputScore1 position
	    assertEquals(610, bc.inputScore1.getY());     //test inputScore1 position
	    assertEquals(210, bc.inputScore1.getWidth());     //test inputScore1 width
	    assertEquals(100, bc.inputScore1.getHeight());     //test inputScore1 height
	    Color inputScore1_background = new Color(243,243,243);
	    assertEquals(inputScore1_background, bc.inputScore1.getBackground());     //test inputScore1 background color

    }

    @Test
    void setScore1() {
	    bc.start(t,sb,t1,t2);
	    assertEquals(490, bc.setScore1.getX());     //test setScore1 position
        assertEquals(610, bc.setScore1.getY());     //test setScore1 position
        assertEquals(210, bc.setScore1.getWidth());     //test setScore1 width
        assertEquals(100, bc.setScore1.getHeight());     //test setScore1 height
        Color setScore1_background = new Color(201,218,248);
        assertEquals(setScore1_background, bc.setScore1.getBackground());     //test setScore1 background color

    }

    @Test
    void incrementScore2_test() {
        bc.start(t,sb,t1,t2);
        assertEquals(750, bc.incrementScore2.getX());     //test incrementScore2 position
        assertEquals(610, bc.incrementScore2.getY());     //test incrementScore2 position
        assertEquals(100, bc.incrementScore2.getWidth());     //test incrementScore2 width
        assertEquals(100, bc.incrementScore2.getHeight());     //test incrementScore2 height
        Color incrementScore1_background = new Color(217, 234, 211);
        assertEquals(incrementScore1_background, bc.incrementScore2.getBackground());     //test incrementScore2 background color

    }

    @Test
    void decrementScore2_test() {
	    bc.start(t,sb,t1,t2);
	    assertEquals(860, bc.decrementScore2.getX());     //test decrementScore2 position
        assertEquals(610, bc.decrementScore2.getY());     //test decrementScore2 position
        assertEquals(100, bc.decrementScore2.getWidth());     //test decrementScore2 width
        assertEquals(100, bc.decrementScore2.getHeight());     //test decrementScore2 height
        Color decrementScore2_background = new Color(244,204,204);
        assertEquals(decrementScore2_background, bc.decrementScore2.getBackground());     //test decrementScore2 background color

    }

    @Test
    void inputScore2_test() {
        bc.start(t,sb,t1,t2);
        assertEquals(970, bc.inputScore2.getX());     //test inputScore2 position
        assertEquals(610, bc.inputScore2.getY());     //test inputScore2 position
        assertEquals(210, bc.inputScore2.getWidth());     //test inputScore2 width
        assertEquals(100, bc.inputScore2.getHeight());     //test inputScore2 height
        Color inputScore1_background = new Color(243,243,243);
        assertEquals(inputScore1_background, bc.inputScore2.getBackground());     //test inputScore2 background color

    }

    @Test
    void setScore2_test() {
        bc.start(t,sb,t1,t2);
        assertEquals(1210, bc.setScore2.getX());     //test setScore2 position
        assertEquals(610, bc.setScore2.getY());     //test setScore2 position
        assertEquals(210, bc.setScore2.getWidth());     //test setScore2 width
        assertEquals(100, bc.setScore2.getHeight());     //test setScore2 height
        Color setScore1_background = new Color(201,218,248);
        assertEquals(setScore1_background, bc.setScore2.getBackground());     //test setScore2 background color

    }

    @Test
    void notifications_test() {
	    bc.start(t,sb,t1,t2);
	    assertEquals(25, bc.notifications.getX());     //test notifications position
	    assertEquals(720, bc.notifications.getY());     //test notifications position
	    assertEquals(1000, bc.notifications.getWidth());     //test notifications width
	    assertEquals(50, bc.notifications.getHeight());     //test notifications height
	    Color notification_background = new Color(243,243,243);
	    assertEquals(notification_background, bc.notifications.getBackground());     //test notifications background color

    }

    @Test
    void acknowledge_test() {
	    bc.start(t,sb,t1,t2);
	    assertEquals(1035, bc.acknowledge.getX());     //test acknowledge position
        assertEquals(720, bc.acknowledge.getY());     //test acknowledge position
        assertEquals(390, bc.acknowledge.getWidth());     //test acknowledge width
        assertEquals(50, bc.acknowledge.getHeight());     //test acknowledge height
        Color acknowledge_background = new Color(217,234,211);
        assertEquals(acknowledge_background, bc.acknowledge.getBackground());     //test acknowledge background color

    }
}
