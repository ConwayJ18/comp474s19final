package com.scorekeeper.model.timer;

import com.scorekeeper.model.graphics.Graphics;

public interface Timer
{
	abstract void startTime();
	abstract void stopTime();
	abstract void resetTime();
	abstract boolean isRunning();
	abstract void setTime(String time);
	abstract String getTime();
	abstract void acknowledge();
	abstract void addObserver(Graphics g);
}