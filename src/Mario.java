
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;
import java.util.ArrayList;

//BY: DAVID HORNE
// the mario class is responsible for Mario's X and Y position and getting his image
// and also creating many different velocity x and y variables 

 
public class Mario {
	private int x = 500, y = 910; // position of mario
	private Image img;
	private AffineTransform tx;
	private int ay; //gravity
	private double vx;
	private double vy;
	public int setvelY;
	public int setvelX;
	public boolean climbing = false;
	ArrayList<Level> platforms;
	boolean onPlatform = false;
	
	
	

	public Mario(ArrayList<Level> platforms) {
		img = getImage("/imgs/MarioFaceRight.png"); // load the image for mario
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y); // initialize the location of the image
					// use your variables
		this.platforms = platforms;
	}

	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(0, 0);
	}

	
	public void paint(Graphics g) {
		// these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;

		/* check for platform collisions which determines if we're moving down */
		int count = 0;
		for( Level level : platforms ) {
			
			if(level.hitbox().intersects(this.hitBox()) && vy > 0) {
				ay = 0;
				vy = 0;
				onPlatform = true;
				count++;
				break;
			}
			
		}
		
		 if(!onPlatform) {
			ay = 1;	
			vy += ay; //acceleration affects velocity
			y += vy;
		 }

		x += vx;
	
		// make certain coordinates so when mario hits it, he bounces back up
		// increase velocity by 1
		// set velocity y to 25d
		init(x, y);
		g2.drawImage(img, tx, null);
		//g2.drawRect(x+25,y+25, 50, 50);

	}

	public void climb(){
		y -= 10;
		ay = 0;
		init(x,y);
	//	System.out.println("climb");
	}
	
	
	public Rectangle hitBox() {
		return new Rectangle(x+25,y+25, 50, 50);
		
	}
	
	// GETTERS AND SETTERS
	
	// This method returns the current horizontal velocity
	// vx of Mario
	public double getVx() {
		return vx;
	}
	// This method sets the horizontal velocity 
	// vx of Mario
	public void setVx(double vx) {
		this.vx = vx;
	}
	
	// This method sets the current vertical velocity 
	// vy of Mario
	public void setVy(double vy) {
		this.vy= vy;
	}
	
	// This method returns the current horizontal position x of Mario
	public int getX() {
		return x;
	}
	// This method returns the current vertical velocity vy of Mario
	public double getVy() {
		return vy;
	}
	
	// This method sets the horizontal position x of Mario
	public void setX(int x) {
		this.x = x;
	}
	// This method returns the current vertical position Y of mario 
	public int getY() {
		return y;
	}
	// This method sets the vertical position y of Mario and 
	// int y is the new vertical position to set
	public void setY(int y) {
		this.y = y;
	}

	public void jump() {
		if( onPlatform) {
			vy = -11;
			onPlatform = false;
		}
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.2, .2); // Making mario smaller by .2
	}
	// try catch block method for getting mario's image
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Mario.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;

	}

}