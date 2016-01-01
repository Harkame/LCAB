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

	JLabel myLabel;

//	private static Utilisateur recup = Identification.getutilisateur();
//	private static Utilisateur utilisateur = new Utilisateur(recup.getIdentifiant());
//	private static Utilisateur utilisateur = Jeu.getutilisateur();
	// !!! A régler
	private static Utilisateur utilisateur = new Utilisateur("marion"); // !!! Lance l'exception  java.lang.ArrayIndexOutOfBoundsException: 8
	static {
		try {
			utilisateur.Identification(); //On fait une identification de l'utilisateur courant
		} catch (IOException e) {
		}
	}

	public void initialization(Object[][] valeurs) {
		Object[][] tableau_niveau1 = utilisateur.niveau1toMatrice(); //On récupère les scores du niveau statique sous forme de matrice
		Object[][] tableau_niveau2 = utilisateur.niveau2toMatrice(); //Même chose pour le niveau mobile
		for (int j = 0; j < 4; j++) { //Pour chaque des palliers 4/niveau
			valeurs[j][2] = tableau_niveau1[j][0]; //On attribut le nombre de clics du niveau 1
			valeurs[j][3] = tableau_niveau1[j][1]; //nombre de bulles du niveau 1
			valeurs[j][5] = tableau_niveau2[j][0]; // Même chose mais niveau 2
			valeurs[j][6] = tableau_niveau2[j][1]; // Encore même chose mais niveau 2
		}
	}

	public FenetreScore() throws IOException {

		// this.setContentPane(new ImagePanel(new ImageIcon(
		// "/home/ann2/daviaudl/Bureau/bulle1.jpg").getImage()));
		this.setTitle("La case a bulles"); //On titre la fenêtre
		this.setExtendedState(Frame.MAXIMIZED_BOTH); //Plein écran
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Si on clique sur la croix rouge, sa tue le processus
		this.setLocationRelativeTo(null); //La fenêtre est indépendante
		Object[][] valeurs = {
				{ "Pallier 1", null, null, null, null, null, null },
				{ "Pallier 2", null, null, null, null, null, null },
				{ "Pallier 3", null, null, null, null, null, null },
				{ "Pallier 4", null, null, null, null, null, null }, }; //Par défault les valeurs sont à null
		String[] titre = { "Pallier", "niveau 1", "nombre de clics",
				"nombre de bulles", "niveau 2", "nombre de clics",
				"nombre de bulles" }; //les titres de chacune des colonnes de la grille des scores
		JTable table = new JTable(valeurs, titre); // On crée une JTable (grille), avec les scores et les valeurs
		initialization(valeurs); //On va initialiser les valeurs des scores
		/*
		 * Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		 * table.setPreferredScrollableViewportSize(screen);
		 */
		// scroller
		JScrollPane scrollpane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); //Si besoin il y a une scrollbar
		this.getContentPane().add(scrollpane); //On l'ajoute
		this.setVisible(true); //On affiche la fenêtre
	}

	public boolean isCellEditable(int row, int col) {
		if (row == 0 && col == 0) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) throws IOException {
		FenetreScore id1 = new FenetreScore();
		// id1.execute();
	}
}
