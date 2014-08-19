package Stuff;

import Stuff.Equipment;

public class Item
{
    private int minlevel;
	private String name;
	private int value;
	private Equipment equip;

	public Item(String nm, int ml)
	{
   	 name = nm;
   	 minlevel = ml;
   	 value = 2 * ml;
	}
    
	public Item(int level)
	{
   	 minlevel = level;
   	 value = (int)(Math.random() * minlevel * 10);
   	 
   	 int v = (int)(Math.random()*100);
   	 
   	 if(v < 6) name = "weapon";
   	 else if( v < 11) name = "armor";
   	 else if( v < 16) name = "footgear";
   	 else if( v < 21) name = "headgear";
   	 else if( v < 31) name = "Health potion";
   	 else if( v < 41) name = "Mana potion";
   	 else name = "Coins";
   	   
   	 
   	 {
   		 equip = new Equipment(name, minlevel);
   	 }
	}

	public int getMinLevel()  		 {    return minlevel;     }
	public void setMinLevel(int a)  {    minlevel = a;   	}
	public String getName()     	{    return name;    	}
	public void setName(String a)   {    name = a;   		 }
	public Equipment getEquip()   	 {    return equip;   	 }
	public int getValue()   		 {    return value;   	 }
}
