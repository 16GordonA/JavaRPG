package Stuff;

public class Equipment extends Item 
{
	
	private int damage;
    private int defense;
    private int vitality;
    private int speed;  

    public Equipment(String nm, int ml)
    {
        super(nm, ml);
       
        damage = (int)(Math.random()*(ml+1));
        defense = (int)(Math.random()*(ml+1));
        vitality = (int)(Math.random()*(ml+1));
        speed = (int)(Math.random()*(ml+1));       
    }
    public Equipment(String nm, int ml, int dmg, int def, int vit, int spd)
    {
    	super(nm, ml);
    	
    	damage = dmg;
    	defense = def;
    	vitality = vit;
    	speed = spd;
    }
    
    public void upgrade(int cost)
    {
        int a = (int)(Math.random() * cost / 20);

        damage += a;
        defense += a;
        vitality += a;
        speed += a;

        System.out.println("Your level " + super.getMinLevel() + " " + super.getName() 
        		+ " had all of its stats increased by " + a + ".");
    }

    public int getDamage()    	{    return damage;  	}
    public int getDefense()   	{    return defense;    }
    public int getVitality()    {    return vitality;   }
    public int getSpeed()    	{    return speed;      }
   
}

