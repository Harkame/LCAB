package model;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private static final long	serialVersionUID	= 1L;

	private Image				img;

	public ImagePanel(Image img) {
		this.img = img;
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}
