package fr.harkame.lcab.fenetre;

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

import fr.harkame.lcab.fenetre.*;
import fr.harkame.lcab.main.Jeu;
import fr.harkame.lcab.main.Jeu.STATE;
import fr.harkame.lcab.model.*;

public class ChoisirNiveau extends JFrame implements KeyListener {

	Utilisateur		utilisateur	= Jeu.getutilisateur();

	Dimension		screenSize	= Toolkit.getDefaultToolkit().getScreenSize();	// ces
																				// lignes
																				// vont
																				// servir
																				// a
																				// connaitre
	int				width		= (int) screenSize.getWidth();					// la
																				// taille
																				// des
																				// ecrans
																				// de
																				// l'utilisateur.
	int				height		= (int) screenSize.getHeight();
	private JButton	NiveauStatique1;											// chaque
																				// bouton
																				// correspondra
																				// a
																				// un
																				// bouton
																				// de
																				// palier
	private JButton	NiveauStatique2;											// NiveauStatique2
																				// est
																				// le
																				// 2eme
																				// palier
																				// du
																				// mode
																				// statique.
	private JButton	NiveauStatique3;											//
	private JButton	NiveauStatique4;											//
	private JButton	NiveauMobile1;												// NiveauMobile
																				// est
																				// le
																				// 1er
																				// palier
																				// du
																				// mode
																				// mobile
	private JButton	NiveauMobile2;												//
	private JButton	NiveauMobile3;												//
	private JButton	NiveauMobile4;												//
	private JButton	MenuPrincipal;												//
	double			w			= width / 1.60;									// on
																				// prend
																				// dans
																				// une
																				// variable
																				// la
																				// largeur
																				// de
																				// l'ecran
																				// divisee
																				// par
																				// 1.75
	double			h			= height / 1.5;									// on
																				// prend
																				// dans
																				// une
																				// variable
																				// la
																				// hauteur
																				// de
																				// l'ecran
																				// divisee
																				// par
																				// 1.5

