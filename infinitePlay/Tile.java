package infinitePlay;

public class Tile
{
	protected String type;
	protected boolean playerOn = false;
	protected boolean T_TOn = false;
	protected boolean blocker = false;

	public  Tile(int a)
	{
		if(a == 0)
			type = "TWN";
		else
		{
			a = (int) (40*Math.random());
			
			if(a >= 6 && a <= 22)
				type = ",,,";
			else if(a >= 22 && a <= 39)
				type = "o0o";
			else if(a == 0)
				type = "TWN";
			else if(a >= 1 && a <= 5)
				type = "|-|";
			
			if(type.equals("|-|"))
				blocker = true;
		}	
	}

	public String getType() {return type;}
	public void setType(String str) {type = str;}
	public boolean getPlayerOn() {return playerOn;}
	public void setPlayerOn(boolean b) {playerOn = b;}
	public boolean getT_TOn() {return T_TOn;}
	public void setT_TOn(boolean b) {T_TOn = b;}
	
	public String getApp() //returns tile's appearance
	{
		if(playerOn)
			return "\\o/";
		else if(T_TOn)
			return "T_T";
		else
			return type;
	}
}

