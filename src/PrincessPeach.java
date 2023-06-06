import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;


public class PrincessPeach {
	private int x, y; //position of the bird
	private Image img;
	private AffineTransform tx;
	
	//add the no-argument (zero parameters) constructor)
	
	public PrincessPeach(){
		img = getImage("/imgs/princesspeach.png"); //load the image for Tree
		tx = AffineTransform.getTranslateInstance(x, y);
		init(200, 120); 				//initialize the location of the image
									//use your variables
	}
	
	//add the 1-argument constructor - to set the fileName
	//of the image to use
	
	public PrincessPeach(String fileName) {
		img = getImage("/imgs/princesspeach.png"+ fileName); //load the image for Tree
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
		g2.drawRect(x+200,y+120, 100, 135);

	}
	public Rectangle hitBox() {
		return new Rectangle(x+100,y+100, 50, 50);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1); //scaling image to fit on the screen. the pixels
						//for this image are much smaller allowing me to scale it over one unlike background img
	}

	private Image getImage(String path) {
		//try catch is there to be able to define the image class to be tested for errors while it is being executed
		Image tempImage = null;
		try {
			URL imageURL = Barrel.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	
	}
	
	public void update() {
		
	}

	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	}