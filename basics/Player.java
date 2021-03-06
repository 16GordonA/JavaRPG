package basics;

import Stuff.*;
import classes.*;
import java.util.ArrayList;

public class Player 
{
	protected String religion;
	private int maxHP;
	private int hp;
	private int attack;
	private int defense;
	private int maxMana;
	private int mana;
	private int speed;
	private double vitality;
	private int coins;
	private int level;
	private int intelligence;
	private int experience;
	private int healthPotions = 0;
	private int manaPotions = 0;
	private int factionCoins = 0;
	
	private Equipment headgear;
	private Equipment armor;
	private Equipment footgear;
	private Equipment weapon;
	
	private boolean alive;

	public Player() 
	{
		religion = "none";
		maxHP = 100;
		hp = maxHP;
	    attack = 10;
	    defense = 0;
	    maxMana = 50;
	    mana = maxMana;
	    speed = 10;
	    vitality = 1;
	    coins = 0;
	    level = 1;
	    healthPotions = 3;
	    manaPotions = 3;
	    
	    headgear = new Equipment("headgear", 0);
	    armor = new Equipment("armor", 0);
	    footgear = new Equipment("footgear", 0);
	    weapon = new Equipment("weapon", 0);
	    

	}
	
	public ArrayList<String> heal()
	{
		ArrayList<String> q = new ArrayList<String>();
		
		int test = 5;
		
		int a = (int)(vitality*intelligence);
		if(a < 10*vitality)
			a = (int) (10*vitality);
		hp += a;
		if(hp > maxHP)
			hp = maxHP;
		
		q.add("You meditate and manage to heal " + a + " HP points.");
		
		return q;
	}
	
	public ArrayList<String> attack(Enemy e)
	{
		int a = getAttack() - e.getDefense();
		if(a <= 0)
			a = 1;
		
		String action = "";
		String action2 = "";
		
		if(this instanceof Archer)
		{
			action = "shoot";
			action2 = " with an arrow";
		}
		else if(this instanceof Warrior)
		{
			action = "slash";
			action2 = " with your sword";
		}
		else if(this instanceof Thief)
		{
			action = "stab";
			action2 = " with your dagger";
		}
		else if(this instanceof Mage)
		{
			action = "bop";
			action2 = " on the head with your staff";
		}
		
		String resp1 = ("\nYou " + action + " the level " + e.getLevel() + " " + e.getName() + 
			action2 + " dealing " + a + " damage.");
		
		e.setHp(e.getHp() - a);
		
		if(e.getHp() <= 0)
			e.setHp(0);
		
		String resp2 = ("The level " + e.getLevel() + " " + e.getName() + 
				" has " + e.getHp() + " HP left.");
		
		ArrayList<String> resp = new ArrayList<String>();
		resp.add(resp1); resp.add(resp2);
		
		if(e.getHp() == 0)	
		{
			ArrayList<String> temp = e.die(this);
			resp.add(temp.get(0)); resp.add(temp.get(1));
			
			if(e.getDropItem().getName().equals("Coins")){
				this.setCoins(this.getCoins() + e.getDropItem().getValue());
			}
			else if(e.getDropItem().getName().equals("Health potion"))
			{
				this.getHealthPotion();
			}
			else if(e.getDropItem().getName().equals("Mana potion"))
			{
				this.getManaPotion();
			}
			else 
			{
				Equipment eq = e.getDropItem().getEquip();
				if(eq.getName().equals("armor"))
					this.changeA(eq);
				else if(eq.getName().equals("footgear"))
					this.changeFG(eq);
				else if(eq.getName().equals("headgear"))
					this.changeHG(eq);
				else if(eq.getName().equals("weapon"))
					this.changeW(eq);
				
			}
		}
		
		return resp;
	}	
	public String die(Enemy e)
	{
		alive = false;
		
		return ("\nThe level " + e.getLevel() + " " + e.getName() +
				" kills you and you die a horrible death.");
	}
	
	public String getRelig()		{ 	return religion;	 }
	public void setRelig(String a)	{	religion = a;		 }
	public int getMaxHp()           {   return maxHP;     	 }
	public void setMaxHp(int a)     {   maxHP = a;       	 }
	public int getHp()            	{   return hp;     		 }
	public void setHp(int a)      	{   hp = a;       	  	 }
	public int getAttack()        	{   return attack; 		 }
	public void setAttack(int a)  	{   attack = a;    		 }
	public int getDefense()       	{   return defense;  	 }
	public void setDefense(int a) 	{   defense = a;     	 }
	public int getMaxMana()         {   return maxMana;      }
	public void setMaxMana(int a)   {   maxMana = a;         }
	public int getMana()          	{   return mana;       	 }
	public void setMana(int a)    	{   mana = a;        	 }
	public int getSpeed()        	{   return speed;      	 }
	public void setSpeed(int a)  	{   speed = a;         	 }
	public double getVitality()     {	return vitality;   	 }
	public void setVitality(double a){   vitality = a;    	 }
	public int getCoins()         	{   return coins;   	 }
	public void setCoins(int a)  	{   coins = a;       	 }
	public int getFCoins()			{	return factionCoins; }
	public void setFCoins(int a)	{	factionCoins = a;	 }
	public int getLevel()         	{   return level;    	 }
	public void setLevel(int a)   	{   level = a;       	 }
	public boolean getAlive()	  	{	return alive;  		 }	
	public void setAlive(boolean a)	{	alive = a;			 }
	public int getXP()				{ 	return experience;	 }
	public int getIntel()			{ 	return intelligence; }
	public void setIntel(int a)		{ 	intelligence = a;	 }
	public int getHPpot()			{	return healthPotions;}
	public int getMPpot()			{	return manaPotions;  }
	
