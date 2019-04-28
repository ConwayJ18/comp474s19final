package com.scorekeeper.client;

import com.scorekeeper.model.graphics.*;
import com.scorekeeper.model.scoreboard.ScoreboardImpl;
import com.scorekeeper.model.team.TeamImpl;
import com.scorekeeper.model.timer.TimerImpl;

public class ScoreboardClient
{
	public static void main(String args[])
	{
		Graphics controlDisplay = new BasicControls();
		Graphics outwardDisplay = new OutwardDisplay();
		TimerImpl t = new TimerImpl();
		t.addObserver(controlDisplay);
		t.addObserver(outwardDisplay);
		ScoreboardImpl s = new ScoreboardImpl();
		s.addObserver(controlDisplay);
		s.addObserver(outwardDisplay);
		TeamImpl t1 = new TeamImpl();
		t1.addObserver(controlDisplay);
		t1.addObserver(outwardDisplay);
		TeamImpl t2 = new TeamImpl();
		t2.addObserver(controlDisplay);
		t2.addObserver(outwardDisplay);
		controlDisplay.start(t, s, t1, t2);
		outwardDisplay.start(t, s, t1, t2);
	}
}