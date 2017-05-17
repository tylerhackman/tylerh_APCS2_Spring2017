package uberkalt;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.*;

public class Player {
	
	Graphics2D g2d;
	int x;
	int y;
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void drawPlayer(Graphics2D thing) {
		thing.drawImage(getPlayer(), x, y, null);
		
	}
	
	public Image getPlayer() {
		
		ImageIcon player = new ImageIcon ("C:/Users/APCS2/Desktop/player2.png");
		Image playerImage = player.getImage();
		return playerImage;
	}
	
	public void update() {
		
	}
}
