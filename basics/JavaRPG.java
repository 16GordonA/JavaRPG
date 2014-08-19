package basics;

/**
 *DISCLAIMER: Any characters in this story bearing any resemblance to people, living or dead, is completely coincidental
 *DISCLAIMER: Akiva Gordon and the Akiva Gordon Corporation are not responsible for any actions the player might take in this game
 *
 *A young man named Akiva Gordon went along and killed an evil goblin 
 *The goblin had been terrorizing the peaceful land of Toreador
 *The Toreadorians were overjoyed at Akiva's victory and held a feast
 *Akiva prepared a puppet show for the climax of the feast
 *Just when he was about to do his show, aliens attacked
 *They came down and infected the land of Toreador with a specialized virus
 *Akiva and some others ran away to the land of Westonia, but most were killed by the savage invaders
 *And so our story begins!
 *
 *You are Akiva Gordon! You must pick a skill set and free the land of Toreador from the evil Aliens
 *
 *~The Creators, Akiva Gordon and Andrew Li
 *
 *
 *
 *
 *     P.S.
 *        You won't have nightmares over this. Really. =D
 *        
 *     OR WILL YOU???
 *
 */

import graphics.JRPGraphics;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import classes.*;
import Stuff.*;
import basics.*;

import java.lang.InterruptedException;

public class JavaRPG 
{	
	static String[] c = {"Continue"};
	static String[] f = {"FIGHT"};
	public static Player player = new Player();
	public static JRPGraphics g = new JRPGraphics();
	
	public static void main(String[] args) 
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
		
		JFrame mainJF = new JFrame("Java RPG");
		mainJF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainJP;
		
		String name;
		String[] btcd = {"Speak the beta code and enter: (not case sensitive)"};
		String q = g.RequestText(btcd);
		boolean mg = false;
		boolean beta = false;
		boolean srishti = false;
		boolean joanna = false;
		boolean andrewLi = false;
		if(q.toLowerCase().equals("mellogoth")) //read http://xkcd.com/1218/
		{
			mg = true;
			beta = true;
		}
		else if(q.toLowerCase().equals("sn0rl4x"))
		{
			beta = true;
		}
		else if(q.toLowerCase().equals("um..."))
		{
			beta = true;
			srishti = true;
		}
		else if(q.toLowerCase().equals("maki"))
		{
			beta = true;
			joanna = true;
		}
		else
			beta = false;
		
		int shrtlng = 5;
		
		if(beta)
		{
			String[] bT = {"","That is one of the correct code(s), Beta-Tester version is enabled", ""};
			
			if(mg)
			{
				bT[0] = "\"mellogoth\" why would you even try that????";
				bT[1] = "But yeah, that is one of the correct code(s), Beta-Tester version is enabled.";
				bT[2] = "There is also an additional item in the shop for you";
			}
			
			g.DispText(bT, c);
			
			String[] solT = {"Would you like to play the shortened version (no arena)?"} ;
			String[] solB = {"Yes", "No"};
			shrtlng = g.DispText(solT, solB);
			if(shrtlng == 2)
				shrtlng = 5;
		}
		else
		{
			String[] bT = {"Sorry, but \""+ q.toLowerCase() + "\" is not one of the correct code(s), Standard version is enabled"};
			
			g.DispText(bT, c);
		}
		
		String[] rT = {"Please select your religion:"};
		String[] rB = {"Faith of the 7", "Lord of Light", "The Old Gods", "The Drowned God", "The Many-Faced God" ,"none"};
		
		int relig = g.DispText(rT, rB);
		
		
		
