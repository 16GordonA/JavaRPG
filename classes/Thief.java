package classes;

import Stuff.Equipment;
import basics.Enemy;
import basics.Player;
import java.util.ArrayList;

public class Thief extends Player
{
	public Thief() 
	{
		super();
		
		setMaxHp(150);
		setHp(getMaxHp());
		setAttack(15);
		setDefense(0);
		setMaxMana(60);
		setMana(getMaxMana());
		setSpeed(25);
		setVitality(3);
		setCoins(100);
		setLevel(1);
		setIntel(2); //Unlike some people this isn't an insult, you just aren't magical
	    
	   setAlive(true);
	}
	
	public void levelUp()
	{
		setLevel(getLevel() + 1);
		setMaxHp(getMaxHp() + 15);
		setHp(getMaxHp());
		setAttack(getAttack() + 2);
		setDefense(getDefense() + 1);
		setMaxMana(getMaxMana() + 10);
		setMana(getMaxMana());
		setSpeed(getSpeed() + 3);
		setVitality(getVitality() + 0.5);
		setIntel(getIntel() + 1);
			System.out.println("You feel a small sense of accomplishment as you throw a dagger through a tree.\nYou gained a level.");
	}
	
	public ArrayList<String> MagicAttack(Enemy e)
	{
		ArrayList<String> resp = new ArrayList<String>();
		
		if(getMana() < 9)
		{
			resp.add("\nYou don't have enough mana, you wasted a turn, Einstein.");
		}
		else
		{
			int a = getAttack() + (4*getIntel()) - e.getDefense();
			setMana(getMana() - 8);
			if(a <= 0)
				a = 1;
			
			String resp1 = ("\nYou throw a magically imbued dagger at the level " + e.getLevel() + " " + e.getName() + 
					" dealing " + a + " damage.");
			
			e.setHp(e.getHp() - a);
			
			if(e.getHp() <= 0)
				e.setHp(0);
			
			String resp2 = ("The level " + e.getLevel() + " " + e.getName() + 
					" has " + e.getHp() + " HP left");
			
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
		}
		return resp;
	}
}
