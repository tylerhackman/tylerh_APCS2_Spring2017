package uberkalt;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.*;

public class Enemy {
	
	Graphics2D g2d;
	int x;
	int y;
	
	public Enemy(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void drawEnemy(Graphics2D thing) {
		thing.drawImage(getEnemy(), x, y, null);
		
	}
	
	public Image getEnemy() {
		
		ImageIcon player = new ImageIcon ("C:/Users/APCS2/Desktop/Enemy.png");
		Image playerImage = player.getImage();
		return playerImage;
	}
	
	public void update() {
		
	}
}
