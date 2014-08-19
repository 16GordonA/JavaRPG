package basics;

import javax.swing.ImageIcon;

public class ImageHelper 
{
	public ImageIcon createImageIcon(String path, String description) 
	{
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) 
		{
			return new ImageIcon(imgURL, description);
		} 
		else 
		{
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}
