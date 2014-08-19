package classes;

import Stuff.Equipment;
import basics.Enemy;
import basics.Player;
import java.util.ArrayList;

public class Mage extends Player 
{
	public Mage() 
	{
		super(); 
		
		setMaxHp(120);
		setHp(getMaxHp());
		setAttack(8);
		setDefense(0);
		setMaxMana(140); //all attacks (-bludgeon?) cost mana
		setMana(getMaxMana());
		setSpeed(10);
		setVitality(1); //heal spell?
		setCoins(100);
		setLevel(1);
		setIntel(10); //You are one smart cookie :D
		
		setAlive(true);
	}
	
	public void levelUp()
	{
		setLevel(getLevel() + 1);
		setMaxHp(getMaxHp() + 12);
		setHp(getMaxHp());
		setAttack(getAttack() + 2);
		setDefense(getDefense() + 1);
		setMaxMana(getMaxMana() + 35);
		setMana(getMaxMana());
		setSpeed(getSpeed() + 1);
		setVitality(getVitality() + 0.334);
		setIntel(getIntel() + 4); //You like to study
			System.out.println("You feel a small sense of accomplishment as you transcend reality.\nYou gained a level.");
	}
	
	public ArrayList<String> MagicAttack(Enemy e)
	{
		ArrayList<String> resp = new ArrayList<String>();
		
		if(getMana() < 30 + (5*getLevel()))
		{
			resp.add("\nYou don't have enough mana, you wasted a turn, Einstein.");
		}
		else
		{
			int a = (5*getIntel() - e.getDefense()); //holy crap that's heavy damage :D
			setMana(getMana() - (30 + (5*getLevel())));
			if(a <= 0)
				a = 1;
			
			String resp1 = ("\nYou throw a huge fireball at the level " + e.getLevel() + " " + e.getName() + 
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
