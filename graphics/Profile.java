package graphics;
import java.util.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import basics.*;
import Stuff.*;
import classes.*;


public class Profile extends JComponent 
{	
	int x = 30; int y = 30; int w = 240; int h = 400;
	Player p;
	
	public Profile(Player person)
	{
		p = person;
	}
	
	public void paintComponent(Graphics g)
	{  
		
		g.setColor(Color.YELLOW);
		g.fillOval(x+5*w/6, y + h/2, w/6, w/6);
		g.setColor(Color.BLACK);		
		g.drawString(""+p.getCoins()+"", x+5*w/6 + w/25, y + h/2 + h/15);		
		
		
		g.setColor(Color.BLACK);
		g.drawOval(x +w/3, y, w/3, h/6);
		
		g.drawString("DMG +" + p.getHeadgear().getDamage(), x+ w/3 + w/15, y + 3*h/60);
		g.drawString("DEF +" + p.getHeadgear().getDefense(), x+ w/3 + w/15, y + 5*h/60);
		g.drawString("SPD +" + p.getHeadgear().getSpeed(), x+ w/3 + w/15, y + 7*h/60);
		g.drawString("VIT +" + p.getHeadgear().getVitality(), x+ w/3 + w/15, y + 9*h/60);
		
		
		g.drawRect(x + w/4, y + 11*h/60, w/2, 7*h/20);
		
		g.drawString("DMG +" + p.getArmor().getDamage(), x+w/4 + w/16, y + 18*h/60);
		g.drawString("DEF +" + p.getArmor().getDefense(), x + w/4 + w/16, y + 21*h/60);
		g.drawString("SPD +" + p.getArmor().getSpeed(), x + w/4 + w/16, y + 24*h/60);
		g.drawString("VIT +" + p.getArmor().getVitality(), x + w/4 + w/16, y + 27*h/60);
		
		  drawPara(g, x, y, h/7, w/4, h/6 + h/60);
		  drawPara(g, x + (3*w)/4, y + h/6 + h/60, h/7, w/4 - w/40, -h/6 -h/60); 
		
		g.drawRoundRect(x, y + h/2, 9*w/41, h/2, 5, 5); 
		g.drawString("DMG +" + p.getWeapon().getDamage(), x + 2, y + 38*h/60);
		g.drawString("DEF +" + p.getWeapon().getDefense(), x + 2, y + 41*h/60);
		g.drawString("SPD +" + p.getWeapon().getSpeed(), x + 2, y + 44*h/60);
		g.drawString("VIT +" + p.getWeapon().getVitality(), x + 2, y + 47*h/60);  
				
		g.drawRect(x + w/4, y + 32*h/60, w/5, 28*h/60);
		g.drawRect(x + w/4 + 3* w/10,y+ 32*h/60, w/5, 28*h/60);
		
		g.drawString("DMG +" + p.getFootwear().getDamage(), x + w/4 + w/80, y + 54*h/60);
		g.drawString("DEF +" + p.getFootwear().getDefense(), x + w/4 + 3*w/10 + w/80, y + 54*h/60);
		g.drawString("SPD +" + p.getFootwear().getSpeed(), x + w/4 + w/80, y + 57*h/60);
		g.drawString("VIT +" + p.getFootwear().getVitality(), x + w/4 + 3*w/10 + w/80, y + 57*h/60);		
	}
	public void drawPara(Graphics g, int x, int y, int h, int w, int slant)
	{
		int[] X = {x, x + w, x + w, x, x};
		int[] Y = {y, y + slant, y + slant + h, y + h, y};
		
		g.setColor(Color.BLACK);
		
		g.drawPolygon(X,Y,5);
	}
	public void redo(int xleft, int ytop, int height, int width)
	{
		x = xleft; y = ytop;
		h = height; w = width;
		repaint();
	}
	public void update(Player psn)
	{
		p = psn;
		repaint();
	}
}