	       Scanner sc = new Scanner(System.in);
	       if(!srishti && !joanna)
	       {
		       String[] nm = {"What is your name?"};
		       
		       name = g.RequestText(nm);
		       g.wait(1);
	   	       String w = name.toLowerCase();
	   	       String[] ts = new String[2];
	   	       
	   	       if((w.equals("akiva gordon")))
	   	       {
	   	    	   ts[0] = "Akiva Gordon is a fine name,"; ts[1] = "Ellis Island says you can keep it!";
	   	       }
	   	       else if(w.equals("andrew li"))
	   	       {
	   	    	   ts[0] = "The Ellis Island people fall off their chairs laughing at your ridiculous name."; 
	   	    	   ts[1] = "Your name is unchanged as you slowly back out of the room.";
	   	    	   andrewLi = true;  	    	   
	   	       }
	   	       else
	   	       {
	   	    	   ts[0] = name + " eh? Hmm..." ; ts[1] = "Ellis Island says that your name is now \"Akiva Gordon\"";
	   	       }
	   	          	       
	   	       g.DispText(ts, c);
	       }
   	       /**mainJF.setSize(350, 125);
   	       JLabel jl2 = new JLabel(name + " eh? Hmm...");
   	       JLabel jl3 = new JLabel("Elis Island says that your name is now \"Akiva Gordon\"");
   	       JButton jb2 = new JButton("Continue");
   	       jb2.addActionListener(new Action(1));
   	       
   	       mainJP = new JPanel();
   	       mainJP.add(jl2); mainJP.add(jl3); mainJP.add(jb2);
   	       
   	       mainJF.add(mainJP);
   	       mainJF.setVisible(true);
   	       
	       while(choice == 0)
	       {
	    	   if(choice != 0)
	    		   break;
	       }
	       choice = 0;
	       mainJF.remove(mainJP);
	       mainJF.setVisible(false);*/
   	       if(srishti)
   	    	   name = "Srishti Lulla";
   	       else if(joanna)
   	    	   name = "Joanna Tao";
   	       else if(andrewLi)
   	    	   name = "Andrew Li";
   	       else
   	    	   name = "Akiva Gordon the Derp";
   	       
	       
	       String[] classT = new String[4];
	       classT[0] = ("Welcome to the land of Westonia, " +name+ ". In front of you lie 4 weapons.");
	       classT[1] = ("You consider taking all of them, but then realize that you aren't strong enough.");
	       classT[2] = ("Actually, it doesn't matter, 'cause once you take one, the others'll disapear forever.");
	       classT[3] = ("Please choose a weapon to pick up:");
	       
	       String[] classB = {"Staff (Mage)","Sword (Warrior)","Bow (Archer)", "Dagger (Thief)" };
	       
	       choice = g.DispText(classT, classB);

	       if (choice == 1)
	       {
	       	   player = new Mage();
	       }
	       else if (choice == 2)
	       {
	    	   player = new Warrior(); 
	       }
	       else if (choice == 3)
	       {
	    	   player = new Archer(); 
	       }
	       else
	       {
	    	   player = new Thief(); 
	       }
	       
	       player.setRelig(rB[relig - 1]);
	       
	       choice = 0;
	       g.updtAll(player);

	       /**
	       Enemy goblin1;
	       goblin1 = new Enemy(1, "Goblin");
	       
	       System.out.println("You encounter a wild goblin!");
	       
	       fight(player, goblin1);
	       
	       Enemy[] monsters = {};//{new Enemy(1, "Goblin"), new Enemy(1, "Goblin"), new Enemy(1, "Goblin")};
	       
	       for(int i = 0; i < monsters.length ; i ++)
	       {
	    	   fight(player, monsters[i]);
	       }
	       
	       
	       if(player.getAlive() == true)
	    	   System.out.println("YOU WIN!!!");
	        */
	       
           Enemy enemy1;      
           
           ArrayList<String> easterEggEnemylist = new ArrayList<String>();
           ArrayList<String> enemylist = new ArrayList<String>();    
           
           easterEggEnemylist.add("Dr. Korsunsky");
           easterEggEnemylist.add("Mr. Banker");
           easterEggEnemylist.add("Chuck Norris");
           easterEggEnemylist.add("Enormous [REDACTED]");     

           enemylist.add("wild Goblin");
           enemylist.add("HobGoblin");
           enemylist.add("Giant Cockroach");
           enemylist.add("Elf");
           enemylist.add("wild Akiva");
           enemylist.add("Giant Spider");
           enemylist.add("wild Andrew");
           enemylist.add("Large Akiva");
           enemylist.add("Demonic Duck");
           if(andrewLi == true)
        	   enemylist.add("Enormous [REDACTED]");
	   if(name.equals("Akiva Gordon the Derp"))
		   enemylist.add("Ms. Gordon");
           
           
           enemy1 = new Enemy(1, "Goblin");
           
           String[] ffT = {("You encounter a wild " + enemy1.getName() + "!")};
           g.DispText(ffT, f);
           