	public Equipment getHeadgear()	{	return headgear;	 }
	public Equipment getArmor()		{	return armor;		 }
	public Equipment getFootwear()	{	return footgear;	 }
	public Equipment getWeapon()	{	return weapon;		 }
	
	
	public boolean changeHG(Equipment e)
	{
		int check = 0;
		if(e.getDamage() > headgear.getDamage())		check++;
		else if (e.getDamage() < headgear.getDamage())		check--;
		
		if(e.getDefense() > headgear.getDefense())		check++;
		else if(e.getDefense() < headgear.getDefense())		check--;
		
		if(e.getSpeed() > headgear.getSpeed())			check++;
		else if (e.getSpeed() < headgear.getSpeed())		check--;
		
		if(e.getVitality() > headgear.getVitality())	check++;
		else if(e.getVitality() < headgear.getVitality())		check--;
		
		if(check > 0)
		{
			UpdateStats(headgear, e);
			headgear = e;
			return true;
		}
		return false;
		
	}
	public boolean changeA(Equipment e)
	{
		int check = 0;
		check += e.getDamage() - armor.getDamage();
                check += e.getDefense() - armor.getDefense();
                check += e.getSpeed() - armor.getSpeed();
                check += e.getVitality() - armor.getVitality();
		if(check >= 0)
		{
			UpdateStats(armor, e);
			armor = e;
			return true;
		}
		return false;
		
	}
	public boolean changeFG(Equipment e)
	{
		int check = 0;
		if(e.getDamage() > footgear.getDamage())		check++;
		else if(e.getDamage() < footgear.getDamage())		check--;
		
		if(e.getDefense() > footgear.getDefense())		check++;
		else if(e.getDefense() < footgear.getDefense())		check--;
		
		if(e.getSpeed() > footgear.getSpeed())			check++;
		else if(e.getSpeed() < footgear.getSpeed())		check--;
		
		if(e.getVitality() > footgear.getVitality())	check++;
		else if(e.getVitality() < footgear.getVitality())		check--;
		
		if(check > 0)
		{
			UpdateStats(footgear, e);
			footgear = e;
			return true;
		}
		return false;
		
	}
	public boolean changeW(Equipment e)
	{
		int check = 0;
		if(e.getDamage() > weapon.getDamage())		check++;
		else if(e.getDamage() < weapon.getDamage())		check--;
		
		if(e.getDefense() > weapon.getDefense())		check++;
		else if(e.getDefense() < weapon.getDefense())		check--;
		
		if(e.getSpeed() > weapon.getSpeed())			check++;
		else if(e.getSpeed() < weapon.getSpeed())		check--;
		
		if(e.getVitality() > weapon.getVitality())	check++;
		else if(e.getVitality() < weapon.getVitality())		check--;
		
		if(check > 0)
		{
			UpdateStats(weapon, e);
			weapon = e;
			return true;
		}
		return false;
		
	}
	
	public void UpdateStats(Equipment o, Equipment n)
	{
		setAttack(getAttack() - o.getDamage() + n.getDamage());
		setDefense(getDefense() - o.getDefense() + n.getDefense());
		setSpeed(getSpeed() - o.getSpeed() + n.getSpeed());
		setVitality(getVitality() - o.getVitality() + n.getVitality());
	}
	
	public void gainXP(int x)
	{
		experience += x;
		if(experience >= (level * 30))
		{
			experience -= (level * 30);
			levelUp();
		}
	}
	
	public void levelUp()
	{
		//implement in subclasses
	}
	public ArrayList<String> MagicAttack(Enemy e)
	{
		//implement in subclasses
		return new ArrayList<String>();
	}

	public ArrayList<String> drinkHealthPotion()
	{
		ArrayList<String> resp = new ArrayList<String>();
		if(healthPotions > 0)
		{
			if(hp < maxHP)
			{
				hp += (30*level);
				if(hp > maxHP)
					hp = maxHP;
				healthPotions --;
				resp.add("\nYou drink a refreshing glass of red liquid and gain " + 30*level +" HP");
			}
			else
				resp.add("\nYou are already at full life, you cannot drink more health potions now");
		}
		else
		{
			resp.add("\nYou have no health potions. You wasted a turn, Einstein");
		}
		return resp;
		
	}
	public void getHealthPotion()
	{
		healthPotions++;  //this is me being lazy :D
	}//but I think it's good for coding style.
	
	public ArrayList<String> drinkManaPotion()
	{
		ArrayList<String> resp = new ArrayList<String>();
		if(manaPotions > 0)
		{
			if(mana < maxMana)
			{
				mana += 30*level;
				if(mana > maxMana)
					mana = maxMana;
				manaPotions --;
				resp.add("\nYou drink a refreshing glass of blue liquid and gain "+30*level+" MP");
			}
			else
				resp.add("\nYou are already at full mana, you cannot drink more mana potions now");
		}
		else
		{
			resp.add("\nYou have no mana potions. You wasted a turn, Einstein");
		}
		return resp;
	}
	public void getManaPotion()
	{
		manaPotions++;  //this is me being lazy :D
	}



}
