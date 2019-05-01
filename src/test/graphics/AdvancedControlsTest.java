package test.graphics;

import static org.junit.jupiter.api.Assertions.*;

import com.scorekeeper.model.scoreboard.ScoreboardImpl;
import com.scorekeeper.model.team.TeamImpl;
import com.scorekeeper.model.timer.TimerImpl;

import org.junit.jupiter.api.Test;

import com.scorekeeper.model.graphics.AdvancedControls;

import java.awt.*;

class AdvancedControlsTest {
	TimerImpl t = new TimerImpl();
	ScoreboardImpl sb = new ScoreboardImpl();
	AdvancedControls ac = new AdvancedControls();
	TeamImpl t1 = new TeamImpl();
	TeamImpl t2 = new TeamImpl();
	 
	@Test
	void frame_test() {
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
	    ac.start(t,sb,t1,t2);
	    assert(ac.frame.isVisible());
	    ac.hide();
	    assert(!ac.frame.isVisible());
	    ac.show();
	    assert(ac.frame.isVisible());
    }
	
    @Test
	void timer_test() {
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
	    ac.start(t,sb,t1,t2);
	    assertEquals(25, ac.scorebox1.getX());     //test scoreboard1 position
	    assertEquals(200, ac.scorebox1.getY());     //test scoreboard1 position
	    assertEquals(675, ac.scorebox1.getWidth());     //test scoreboard1 width
	    assertEquals(350, ac.scorebox1.getHeight());      //test scoreboard1 height
        Color scorebox1_background = new Color(243,243,243);
        assertEquals(scorebox1_background, ac.scorebox1.getBackground());     //test scoreboard1 background color

    }

    @Test
    void scorebox2_test() {
        ac.start(t,sb,t1,t2);
        assertEquals(750, ac.scorebox2.getX());     //test scoreboard2 position
        assertEquals(200, ac.scorebox2.getY());     //test scoreboard2 position
        assertEquals(675, ac.scorebox2.getWidth());     //test scoreboard2 width
        assertEquals(350, ac.scorebox2.getHeight());      //test scoreboard2 height
        Color scorebox2_background = new Color(243,243,243);
        assertEquals(scorebox2_background, ac.scorebox1.getBackground());     //test scoreboard2 background color

    }
    
    @Test
    void teamName1_test() {
	    ac.start(t,sb,t1,t2);
	    assertEquals(25, ac.teamName1.getX());     //test scoreboard1 position
	    assertEquals(550, ac.teamName1.getY());     //test scoreboard1 position
	    assertEquals(675, ac.teamName1.getWidth());     //test scoreboard1 width
	    assertEquals(50, ac.teamName1.getHeight());      //test scoreboard1 height
        Color scorebox1_background = new Color(243,243,243);
        assertEquals(scorebox1_background, ac.scorebox1.getBackground());     //test scoreboard1 background color

    }

    @Test
    void teamName2_test() {
        ac.start(t,sb,t1,t2);
        assertEquals(750, ac.teamName2.getX());     //test scoreboard2 position
        assertEquals(550, ac.teamName2.getY());     //test scoreboard2 position
        assertEquals(675, ac.teamName2.getWidth());     //test scoreboard2 width
        assertEquals(50, ac.teamName2.getHeight());      //test scoreboard2 height
        Color scorebox2_background = new Color(243,243,243);
        assertEquals(scorebox2_background, ac.scorebox1.getBackground());     //test scoreboard2 background color

    }

    @Test
    void starttime_test() {
	    ac.start(t,sb,t1,t2);
	    assertEquals(25, ac.startTime.getX());     //test starttime position
	    assertEquals(25, ac.startTime.getY());     //test starttime position
	    assertEquals(150, ac.startTime.getWidth());     //test starttime width
	    assertEquals(150, ac.startTime.getHeight());     //test starttime height
        Color starttime_background = new Color(217,234,211);
        assertEquals(starttime_background, ac.startTime.getBackground());     //test starttime background color

    }

    @Test
    void stopReset_test() {
	    ac.start(t,sb,t1,t2);
	    assertEquals(185, ac.stopReset.getX());     //test stopReset position
	    assertEquals(25, ac.stopReset.getY());     //test stopReset position
	    assertEquals(150, ac.stopReset.getWidth());     //test stopReset width
	    assertEquals(150, ac.stopReset.getHeight());     //test stopReset height
        Color stopReset_background = new Color(244,204,204);
	    assertEquals(stopReset_background, ac.stopReset.getBackground());     //test stopReset background color

    }

    @Test
    void inputTime_test() {
	    ac.start(t,sb,t1,t2);
	    assertEquals(1100, ac.inputTime.getX());     //test inputTime position
	    assertEquals(25, ac.inputTime.getY());     //test inputTime position
        assertEquals(325, ac.inputTime.getWidth());     //test inputTime width
        assertEquals(70, ac.inputTime.getHeight());     //test inputTime width
        Color inputTime_background = new Color(243,243,243);
        assertEquals(inputTime_background, ac.inputTime.getBackground());     //test inputTime background color

    }

    @Test
    void setTime_test() {
	    ac.start(t,sb,t1,t2);
	    assertEquals(1100, ac.setTime.getX());     //test setTime position
	    assertEquals(105, ac.setTime.getY());     //test setTime position
        assertEquals(325, ac.setTime.getWidth());     //test setTime width
        assertEquals(70, ac.setTime.getHeight());     //test setTime height
        Color setTime_background = new Color(201,218,248);
        assertEquals(setTime_background, ac.setTime.getBackground());     //test setTime background color

    }

