import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;
import java.util.ArrayList;




public class Barrel extends Barrels{
	
	private int x  ,y ; // position of the bird
	private double vx=2, vy; // for movement
	int count;
	private Image img; 	
	private AffineTransform tx;
	private double ay;
	private boolean onPlatform;
	private ArrayList<Level> platforms;


	public Barrel(ArrayList<Level> platforms) {
		img = getImage("/imgs/barrel.png"); //load the image for Tree
		tx = AffineTransform.getTranslateInstance(getX(), getY());
		init(getX(), getY()); 				//initialize the location of the image
									//use your variables
		this.platforms = platforms;
	
	}
	
	//include a constructor that allows the specifying the file name
	// of the image
	public Barrel(String fileName) {
		img = getImage("/imgs/"+fileName); //load the image for Tree
		tx = AffineTransform.getTranslateInstance(getX(), getY());
		init(getX(), getY()); 				//initialize the location of the image
									//use your variables
		
		//give duck a random non-zero velocitu between -3 and 3
		//in both x and y directions
		
		
		
		
		
	}
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(getX(), getY());
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		/* check for platform collisions which determins if we're moving down */
		int count = 0;
		for( Level level : platforms ) {
			
			if(level.hitbox().intersects(this.hitBox()) && vy >= 0 ) {
				ay = 0;
				vy = 0;
				onPlatform = true;
				System.out.println("on platform");
				count++;
				break;
			 
			}
		
			
		}
		
		if(count==0) {
			ay = 1;	
			vy += ay; //acceleration affects velocity
			y += vy;
		}
		
		if( x > 900) {
			vx = -5;
		}
		if( x < 0) {
			vx= 5;
		}
		x += vx;
	
		// make certain coordinates so when mario hits it, he bounces back up
		// increase velocity y bdy 1
		// set velocity y to 25daa
		init(x, y);
		g2.drawImage(img, tx, null);
		g2.drawRect(x+42,y+50, 20, 20);

	}
	
	public Rectangle hitBox() {
		// TODO Auto-generated method stub
		return new Rectangle(x+20,y+25, 40, 40);

	}

	private void update() {
		tx.setToTranslation(getX(), getY());
		tx.scale(4 ,4);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}


	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Barrel.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	public boolean hit(MouseEvent mouse) {
		Rectangle m = new Rectangle(mouse.getX(), mouse.getY(), 70, 70);
		Rectangle d = new Rectangle(getX()+70, getY()+70, 190, 190);
		
		if(m.intersects(d)) {
			setVx(this.getVx());
			setVy(this.getVy());
			return true;
		}
		return false;
	}

	public double getVy() {
		return vy;
	}

	public void setVy(double vy) {
		this.vy = vy;
	}

	public double getVx() {
		return vx;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


}
