package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MainRunner extends MainAnimation{
	public static void main(String[] args){
		MainAnimation t = new MainAnimation();
		JFrame jf = new JFrame();
		jf.setTitle("THAT ONE ANNOYING GAME"); //name it\
		jf.setSize(windowX, windowY); //see above size (720p)
		jf.setResizable(false); //locked at 720p (1280 x 720)
		jf.setVisible(true); //display on screen
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit command
		jf.add(t);
		
		if(MainAnimation.isGameOver()){
			jf.remove(t);
		}
		//t.paint(null);
		//while(true){
		//System.out.println(MainAnimation.playershot);
		//}
	}

}