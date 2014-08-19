package graphics;

import java.util.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import basics.*;
import Stuff.*;
import classes.*;
import infinitePlay.*;


public class Potions extends JPanel 
{
	Player p;
	int x; int y;
	int height; int width;
	GridBagConstraints c;
	JButton h;
	JButton m;
	JComponent hpc;
	JComponent mpc;
	int type; //this is 0 for normal, 1 for infinite
	
	
	public Potions(Player psn, int X, int Y, int t)
	{
		type = t;
		p = psn;
		
		this.setLayout(new GridBagLayout());
		
		c = new GridBagConstraints();
		
		height = 60; width = 45;
		x = X; y = Y;
		
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.CENTER;
		
		c.gridx = 0;
		c.gridy = 1;
		
		h = new JButton("Drink HP Potion");
		h.addActionListener(new Hlstnr());
		
		this.add(h, c);
		
		c.gridx = 1;
		c.gridy = 1;
		
		m = new JButton("Drink MP Potion");
		m.addActionListener(new Mlstnr());
		
		this.add(m, c);
		
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;
		
		hpc = new HPpotComp();		
		this.add(hpc, c);
		
		c.gridx = 1;
		c.gridy = 0;
		
		mpc = new MPpotComp();
		this.add(mpc, c);
		
	}
	
	public class HPpotComp extends JComponent
	{
		public void paintComponent(Graphics g)
		{
			g.setColor(Color.YELLOW);
			g.fillOval(x+width/6, y, (2*width)/3, height/5);
			g.setColor(Color.BLACK);
			g.drawOval(x+width/6, y, (2*width)/3, height/5);
			g.setColor(Color.PINK);
			g.fillRoundRect(x, y+height/5, width, (4*height)/5,8,8);
			g.setColor(Color.BLACK);
			g.drawString("" + p.getHPpot(), x + (3*width)/7, y+(2*height)/3);
		}
	}
	public class MPpotComp extends JComponent
	{
		public void paintComponent(Graphics g)
		{
			g.setColor(Color.YELLOW);
			g.fillOval(x+width/6, y, (2*width)/3, height/5);
			g.setColor(Color.BLACK);
			g.drawOval(x+width/6, y, (2*width)/3, height/5);
			g.setColor(Color.CYAN);
			g.fillRoundRect(x, y+height/5, width, (4*height)/5,8,8);
			g.setColor(Color.BLACK);
			g.drawString("" + p.getMPpot(), x + (3*width)/7, y+(2*height)/3);
		}
	}
	
	public class Hlstnr implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(type == 0)
			{
				JavaRPG.player.drinkHealthPotion();
				JavaRPG.g.updtAll(JavaRPG.player);
			}
			else
			{
				JavaRPG_infinite.player.drinkHealthPotion();
				JavaRPG_infinite.g.updtAll(JavaRPG_infinite.player);
			}
		}
	}
	public class Mlstnr implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(type == 0)
			{
				JavaRPG.player.drinkManaPotion();
				JavaRPG.g.updtAll(JavaRPG.player);
			}
			else
			{
				JavaRPG_infinite.player.drinkManaPotion();
				JavaRPG_infinite.g.updtAll(JavaRPG_infinite.player);
			}
		}
	}
	public void update(Player psn)
	{
		p = psn;
		hpc.repaint();
		mpc.repaint();
		this.updateUI();
	}
}