	public ChoisirNiveau() {

		super("Jeu De Bulles");
		setSize(width, height);
		int i = 0;

		/*
		 * Redimensionner les images pour travailler sur tous les
		 * ÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â©crans
		 */
		// if(width == 1920 && height == 1080) {
		this.setContentPane(new ImagePanel(new ImageIcon(getClass().getResource("/wallpaper.jpg")).getImage()));
		this.setVisible(true);
		this.setLayout(null); // permet le position correcte des boutons
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font police = new Font("Verdana", Font.BOLD, 15); // on choisi la police
															// du texte

		this.NiveauStatique1 = new JButton("Niveau Statique1"); // on cree le
																// bouton qui
																// permettra de
																// lancer un
																// palier
		this.NiveauStatique1.setBackground(Color.WHITE);// statique de
														// difficulte 1, et on
														// le place au bon
														// endroit
		this.NiveauStatique1.setFont(police);// sur la fenetre
		this.NiveauStatique1.setBounds((int) (width / 7), height / 6, width / 5, height / 10);
		NiveauStatique1.setEnabled(true);
		this.getContentPane().add(this.NiveauStatique1);
		i++;
		this.NiveauStatique2 = new JButton("Niveau Statique2");
		this.NiveauStatique2.setBackground(Color.WHITE);
		this.NiveauStatique2.setFont(police);
		this.NiveauStatique2.setBounds(width / 7, height / 3, width / 5, height / 10);
		if (this.utilisateur.getscores()[i - 1].getnombre_clics() != 0) {
			NiveauStatique2.setEnabled(true);
		} else {
			NiveauStatique2.setEnabled(false);
		}
		this.getContentPane().add(this.NiveauStatique2);
		i++;
		this.NiveauStatique3 = new JButton("Niveau Statique3");
		this.NiveauStatique3.setBackground(Color.WHITE);
		this.NiveauStatique3.setFont(police);
		this.NiveauStatique3.setBounds(width / 7, height / 2, width / 5, height / 10);
		if (this.utilisateur.getscores()[i - 1].getnombre_clics() != 0) {
			NiveauStatique3.setEnabled(true);
		} else {
			NiveauStatique3.setEnabled(false);
		}
		this.getContentPane().add(this.NiveauStatique3);
		i++;
		this.NiveauStatique4 = new JButton("Niveau Statique4");
		this.NiveauStatique4.setBackground(Color.WHITE);
		this.NiveauStatique4.setFont(police);
		this.NiveauStatique4.setBounds(width / 7, (int) h, width / 5, height / 10);
		if (this.utilisateur.getscores()[i - 1].getnombre_clics() != 0) {
			NiveauStatique4.setEnabled(true);
		} else {
			NiveauStatique4.setEnabled(false);
		}
		this.getContentPane().add(this.NiveauStatique4);
		i++;
		this.NiveauMobile1 = new JButton("Niveau mobile1"); // on cree le bouton
															// qui permettra de
															// lancer le palier
		this.NiveauMobile1.setBackground(Color.WHITE); // de niveau mobile de
														// difficulte 1 et on le
														// place
		this.NiveauMobile1.setFont(police);
		this.NiveauMobile1.setBounds((int) w, height / 6, width / 5, height / 10);
		if (this.utilisateur.getscores()[i - 1].getnombre_clics() != 0) {
			NiveauMobile1.setEnabled(true);
		} else {
			NiveauMobile1.setEnabled(false);
		}
		this.getContentPane().add(this.NiveauMobile1);
		i++;
		this.NiveauMobile2 = new JButton("Niveau mobile2");
		this.NiveauMobile2.setBackground(Color.WHITE);
		this.NiveauMobile2.setFont(police);
		this.NiveauMobile2.setBounds((int) w, height / 3, width / 5, height / 10);
		if (this.utilisateur.getscores()[i - 1].getnombre_clics() != 0) {
			NiveauMobile2.setEnabled(true);
		} else {
			NiveauMobile2.setEnabled(false);
		}
		this.getContentPane().add(this.NiveauMobile2);
		i++;
		this.NiveauMobile3 = new JButton("Niveau mobile3");
		this.NiveauMobile3.setBackground(Color.WHITE);
		this.NiveauMobile3.setFont(police);
		this.NiveauMobile3.setBounds((int) w, height / 2, width / 5, height / 10);
		if (this.utilisateur.getscores()[i - 1].getnombre_clics() != 0) {
			NiveauMobile3.setEnabled(true);
		} else {
			NiveauMobile3.setEnabled(false);
		}
		this.getContentPane().add(this.NiveauMobile3);
		i++;
		this.NiveauMobile4 = new JButton("Niveau mobile4");
		this.NiveauMobile4.setBackground(Color.WHITE);
		this.NiveauMobile4.setFont(police);
		this.NiveauMobile4.setBounds((int) w, (int) h, width / 5, height / 10);
		if (this.utilisateur.getscores()[i - 1].getnombre_clics() != 0) {
			NiveauMobile4.setEnabled(true);
		} else {
			NiveauMobile4.setEnabled(false);
		}
		this.getContentPane().add(this.NiveauMobile4);
		i++;
		this.MenuPrincipal = new JButton("Menu Principal"); // on place un
															// bouton permettant
		this.MenuPrincipal.setBackground(Color.WHITE);// de revenir au menu
														// principal
		this.MenuPrincipal.setFont(police);
		this.MenuPrincipal.setBounds((int) (width / 2.5), height / 2, width / 6, height / 10);
		this.getContentPane().add(this.MenuPrincipal, BorderLayout.CENTER);

		this.NiveauStatique1.addActionListener(new ActionListener(){ // on
																		// choisi
																		// l'action
																		// au
																		// clic
																		// du
																		// bouton

			public void actionPerformed(ActionEvent e) {

				dispose();

				PlateauBulle N1 = new PlateauBulle(5, 1, 0); // on lance
																// un
																// palier
																// correspond
																// a la
																// difficulte
																// 1
				// d'un niveau statique
			}
		});

		this.NiveauStatique2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {

				dispose();

				PlateauBulle N1 = new PlateauBulle(7, 2, 0);

			}
		});

		this.NiveauStatique3.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {

				dispose();

				PlateauBulle N1 = new PlateauBulle(9, 3, 0);

			}
		});

		this.NiveauStatique4.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {

				dispose();

				PlateauBulle N1 = new PlateauBulle(11, 3, 0);

			}
		});

		this.NiveauMobile1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {

				dispose();

				PlateauBulle N1 = new PlateauBulle(5, 1, 1);

			}
		});

		this.NiveauMobile2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {

				dispose();

				PlateauBulle N1 = new PlateauBulle(7, 2, 1);

			}
		});

		this.NiveauMobile3.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {

				dispose();

				PlateauBulle N1 = new PlateauBulle(9, 2, 1);

			}
		});

		this.NiveauMobile4.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {

				dispose();

				PlateauBulle N1 = new PlateauBulle(11, 3, 1);

			}
		});

		this.setVisible(true);

		this.MenuPrincipal.addActionListener(new ActionListener(){ // on choisi
																	// l'action
																	// au lic du
																	// bouton
																	// menu
																	// principal

			public void actionPerformed(ActionEvent e) {
				Jeu.State = STATE.MENU;
				dispose(); // efface l'ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â©cran de connexion
				try {
					Jeu.controller();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

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

	public static void main(String[] args) {
		ChoisirNiveau ch1 = new ChoisirNiveau();
	}
}