    @Test
    void incrementScore1_test() {
	    ac.start(t,sb,t1,t2);
	    assertEquals(25, ac.incrementScore1.getX());     //test incrementScore1 position
        assertEquals(610, ac.incrementScore1.getY());     //test incrementScore1 position
        assertEquals(100, ac.incrementScore1.getWidth());     //test incrementScore1 width
        assertEquals(100, ac.incrementScore1.getHeight());     //test incrementScore1 height
        Color incrementScore1_background = new Color(217,234,211);
        assertEquals(incrementScore1_background, ac.incrementScore1.getBackground());     //test incrementScore1 background color

    }

    @Test
    void decrementScore1_test() {
	    ac.start(t,sb,t1,t2);
	    assertEquals(130, ac.decrementScore1.getX());     //test decrementScore1 position
	    assertEquals(610, ac.decrementScore1.getY());     //test decrementScore1 position
	    assertEquals(100, ac.decrementScore1.getWidth());     //test decrementScore1 width
	    assertEquals(100, ac.decrementScore1.getHeight());     //test decrementScore1 height
        Color decrementScore1_background = new Color(244,204,204);
        assertEquals(decrementScore1_background, ac.decrementScore1.getBackground());     //test decrementScore1 background color

    }

    @Test
    void inputScore1_test() {
	    ac.start(t,sb,t1,t2);
	    assertEquals(240, ac.inputScore1.getX());     //test inputScore1 position
	    assertEquals(610, ac.inputScore1.getY());     //test inputScore1 position
	    assertEquals(210, ac.inputScore1.getWidth());     //test inputScore1 width
	    assertEquals(100, ac.inputScore1.getHeight());     //test inputScore1 height
	    Color inputScore1_background = new Color(243,243,243);
	    assertEquals(inputScore1_background, ac.inputScore1.getBackground());     //test inputScore1 background color

    }

    @Test
    void setScore1() {
	    ac.start(t,sb,t1,t2);
	    assertEquals(490, ac.setScore1.getX());     //test setScore1 position
        assertEquals(610, ac.setScore1.getY());     //test setScore1 position
        assertEquals(210, ac.setScore1.getWidth());     //test setScore1 width
        assertEquals(100, ac.setScore1.getHeight());     //test setScore1 height
        Color setScore1_background = new Color(201,218,248);
        assertEquals(setScore1_background, ac.setScore1.getBackground());     //test setScore1 background color

    }

    @Test
    void incrementScore2_test() {
        ac.start(t,sb,t1,t2);
        assertEquals(750, ac.incrementScore2.getX());     //test incrementScore2 position
        assertEquals(610, ac.incrementScore2.getY());     //test incrementScore2 position
        assertEquals(100, ac.incrementScore2.getWidth());     //test incrementScore2 width
        assertEquals(100, ac.incrementScore2.getHeight());     //test incrementScore2 height
        Color incrementScore1_background = new Color(217, 234, 211);
        assertEquals(incrementScore1_background, ac.incrementScore2.getBackground());     //test incrementScore2 background color

    }

    @Test
    void decrementScore2_test() {
	    ac.start(t,sb,t1,t2);
	    assertEquals(860, ac.decrementScore2.getX());     //test decrementScore2 position
        assertEquals(610, ac.decrementScore2.getY());     //test decrementScore2 position
        assertEquals(100, ac.decrementScore2.getWidth());     //test decrementScore2 width
        assertEquals(100, ac.decrementScore2.getHeight());     //test decrementScore2 height
        Color decrementScore2_background = new Color(244,204,204);
        assertEquals(decrementScore2_background, ac.decrementScore2.getBackground());     //test decrementScore2 background color

    }

    @Test
    void inputScore2_test() {
        ac.start(t,sb,t1,t2);
        assertEquals(970, ac.inputScore2.getX());     //test inputScore2 position
        assertEquals(610, ac.inputScore2.getY());     //test inputScore2 position
        assertEquals(210, ac.inputScore2.getWidth());     //test inputScore2 width
        assertEquals(100, ac.inputScore2.getHeight());     //test inputScore2 height
        Color inputScore1_background = new Color(243,243,243);
        assertEquals(inputScore1_background, ac.inputScore2.getBackground());     //test inputScore2 background color

    }

    @Test
    void setScore2_test() {
        ac.start(t,sb,t1,t2);
        assertEquals(1210, ac.setScore2.getX());     //test setScore2 position
        assertEquals(610, ac.setScore2.getY());     //test setScore2 position
        assertEquals(210, ac.setScore2.getWidth());     //test setScore2 width
        assertEquals(100, ac.setScore2.getHeight());     //test setScore2 height
        Color setScore1_background = new Color(201,218,248);
        assertEquals(setScore1_background, ac.setScore2.getBackground());     //test setScore2 background color

    }

    @Test
    void notifications_test() {
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
	    ac.start(t,sb,t1,t2);
	    assertEquals(1035, ac.acknowledge.getX());     //test acknowledge position
        assertEquals(720, ac.acknowledge.getY());     //test acknowledge position
        assertEquals(390, ac.acknowledge.getWidth());     //test acknowledge width
        assertEquals(50, ac.acknowledge.getHeight());     //test acknowledge height
        Color acknowledge_background = new Color(217,234,211);
        assertEquals(acknowledge_background, ac.acknowledge.getBackground());     //test acknowledge background color

    }
}
