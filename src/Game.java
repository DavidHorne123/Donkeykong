import java.awt.Color;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements KeyListener, MouseListener, ActionListener{
	int score = 0; //created score variable
	int highscore = 0; //created highscore variable which should go at the top middle of the screen
	int Lives = 10; //Mario has lives
	int hit; //the variable for when the barrels hit mario
	
	
	public int keyright = KeyEvent.VK_RIGHT;
	public int keyleft = KeyEvent.VK_LEFT;
	int velX = 0, velY = 0; //need this for the methods below
	
	public int characterheight = 36;
	public int characterwidth = 24;
	public int fallingframe = 0;
	public int fallingSpeed = 1;
	public boolean falling = false;
	public boolean running = true;
	public boolean climb = false;
	
	public boolean left = false;
	public boolean right = false;
	boolean gamestart = false;
	
	
	Mario m;
	//Background bigFrame = new Background();
	//Duck duck = new Duck();
	PrincessPeach p = new PrincessPeach(); //Princess Peach
	DonkeyKongg d = new DonkeyKongg(); // Donkey Kong
	Ladder L = new Ladder(800, 845); //the ladders that allows Mario to advancew
	Ladder L2 = new Ladder(100, 730);
	//Ladder L2 = new Ladder();
	Barrel ba;
	firstlevel firstlevel = new firstlevel();
	secondlevel secondlevel = new secondlevel();
	fourthlevel fourthlevel = new fourthlevel();
	thirdlevel thirdlevel = new thirdlevel();
	fifthlevel fifthlevel = new fifthlevel();
	toplevel toplevel = new toplevel();
	
	ArrayList<Level> platforms;
	private String img;
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		//bigFrame.paint(g); //painging the giant background
	
		d.paint(g); //painting donkey kong
		p.paint(g);
		m.paint(g); //painting mario
		ba.paint(g); //painting Donkey Kong
		
		firstlevel.paint(g); //painting the first platform
		secondlevel.paint(g);
		fourthlevel.paint(g);
		thirdlevel.paint(g);
		fifthlevel.paint(g);
		toplevel.paint(g);
		L.paint(g); //the ladder
		L2.paint(g);

		
	}
	

	
	
	public static void main(String[] arg) {
		Game g = new Game();
	}
	
 
	
	public Game() {
		JFrame f = new JFrame("Duck Hunt");
		f.setSize(new Dimension(1022, 1022));
		f.setBackground(Color.blue);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		f.setUndecorated(true);
		
		//platforms setup
		platforms = new ArrayList<Level>();
		platforms.add(firstlevel);
		platforms.add(secondlevel);
		platforms.add(fourthlevel);
		platforms.add(thirdlevel);
		platforms.add(fifthlevel);
		platforms.add(toplevel);
		m = new Mario(platforms);
		ba = new Barrel(platforms); // the barrels that try to kill Mario
		
		Timer t = new Timer(1, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);	
	}
	public void run() {
		//character feet
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {  //We worked really hard in order to make Mario move
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_W) { //up
			
		/*	if(m.hitBox().intersects(L.hitBox())) {
				m.climb();
				m.climbing = true;
			}else if(m.getVy()==0) {
				m.setVy(-10);
				m.climbing = false;
			} */
			m.jump();
			
		} else if (key == KeyEvent.VK_S) { //goes down
			m.setVx(0);
		} else if (key == KeyEvent.VK_A) { //left
			m.setVx(-2);
		} else if (key == KeyEvent.VK_D) { //right
			m.setVx(2);
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_W) { //stops moving
			//m.setVy(0);
		} else if (key == KeyEvent.VK_S) { //stops moving 
			m.setVy(1);
		} else if (key == KeyEvent.VK_A) {// stops moving
			m.setVx(0);
		} else if (key == KeyEvent.VK_D) { //stops moving
			m.setVx(0);	
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}
	
	

}
