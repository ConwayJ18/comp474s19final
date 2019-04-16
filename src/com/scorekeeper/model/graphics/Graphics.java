package com.scorekeeper.model.graphics;

public interface Graphics 
{
	void start();
	void hide();
	void show();
	void updateNotification(String alertMessage);
	void updateTimer(String string);
}
