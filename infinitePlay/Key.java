package infinitePlay;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import basics.*;

public class Key implements KeyListener
{
	public void keyPressed(KeyEvent e) 
	{
		char s = (e.getKeyChar()); //or we can just revert back to the stone age instead!
		
		if(s == 'j')
		{
			JavaRPG_infinite.player.drinkHealthPotion();
			JavaRPG_infinite.g.updtAll(JavaRPG_infinite.player);
		}
		if(s == 'k')
		{
			JavaRPG_infinite.player.drinkManaPotion();
			JavaRPG_infinite.g.updtAll(JavaRPG_infinite.player);
		}
		
		if(JavaRPG_infinite.battle == true || JavaRPG_infinite.decision == true || JavaRPG_infinite.onTown == true)
		{
			if(s == 'a')
				JavaRPG_infinite.g.choice = 1;
			else if(s == 's')
				JavaRPG_infinite.g.choice = 2;
			else if(s == 'd')
			{
				if(JavaRPG_infinite.onTown == true && JavaRPG_infinite.player.getCoins() < 200)
					JavaRPG_infinite.g.choice = 4;
				else
					JavaRPG_infinite.g.choice = 3;
			}
			else if(s == 'f')
				JavaRPG_infinite.g.choice = 4;
		}
		else
		{
			
			if(s == 'w')
				JavaRPG_infinite.g.brd.move(0);
			else if(s == 'a')
				JavaRPG_infinite.g.brd.move(1);
			else if(s == 's')
				JavaRPG_infinite.g.brd.move(2);
			else if(s == 'd')
				JavaRPG_infinite.g.brd.move(3);
			
			
		}
		JavaRPG_infinite.jtf.setText("");
		JavaRPG_infinite.g.resetInput();
	}
	public void keyTyped(KeyEvent e)
	{}
	public void keyReleased(KeyEvent e)
	{}
}
