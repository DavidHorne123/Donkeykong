

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


public class Mario{
	private int x= 300, y = 860; //position of mario
	private Image img;
	private AffineTransform tx;
	private int Vy;
	private double vx;
	private double vy;
	public int setvelY;
	public int setvelX;
	
	//add the no-argument (zero parameters) constructor)
	
	public Mario(){
		img = getImage("/imgs/MarioFaceRight.png"); //load the image for mario
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
		x += vx;
		y += vy;
		init(x, y);
		vy++;
		
		//make certain coordinates so when mario hits it, he bounces back up
		//increase velocity y bdy 1
		//set velocity y to 25daa
		
		g2.drawImage(img, tx, null);
		//g2.drawRect(x,y, 50, 50);
		
		
	}
	public boolean hitbox(Rectangle M) {
		Rectangle platform1 = new Rectangle(getX() + 900, getY() + 950, 942, 975);
		
		Rectangle M1 = new Rectangle(getX()+70, getY()+70, 190, 190);
		
		if(M1.intersects(platform1)) {
			setVx(0);
			setVy(0);
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






	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.2,.2);
	}

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
	



	public void update() {
		// TODO Auto-generated method stub
		
	}
}