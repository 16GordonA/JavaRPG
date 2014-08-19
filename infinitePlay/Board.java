package infinitePlay;


import graphics.JRPGraphics;

import java.util.*;

import javax.imageio.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import classes.*;
import Stuff.*;
import basics.*;

public class Board extends JComponent
{
	Tile[][] layout;
	int[] pTile = new int[2];
	int state = 0; //0 = map, 1 = battle, 2 = town, 3 = crossroads, there may be others?
	String[] battle = new String[6]; //this is the battle graphic!
	String[] town = new String[6]; //this is the town graphic!
	String[]decision = new String[6]; //this is the crossroads graphic
	
	public Board(int x, int y)
	{
		layout = new Tile[x][y];
		pTile[0] = 0; pTile[1] = 0;
		
		for(int i = 0; i < x; i++)
		{
			for(int j = 0; j < y; j++)
			{
				if(i == 0 && j == 0)
					layout[i][j] = new Tile(0);
				else
					layout[i][j] = new Tile(1);
			}
		}
		initialize();
		
		layout[pTile[0]][pTile[1]].setPlayerOn(true);
	}
	
	public void paintComponent(Graphics g)
	{
		g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
		if(state == 0)
		{
			
			ImageIcon a = new ImageIcon("grass.png");
		    Image image1 = a.getImage();
			for(int i = 0; i < layout.length; i++)
			{
				for(int j = 0; j < layout[0].length; j++)
				{
					if(layout[i][j].getApp().equals(",,,"))
					{
						g.setColor(Color.GREEN);
						
						/**
						BufferedImage img = ImageIO.read("stone.png");
						ImageIcon icon = createImageIcon("grass.png", "grass");
						g.drawImage(icon, 30*i, 30+25 * j, 30, 25, new Detector());
						**/
					}
					else if(layout[i][j].getApp().equals("o0o"))
						g.setColor(Color.GRAY);
					else if(layout[i][j].getApp().equals("\\o/"))
						g.setColor(Color.RED);
					else if(layout[i][j].getApp().equals("TWN"))
						g.setColor(Color.MAGENTA);
					else if(layout[i][j].getApp().equals("|-|"))
						g.setColor(Color.BLACK);
					
					//if(!layout[i][j].getApp().equals(",,,"))
						g.drawString(layout[i][j].getApp(),30 * i, 30+25 * j);
				}
			}
		}
		else if(state == 1)
		{
			g.setColor(Color.BLACK);
			for(int i = 0; i < 6; i++)
				g.drawString(battle[i], 0, 30 + 25*i);
		}
		else if(state == 2)
		{
			{
				g.setColor(Color.BLACK);
				for(int i = 0; i < 6; i++)
					g.drawString(town[i], 0, 30 + 25*i);
			}
		}
		else if(state == 3)
		{
			{
				g.setColor(Color.BLACK);
				for(int i = 0; i < 6; i++)
					g.drawString(decision[i], 0, 30 + 25*i);
			}
		}
	}
	
	public boolean move(int dir)
	{
		if(dir == 0) //up
		{
			if(pTile[1] != 0 && !getNeighbor(0).equals("|-|"))
			{
				layout[pTile[0]][pTile[1]].setPlayerOn(false);
				pTile[1] --;
				layout[pTile[0]][pTile[1]].setPlayerOn(true);
				
				repaint();
			}
			else
				return false;
		}
		else if(dir == 1) //left
		{
			if(pTile[0] != 0 && !getNeighbor(1).equals("|-|"))
			{
				layout[pTile[0]][pTile[1]].setPlayerOn(false);
				pTile[0] --;
				layout[pTile[0]][pTile[1]].setPlayerOn(true);
				
				repaint();
			}
			else
				return false;
		}
		else if(dir == 2) //down
		{
			if(pTile[1] != layout[0].length - 1 && !getNeighbor(2).equals("|-|"))
			{
				layout[pTile[0]][pTile[1]].setPlayerOn(false);
				pTile[1] ++;
				layout[pTile[0]][pTile[1]].setPlayerOn(true);
				
				repaint();
			}
			else
				return false;
		}
		else if(dir == 3) //right
		{
			if(pTile[0] != layout.length - 1 && !getNeighbor(3).equals("|-|"))
			{
				layout[pTile[0]][pTile[1]].setPlayerOn(false);
				pTile[0] ++;
				layout[pTile[0]][pTile[1]].setPlayerOn(true);
				
				repaint();
			}
			else
				return false;
		}
		if(layout[pTile[0]][pTile[1]].getType().equals("TWN"))
		{
			JavaRPG_infinite.g.brd.setState(2);
			JavaRPG_infinite.onTown = true;
			
		}
		else
			state = 0;
		for(Tile[] ta : layout)
			for(Tile t : ta)
			{
			}
		JavaRPG_infinite.x ++;
		return true;
	}
	public String getNeighbor(int dir)
	{
		if(dir == 0 && pTile[1] != 0)
			return layout[pTile[0]][pTile[1] - 1].getApp();
		else if(dir == 1 && pTile[0] != 0)
			return layout[pTile[0] - 1][pTile[1]].getApp();
		else if(dir == 2 && pTile[1] != layout[0].length - 1)
			return layout[pTile[0]][pTile[1] + 1].getApp();
		else if(dir == 3 && pTile[0] != layout.length - 1)
			return layout[pTile[0] + 1][pTile[1]].getApp();
		
		else
			return "";
		
	}
	public void update()
	{
		/**
		if(layout[pTile[0]][pTile[1]].getType().equals("TWN"))
			state = 2;
		else if(JavaRPG_infinite.battle)
			state = 1;
		else
			state = 0;
			*/
		repaint();
	}
	
	public void setState(int a)
	{
		state = a;
		repaint();
		JavaRPG_infinite.g.updtAll(JavaRPG_infinite.player);
	}
	
	public void initialize()
	{
		battle[0] = "                         \\ /                   "; //note that there are a lot of double backslashes,
		battle[1] = "              ^^^^        X          ,,,/       "; //these are escape characters
		battle[2] = "             |~~<>\\      / \\        /<> /     ";
		battle[3] = "             ~~   >   \\ /   \\ /     /.  \\    ";
		battle[4] = "             \\~~\\-/   /\\     /\\     v |  |  ";
		battle[5] = "              ‘---’    +/\\   /\\+       |/\\ \\";
		
		town[0] = "               SHOP                   ";
		town[1] = "                                 /---\\";
		town[2] = "             ||    ||      /-\\   |ooo|";
		town[3] = "            /HP\\  /MP\\     |o|   |ooo|";
		town[4] = "            \\--/  \\--/  /--|o|---|ooo|";
		town[5] = "             50    40   |oo|o|ooo|ooo|";
		
		decision[0] = "                       | |      THE       ";
		decision[1] = "                       | |   CROSSROADS   ";
		decision[2] = "              —————'   '————-          ";
		decision[3] = "              —————,   ,————-          ";
		decision[4] = "                       | |                ";
		decision[5] = "                       | |                ";
	}
	
	public static ImageIcon createImageIcon(String path, String description) 
	{
		ImageHelper a = new ImageHelper();
		return a.createImageIcon(path, description);
	}
	
}
