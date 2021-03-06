package infinitePlay;

import java.util.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import classes.*;
import Stuff.*;
import basics.*;
import graphics.*;

import java.lang.InterruptedException;

public class JRPGInfGraphics 
{
	JFrame mainJF = new JFrame("JavaRPG");
	JPanel mainJP = new JPanel(new GridBagLayout());
	GridBagConstraints mainC = new GridBagConstraints();
	JPanel textJP = new JPanel(new GridBagLayout());
	GridBagConstraints textC = new GridBagConstraints();
	public Board brd = new Board(17, 6);
	public JTextField jtf = new JTextField(5);
	JLabel[] text = new JLabel[6];
	JPanel buttonJP = new JPanel();
	JPanel bottomJP = new JPanel(new GridBagLayout());
	GridBagConstraints bottomC = new GridBagConstraints();
	Profile prof = new Profile(new Player());
	BarComponent[] bars = new BarComponent[3];
	Potions pots = new Potions(new Player(), 5, 5, 1);
	int choice;
	
	public JRPGInfGraphics()
	{
		class Ender implements ActionListener
		{			
			public void actionPerformed(ActionEvent event)
			{
				System.exit(1);
			}
		}
		mainJF.setSize(1200,700);
		mainJF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//mainJF.getContentPane().setBackground(Color.BLACK);
		
		for (int i = 0; i < text.length; i++)
		{
			text[i] = new JLabel(" ");
		}
		
		textC.weightx = 1; textC.weighty = 1;
		/**textC.gridx = 0; textC.gridy = 0;
		textC.gridheight = 2; textC.gridwidth = 2;
		textC.fill = GridBagConstraints.BOTH;
		
		textJP.add(brd, textC);*/
		
		textC.gridheight = 1; textC.gridwidth = 1;
		textC.gridx = 0; textC.gridy = 2;	
		textC.fill = GridBagConstraints.NONE;
		
		jtf.addKeyListener(new Key());
		
		textJP.add(jtf, textC);
		
		textC.gridx = 0;

		for(int i = 0; i < text.length; i++)
		{
			textC.gridy = i+3;
			textJP.add(text[i], textC);
		}
		
		JButton exit = new JButton("END GAME");
		exit.addActionListener(new Ender());
		JLabel coprig = new JLabel("COPYRIGHT 2013 Akiva Gordon and Andrew Li");
		bottomC.weightx = 1.0;
		bottomC.weighty = 1.0;
		bottomC.gridx = 0;
		bottomC.gridy = 0;
		bottomC.fill = GridBagConstraints.HORIZONTAL;
		bottomJP.add(exit, bottomC);
		bottomC.gridx = 0;
		bottomC.gridy = 1;
		bottomJP.add(coprig, bottomC);
		
		
		for(int i = 0; i < 3; i++)
		{
			bars[i] = new BarComponent(15, 15, 15, new Player(), i);
		}
		
		
		mainC.weightx = 1;
		mainC.weighty = 1;
		
		mainC.gridx = 1;
		mainC.gridy = 0;
		mainC.gridheight = 2;
		mainC.fill = GridBagConstraints.BOTH;
		
		mainJP.add(brd, mainC);
		
		mainC.fill = GridBagConstraints.CENTER;
		mainC.gridheight = 1;
		
		mainC.gridx = 1;
		mainC.gridy = 2;
		mainJP.add(textJP, mainC);
		mainC.gridx = 1;
		mainC.gridy = 3;
		mainJP.add(buttonJP, mainC);
		mainC.gridx = 1;
		mainC.gridy = 4; 
		mainJP.add(bottomJP, mainC);
		
		mainC.gridx = 2;
		mainC.gridy = 0;
		mainC.fill = GridBagConstraints.BOTH;
		mainC.gridheight = 3;
		
		mainJP.add(prof, mainC);
		
		mainC.gridheight = 1;
		mainC.gridx = 0;
		mainC.gridy = 0;
		mainJP.add(bars[0], mainC);
		//mainJP.add(new JLabel("TEST"), mainC);
		mainC.gridx = 0;
		mainC.gridy = 1;
		mainJP.add(bars[1], mainC);
		mainC.gridx = 0;
		mainC.gridy = 2;
		mainJP.add(bars[2], mainC);
		mainC.gridy = 3;
		mainJP.add(bars[2], mainC);
		
		mainC.gridx = 2;
		mainC.gridy = 4;
		
		mainJP.add(pots, mainC);
		
		
		mainJF.add(mainJP);
		
		/*Container tempCP = mainJF.getContentPane();
		tempCP.setBackground(Color.WHITE);
		mainJF.setContentPane(tempCP);*/
		
		System.out.print(mainJF.getContentPane().getBackground());
		
		mainJF.setVisible(true);
		
	}
	
