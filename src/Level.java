import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

public class Level {

	public int width = 1000;
	public int height = 50;
	protected int x, y; //position of the bird
	protected Image img;
	protected AffineTransform tx;
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		g.setColor(new Color(255,255,255));
		g.drawRect(x, y, width, height);
	}
	
	public Rectangle hitbox() {
		return new Rectangle(x,y,width,height);
	}
	
}
