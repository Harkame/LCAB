package projet_bulles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import projet_bulles.Jeu.STATE;



public class Menu extends JFrame {
	
	int SCALE = 2;
	String title = "Jeu de Bulles";
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int width = (int) screenSize.getWidth();
	int height = (int) screenSize.getHeight();
	
	private JButton BoutonJouer;
	private JButton BoutonChoisirNiveau;
	private JButton BoutonOptions;
	private JButton BoutonQuitterJeu;
	private JButton BoutonRevenirConnexion;
	
	
	
	
	public Menu()  throws IOException{
		
		super("Jeu De Bulles");
		setSize(width,height);
		
		/* Redimensionner les images pour travailler sur tous les Ã©crans */
		// if(width == 1920 && height == 1080) {
		this.setContentPane(new ImagePanel(new ImageIcon("wallpaper.jpg").getImage()));
		 //}
		 
			this.setLayout(null); // permet le position correcte des boutons
			
		 Font police = new Font("Verdana", Font.BOLD, 20);
			this.BoutonJouer = new JButton("Jouer");
			this.BoutonJouer.setBackground(Color.WHITE);
			this.BoutonJouer.setFont(police);
			this.BoutonJouer.setBounds((int) (width / 2.5), height / 3, width / 6, height / 10);
		this.getContentPane().add(this.BoutonJouer, BorderLayout.CENTER);
		
		
		
		this.BoutonJouer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Jeu.State = STATE.GAME;
				dispose();
				try {
					Jeu.controller();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
	
			this.BoutonChoisirNiveau = new JButton("Choisir Niveau");
			this.BoutonChoisirNiveau.setBackground(Color.WHITE);
			this.BoutonChoisirNiveau.setFont(police);
			this.BoutonChoisirNiveau.setBounds((int) (width / 2.5), (int)(height / 2), width / 6, height / 10);
		this.getContentPane().add(this.BoutonChoisirNiveau, BorderLayout.CENTER);
		
		
		this.BoutonChoisirNiveau.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Jeu.State = STATE.SELECTION_NIVEAU;
				dispose();
				try {
					Jeu.controller();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		

		this.BoutonOptions = new JButton("Options");
		this.BoutonOptions.setBackground(Color.WHITE);
		this.BoutonOptions.setFont(police);
		this.BoutonOptions.setBounds((int) (width / 2.5), (int)(height / 1.5), width / 6, height / 10);
	this.getContentPane().add(this.BoutonOptions, BorderLayout.CENTER);
	
	
		

		this.BoutonQuitterJeu = new JButton("Quitter le jeu");
		this.BoutonQuitterJeu.setBackground(Color.WHITE);
		this.BoutonQuitterJeu.setFont(police);
		this.BoutonQuitterJeu.setBounds((int) (width / 2.5), (int)(height / 1.20), width / 6, height / 10);
	this.getContentPane().add(this.BoutonQuitterJeu, BorderLayout.CENTER);
	
	this.BoutonQuitterJeu.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.gc();
			System.exit(0);
			
			
		}
		
	});
	
	this.BoutonRevenirConnexion = new JButton("Revenir Ã  l'Ã©cran de connexion");
	this.BoutonRevenirConnexion.setBackground(Color.ORANGE);
	this.BoutonRevenirConnexion.setFont(police);
	this.BoutonRevenirConnexion.setBounds(100, 900, 500, 75);
this.getContentPane().add(this.BoutonRevenirConnexion, BorderLayout.CENTER);

this.BoutonRevenirConnexion.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Jeu.State = STATE.IDENTIFICATIONS;
		dispose();
		try {
			Jeu.controller();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
});
	
	
		 
		 
		setResizable(false);
	
		
		this.setVisible(true);

//		
	}
	
	
	public static void main(String[] args) throws IOException {
	
		Menu m1 = new Menu();
		//	new Menu2().setVisible(true);
		
		// id1.execute();
	}
	
	
}
