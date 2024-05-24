import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;
//BY: DAVID HORNE


public class Ladder5 {
	private int x , y; //position of the ladder
	private Image img;
	private AffineTransform tx;
	
	
	// constructor that contains the image used
	public Ladder5(int x, int y){
		img = getImage("/imgs/Ladder5.png"); //load the image for Tree
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x,y); 				//initialize the location of the image
									//use your variables
		this.x = x;
		this.y = y;
	}
	
	//add the 1-argument constructor - to set the fileName
	//of the image to use
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(0, 0);
	}
	
	// paint method
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		g.setColor(Color.blue);
		g.drawRect(x, y, 50, 100);
	}
	
	public Rectangle hitBox() {
		return new Rectangle(x,y, 50, 100);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1.8, 1.8);
	}
	
	// getting the image that we used with a try catch exception
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