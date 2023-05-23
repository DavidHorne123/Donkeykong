import java.awt.Color;


import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements KeyListener, MouseListener, ActionListener{
	Mario m = new Mario(); //Mario
	Background bigFrame = new Background();
	//Duck duck = new Duck();
	PrincessPeach p = new PrincessPeach(); //Princess Peach
	DonkeyKongg d = new DonkeyKongg(); // Donkey Kong
	Ladder L = new Ladder(); //the ladders that allows Mario to advance
	Ladder L2 = new Ladder();
	barrel ba = new barrel(); // the barrels that try to kill Mario
	firstlevel firstlevel = new firstlevel();
	secondlevel secondlevel = new secondlevel();
	fourthlevel fourthlevel = new fourthlevel();
	private String img;
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		bigFrame.paint(g); //painging the giant background
		L.paint(g);; //the ladder
		d.paint(g); //painting donkey kong
		p.paint(g);
		m.paint(g); //painting mario
		ba.paint(g); //painting Donkey Kong
		firstlevel.paint(g); //painting the first platform
		secondlevel.paint(g);
		fourthlevel.paint(g);
		//duck.paint(g);
		//System.out.println("here");
		Point mouse;
		Rectangle m = new Rectangle();
		Rectangle d = new Rectangle(getX()+70, getY()+70, 190, 190);
		
	}
	
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
	
	public static void main(String[] arg) {
		Game g = new Game();
	}
	
	int x = 0, y = 0; //initializing variables x and y in game class
	
	public void update() {
		y += velY; //updates y velocity
		x += velX; //updates x velocity
		
	}
	//if(m.getx() > 945 || getx() < 975) {
//		setVx(-getX());
//	}
//	
	//if(getY() > 420 || getY() < -50) {
	//	setVy(-getY());
	//}
	
	
	
	
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
			m.setVy(-20);
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
		m.update();
	}
	
	

}