           fight(player, enemy1, 0, 0);

           if (player.getAlive() == true)
           {
        	   String[] pffT = new String[3];
        	   
        	   pffT[0] = ("After you kill the goblin, several people come out of the trees and thank you.");
        	   pffT[1] = ("They tell you that this goblin has been terrorizing them for years...");
        	   pffT[2] = ("They put you in an arena so that you can become sufficiently powerful to save the land of Toreador");
        	   
        	   g.DispText(pffT, c);
           }
           
           else
           {
        	   mainJF.setSize(75, 125);
        	   mainJP = new JPanel();
        	   
               String[] fflT = {"You died!"};
               String[] fflB = {"GAME OVER"};
               
               g.DispText(fflT, fflB);
                              
               System.exit(1);
           }
           
           String en;
           int killed = 0;

           while(player.getLevel() < shrtlng)
           {
        	   en = enemylist.get((int)(Math.random() * enemylist.size()));
        	   enemy1 = new Enemy(player.getLevel(), en);
               
               String[] arnT = {("You encounter a " + enemy1.getName() + "!")};
               g.DispText(arnT, f);
               
               fight(player, enemy1, killed, 120);

               if (player.getAlive() == true)
               {
            	   killed++;
            	   
            	   String[] arn2T = new String[3];
            	   arn2T[0] = ("You have killed another enemy!");
            	   arn2T[1] = ("You have "+ (59 - killed) + " enemies left");
            	   arn2T[2] = ("You are level " + player.getLevel() + " with " + player.getHp() + " hitpoints left");

            	   g.DispText(arn2T, c);
               }
               
               else
               {
                   lose();
               }
           }
           if(shrtlng == 1)
        	   while(player.getLevel() < 5)
        		   player.levelUp();
           
           g.updtAll(player);
           
           String[] parnT = new String[4];
           
           parnT[0] = ("You come out of the arena and the townspeople are quite surprised that you are alive");
           parnT[1] = ("\"You are the first adventurer in days to survive that!\"");
           parnT[2] = ("You assume a heroic stance and they start throwing flowers");
           parnT[3] = ("In exchange for your further help, they offer you elite training:");
           
           String[] parnB = {("DPS (Dmg + Spd)"),"Tank (Amr + Vit)",("Magic (Mna + Int)")};
           		
           choice = g.DispText(parnT, parnB);
           
           if(choice == 1)
           {
        	   player.setAttack(player.getAttack() + 5);
        	   player.setSpeed(player.getSpeed() + 3);
           }
           else if(choice == 2)
           {
        	   player.setDefense(player.getDefense() + 3);
        	   player.setVitality(player.getVitality() + 3);
           }
           else
           {
        	   player.setMaxMana(player.getMaxMana() + 60);
        	   player.setMana(player.getMana() + 60);
        	   player.setIntel(player.getIntel() + 3);
           }
           
           g.updtAll(player);
           
           choice = 0;
           
           for(int i = 0; i < 5; i++)
           {
        	   player.getHealthPotion();
        	   player.getManaPotion();
           }
           
           String[] forkT = {"They also give you some extra potions.", "You come to a fork in the road. Which way would you like to go?"};
           String[] forkB = {"Left", "Right", "Up"};
           
           int n = g.DispText(forkT, forkB);
           /**System.out.println("They also give you some extra potions.");
           System.out.println("You come to a fork in the road. Which way would you like to go?");
           System.out.printf("1) Left \n 2) Right \n 3) Up");
           int n = sc.nextInt();*/

