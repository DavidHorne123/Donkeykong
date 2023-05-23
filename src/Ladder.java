import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;


public class Ladder {
	private int x , y; //position of the bird
	private Image img;
	private AffineTransform tx;
	
	//add the no-argument (zero parameters) constructor)
	
	public Ladder(){
		img = getImage("/imgs/Ladder.png"); //load the image for Tree
		tx = AffineTransform.getTranslateInstance(x, y);
		init(800, 820); 				//initialize the location of the image
									//use your variables
	}
	
	//add the 1-argument constructor - to set the fileName
	//of the image to use
	
	public Ladder(String fileName) {
		img = getImage("/imgs/Ladder.png"+ fileName); //load the image for Tree
		tx = AffineTransform.getTranslateInstance(x, y);
		init(0, 0);			//initialize the location of the image
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

	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1.8, 1.8);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Ladder.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	
	}
}