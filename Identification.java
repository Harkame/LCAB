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

	static boolean connecte = true; // ÃƒÆ’Ã‚Â  changer

	public Identification() throws IOException {
		this.setContentPane(new ImagePanel(new ImageIcon(getClass()
				.getResource("wallpaper.jpg")).getImage())); // on met le fond
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // RÃƒÂ©cupÃƒÂ©ration
																			// des
																			// dimensions
																			// de
																			// l'ÃƒÂ©cran
		int width = (int) screenSize.getWidth(); // La largeur
		int height = (int) screenSize.getHeight(); // La hauteur
		final double w = width / 1.5; // La moitiÃƒÂ© de l'ÃƒÂ©cran
		Utilisateur.recupIdentifiants(); // On rÃƒÂ©cup_re tous les
											// identifiants, utile pour la
											// suggestion
		this.utilisateurs = Utilisateur.getutilisateurs(); // On prÃƒÂ©pare la
															// suggestions
		this.setTitle("La case a bulles"); // Nommage de la fenÃƒÂªtre (titre)
		this.setExtendedState(Frame.MAXIMIZED_BOTH); // FenÃƒÂªtre en plein
														// ÃƒÂ©cran
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Si on clic sur
																// la croix
																// rouge (en
																// haut a
																// droite), sa
																// fermera le
																// processus
		this.setLocationRelativeTo(null); // On localisation de la fenÃƒÂªtre
											// est indÃƒÂ©pendante
		Font police = new Font("Verdana", Font.BOLD, 20); // Police lisible et
															// suffisament
															// grosse
		this.setLayout(null); // La fenÃƒÂªtre est null au dÃƒÂ©part (utile pour
								// la modifier comme on veux ensuite)
		// make userbox to enter users name
		JComboBox<String> combo = MainPanel.makeComboBox(this.utilisateurs); // On
																				// crÃƒÂ©e
																				// les
																				// suggestions
		combo.setEditable(true); // La combo est modifiable
		combo.setSelectedIndex(-1); // A la base il n'y a rien dedans
		this.champ_saisie = (JTextField) combo.getEditor().getEditorComponent(); // CrÃƒÂ©ation
																					// du
																					// champ
																					// de
																					// saisie
		this.champ_saisie.setText(""); // Par dÃƒÂ©fault il est vide
		this.champ_saisie.addKeyListener(new ComboKeyHandler(combo)); // On y
																		// met
																		// la
																		// combo
																		// pour
																		// les
																		// suggestions
																		// en
																		// temps
																		// rÃƒÂ©el
		champ_saisie.setFont(police); // On lui donne la plice crÃƒÂ©e
		JPanel p = new JPanel(new BorderLayout()); // on crÃƒÂ©e un panel pour
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
															// fenÃƒÂªtre
															// principale
		// ////////////////////////////////////////
		Insets insets = this.getInsets(); // ?
		this.bouton_seconnecter = new JButton("Se connecter"); // CrÃƒÂ©ation du
																// bouton se
																// connecter
		this.bouton_seconnecter.setBackground(Color.ORANGE); // Coloration orane
		this.bouton_seconnecter.setFont(police); // On lui donne la police
		this.bouton_seconnecter.setBounds(width / 2, height / 3, width / 5,
				height / 20); // DÃƒÂ©finition de sa taille et de la position
		this.getContentPane().add(this.bouton_seconnecter, BorderLayout.CENTER); // On
																					// ajoute
																					// le
																					// bouton
																					// ÃƒÂ 
																					// la
																					// fenÃƒÂªtre
		this.bouton_seconnecter.addActionListener(new ActionListener() { // On
																			// donne
																			// un
																			// action
																			// au
																			// bouton
					public void actionPerformed(ActionEvent e) { // Si on clic
																	// dessus
						Identification.connecte = true; // On passe en
														// connectÃƒÂ©
						utilisateur = new Utilisateur(
								champ_saisie.getText() == null ? ""
										: champ_saisie.getText()); // On crÃƒÂ©e
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
							dispose(); // On efface l'ÃƒÂ©cran
							// new Identification(); //On en recrÃƒÂ©e une
							// nouvelle (Sa met ÃƒÂ  jour les suggestions avec
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
																	// verifiÃƒÂ©
																	// rapidement
																	// si sa a
																	// marchÃƒÂ©
																	// ou pas
																	// (utile
																	// pour le
																	// programmeur)
						if (connecte == true) { // Si on est passer connecter
							Jeu.State = STATE.MENU; // on est rediriger sur le
													// menu
							dispose(); // efface l'ÃƒÆ’Ã‚Â©cran de connexion
							try {
								Jeu.controller();
							} catch (IOException e1) {
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
				(int) (width / 3.5), height / 15); // DÃƒÂ©finition de la taille
													// et de la position
		this.getContentPane().add(this.bouton_reset, BorderLayout.SOUTH); // On
																			// l'ajoute
																			// a
																			// la
																			// fenÃƒÂªtre
																			// actuel
		this.bouton_reset.addActionListener(new ActionListener() { // DÃƒÂ©fition
																	// d'une
																	// action au
																	// moment du
																	// clic
					public void actionPerformed(ActionEvent e) { // Si on clic
																	// dessus
						Utilisateur.reinitialisation(true); // On
															// rÃƒÂ©initialiser
															// le fichier texte,
															// true indique
															// qu'on demandera
															// une confirmation
															// ÃƒÂ 
															// l'utilisateur
						dispose(); // On ÃƒÂ©fface l'ÃƒÂ©cran d'identification
						try {
							new Identification(); // On en recrÃƒÂ©e une
													// nouvelle (Sa met ÃƒÂ 
													// jour les suggestions avec
													// le nouvel utilisateur)
						} catch (IOException e1) {
						}

					}
				});
		this.setVisible(true); // On affiche la fenÃƒÂªtre d'identification
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
