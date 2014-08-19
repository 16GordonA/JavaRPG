package classes;

import Stuff.Equipment;
import basics.Enemy;
import basics.Player;
import java.util.ArrayList;

public class Warrior extends Player 
{
	public Warrior() 
	{		
	   super();	
		
	   setMaxHp(250);
	   setHp(getMaxHp());
	   setAttack(35);
       setDefense(0);
	   setMaxMana(40);
	   setMana(getMaxMana());
	   setSpeed(7);
	   setVitality(4);
	   setCoins(100);
	   setLevel(1);
	   setIntel(1); //You are stupid :P
	   
	   setAlive(true);
	}
	
	public void levelUp()
	{
		setLevel(getLevel() + 1);
		setMaxHp(getMaxHp() + 25);
		setHp(getMaxHp());
		setAttack(getAttack() + 4);
		setDefense(getDefense() + 1);
		setMaxMana(getMaxMana() + 8);
		setMana(getMaxMana());
		setSpeed(getSpeed() + 1);
		setVitality(getVitality() + 0.5);
		setIntel(getIntel() + 1); //you don't get much smarter either
			System.out.println("You feel a small sense of accomplishment as you booty dance with your sword.\nYou gained a level.");
	}
	
	public ArrayList<String> MagicAttack(Enemy e)
	{
		ArrayList<String> resp = new ArrayList<String>();
		
		if(getMana() < 9)
		{
			resp.add("You don't have enough mana, you wasted a turn, Einstein.");
		}
		else
		{
			int a = getIntel() * 10 + getAttack() - e.getDefense();
			setMana(getMana() - 9);
			if(a <= 0)
				a = 1;
			
			String holy = "";
			if(religion.equals("Faith of the 7"))
				holy = "the holy fires of the Smith";
			else if(religion.equals("Lord of Light"))
				holy = "the holy light of R'hllor";
			else if(religion.equals("The Old Gods"))
				holy = "the holy magic of the greenseers";
			else if(religion.equals("The Drowned God"))
				holy = "the holy waters of the Drowned God";
			else if(religion.equals("The Many-Faced God"))
				holy = "the holy mystery of the Faceless Men";
			else if(religion.equals("none"))
				holy = "the holy sublimation of dry ice";
			
			String resp1 = ("\nYou use your magical powers to imbue your sword with " + holy + ".");
			String resp2 = ("You strike the level " + e.getLevel() + " " + e.getName() + 
					" dealing " + a + " damage.");
			
			e.setHp(e.getHp() - a);

			if(e.getHp() <= 0)
				e.setHp(0);
			
			String resp3 = ("The level " + e.getLevel() + " " + e.getName() + 
					" has " + e.getHp() + " HP left");
			
			resp.add(resp1); resp.add(resp2); resp.add(resp3);
			
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
		}
		return resp;
	}
}
