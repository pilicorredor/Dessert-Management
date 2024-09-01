package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {
	private Image image;
	
	public void paint(Graphics g) {
		image = new ImageIcon(getClass().getResource("/resource/Img_Background.png")).getImage();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
	}
}
