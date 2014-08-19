package graphics;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import basics.*;
import classes.*;
import Stuff.*;

//test

public class BarComponent extends JComponent {

	int x;
	int y;
	
	int max;
	int l;
	int w;
	Color c;
		
	public BarComponent(int X, int Y, int wid, Player psn, int n)
	{
		x = X; y = Y;
		
		if(n == 0) //for hitpoints
		{
			max = psn.getMaxHp();
			
			l = psn.getHp();
			
			c = Color.RED;
			
			repaint();
			
		}
		else if(n == 1) //for mana
		{
			max = psn.getMaxMana();
			
			l = psn.getMana();
			
			c = Color.BLUE;
			
			repaint();
			
		}
		else if(n == 2) //for experience
		{
			max = 50;
			l = psn.getXP()/psn.getLevel();
			
			c = Color.yellow;
			
			repaint();
		}
		
		
		w = wid;
	}
	
	public void paintComponent(Graphics g)
	{		
		g.setColor(c);
		g.fillRect(x, y, (int)(2*100*l/max), w);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, 200, w);
		g.setColor(Color.BLACK);
		String temp = l + " (" + (int)100*l/max + "%)";
		g.drawString(temp, x + 66, y + ((int) y -2));
	}
	public void updateValue(Player psn, int n)
	{
		if(n == 0) //for hitpoints
		{
			max = psn.getMaxHp();
			
			l = psn.getHp();
			
			c = Color.RED;
			
			repaint();
			
		}
		else if(n == 1) //for mana
		{
			max = psn.getMaxMana();
			
			l = psn.getMana();
			
			c = Color.BLUE;
			
			repaint();
			
		}
		else if(n == 2) //for experience
		{
			max = 30;
			l = psn.getXP()/psn.getLevel();
			
			c = Color.yellow;
			
			repaint();
		}
	}
}
