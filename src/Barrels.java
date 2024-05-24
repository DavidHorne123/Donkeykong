import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
//BY: DAVID HORNE

public class Barrels {
	private int x,y; // position of the bird
	private double vx, vy; // for movement
	int count;
	private Image img; 	
	private AffineTransform tx;
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
	
		
		setX((int) (getX()+ getVx()));
		setY((int) (getY()+ getVy()));
		
		if( x > 800) {
            vx = -15;
        }
        else {
            vx= 15;
        }
		
		
		x += vx;
		setX(x);
		// call update to update the actual picture location
		update();
		g2.drawImage(img, tx, null);
		
		//whenever x reaches border
		//multiply vx by -1
		

		
		


	}

	private void setVy(int i) {
		// TODO Auto-generated method stub
		
	}

	private void setVx(int i) {
		// TODO Auto-generated method stub
		
	}

	private int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getVy() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getVx() {
		// TODO Auto-generated method stub
		return 0;
	}

	private void update() {
		// TODO Auto-generated method stub
		
	}

	private int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	private void setY(int i) {
		// TODO Auto-generated method stub
		
	}

	private void setX(int i) {
		// TODO Auto-generated method stub
		
	}
	
}