           try
           {
               if(n == 3)
               {
                   String[] upT = {"You cannot fly, son!", "Pick another direction"};
                   String[] upB = {"Left", "Right"};
                   n = g.DispText(upT, upB);
               }
        	   
               if (n == 1)
               {
                   String[] LeftT = {"You go left.", "You see a town up ahead, and gratefully head for shelter."};
            	   
            	   g.DispText(LeftT, c);
               }

               else if (n == 2)
               {
            	   String[] RightT = {"You see a lake ahead. It seems like a nice place to rest and recover after your fight.", "You have arrived at the lake. What would you like to do?"};
            	   String[] RightB = {"Look for food", "Take a poop", "Swim across the lake"};               
                   
                   n = g.DispText(RightT, RightB);

                   if (n == 1)
                   {
                	   player.getHealthPotion();
                       String[] foodT = {"You find a small HP Potion!" ,"Now you head across the lake, where there seems to be a town."};
                       
                       g.DispText(foodT, c);
                   }
                   else if (n == 2)
                   {
                	   player.gainXP(10);
                   	   String[] poopT = {"You take a poop, and are satisfied with the results.", "You proceed to swim across the lake."};
                   	   g.updtAll(player);
                   	   g.DispText(poopT, c);
                   }
                   else
                   {
                   	   String[] swimT = {"You swim across the lake.",  "It is very very cold, but you make it without dying of hypothermia or being eaten by an Akiva."};
                   	   
                   	   g.DispText(swimT, c);
                   }
               }              
               String[] townT = {"You arrive at a town and see that there is a market. You also see a bunch of beggars on the street."};// Do you want to 1) go to the beggars or 2) go to the market"};
               String[] townB = {"Go to Beggars", "Go to Market"};
           	   n = g.DispText(townT, townB);
           	   if (n == 1)
           	   {
           	       String[] begT = {"Approaching the suspicious beggars, you begin to ask them if they want some money",  "when the closest one bludgeons you with a bludgeon and the world goes dark."};
           	       g.DispText(begT, c);
           	       for(int i = 0; i < 3; i++)
           	       {
	           	       g.wait(2);
           	       }
           	       String[] tmT = {"\"Welcome to the order of the Twilight Mountain,\"","calls a soft voice as you come to your senses.", "", "", ""};
           	   	   //story from this point on involves him joining a secret society to fight against the Empire.	
           	       tmT[2] = ("\"We would like to give you the symbol of our order\"");
           	       tmT[3] = ("A woman steps forward, her face hidden,");
           	       tmT[4] = ("and offers you a bronze coin engraved with a howling wolf");
           	       String[] tmB = {"Take the Coin", "Reject the gift like an idiot"};
           	       choice = g.DispText(tmT, tmB);
           	       if(choice == 1)
           	       {
           	    	   player.setFCoins(player.getFCoins() + 1);
           	    	   
           	    	   String[] ttcT = {("You gladly accept the faction coin"),("The witch smiles and leads you to the main hall")};
           	    	   g.DispText(ttcT, c);
           	    	   
           	       }
           	       else
           	       {
           	    	   String[] rtcT = {("You politely refuse the offer. \"You do not wish to accept my gift?\"")};
           	    	   String[] rtcB = {"Yes, you and your faction are stupid\"", "\"No, I simply am too weak to carry all of these coins and equipment\""};
           	    	   choice = g.DispText(rtcT, rtcB);
           	    	   if(choice == 1)
           	    	   {
           	    		   String[] sfT = {"The enraged witch punches you in the face", "and shoves the coin into your hand."};
           	    		   g.DispText(sfT, c);
           	    		   player.setHp(player.getHp() - 5);
           	    		   player.setFCoins(player.getFCoins() + 1);

           	    		   g.wait(2);
	 	           	       
	 	           	       String[] sfT2 = {"You awake in a small room", "and a guard drags you to the main hall"};
	 	           	       g.DispText(sfT2, c);
           	    	   }
           	    	   if(choice == 2)
           	    	   {
           	    		   String[] twT = {"\"I am sorry, I will imbue you with extra strength to carry the weight\"", ""};
           	    		   twT[1] = ("The witch casts a spell, hands you the coin and leads you to the main hall");
           	    		   
           	    		   g.DispText(twT, c);
           	    		   player.setFCoins(player.getFCoins() + 1);
           	    	   }
           	       }
           	    g.wait(2);
	    		
	    		String[] mhT = {"Upon arriving in the main hall, you look up and see an elaborately dressed man standing on a speakers' platform", "", "" , ""};
	    		mhT[1] = "\"...And most of all, remember why we are here- TO TAKE DOWN THE EMPIRE!!!\"";
	    		mhT[2] = "\nThe crowd erupts in cheers until they are quieted down by the speaker";
	    		mhT[3] =	"\n\"All recruits please report to the training facilities.\"";
	    		
	    		g.DispText(mhT, c);
	    		
	    		String[] tdT = {"You look down and see that your clothes have been changed to a simple white robe with a howling wolf insignia.", "", ""};
	    		tdT[1] = "\nYou decide to follow the similarly garbed figures streaming through the righthand door.";
	    		tdT[2] = ("They decide to start by having you fight with a training dummy");
	    		String[] tdB = {"Fight"};
	    		
	    		g.DispText(tdT, tdB);
	    		
	    		fight(player, new Enemy(10, "Training Dummy", 1000, 0, 0, 1, 0), 0 , 0);
	    		
	    		String[] tdpfT = {"The massive straw dummy lying hacked on the floor, they deem your skills sufficient to face a real foe", ""}; 
	    		tdpfT[1] = "\nYou look and see a young man, green as grass coming toward you... This ain't gonna be pretty";
	    		
	    		g.DispText(tdpfT, tdB);
	    		
	    		fight(player, new Enemy(3, "Young Recruit"), 0, 0);
	    		if(!player.getAlive())
	    		{
	    			lose();
	    		}
	    		
	    		String[] yrT = {"You look down at his bloodstained cloak and begin to weep,", "", "", "", ""};
	    		yrT[1] = "your tears are only staunched when the battlemaster comes forward and points out that it could have been you";
	    		yrT[2] = "He leads you back to your quarters where a red soldiers' cloak lies, neatly folded, on your bed";
	    		yrT[3] = "You may not like it, but there seems to be only one way to gain prestige here.";
	    		yrT[4] = "You also pick up an envelope containing 10 faction coins- your first paycheck!";
	    		
	    		g.DispText(yrT, c);
	    		player.setFCoins(player.getFCoins()+10);
        
	    		end();
           	   }
           	   else if (n == 2)
           	   {
           		   if(player.getCoins() >= 30)
           		   {
           			   String[] tmp = {};
	           	       String[] bwT = {"You decide to avoid the sketchy beggars and go to the market instead.", "What would you like to buy (only one)?"};
	           	       if(mg)
	           	       {
	           	    	   String[] bwB = {"Solstice Staff", "Bow of the Huns" ,"Blade of Nababa", "Ninchaku of Heavenly Rage", "Elvish Mellon-Chucker", "Nothing"};
	           	    	   tmp = bwB;
	           	       }
	           	       else
	           	       {
	           	    	   String[] bwB = {"Solstice Staff", "Bow of the Huns" ,"Blade of Nababa", "Ninchaku of Heavenly Rage", "Nothing"};
	           	    	   tmp = bwB;
	           	       }
	           	    	   
	           	   	   n = g.DispText(bwT, tmp);
	           	   	   if (n == 1)
	           	   	   {
	           	   		   String[] ssT = {"You hand over 30 coins."};
	           	   	   	   g.DispText(ssT ,c);
	           	   	   	   Equipment e = new Equipment("Solstice Staff", 0, 4, 0, 1, 0);
	           	   	   	   player.changeW(e);           	   	  
	           	   	   	   player.setCoins(player.getCoins() - 30);
	           	   	   }
	           	   	   else if (n == 2)
	           	   	   {
	           	   	   	   String[] bhT = {("You hand over 30 coins.")};
	           	   	   	   g.DispText(bhT, c);
	           	   	   	   Equipment e = new Equipment("Bow of the Huns", 0, 6, 0, 2, 0);
	           	   	   	   player.changeW(e);
	           	   	   	   player.setCoins(player.getCoins() - 30);
	           	   	   }
	           	   	   else if (n == 3)
	           	   	   {
	           	   	   	   String[] bnT = {"You hand over 30 coins."};
	           	   	   	   g.DispText(bnT, c);
	           	   	   	   Equipment e = new Equipment("Blade of Nabababa", 0, 8, 1, 0, 0);
	           	   	   	   player.changeW(e);  
	           	   	   	   player.setCoins(player.getCoins() - 30);
	           	   	   }
	           	   	   else if (n == 4)
	           	   	   {
	           	   	   	   String[] nhrT = {"You hand over 30 coins."};
	           	   	   	   g.DispText(nhrT, c);
	           	   	   	   Equipment e = new Equipment("Ninchaku of Heavenly Rage", 0, 4, 0, 0, 3);
	           	   	   	   player.changeW(e);  
	           	   	   	   player.setCoins(player.getCoins() - 30);
	           	   	   }
	           	   	   else if (n == 5)
	           	   	   {
	           	   		   if(mg)
	           	   		   {
		           	   		   String[] eccT = {"You hand over 30 coins."};
		           	   		   g.DispText(eccT, c);
		           	   		   Equipment e = new Equipment("Elvish Mellon-Chucker", 0, 20, 20,5,5);
		           	   		   player.changeW(e);  
		           	   	   	   player.setCoins(player.getCoins() - 30);
	           	   		   }
	           	   		   else
	           	   		   {
	           	   			   String[] ntngT = {("So you don't want to buy anything, fine.")};
		           	   		   g.DispText(ntngT, c); 
	           	   		   }
	           	   	   }
	           	   	   else 
	           	   	   {
	           	   		   String[] ntngT = {("So you don't want to buy anything, fine.")};
	           	   		   g.DispText(ntngT, c);
	           	   	   }
	           	   	   g.updtAll(player);
	           	       g.wait(2);
           		   }
           	       String[] eT = {"You see a poster for the Empire's army, and feel like joining.", "\"Where do I go to join the army?\" you ask the shop owner." , "He points in the direction of the castle.", "", "",""};
           	       eT[3] = ("You take the road to the castle, knock on the gate and announce your wishes to join");
           	       eT[4] = ("The gateguard gives you a small bronze token engraved with a flying swallow and directs you to the keep");
           	       eT[5] = ("Upon arriving at the keep, you look up and see an elaborately dressed man on a speakers' platform");
           	       
           	       g.DispText(eT, c);
           	       player.setFCoins(player.getFCoins() + 1);
           	   
           	       end();
           	   }
           }