	public int DispText(String[] t, String[] b)
	{
		class Action implements ActionListener
		{
			int r;
			
			public Action(int a)
			{
				super();
				r = a;
			}
			
			public void actionPerformed(ActionEvent event)
			{
				System.out.println("Changing choice to" + r);
				choice = r;
			}
			
			public void setR(int a)
			{
				r = a;
			}
		}
		//System.out.println("3");
		t = fiftychar(t, 70);
		
		for(int i = 0; i <= (text.length - 1 -t.length); i++)
		{
			text[i].setText(text[i + t.length].getText());
			text[i].setForeground(Color.GRAY);
		}
		
		for(int i = 0; i < t.length; i++)
		{
			text[(text.length - 1) - (t.length - 1 - i)].setText(t[i]);
			text[(text.length -1) - (t.length - 1 - i)].setForeground(Color.RED);
		}
		//System.out.println("2");
		
		mainJP.remove(buttonJP);
		buttonJP = new JPanel();
		
		//if(b.length != 4)
			buttonJP.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.weightx = 1; c.weighty = 1;
		c.fill = GridBagConstraints.CENTER;
		
		//System.out.println("1");
		for(int i = 0; i < b.length; i++)
		{
			c.gridy = i;
			JButton jb;
			if(b[i].substring(0,1).equals("!"))
			{
				jb = new JButton(b[i].substring(1,b[i].length()));
				jb.setEnabled(false);
			}
			else
				jb = new JButton(b[i]);
			jb.addActionListener(new Action(i+1));
			if(b.length != 4)
			{
				c.gridx = (int)(i%3); c.gridy = (int)(i/3);
				buttonJP.add(jb, c);
			}
			else if(b.length == 4)
			{
				c.gridx = (int) (i%2); c.gridy = i/2;
				buttonJP.add(jb, c);
			}
			else
				buttonJP.add(jb);
		}
		mainC.gridx = 1;
		mainC.gridy = 1;
		
		mainJP.add(buttonJP, mainC);
		
		mainJP.updateUI();
		//System.out.println("0");
		
		choice = 0;
		while(choice == 0)
			if(choice != 0)
				break;
		//System.out.println("choice is " + choice);
		int temp = choice;
		choice = 0;
		return temp;
	}
	
	public String RequestText(String[] t)
	{
		class Action implements ActionListener
		{
			int r;
			
			public Action(int a)
			{
				super();
				r = a;
			}
			
			public void actionPerformed(ActionEvent event)
			{
				choice = r;
			}
			
			public void setR(int a)
			{
				r = a;
			}
		}
		for(int i = 0; i <= (text.length - 1 -t.length); i++)
		{
			text[i].setText(text[i + t.length].getText());
			text[i].setForeground(Color.GRAY);
		}
		
		for(int i = 0; i < t.length; i++)
		{
			text[(text.length - 1) - (t.length - 1 - i)].setText(t[i]);
			text[(text.length -1) - (t.length - 1 - i)].setForeground(Color.RED);
		}
		
		mainJP.remove(buttonJP);
		buttonJP = new JPanel();
		
		JTextField jtf = new JTextField(20);
		buttonJP.add(jtf);

		JButton jb = new JButton("Submit");
		jb.addActionListener(new Action(1));
		
		buttonJP.add(jb);
		
		mainC.gridx = 1;
		mainC.gridy = 1;
		
		mainJP.add(buttonJP, mainC);
		
		mainJP.updateUI();
		
		while(choice == 0)
			if(choice != 0)
				break;
		
		String temp = jtf.getText();
		choice = 0;
		return temp;
	}
	
	public void wait(int n)
	{
		class Action implements ActionListener
		{
			int r;
			
			public Action(int a)
			{
				super();
				r = a;
			}
			
			public void actionPerformed(ActionEvent event)
			{
				choice = r;
			}
			
			public void setR(int a)
			{
				r = a;
			}
		}
		mainJP.remove(buttonJP);
		String[] t = {"..."};
		
		for(int j = 0; j < n; j++)
		{
			for(int i = 0; i <= (text.length - 1 -t.length); i++)
			{
				text[i].setText(text[i + t.length].getText());
				text[i].setForeground(Color.GRAY);
			}
			
			for(int i = 0; i < t.length; i++)
			{
				text[(text.length - 1) - (t.length - 1 - i)].setText(t[i]);
				text[(text.length -1) - (t.length - 1 - i)].setForeground(Color.RED);
			}
			
			try
	   	    {
	   	       Thread.sleep(500);
	   	    }
	   	    catch (InterruptedException ex)
	   	    {
	   	       Thread.currentThread().interrupt();
	   	    }
		}
		buttonJP = new JPanel();
		mainC.gridx = 1;
		mainC.gridy = 1;
		mainJP.add(buttonJP, mainC);
	}
	
