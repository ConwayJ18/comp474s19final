package com.scorekeeper.model.graphics;

import com.scorekeeper.model.scoreboard.ScoreboardImpl;
import com.scorekeeper.model.timer.TimerImpl;

public interface Graphics 
{
	void start(TimerImpl t, ScoreboardImpl s);
	void hide();
	void show();
	void updateTimer(String string);
	void updateNotification(String string);
	void updateScore();
}
