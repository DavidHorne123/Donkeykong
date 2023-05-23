
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;


public class Background {
	private int x= 0, y =0; //position of 
	private Image img;
	private AffineTransform tx;
	
	//add the no-argument (zero parameters) constructor)
	
	public Background(){
		img = getImage("/imgs/gameFrame.png"); //load the image for background
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x,y); 				//initialize the location of the image
									//use your variables
	}

	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(0, 0);
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		//g2.drawRect(x,y, 50, 50);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b); //use this to scale the image to 1
		tx.scale(1, 1); //wont fit on screen if the scale is larger than 1
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Mario.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace(); 
		}                             //try-catch allows you to check a block of code for any exceptions
		return tempImage;
	
	}
}