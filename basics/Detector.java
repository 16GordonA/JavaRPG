package basics;

import java.awt.Image;
import java.awt.image.ImageObserver;

public class Detector implements ImageObserver {

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y,
			int width, int height) {
		//do nothing, hope for the best
		return false;
	}

}
