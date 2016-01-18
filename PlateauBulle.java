package projet_bulles;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JWindow;
import javax.swing.KeyStroke;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
import java.awt.FlowLayout;

import projet_bulles.Jeu.STATE;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.io.IOException;

public class PlateauBulle extends JFrame { // creation de la fenetre
	public static JPanel pan; // notre conteneur
	public static Annimation[] anim; // tableau animmation qui contiendra tout
										// nos objets animmation
	private int countClick = 0; // le nombre de click total
	private int countBulleEclat = 0; // nombre de click total sur les bulles
	private Dimension dimension = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize(); // recuperation des dimensions de l'ecrant
	private int height = (int) dimension.getHeight();
	private int width = (int) dimension.getWidth();
	private JButton palierSuivant; // Declaration bouton palier suivant
	private JButton MenuPrincipal; // Declaration bouton Menu Principal
	Font police = new Font("Verdana", Font.BOLD, 15); // Police de notre texte

	/**
	 */
	public PlateauBulle(int nb, int taille, int vitesse) {

		this.setContentPane(new ImagePanel(new ImageIcon(getClass()
				.getResource("/lefond.jpg")).getImage()));
		// Les lignes de code ci-dessus font des bugs graphiques, c'est le code
		// pour afficher 'Appuyez Echap pour afficher le menu'
		// Il est dÃƒÂ©sormais remplacÃƒÂ© par les trois lignes de code ci-dessous

		JLabel text = new JLabel("Appuyez sur Echap pour afficher le menu");
		text.setFont(new Font("Serif", Font.BOLD, 25));
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		text.setForeground(Color.white);
		text.setOpaque(true);
		text.setBackground(Color.black);

		// this.add(text);

		this.MenuPrincipal = new JButton("Menu Principal");
		this.MenuPrincipal.setBackground(Color.WHITE);
		this.MenuPrincipal.setFont(police);
		this.MenuPrincipal.setBounds((int) (width / 3 * 1.05), height / 3,
				width / 6, height / 10);
		// this.getContentPane().add(this.MenuPrincipal);
		// this.MenuPrincipal.setVisible(false);

		this.MenuPrincipal.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Jeu.State = STATE.MENU;
				dispose(); // efface l'ecran de connexion
				try {
					Jeu.controller();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		this.setTitle("La case a bulles");
		this.setSize(1000, 1000);
		this.setExtendedState(Frame.MAXIMIZED_BOTH); // fenetre plein ecrant
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // stopper le
																// programme en
																// au click sur
																// la croix
		this.pan = (JPanel) this.getContentPane(); // instanciation de mon
													// conteneur
		this.setContentPane(pan); // je choisi mon contenneur
		this.setVisible(true); // rentdre ma fenetre visible
		this.pan.setLayout(null); // aucune disposition par default dans mon
									// conteneur ce qui permet de deplacer comme
									// on veut notre label
		anim = new Annimation[nb];

		this.palierSuivant = new JButton("Palier Suivant"); // creation du
															// bouton palier
															// suivant
		this.palierSuivant.setBackground(Color.WHITE);
		this.palierSuivant.setBounds((width / 2) - 115, (height / 2) + 200,
				300, 75); // a replacer
		this.palierSuivant.addActionListener(new ActionListener() { // definition
																	// d'une
																	// action ÃƒÂ 
																	// chaque
																	// clique
																	// sur
																	// palier
																	// suivant
					public void actionPerformed(ActionEvent e) {

						dispose();
						if (nb + 2 <= 11) { // si on est pas deja au dernier
											// palier (donc a 9 bulles
											// presentes)
							if (vitesse == 0) { // envoie au palier "statique"
												// ou "mobile" suivant l'actuel
								if (taille + 1 <= 3) {

									PlateauBulle N1 = new PlateauBulle(nb + 2,
											taille + 1, 0);
								} else {
									PlateauBulle N1 = new PlateauBulle(nb + 2,
											taille, 0);
								}
							} else if (taille + 1 <= 3) {
								PlateauBulle N1 = new PlateauBulle(nb + 2,
										taille + 1, 1);
							}

							else {
								PlateauBulle N1 = new PlateauBulle(nb + 2,
										taille, 1);
							}

						}

					}

				});

		this.getContentPane().add(this.palierSuivant);
		this.palierSuivant.setVisible(false);

		for (int i = 0; i < nb; i++) { // realisation de nb objet annimation
			anim[i] = new Annimation("anim", pan, taille, vitesse);
		}
		for (int i = 0; i < nb; i++) { // lancement des nb objet annimation
			anim[i].start();
		}
		for (int i = 0; i < nb; i++) { // Une action a chaque bulle
			anim[i].getBulle().getLabel().addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent me) {
					countBulleEclat++;
					if (nb - countBulleEclat == 0) { // quand il n'y a plus de
														// bulle
						Icon imageFelicitation = new ImageIcon(getClass()
								.getResource("/feuDartifice.gif")); // mettre
																	// ici le
																	// gif ÃƒÆ’Ã‚Â 
																	// la place
						JLabel labelFelicit = new JLabel(imageFelicitation);
						pan.add(labelFelicit);
						labelFelicit.setBounds(width / 3, height / 8, 500, 500);

						int palier;
						int nombre_clics = 0;

						if (vitesse > 0) {
							if (nb == 11) {
								palier = 8;
							} else {
								palier = taille + 4;
							}
							nombre_clics = countClick;
							try {
								Jeu.getutilisateur().modifieScore(palier,
										nombre_clics); // modification
														// des scores
														// sur le
														// fichier
														// utilisateur.txt
								Jeu.getutilisateur().maj();
							} catch (IOException e) {
								e.getMessage();
								e.printStackTrace();
							}
							if (taille + 1 > 3 && nb + 2 > 11) {
								JLabel fin = new JLabel(
										"Vous avez termine ce mode de jeu, bravo !!!");
								Font font = new Font("Arial",Font.BOLD,12);
								fin.setFont(font);
								fin.setForeground(Color.white);
								pan.add(fin);
								fin.setBounds(width / 2, height / 3, 500, 500);
								MenuPrincipal.setBounds(
										(int) (width / 2) - 115,
										(height / 2) + 200, 300, 75);
								pan.add(MenuPrincipal);

							} else {
								palierSuivant.setVisible(true);
							}
						} else {
							if (nb == 11) {
								palier = 4;
							} else {
								palier = taille;
							}
							nombre_clics = countClick;
							try {
								Identification.getutilisateur().modifieScore(
										palier, nombre_clics);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if (taille + 1 > 3 && nb + 2 > 11) {
								JLabel fin = new JLabel(
										"Vous avez termine ce mode de jeu, bravo !!!");
								Font font = new Font("Arial",Font.BOLD,12);
								fin.setFont(font);
								fin.setForeground(Color.white);
								pan.add(fin);
								fin.setBounds(width / 2, height / 3, 500, 500);
								MenuPrincipal.setBounds(
										(int) (width / 2) - 115,
										(height / 2) + 200, 300, 75);
								pan.add(MenuPrincipal);

							} else {
								palierSuivant.setVisible(true);
							}

						}

					}

				}

			});
		}
		this.pan.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				countClick++;
				System.out.println(countClick);
				// TODO Auto-generated catch block

			}
		});

		Action action = new AbstractAction("Echap") {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				/*
				 * Jeu.State = STATE.MENU; dispose(); try { Jeu.controller(); }
				 * catch (IOException e) { // TODO Auto-generated catch block
				 * e.printStackTrace(); }
				 */

				final JFrame MenuBox = new JFrame(); // Fait le menu echap
				MenuBox.setSize(600, 600);
				MenuBox.getContentPane().setBackground(Color.BLACK);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				MenuBox.setLocation(
						dim.width / 2 - MenuBox.getSize().width / 2, dim.height
								/ 2 - MenuBox.getSize().height / 2); // met la
																		// taille
				MenuBox.setUndecorated(true);
				MenuBox.setContentPane(new ImagePanel(new ImageIcon(getClass()
						.getResource("/wallpaper.jpg")).getImage()));
				MenuBox.setVisible(true);

				JButton RevenirJeu;
				JButton MenuPrincipal;
				JButton ChoisirNiveau;
				JButton QuitterJeu;

				MenuBox.setLayout(null);
				Font police = new Font("Verdana", Font.BOLD, 20);

				RevenirJeu = new JButton("Reprendre le jeu");
				RevenirJeu.setBackground(Color.CYAN);
				RevenirJeu.setFont(police);
				RevenirJeu.setBounds(215 - 25, 50, 250, 75); // -25 pour le
																// mettre au
																// milieu

				RevenirJeu.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						MenuBox.dispose();

					}

				});

				MenuPrincipal = new JButton("Menu principal");
				MenuPrincipal.setBackground(Color.CYAN);
				MenuPrincipal.setFont(police);
				MenuPrincipal.setBounds(215, 175, 200, 75);

				MenuPrincipal.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						MenuBox.dispose(); // Le Menu disparaÃƒÂ®t
						try {
							RevenirMenuPrincipal();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}

				});

				ChoisirNiveau = new JButton("Niveaux");
				ChoisirNiveau.setBackground(Color.CYAN);
				ChoisirNiveau.setFont(police);
				ChoisirNiveau.setBounds(215, 300, 200, 75);

				ChoisirNiveau.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						MenuBox.dispose();
						try {
							RevenirEcranSelectionNiveau();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}

				});

				QuitterJeu = new JButton("Quitter le jeu");
				QuitterJeu.setBackground(Color.CYAN);
				QuitterJeu.setFont(police);
				QuitterJeu.setBounds(215, 425, 200, 75);

				QuitterJeu.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);

					}

				});

				MenuBox.getContentPane()
						.add(MenuPrincipal, BorderLayout.CENTER); // Ajoute le
																	// bouton ÃƒÂ 
																	// la
																	// fenetre
																	// MenuBox
				MenuBox.getContentPane()
						.add(ChoisirNiveau, BorderLayout.CENTER);
				MenuBox.getContentPane().add(QuitterJeu, BorderLayout.CENTER);
				MenuBox.getContentPane().add(RevenirJeu, BorderLayout.CENTER);

				RevenirJeu.setVisible(true); // rend visisible le bouton
				QuitterJeu.setVisible(true);
				ChoisirNiveau.setVisible(true);
				MenuPrincipal.setVisible(true);

				/*
				 * ÃƒÆ’Ã‚Â  faire pour plus tard Pop up menu en plein jeu plus
				 * propre que revenir au menu et pause le jeu en cours plutot
				 * que de le quitter
				 * 
				 * JWindow w = new JWindow(); w.setLayout(null);
				 * w.setBounds(JeuTest.WIDTH/2 + 150, JeuTest.HEIGHT/2 - 150,
				 * 600, 600); w.setVisible(true);
				 */
				// ExecuteMenu();

			}

		};
		KeyStroke key = KeyStroke.getKeyStroke((char) KeyEvent.VK_ESCAPE); // KeyHandler
																			// pour
																			// echap
																			// pour
																			// afficher
																			// le
																			// menuBox
		pan.getActionMap().put("Echap", action);
		pan.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(key, "Echap");

		this.pan.setLayout(null); // aucune disposition par dÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â©fault dans
									// mon conteneur ce qui permet de
									// dÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â©placer comme on veut notre label
		this.countClick = nb;
		/***/

	}

	public void RevenirMenuPrincipal() throws IOException { // RevenirMenuprincipal
		Jeu.State = STATE.MENU;
		this.dispose();
		Jeu.controller();
	}

	public void RevenirEcranSelectionNiveau() throws IOException { // RevenirEcranSelectionNiveau
		Jeu.State = STATE.SELECTION_NIVEAU;
		this.dispose();
		Jeu.controller();
	}

	public static void main(String[] args) {
		new PlateauBulle(9, 5, 0);
		// aprÃƒÆ’Ã‚Â¨s cette instruction rien ne peut s'excuter car j'utilise un
		// true dans la condition d'un tant que

	}
}
