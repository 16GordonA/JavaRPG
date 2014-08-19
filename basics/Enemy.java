package basics;

import Stuff.Item;
import java.util.ArrayList;

public class Enemy extends Player 
{
	private Item dropItem;
	private String name;
	
	public Enemy(int l, String nm)
	{
		setHp(((int)(Math.random() * 100 * l) +50)/5);
		setAttack(((int)(Math.random() * 10 * l) +10)/2);
		setDefense((int)(Math.random() * l)/2);
		setMana((int)(Math.random() * 100 * l));
		setSpeed((int)(Math.random() * 10) +5);
		setVitality(((int)(Math.random() * l))/5);
		setLevel(l);
		
		setAlive(true);
		
		name = nm;
		dropItem = new Item(l);
		
	} 
	public Enemy(int l, String nm, int hp, int atk, int def, int sp, int v)
	{
		setHp(hp);
		setAttack(atk);
		setDefense(def);
		setSpeed(sp);
		setVitality(v);
		setLevel(l);
		
		setAlive(true);
		
		name = nm;
		dropItem = new Item(l);
	}
		
	public ArrayList<String> attack(Player p)
	{
		int a = getAttack() - p.getDefense();
		if(a <= 0)
			 a =1;
			
		String resp1 = ("\nThe level " + getLevel() + " " + getName() + 
				" attacks you dealing " + a + " damage.");
		
		p.setHp(p.getHp() - a);
		
		if(p.getHp() <= 0)
			p.setHp(0);
		
		String resp2 = ("You have " + p.getHp() + " HP left.");
		
		ArrayList<String> resp = new ArrayList<String>();
		resp.add(resp1); resp.add(resp2);
		
		if(p.getHp() == 0)
			resp.add(p.die(this));
		
		return resp;
	}
	
	
	public ArrayList<String> die(Player p)
	{
		String resp1 = ("\nThe level " +getLevel() + " " + name +
				" dies a horrible death.");
		
		String resp2;
		
		if(dropItem.getName().equals("Coins")){
			resp2 = ("It dropped " + dropItem.getValue() + " coins");
			//p.setCoins(p.getCoins() + dropItem.getValue());
		}
		
		else if(dropItem.getName().equals("Health Potion"))
		{
			resp2 = ("It dropped a Health Potion!");
			//p.getHealthPotion();
		}
		else if(dropItem.getName().equals("Mana Potion"))
		{
			resp2 = ("It dropped a Mana Potion!");
			//p.getManaPotion();
		}
		else 
		{
			resp2 = ("It dropped a level " + dropItem.getMinLevel() + " "
					+ dropItem.getName() + ".");
		}
		
		setAlive(false);
		
		ArrayList<String> resp = new ArrayList<String>();
		resp.add(resp1); resp.add(resp2);
		
		return (resp);

	}
	
	public Item getDropItem()	{	return dropItem;	}
	public String getName()		{	return name;		}
}
