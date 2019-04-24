package com.scorekeeper.client;

import com.scorekeeper.model.graphics.*;
import com.scorekeeper.model.scoreboard.ScoreboardImpl;
import com.scorekeeper.model.timer.TimerImpl;

public class ScoreboardClient
{
	public static void main(String args[])
	{
		Graphics controlDisplay = new ControlDisplay();
		Graphics outwardDisplay = new OutwardDisplay();
		TimerImpl t = new TimerImpl();
		t.addObserver(controlDisplay);
		t.addObserver(outwardDisplay);
		ScoreboardImpl s = new ScoreboardImpl();
		s.addObserver(controlDisplay);
		s.addObserver(outwardDisplay);
		controlDisplay.start(t, s);
		outwardDisplay.start(t, s);
	}
}