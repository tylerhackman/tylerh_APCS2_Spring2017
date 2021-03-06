package game;



/***
 *  find way to shoot, and make bombs drop, then hit reg, and it's done
 */


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainAnimation extends JPanel implements ActionListener, KeyListener{

	static int windowX = 1280;
	static int windowY = 720;
	int playerWidth = 50; //X
	int playerHeight = 50; //Y

	int numBombs = 9;

	//int playerXPos;
	//int playerYPos;

	boolean startGameScreen = false;

	//boolean paused = false;
	boolean startGame = false;

	Timer tm = new Timer(6, this); //player timer
	//Timer bombtm = new Timer(10, this); //bombs timer
	//x and y are starting positions, starts at bottom center
	int x = windowX/2 - playerWidth/2;
	int y = windowY - playerHeight - 50;

	int velX = 0;
	int velY = 0;

	int projectileX;
	int projectileY = y - playerHeight/2;
	int projectileVelY = 5;

	int randomNum;

	//int bombVelX = 1; bombs fall downward
	int bombVelY = 2;

	int bombX = 0;
	int bombY = 5;
	int bombXPos;

	static boolean gameOver = false;
	boolean gameoverScreen = false;

	boolean playerShot = false;
	boolean hitYet = false;

	boolean bomb1Hit = false;

	boolean playerMoved = false;

	boolean wonGame = false;
	boolean wonGameScreen = false;

	boolean rngsus = false;

	boolean dontRun = false;

	JFrame ctrlFrame = new JFrame();
	JFrame winFrame = new JFrame();

	//ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	//InputStream player = classLoader.getResourceAsStream("/images/usflag.png");

	/*public void ImagePanel() {
		BufferedImage player;
		try {                
			player = ImageIO.read(new File("/images/usflag.png"));
		} catch (IOException ex) {
			// handle exception...
		}
	}*/

	public MainAnimation(){
		tm.start();
		//bombtm.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		rng();
	}

	public void setVelX(int velX){
		this.velX = velX;
	}

	public void setVelY(int velY){
		this.velY = velY;
		this.bombVelY = 2;
	}




	/*public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(10, 10, 100, 50);
	}*/

	public void rng(){
		if(rngsus == false){
			randomNum = 1 + (int)(Math.random() * ((31) + 1));
			rngsus = true;
		}
	}

	ArrayList<Integer> pos = new ArrayList<Integer>(); //don't remove, will breaks game

	public void hitDetection(){
		if((bombY + 64) >= (720-50) && dontRun == false){
			gameOver = true;
			//JLabel gamOver = new JLabel("Game Over");
			//gameOver.setVisible(true);

		}

		if((projectileX + playerWidth/2 + 5 >= bombXPos && projectileX + playerWidth/2 + 5 <= bombXPos + 40) && projectileY <= bombY){ //hits
			hitYet = true;
			wonGame = true;
			dontRun = true;
		}else if(dontRun == false && projectileY < 0){ //misses
			gameOver = true;
			wonGame = false;
		}
	}




	public void paintComponent(Graphics g){
		super.paintComponent(g);

		//g.drawImage(player, 0, 0, this);

		Paint.paintRect(g, Color.RED, x, y, playerWidth, playerHeight); //I am very proud that I made this work ~ Joman
		//g.setColor(Color.RED);
		//g.fillRect(x, y, playerWidth, playerHeight);
		/*Paint.paintRect(g, Color.WHITE, x, y + playerHeight/12, playerWidth, playerHeight/12);
		Paint.paintRect(g, Color.WHITE, x, y + playerHeight/12 * 3 , playerWidth, playerHeight/12);
		Paint.paintRect(g, Color.WHITE, x, y + playerHeight/12 * 5, playerWidth, playerHeight/12);
		Paint.paintRect(g, Color.WHITE, x, y + playerHeight/12 * 7, playerWidth, playerHeight/12);
		Paint.paintRect(g, Color.WHITE, x, y + playerHeight/12 * 9, playerWidth, playerHeight/12);
		Paint.paintRect(g, Color.WHITE, x, y + playerHeight/12 * 11, playerWidth, playerHeight/12);
		 */
		Paint.paintRect(g, Color.GREEN, 0, 720 - playerHeight, 1280, playerWidth); //the ground
		//g.setColor(Color.GREEN);
		//g.fillRect(0, 720 - 50, 1280, 50);

		//Bomb b = new Bomb(pos)
		if(rngsus){
			Paint.paintRect(g, Color.BLUE, bombX + randomNum* 40, bombY, 40, 64);
			bombXPos = bombX + randomNum * 40 + 20;
		}
		//g.setColor(Color.BLUE); //bomb?


		if(isGameOver() && gameoverScreen == false){
			Paint.paintRect(g, Color.BLACK,0 , 0, windowX, windowY);
			JFrame frame = new JFrame();
			frame.setLayout(new GridBagLayout());
			JPanel panel1 = new JPanel();
			JLabel jlabel1 = new JLabel("Game Over");
			JLabel jlabel2 = new JLabel(", you suck.");
			jlabel1.setFont(new Font("Verdana",1,20));
			jlabel2.setFont(new Font("Verdana",2,20));
			panel1.add(jlabel1);
			panel1.add(jlabel2);
			panel1.setBorder(new LineBorder(Color.BLACK)); // make it easy to see
			frame.add(panel1, new GridBagConstraints());
			frame.setSize(400, 400);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			gameoverScreen = true;
		}else if(isGameOver()){
			Paint.paintRect(g, Color.BLACK,0 , 0, windowX, windowY); //literally could replace with Soviet flag instead of black screen
		}


		if(startGame == false && startGameScreen == false){
			ctrlFrame.setLayout(new GridBagLayout());
			JPanel panel2 = new JPanel();
			JLabel line1 = new JLabel("CONTROLS: Left arrow key, Right arrow key, Up arrow key to shoot");
			JLabel line2 = new JLabel("Press down arrow key to start");
			line1.setFont(new Font("Verdana",1, 12));
			line2.setFont(new Font("Verdana",0, 12));
			panel2.add(line1);
			panel2.add(line2);
			panel2.setBorder(new LineBorder(Color.BLACK)); // make it easy to see
			ctrlFrame.add(panel2, new GridBagConstraints());
			ctrlFrame.setSize(800, 300);

			ctrlFrame.setLocationRelativeTo(null);
			ctrlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ctrlFrame.setVisible(true);
			startGameScreen = true;
		}

		if(wonGameScreen == false && wonGame){
			winFrame.setLayout(new GridBagLayout());
			JPanel WINdow = new JPanel();  //"win"dow
			JLabel line3 = new JLabel("Congrats you don't suck?");
			line3.setFont(new Font("Verdana",1, 12));
			WINdow.add(line3);
			WINdow.setBorder(new LineBorder(Color.BLACK)); // make it easy to see
			winFrame.add(WINdow, new GridBagConstraints());
			winFrame.setSize(300, 300);

			winFrame.setLocationRelativeTo(null);
			winFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			winFrame.setVisible(true);

			wonGameScreen = true;

			//tm.stop();
		}


		if(playerShot){
			g.setColor(Color.BLACK);
			pos.add(x);
			g.fillRect(pos.get(0) + playerWidth/2 - 5, projectileY, 10, 16);
			projectileX = pos.get(0) + playerWidth/2 - 5;
		}
		/*if(hitYet){
			hitYet = false;
		}*/

		tm.start();	
	}

	/**
	 * 
	 *  This code is made by Joman Wong, Kevin Wong, Tyler Hackman. This program is part of CC (Creative Commons), however,
	 *  cite creators' names in use or sharing.
	 *
	 */


	public void actionPerformed(ActionEvent e){
		hitDetection();
		if(x < 0){ //left side
			velX = 0;
			x = 0;
		} 
		if(x > windowX - playerWidth){ //right side
			velX = 0;
			x = windowX - playerWidth - 7;
		}

		x = x + velX;
		y = y + velY;

		if(startGame){
			//bombX += bombVelX;
			bombY += bombVelY;
		}
		if(playerShot){
			projectileY = projectileY - projectileVelY;
		}
		repaint();
	}

	public void shoot(){
		playerShot = true;
	}


	public void keyPressed(KeyEvent e){

		int c = e.getKeyCode();
		if(c == KeyEvent.VK_DOWN) {
			startGame = true; //press down arrow to start game
			ctrlFrame.setVisible(false);
		}

		if(startGame == true){
			if(c == KeyEvent.VK_LEFT && playerMoved == false){ //go left
				velX = -6;
				velY = 0;
				playerMoved = true;
			}else if(c == KeyEvent.VK_UP){ //shoot
				shoot();
				//playerShot = false; //is string because test
			}else if(c == KeyEvent.VK_RIGHT && playerMoved == false){ //go right
				velX = 6;
				velY = 0;
				playerMoved = true;
			}


		}
	}

	public void KeyTyped(KeyEvent e){

	}

	public void keyReleased(KeyEvent e){
		velX = 0;
		velY = 0;
	}

	public static boolean isGameOver(){
		return gameOver;
	}
}
