package infinitePlay;

import graphics.JRPGraphics;

import java.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import classes.*;
import Stuff.*;
import basics.*;

public class JavaRPG_infinite 
{	
	public static int x = 0;
	public static Board b = new Board(10,10);	
	public static JTextField jtf = new JTextField(20);
	public static int choice;
	public static JRPGInfGraphics g;
	public static String[] c = {"Continue (a)"};
	public static String[] f = {"FIGHT! (a)"};
	public static Player player = new Player();
	public static boolean battle;
	public static boolean decision;
	public static boolean onTown;
	
	public static void main(String[] args) 
	{		
		
		battle = false;	decision = true; onTown = false;
		player = new Player();
		
		g = new JRPGInfGraphics();
		g.updtAll(player);
		g.brd.setState(3);
	
		int k;
		String[] clT = {"Please pick a class:"};
		String[] clB = {"Mage (a)", "Warrior (s)", "Archer (d)", "Thief (f)"};
		int classchoice = g.DispText(clT, clB);
		g.clearall();
		decision = false;
		String playerclass = "";
		if(classchoice == 1)
		{
			player = new Mage();
			playerclass = "mage";
		}
		else if(classchoice == 2)
		{
			player = new Warrior();
			playerclass = "warrior";
		}
		else if(classchoice == 3)
		{
			player = new Archer();
			playerclass = "archer";
		}
		else if(classchoice == 4)
		{
			player = new Thief();
			playerclass = "thief";
		}
		player.setCoins(0);
		g.brd.setState(0);
		g.updtAll(player);
		
		while(x == 0)
		{
			k = (int)(4*Math.random()) + 2;
			while(x < k)
			{
				if(player.getAlive() == false)
				{
					String[] deathT = {"Note, clicking \"Game Over\" will close the game. You died as a level " + player.getLevel()
							+ " " + playerclass +". Your legacy will be remembered eternally by no one- unless you take a screenshot!"};
					String[] deathB = {"Game Over"};
					g.DispText(deathT, deathB);
					System.exit(1);
				}
				if(x >= k)
					break;
				if(onTown == true)
				{
					g.townScript();
					onTown = false;
				}
			}
			battle = true;
			g.brd.setState(1);
			g.brd.update();
			String[] a = {"You encounter a goblin! GET READY TO RUMBLE!!!!"}; String[] b1 = {"AUTOFIGHT (a)", "FIGHT (s)"};
			boolean aufi = false;
			int auto = g.DispText(a, b1);
			if(auto == 1)
				aufi = true;
			fight(player, new Enemy(player.getLevel(), "Goblin"), 0, 0, aufi);
			x = 0;
			g.brd.setState(0);
			battle = false;
			g.brd.update();
			
		}
			
		//fight(player, new Enemy(3, "Goblin"), 0, 0);
		/**JFrame jf = new JFrame("Java RPG");
		jf.setSize(400, 400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jp = new JPanel();
		jp.setLayout(new GridBagLayout()); //⌂ ║
		Key kl = new Key();	
		jtf.addKeyListener(kl);
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.weightx = 1; c.weighty = 1;
		c.gridx = 0; c.gridy = 0;
		c.gridwidth = 2; c.gridheight = 2;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		
		jp.add(b, c);
		
		
		c.gridx = 0; c.gridy = 2;
		c.gridwidth = 2; c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		
		jp.add(jtf, c);
		
		
		jf.add(jp);
		jf.setVisible(true);

		*/
	}	
	public static void occurrence()
	{
		if(Math.random() < 0.2)
		{
			System.out.println("An error is about to occur");
			String[] a = {"You encounter a goblin! GET READY TO RUMBLE!!!!"}; String[] b1 = {"AUTOFIGHT (a)", "FIGHT (s)"};
			boolean auto = false;
			if(g.DispText(a, b1) == 1)
				auto = true;
			fight(player, new Enemy(player.getLevel(), "Goblin"), 0, 0, auto);	
		}
	}
	
	public static void fight(Player p, Enemy e, int qp, int qt, boolean af)
	{
		
		
		int steps = 0;
		choice = 0;
		ArrayList<String> t;
		boolean autofight = af;
		
		
	    while(e.getAlive() && p.getAlive())
	    {    	
	    	
	    	if(steps % (100 / p.getSpeed()) == 0)
	    	{
	    		if(!autofight)
	    		{
		    		String[] chacT = {};
		    		String[] chacB = {"ATTACK (a)", "MAGIC (s)", "HEAL (d)"};
		    		
		    		choice = g.DispText(chacT, chacB);
			    	
		    		if(choice == 1)
		    			t = p.attack(e);
		    		
		    		else if(choice == 2)
		    			t = p.MagicAttack(e);
		    		
		    		else if(choice == 3)
		    			t = p.heal();
		    		
		    		else
		    			t = p.drinkManaPotion();
	
		    		choice = 0;
		    		
		    		String[] cmbtT = new String[t.size()];
			    	
			    	for(String q : t)
			    	{
			    		cmbtT[t.indexOf(q)] = q;
			    	}
			    	
			    	g.DispText(cmbtT, c);
	    		}	    		
	    		else
	    		{
		    		if(p.getHp() > p.getMaxHp()/10)
		    			p.attack(e);
		    		else
		    			p.heal();
	    		}
	    		
	    		if(e.getAlive() == false)
	    		{
	    			p.gainXP(e.getLevel()* 2);
	    			break;
	    		}
	    	}
	    	   
	    	if(steps % (100 / e.getSpeed()) == 0)
	    	{
	    		t = e.attack(p);
	    		
	    		if(!autofight)
	    		{
		    		String[] cmbtT = new String[t.size()];
			    	
			    	for(String q : t)
			    	{
			    		cmbtT[t.indexOf(q)] = q;
			    	}
			    	
			    	g.DispText(cmbtT, c);
	    		}
	    	}
	    	
	    	g.updtAll(p);
	    	
	    	steps++;
	    }
	    if(autofight)
	    {
		    if(e.getAlive() == false)
		    {
		    	t = e.die(p);
		    	String[] cmbtT = new String[t.size()];
		    	
		    	for(String q : t)
		    	{
		    		cmbtT[t.indexOf(q)] = q;
		    	}
		    	
		    	g.DispText(cmbtT, c);
		    }
		    else if(p.getAlive() == false)
		    {
		    	String[] cmbtT = {"The level " + e.getLevel() + " " + e.getName() + " killed you. You died a horrible death."};
		    	
		    	g.DispText(cmbtT, c);
		    }
	    }
	    
	    g.updtAll(p);
	}

}