	public void updtAll(Player p)
	{
		prof.update(p);
		for(int i = 0; i < 3; i++)
		{
			bars[i].updateValue(p, i);
		}
		pots.update(p);
		
		brd.update();
	}
	public void resetInput()
	{
		jtf.setText("");
	}
	public void clearall()
	{
		mainJP.remove(buttonJP);
		buttonJP = new JPanel();
		
		mainC.gridx = 1;
		mainC.gridy = 1;
		
		mainJP.add(buttonJP, mainC);
		for(JLabel l : text)
		{
			l.setText("");
		}
		
	}
	public void townScript() //causes explosions, use with caution
	{
		int k = 0;
		String[] tsPotsT = {"Would you like to buy something?"};
		String[] tsPotsB = {"Health (a)", "Mana (s)","Stat Boost (d)", "No (f)"};
		//System.out.println("incoming!");
		mainJP.updateUI();
		updtAll(JavaRPG_infinite.player);
		
		while(k < 4)
		{
			//System.out.println("Well, here goes nothing!");
			if(JavaRPG_infinite.player.getCoins() < 50)
			{
				tsPotsT[0] = "I'm sorry, you don't have enough coins to buy anything";
				tsPotsB = new String[1];
				tsPotsB[0] = "Continue (a)";
			}
			else if(JavaRPG_infinite.player.getCoins() < 200)
			{
				tsPotsB[2] = "!" + tsPotsB[2];
			}
			k = JavaRPG_infinite.g.DispText(tsPotsT, tsPotsB);
			if(JavaRPG_infinite.player.getCoins() < 50)
				k = 6;
			//System.out.print(" what? not yet?");
			if(k == 1)
			{						
				JavaRPG_infinite.player.getHealthPotion();
			}
			else if(k == 2)
				JavaRPG_infinite.player.getManaPotion();
			if(k == 1 || k == 2)
			{
				JavaRPG_infinite.player.setCoins(JavaRPG_infinite.player.getCoins() - 50);
			}
			if(k == 3)
			{
				Player tp = JavaRPG_infinite.player;
				JavaRPG_infinite.player.setAttack(tp.getAttack() + 1);
				JavaRPG_infinite.player.setDefense(tp.getDefense() + 1);
				JavaRPG_infinite.player.setVitality(tp.getVitality() + 1);
				JavaRPG_infinite.player.setSpeed(tp.getSpeed() + 1);
				
				JavaRPG_infinite.player.setCoins(JavaRPG_infinite.player.getCoins() - 200);
			}
			//System.out.println("I'm very confused right now");
		}
		brd.setState(0);
		
	}
	
	public String[] fiftychar(String[] txt, int n)
	{
		String tem = "";
		for(String x: txt)
			tem += x + " ";
		
		ArrayList<String> a = new ArrayList<String>();
		String q = "";
		
		for(int i = 0; i < tem.length(); i++)
		{
			if(tem.substring(i, i+1).equals(" "))
			{
				a.add(q); 
				q = "";
			}
			else
				q+= tem.substring(i, i+1);
		}
		
		ArrayList<String> b = new ArrayList<String>();
		tem = "";
		
		for(int i = 0; i < a.size(); i++)
		{
			String m = tem + " " +  a.get(i);
			if(m.length() > n)
			{
				b.add(tem);
				tem = "";
				i--;
			}
			else
				tem = m;
			
			if(i == a.size() - 1)
				b.add(tem);
		}
		for(int i = 0; i < b.size(); i++)
		{
			if(b.get(i).substring(0,1).equals(" "))
				b.set(i,b.get(i).substring(1));
			if(b.get(i).length() < n-1)
			{
				while(b.get(i).length() < n-1)
				{
					tem = " " + b.get(i) + " ";
					b.set(i, tem);
				}
			}
		}
			
		
		txt = new String[b.size()];
		for(int i = 0; i < b.size(); i++)
		{
			txt[i] = b.get(i);
		}

		
		return txt;
	}
}
