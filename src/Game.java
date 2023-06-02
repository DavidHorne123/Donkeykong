import java.awt.Color;


import java.awt.Dimension;
import java.awt.Font;
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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements KeyListener, MouseListener, ActionListener{
	
	
	public int keyright = KeyEvent.VK_RIGHT;
	public int keyleft = KeyEvent.VK_LEFT;
	int velX = 0, velY = 0; //need this for the methods below
	

	public boolean falling = false;
	public boolean running = true;
	public boolean climb = false;
	
	public boolean left = false;
	public boolean right = false;
	boolean gamestart = false;
	
	
	Mario m;
	Background Background = new Background();
	//Duck duck = new Duck();
	PrincessPeach p = new PrincessPeach(); //Princess Peach
	DonkeyKongg d = new DonkeyKongg(); // Donkey Kong
	Ladder L = new Ladder(800, 875); //the ladders that allows Mario to advancew
	Ladder L2 = new Ladder(100, 730); //ladder 2
	Ladder L3 = new Ladder(800, 580); //Ladder 3
	Ladder L4 = new Ladder(100, 430);
	Ladder L5 = new Ladder(800, 280);
	
	public int Score= 0;
	//int HighScore;
	
	int pastScore; 
	int HighScore1 = 0; 
	
	//SOUNDS
	Music m1 = new Music("jump.wav", false);

	//the higher the number, the lower the object goes
	//the lower the number, the higher the object goes
	//lower number goes left
	//higher number goes right
	
	//BARRELS
	Barrel b1;
	Barrel b2;
	
	firstlevel firstlevel = new firstlevel();
	secondlevel secondlevel = new secondlevel();
	fourthlevel fourthlevel = new fourthlevel();
	thirdlevel thirdlevel = new thirdlevel();
	fifthlevel fifthlevel = new fifthlevel();
	toplevel toplevel = new toplevel();
	
	ArrayList<Ladders> ladders;
	ArrayList<Level> platforms;
	private String img;
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		//bigFrame.paint(g); //painging the giant background
	
		d.paint(g); //painting donkey kong
		p.paint(g);
		m.paint(g); //painting mario
		b1.paint(g); //painting barrel
		//b2.paint(g);
		
		boolean touching = false;
		if( m.hitBox().intersects(b1.hitBox()))
		{
			g.setColor(Color.BLACK);
			HighScore1 = Score; 
			Font myFont = new Font ("Courier New", 1, 50);
			
			g.setColor(Color.RED);
			g.setFont(myFont);
			g.drawString("GAMEOVER ",  500, 500); // firgure out how to freeze game
			b1.getX();
			b1.getY();
			b1.setX(getX());
			b1.setY(getY());
			m.getX();
			m.getY();
			Score =0;  // reset score
		
		}
		
		
		
		
		

	Font myFont = new Font ("Courier New", 1, 50);
		
		g.setColor(Color.RED);
		g.setFont(myFont);
		g.drawString("HiGH SCORE: " + HighScore1 ,   400, 40);
		g.drawString("Score : " + Score ,  0, 50);
		
		
		g.setColor(Color.white);
		g.drawString("00000 " , 400, 80); // highschore
		
		
		
		
		firstlevel.paint(g); //painting the first platform
		secondlevel.paint(g); //painting the second platform
		fourthlevel.paint(g); //painting the fourth platform
		thirdlevel.paint(g); //painting the third platform
		fifthlevel.paint(g); //painting the fifth platform
		toplevel.paint(g);
		
		L.paint(g); //the ladder
		L2.paint(g); //second ladder
		L3.paint(g); //third ladder
		L4.paint(g); //fourth ladder
		L5.paint(g); //fifth ladder

		
	}
	
	

	
	
	public static void main(String[] arg) {
		Game g = new Game();
	}
	
 
	
	public Game() {
		JFrame f = new JFrame("DK");
		f.setSize(new Dimension(1022, 1022));
		f.setBackground(Color.black);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		f.setUndecorated(true);
		
	
		//Ladders setup
		
		ladders = new ArrayList<Ladders>();
		Ladders.add(L);
		Ladders.add(L2);
		Ladders.add(L3);
		Ladders.add(L4);
		Ladders.add(L5);
		
		//platforms setup
		platforms = new ArrayList<Level>();
		platforms.add(firstlevel);
		platforms.add(secondlevel);
		platforms.add(fourthlevel);
		platforms.add(thirdlevel);
		platforms.add(fifthlevel);
		platforms.add(toplevel);
		m = new Mario(platforms);
		b1 = new Barrel(platforms); // the barrels that try to kill Mario
		
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
		if(m.hitBox().intersects(L.hitBox()) || m.hitBox().intersects(L2.hitBox()) || m.hitBox().intersects(L3.hitBox()) || m.hitBox().intersects(L4.hitBox()) || m.hitBox().intersects(L5.hitBox()))  {
			m.climb();
			img = getImage("/imgs/MarioClimbing.png");
			System.out.print("climbing");
		}
		
		if(key == KeyEvent.VK_W) { //up
			m.jump();
			m1.play();
		} else if (key == KeyEvent.VK_S) { //goes down
			m.setVx(0);
		} else if (key == KeyEvent.VK_A) { //left
			m.setVx(-2);
		} else if (key == KeyEvent.VK_D) { //right
			m.setVx(2);
			
		}
	}

	private String getImage(String string) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		
			
		if (key == KeyEvent.VK_A) {// stops moving
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
