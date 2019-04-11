package com.scorekeeper.model.timer;

public interface Timer
{
	void startTime();
	void stopTime();
	void setTime(String time);
	String getTime();
}
