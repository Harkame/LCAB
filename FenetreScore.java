package projet_bulles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class FenetreScore extends JFrame {

	// private JPanel fenetre;

	// JLabel myLabel;
	private JTable table;

	private static Utilisateur utilisateur = Jeu.getutilisateur();

	// private static Utilisateur utilisateur = Jeu.getutilisateur();
	// !!! A regler
	// private static Utilisateur utilisateur = new Utilisateur("marion"); //
	// !!! Lance l'exception java.lang.ArrayIndexOutOfBoundsException: 8

	public void initialization(Object[][] valeurs) {
		Object[][] tableau_niveau1 = utilisateur.niveau1toMatrice(); // On
																		// recupÃƒÆ’Ã‚Â¨re
																		// les
																		// scores
																		// du
																		// niveau
																		// statique
																		// sous
																		// forme
																		// de
																		// matrice
		Object[][] tableau_niveau2 = utilisateur.niveau2toMatrice(); // MÃƒÆ’Ã‚Âªme
																		// chose
																		// pour
																		// le
																		// niveau
																		// mobile
		for (int j = 0; j < 4; j++) { // Pour chaque des palliers 4/niveau
			valeurs[j][2] = tableau_niveau1[j][0]; // On attribut le nombre de
													// clics du niveau 1
			valeurs[j][3] = tableau_niveau1[j][1]; // nombre de bulles du niveau
													// 1
			valeurs[j][5] = tableau_niveau2[j][0]; // MÃƒÆ’Ã‚Âªme chose mais
													// niveau
													// 2
			valeurs[j][6] = tableau_niveau2[j][1]; // Encore mÃƒÆ’Ã‚Âªme chose
													// mais
													// niveau 2
		}
	}

	public FenetreScore() throws IOException {

		 this.setContentPane(new ImagePanel(new ImageIcon(getClass().getResource("/wallpaper.jpg")).getImage()));
		this.setTitle("La case a bulles"); // On titre la fenÃƒÆ’Ã‚Âªtre
		this.setExtendedState(Frame.MAXIMIZED_BOTH); // Plein ecran
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Si on clique sur
		
		this.setVisible(true); // On affiche la fenÃƒÆ’Ã‚Âªtre
		// la croix
		// le processus
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // RÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â©cupÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â©ration
		int width = (int) screenSize.getWidth(); // La largeur
		int height = (int) screenSize.getHeight(); // La hauteur
		this.setLayout(null);
		//this.setLocationRelativeTo(null); // La fenÃƒÆ’Ã‚Âªtre est independante
		Object[][] valeurs = {
				{ "Pallier 1", null, null, null, null, null, null },
				{ "Pallier 2", null, null, null, null, null, null },
				{ "Pallier 3", null, null, null, null, null, null },
				{ "Pallier 4", null, null, null, null, null, null }, }; // Par
																		// default
																		// les
																		// valeurs
																		// sont
		Font police = new Font("Verdana", Font.BOLD, 30);
		// ÃƒÆ’Ã‚Â 
		// null
		String[] titre = { "Pallier", "niveau 1", "nombre de clics",
				"nombre de bulles", "niveau 2", "nombre de clics",
				"nombre de bulles" }; // les titres de chacune des colonnes de
										// la grille des scores
		this.table =  new JTable(valeurs, titre) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
			}; // On cree une JTable
													// (grille), avec les scores
													// et les valeurs
		initialization(valeurs); // On va initialiser les valeurs des scores
		table.setFont(police);
		table.setRowHeight(table.getRowHeight() + 30);
		table.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 18));
		
		// table.get
		/*
		 * Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		 * table.setPreferredScrollableViewportSize(screen);
		 */
		// scroller
		JScrollPane scrollpane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // Si besoin il y a
																// une scrollbar
		scrollpane.setBounds(0,0,width,height/4+(height/28));
		
	
		JButton MenuPrincipal = new JButton("Menu principal");
		MenuPrincipal.setBackground(Color.CYAN);
		MenuPrincipal.setFont(police);
		MenuPrincipal.setBounds((int) width / 3, height / 2,
				(int) (width / 3.5), height / 15);

		MenuPrincipal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Jeu.State = Jeu.STATE.MENU;
				dispose();
				try {
					Jeu.controller();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});
		
		JLabel monFond=new JLabel(new ImageIcon(getClass().getResource("/wallpaper.jpg")));
		monFond.setBounds(0,0,width,height);
		this.getContentPane().add(MenuPrincipal, BorderLayout.CENTER);
		
		
		this.getContentPane().add(scrollpane); // On l'ajoute
		this.getContentPane().add(monFond);
	}

	public boolean isCellEditable(int row, int col) {
		if (row == 0 && col == 0) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) throws IOException {
		// FenetreScore id1 = new FenetreScore(); invalide maintenant
		// id1.execute();
	}
}
