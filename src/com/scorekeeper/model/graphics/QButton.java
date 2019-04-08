package com.scorekeeper.model.graphics;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class QButton extends JButton
{
	int type;

	/**
	 * 
	 */
	public QButton() 
	{
		super();
		this.format();
	}
	
	/**
	 * @param text
	 */
	public QButton(String text) 
	{
		super(text); //Sets default text
		this.format(); //Sets parameters according to type
	}
	
	/**
	 * @param inputType
	 */
	public QButton(int type) 
	{
		this.type = type; //Sets type of box
		this.format(); //Sets parameters according to type
	}
	
	/**
	 * @param text
	 * @param inputType
	 */
	public QButton(String text, int type)
	{
		super(text);
		this.type = type; //Sets type of box
		this.format(); //Sets parameters according to type
	}
	
	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public QButton(int x, int y, int width, int height)
	{
		super();
		this.setBounds(x, y, width, height); //Sets location & size
		this.format(); //Sets parameters according to type
	}
	
	/**
	 * @param text
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public QButton(String text, int x, int y, int width, int height)
	{
		super(text); //Sets default text
		this.setBounds(x, y, width, height); //Sets location & size
		this.format(); //Sets parameters according to type
	}
	
	/**
	 * @param type
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public QButton(int type, int x, int y, int width, int height)
	{
		super();
		this.type = type; //Sets type of box
		this.setBounds(x, y, width, height); //Sets location & size
		this.format(); //Sets parameters according to type
	}
	
	/**
	 * @param text
	 * @param type
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public QButton(String text, int type, int x, int y, int width, int height)
	{
		super(text); //Sets default text
		this.type = type; //Sets type of box
		this.setBounds(x, y, width, height); //Sets location & size
		this.format(); //Sets parameters according to type
	}
	
	/*
	 * @param type the type to set
	 */
	public void setType(int type)
	{
		this.type = type;
	}

	private void format()
	{
		int type = this.type;
		this.setOpaque(true);
	    this.setBorderPainted(false);
	    this.setVisible(true);
		
		switch(type)
		{
			case 1: //Green buttons
			    this.setBackground(new Color(217,234,211)); //Green
	            break; 
	        case 2: //Yellow buttons
			    this.setBackground(new Color(254,242,204)); //Yellow
			    break; 
			case 3: //Red buttons
			    this.setBackground(new Color(244,204,204)); //Red
			    break;
			case 4:
			    this.setBackground(new Color(201,218,248)); //Blue
	            break; 
	        default: 
	            this.setVisible(false);
		}
	}
}
