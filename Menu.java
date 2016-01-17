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
import javax.swing.JLabel;
import javax.swing.JPanel;

import projet_bulles.Jeu.STATE;

public class Menu extends JFrame {

	int SCALE = 2;
	String title = "Jeu de Bulles";

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // on
																		// recupere
																		// la
																		// taille
																		// de
																		// l'ecran
	int width = (int) screenSize.getWidth();
	int height = (int) screenSize.getHeight();

	private JButton BoutonJouer; // on defini nos boutons permettant de faire
									// les actions necessaires
	private JButton BoutonChoisirNiveau;
	private JButton BoutonScores;
	private JButton BoutonQuitterJeu;
	private JButton BoutonRevenirConnexion;

	public Menu() throws IOException {
		super("Jeu De Bulles");
		setSize(width, height);
		/* Redimensionner les images pour travailler sur tous les ecrans */
		// if(width == 1920 && height == 1080) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Si on clic sur
		// la croix
		// rouge (en
		// haut a
		// droite), sa
		// fermera le
		// processus
		this.setContentPane(new ImagePanel(new ImageIcon(getClass()
				.getResource("/wallpaper.jpg")).getImage()));
		this.setLayout(null); // permet le position correcte des boutons

		Font police = new Font("Verdana", Font.BOLD, 20);
		this.BoutonJouer = new JButton("Jouer"); // on place notre bouton a
													// l'endroit desire
		this.BoutonJouer.setBackground(Color.WHITE);
		this.BoutonJouer.setFont(police); // Met ÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â  jour la
											// police
		this.BoutonJouer.setBounds((int) (width / 2.5), (int) (height / 6),
				width / 6, height / 10);
		this.getContentPane().add(this.BoutonJouer, BorderLayout.CENTER); // DÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â©finit
																			// la
																			// taille
																			// des
																			// boutons

		this.BoutonJouer.addActionListener(new ActionListener() { // on definit
																	// son
																	// action

					@Override
					public void actionPerformed(ActionEvent e) {
						Jeu.State = STATE.GAME; // ce bouton lance le jeu sur le
												// dernier palier joue par
												// l'utilisateur
						dispose(); // efface la fenÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Âªtre
									// courante
						try {
							Jeu.controller();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});

		// this.BoutonJouer.addActionListener(new ActionListener() {

		// @Override
		// public void actionPerformed(ActionEvent e) {
		// Jeu.State = STATE.GAME;
		// dispose();
		// Utilisateur.antibug();
		// try {
		// Jeu.controller();
		// } catch (IOException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		//
		// }
		//
		// });

		this.BoutonChoisirNiveau = new JButton("Choisir Niveau"); // ce bouton
																	// lance la
																	// fenetre
																	// de
																	// selection
		this.BoutonChoisirNiveau.setBackground(Color.WHITE);// du palier
		this.BoutonChoisirNiveau.setFont(police); // Met la police
		this.BoutonChoisirNiveau.setBounds((int) (width / 2.5),
				(int) (height / 3), width / 6, height / 10);
		this.getContentPane()
				.add(this.BoutonChoisirNiveau, BorderLayout.CENTER); // Met
																		// ÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â 
																		// jour
																		// la
																		// taille
																		// de
																		// bouton

		this.BoutonChoisirNiveau.addActionListener(new ActionListener() { // Key
																			// handler
																			// du
																			// bouton
																			// choisir
																			// niveau

					@Override
					public void actionPerformed(ActionEvent e) {
						Jeu.State = STATE.SELECTION_NIVEAU; // met
															// ÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â 
															// jour
															// l'ÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â©tat
															// =
															// selection niveau
						dispose(); // efface la fenetre
						try {
							Jeu.controller(); // lance le controller de la
												// classe jeu
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}

				});

		this.BoutonScores = new JButton("Score"); // ce bouton revoie le fenetre
													// de score de l'utilisateur
													// actuel
		this.BoutonScores.setBackground(Color.WHITE);
		this.BoutonScores.setFont(police);
		this.BoutonScores.setBounds((int) (width / 2.5), (int) (height / 2),
				width / 6, height / 10);
		this.getContentPane().add(this.BoutonScores, BorderLayout.CENTER);

		this.BoutonScores.addActionListener(new ActionListener() { // Key
																	// handler
																	// du bouton
																	// score

					@Override
					public void actionPerformed(ActionEvent e) { // lance le
																	// score
						Jeu.State = STATE.SCORES;
						dispose();
						try {
							Jeu.controller();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}

				});

		this.BoutonQuitterJeu = new JButton("Quitter le jeu"); // ce bouton
																// quitte le jeu
		this.BoutonQuitterJeu.setBackground(Color.WHITE); // met
															// l'arriÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â¨re
															// plan
															// du bouton en
															// oculeur blanc
		this.BoutonQuitterJeu.setFont(police);// met la police au font
		this.BoutonQuitterJeu.setBounds((int) (width / 2.5),
				(int) (height / 1.5), width / 6, height / 10);
		this.getContentPane().add(this.BoutonQuitterJeu, BorderLayout.CENTER); // dÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â©finit
																				// l'emplacement
																				// du
																				// bouton

		this.BoutonQuitterJeu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.gc();
				System.exit(0);

			}

		});

		this.BoutonRevenirConnexion = new JButton(
				"Revenir a l'ecran de connexion"); // bouton de
													// revenirÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â 
													// la
													// correction
		this.BoutonRevenirConnexion.setBackground(Color.ORANGE);// met
																// ÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â 
																// la
																// couleur
																// orange
		this.BoutonRevenirConnexion.setFont(police);
		this.BoutonRevenirConnexion.setBounds((int) (width / 20),
				(int) (height / 1.2), width / 3, height / 10); // dÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â©finit
																// la
																// taille
		this.getContentPane().add(this.BoutonRevenirConnexion,
				BorderLayout.CENTER);

		this.BoutonRevenirConnexion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) { // Met
															// ÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â 
															// jour
															// l'ÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â©tat
															// et
															// efface
															// la
															// fenÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Âªtre
															// actuelle
				Jeu.State = STATE.IDENTIFICATIONS;
				dispose(); // efface la fenÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Âªtre actuelle
				try {
					Jeu.controller(); // execute le controller
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		police = new Font("Verdana", Font.BOLD, 30);
		JLabel identifiant = new JLabel("Bienvenue, "
				+ Jeu.getutilisateur().getIdentifiant());
		JLabel pallier_actuel = new JLabel("Pallier actuel : "
				+ Jeu.getutilisateur().getpallier_actuel());
		identifiant.setBounds((int) (width / 6), -(int) (height / 2.5), width,
				height);
		pallier_actuel.setBounds((int) (width / 6), -(int) (height / 3), width,
				height);
		identifiant.setFont(police);
		pallier_actuel.setFont(police);
		identifiant.setForeground(Color.WHITE);
		pallier_actuel.setForeground(Color.WHITE);
		this.add(identifiant);
		this.add(pallier_actuel);
		setResizable(false);
		this.setVisible(true);
		//
	}

	public static void main(String[] args) throws IOException {

		Menu m1 = new Menu();
		// new Menu2().setVisible(true);

		// id1.execute();
	}

}
