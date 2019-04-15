package com.scorekeeper.model.timer;

import com.scorekeeper.model.graphics.Graphics;

public interface Timer
{
	void startTime();
	void stopTime();
	void resetTime();
	boolean isRunning();
	void setTime(String time);
	String getTime();
	void acknowledge();
	void addObserver(Graphics g);
}