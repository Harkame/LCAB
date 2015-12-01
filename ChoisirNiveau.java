package projet_bulles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import projet_bulles.Jeu.STATE;

public class ChoisirNiveau extends JFrame implements KeyListener {

	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int width = (int) screenSize.getWidth();
	int height = (int) screenSize.getHeight();
	private JButton NiveauStatique;
	private JButton NiveauMobile;
	private JButton MenuPrincipal;
	
	
	public ChoisirNiveau () {
	
	super("Jeu De Bulles");
	setSize(width,height);
	
	/* Redimensionner les images pour travailler sur tous les écrans */
	// if(width == 1920 && height == 1080) {
	this.setContentPane(new ImagePanel(new ImageIcon("wallpaper.jpg").getImage())); // à reprendre
	 //}
	 this.setVisible(true);
		this.setLayout(null); // permet le position correcte des boutons
		
		 Font police = new Font("Verdana", Font.BOLD, 20);
			this.NiveauStatique = new JButton("Niveau Statique");
			this.NiveauStatique.setBackground(Color.WHITE);
			this.NiveauStatique.setFont(police);
			this.NiveauStatique.setBounds(width /2 -210, 400, 300, 75);
		this.getContentPane().add(this.NiveauStatique, BorderLayout.CENTER);
		
	
			this.NiveauMobile = new JButton("Niveau mobile");
			this.NiveauMobile.setBackground(Color.WHITE);
			this.NiveauMobile.setFont(police);
			this.NiveauMobile.setBounds(width /2 -210, 500, 300, 75);
		this.getContentPane().add(this.NiveauMobile, BorderLayout.CENTER);
		
		this.MenuPrincipal = new JButton("Menu Principal");
		this.MenuPrincipal.setBackground(Color.WHITE);
		this.MenuPrincipal.setFont(police);
		this.MenuPrincipal.setBounds(100, 900, 300, 75);
	this.getContentPane().add(this.MenuPrincipal, BorderLayout.CENTER);
	
	
	this.MenuPrincipal.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			
			dispose();
			Jeu.State = STATE.MENU;
			try {
				Jeu.controller();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
	});
	this.setVisible(true);

}
	
	
	
	
	
	
	
	
	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String [ ] args)
	{
		ChoisirNiveau ch1 = new ChoisirNiveau();
	}

}
