package projet_bulles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import projet_bulles.Jeu.STATE;

public class Identification extends JFrame {

	// private JPanel fenetre;
	//
	// JLabel myLabel;

	private JButton bouton_seconnecter;
	private JButton bouton_reset;
	private static String a;
	// JPanel top;
	private JTextField champ_saisie;
	private static Utilisateur utilisateur;
	private String[] utilisateurs;

	static boolean connecte = true; // ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â  changer

	public Identification() throws IOException {
		this.setContentPane(new ImagePanel(new ImageIcon(getClass()
				.getResource("/wallpaper.jpg")).getImage())); // on met le fond
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // RÃƒÆ’Ã‚Â©cupÃƒÆ’Ã‚Â©ration
																			// des
																			// dimensions
																			// de
																			// l'ÃƒÆ’Ã‚Â©cran
		int width = (int) screenSize.getWidth(); // La largeur
		int height = (int) screenSize.getHeight(); // La hauteur
		final double w = width / 1.5; // La moitiÃƒÆ’Ã‚Â© de l'ÃƒÆ’Ã‚Â©cran
		Utilisateur.recupIdentifiants(); // On rÃƒÆ’Ã‚Â©cup_re tous les
											// identifiants, utile pour la
											// suggestion
		this.utilisateurs = Utilisateur.getutilisateurs(); // On prÃƒÆ’Ã‚Â©pare
															// la
															// suggestions
		this.setTitle("La case a bulles"); // Nommage de la fenÃƒÆ’Ã‚Âªtre
											// (titre)
		this.setExtendedState(Frame.MAXIMIZED_BOTH); // FenÃƒÆ’Ã‚Âªtre en plein
														// ÃƒÆ’Ã‚Â©cran
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Si on clic sur
																// la croix
																// rouge (en
																// haut a
																// droite), sa
																// fermera le
																// processus
		this.setLocationRelativeTo(null); // On localisation de la
											// fenÃƒÆ’Ã‚Âªtre
											// est indÃƒÆ’Ã‚Â©pendante
		Font police = new Font("Verdana", Font.BOLD, 20); // Police lisible et
															// suffisament
															// grosse
		this.setLayout(null); // La fenÃƒÆ’Ã‚Âªtre est null au dÃƒÆ’Ã‚Â©part
								// (utile pour
								// la modifier comme on veux ensuite)
		// make userbox to enter users name
		JComboBox<String> combo = MainPanel.makeComboBox(this.utilisateurs); // On
																				// crÃƒÆ’Ã‚Â©e
																				// les
																				// suggestions
		combo.setEditable(true); // La combo est modifiable
		combo.setSelectedIndex(-1); // A la base il n'y a rien dedans
		this.champ_saisie = (JTextField) combo.getEditor().getEditorComponent(); // CrÃƒÆ’Ã‚Â©ation
																					// du
																					// champ
																					// de
																					// saisie
		this.champ_saisie.setText(""); // Par dÃƒÆ’Ã‚Â©fault il est vide
		this.champ_saisie.addKeyListener(new ComboKeyHandler(combo)); // On y
																		// met
																		// la
																		// combo
																		// pour
																		// les
																		// suggestions
																		// en
																		// temps
																		// rÃƒÆ’Ã‚Â©el
		champ_saisie.setFont(police); // On lui donne la plice crÃƒÆ’Ã‚Â©e
		JPanel p = new JPanel(new BorderLayout()); // on crÃƒÆ’Ã‚Â©e un panel
													// pour
													// le champ de saisie
		p.setBounds(width / 2 - width / 8, height / 3, width / 10, height / 20); // Definition
																					// de
																					// la
																					// taille
																					// du
																					// panel
																					// et
																					// de
																					// sa
																					// position
		p.add(combo, BorderLayout.CENTER); // On y ajoute le combo
		this.getContentPane().add(p, BorderLayout.CENTER); // On l'ajoute a la
															// fenÃƒÆ’Ã‚Âªtre
															// principale
		// ////////////////////////////////////////
		Insets insets = this.getInsets(); // ?
		this.bouton_seconnecter = new JButton("Se connecter"); // CrÃƒÆ’Ã‚Â©ation
																// du
																// bouton se
																// connecter
		this.bouton_seconnecter.setBackground(Color.ORANGE); // Coloration orane
		this.bouton_seconnecter.setFont(police); // On lui donne la police
		this.bouton_seconnecter.setBounds(width / 2, height / 3, width / 5,
				height / 20); // DÃƒÆ’Ã‚Â©finition de sa taille et de la
								// position
		this.getContentPane().add(this.bouton_seconnecter, BorderLayout.CENTER); // On
																					// ajoute
																					// le
																					// bouton
																					// ÃƒÆ’Ã‚Â 
																					// la
																					// fenÃƒÆ’Ã‚Âªtre
		this.bouton_seconnecter.addActionListener(new ActionListener() { // On
																			// donne
																			// un
																			// action
																			// au
																			// bouton
					public void actionPerformed(ActionEvent e) { // Si on clic
																	// dessus
						// Identification.connecte = true; // On passe en
						// connectÃƒÆ’Ã‚Â©
						utilisateur = new Utilisateur(
								champ_saisie.getText() == null ? ""
										: champ_saisie.getText()); // On
																	// crÃƒÆ’Ã‚Â©e
																	// un nouvel
																	// utilisateur
																	// avec le
																	// l'information
																	// dans le
																	// champ de
																	// saisie
						try {
							utilisateur.Identification(); // On fait
															// l'indentification
															// de l'utilisateur
															// (voir fonction)
							dispose(); // On efface l'ÃƒÆ’Ã‚Â©cran
							// new Identification(); //On en recrÃƒÆ’Ã‚Â©e une
							// nouvelle (Sa met ÃƒÆ’Ã‚Â  jour les suggestions
							// avec
							// le nouvel utilisateur)
						} catch (IOException e1) {
						}
						System.out.println(utilisateur.toString()); // On
																	// affiche
																	// dans le
																	// terminal
																	// l'utilisateur
																	// courant,
																	// permet de
																	// verifiÃƒÆ’Ã‚Â©
																	// rapidement
																	// si sa a
																	// marchÃƒÆ’Ã‚Â©
																	// ou pas
																	// (utile
																	// pour le
																	// programmeur)
						boolean valide = Utilisateur.getvalide();
						if (valide == true) { // Si on est passer connecter
							Jeu.State = STATE.MENU; // on est rediriger sur le
													// menu
							dispose(); // efface l'ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â©cran de
										// connexion
							try {
								Jeu.controller();
							} catch (IOException e1) {
							}
						} else {
							try {
								new Identification();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}

					}

				});
		this.bouton_reset = new JButton("Reinitialiser les utilisateurs"); // Cration
																			// du
																			// bouton
																			// reset
		this.bouton_reset.setBackground(Color.WHITE); // Un fond blanc
		this.bouton_reset.setFont(police); // On y met la police
		this.bouton_reset.setBounds((int) w, height - height / 6,
				(int) (width / 3.5), height / 15); // DÃƒÆ’Ã‚Â©finition de la
													// taille
													// et de la position
		this.getContentPane().add(this.bouton_reset, BorderLayout.SOUTH); // On
																			// l'ajoute
																			// a
																			// la
																			// fenÃƒÆ’Ã‚Âªtre
																			// actuel
		this.bouton_reset.addActionListener(new ActionListener() { // DÃƒÆ’Ã‚Â©fition
																	// d'une
																	// action au
																	// moment du
																	// clic
					public void actionPerformed(ActionEvent e) { // Si on clic
																	// dessus
						Utilisateur.reinitialisation(true); // On
															// rÃƒÆ’Ã‚Â©initialiser
															// le fichier texte,
															// true indique
															// qu'on demandera
															// une confirmation
															// ÃƒÆ’Ã‚Â 
															// l'utilisateur
						dispose(); // On ÃƒÆ’Ã‚Â©fface l'ÃƒÆ’Ã‚Â©cran
									// d'identification
						try {
							new Identification(); // On en recrÃƒÆ’Ã‚Â©e une
													// nouvelle (Sa met ÃƒÆ’Ã‚Â 
													// jour les suggestions avec
													// le nouvel utilisateur)
						} catch (IOException e1) {
						}

					}
				});
		this.setVisible(true); // On affiche la fenÃƒÆ’Ã‚Âªtre d'identification
	}

	/*
	 * Retourne l'utilisateur courant
	 */
	public static Utilisateur getutilisateur() {
		return utilisateur;
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Identification id1 = new Identification();
		// id1.execute();
	}
}
