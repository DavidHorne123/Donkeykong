import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;




public class barrel{
	
	private int x,y; // position of the bird
	private double vx, vy; // for movement
	int count;
	private Image img; 	
	private AffineTransform tx;


	public barrel() {
		img = getImage("/imgs/barrel.png"); //load the image for Tree
		tx = AffineTransform.getTranslateInstance(getX(), getY());
		init(getX(), getY()); 				//initialize the location of the image
									//use your variables
		while(getVx() == 0) {
			vx += 2;
		}
		
		while(getVy() == 0) {
			vy += 2;
		}
		
	
	}
	
	//include a constructor that allows the specifying the file name
	// of the image
	public barrel(String fileName) {
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
	
		setX((int) (getX()+ getVx()));
		setY((int) (getY()+ getVy()));
		
	
		// call update to update the actual picture location
		update();
		g2.drawImage(img, tx, null);
		
		

		
		


	}
	
	private void update() {
		tx.setToTranslation(getX(), getY());
		tx.scale(2.5 , 2.5);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}


	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = barrel.class.getResource(path);
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
