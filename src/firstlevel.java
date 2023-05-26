
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;


public class firstlevel extends Level{
	

	
	//add the no-argument (zero parameters) constructor)
	
	public firstlevel(){
		img = getImage("/imgs/level.png"); //load the image for Tree
		x = 25; // possition for left side floor
		y = 970;
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x,y);
	}
	
 
	

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(5, 5);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = firstlevel.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	
	}
}