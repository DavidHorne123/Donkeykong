
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;


public class DonkeyKongg{
	private int x= 50, y = 140; //position of the bird
	private Image img;
	private AffineTransform tx;
	private int Vy;
	private double vx;
	private double vy;
	public int setvelY;
	public int setvelX;
	
	//add the no-argument (zero parameters) constructor)
	
	public DonkeyKongg(){
		img = getImage("/imgs/donkeytrans.png"); //load the image for Tree
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x,y); 				//initialize the location of the image
									//use your variables
		while(getVx() == 0) {
			setVx((int)((Math.random()*2) - 3));
		}
		
		
	
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
		setX((int) (getX()+ getVx()));
		setY((int) (getY()+ getVy()));
		
		if(getX() > 440 || getX() < -10) {
			setVx(-getVx());
		}
	
		
		g2.drawImage(img, tx, null);
		//g2.drawRect(x,y, 50, 50);
		
		
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
		tx.scale(.8, .8);
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