           catch (InputMismatchException ex)
           {
        	   JFrame chtrJF = new JFrame("I WARNED YOU!!!");
        	   chtrJF.setSize(200, 100);
        	   chtrJF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	   
        	   JPanel chtrJP = new JPanel();
        	   
               JLabel chtr = new JLabel("You die for not inputting the right things.");
               
               Action chtrA = new Action(1);
               chtrA.setR(1);
               
               JButton chtrJB = new JButton("GAME OVER");
               chtrJB.addActionListener(chtrA);
               
               chtrJP.add(chtr); chtrJP.add(chtrJB);
               chtrJF.add(chtrJP);
               chtrJF.setVisible(true);
               
               choice = 0;
               while(choice == 0)
            	   if(choice != 0)
            		   break;
               
               System.exit(1);
           }
      }
	        
	static int choice = 0;
	public static void fight(Player p, Enemy e, int qp, int qt)
	{
		
		
		int steps = 0;
		choice = 0;
		ArrayList<String> t;
		
	    while(e.getAlive() && p.getAlive())
	    {    	
	    	
	    	if(steps % (100 / p.getSpeed()) == 0)
	    	{
	    		String[] chacT = {};
	    		String[] chacB = {"ATTACK", "MAGIC", "HEAL"};
	    		
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
	    		
	    		if(e.getAlive() == false)
	    		{
	    			p.gainXP(e.getLevel()* 2);
	    			break;
	    		}
	    	}
	    	   
	    	if(steps % (100 / e.getSpeed()) == 0)
	    	{
	    		t = e.attack(p);
	    		String[] cmbtT = new String[t.size()];
		    	
		    	for(String q : t)
		    	{
		    		cmbtT[t.indexOf(q)] = q;
		    	}
		    	
		    	g.DispText(cmbtT, c);
	    	}
	    	
	    	g.updtAll(p);
	    	
	    	steps++;
	    }
	    
	    g.updtAll(p);
	}
	public static void lose()
	{
		String[] lT = new String[2];

		lT[0] = ("As your corpse is taken away, your spirit rises up only to be pulled back to Toreador");
		lT[1] = ("The people there spit through your shadowy image and burn your effigy.");
		
		String[] lB = {("GAME OVER")};
		g.DispText(lT, lB);
		
		System.exit(1);
	}
	public static void end()
	{
		
		String[] eT = new String[3];
		
		eT[0] = ("You have come to code's end. There is no more at the moment...");
		eT[1] = ("Feel free to play again, make new choices, make new friends,");
		eT[2] = ("and alienate the ones standing outside your window waiting for you to finish \"just one more game\"");
		
		String[] eB = {"GAME OVER"};
		
		g.DispText(eT, eB);
		
		System.exit(1);
	}
}
