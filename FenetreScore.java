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
	private static Utilisateur utilisateur = Jeu.getutilisateur();
	static {
		try {
			utilisateur.Identification();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initialization(Object[][] valeurs) {
		Object[][] tableau_niveau1 = utilisateur.niveau1toMatrice();
		Object[][] tableau_niveau2 = utilisateur.niveau2toMatrice();
		for (int j = 0; j < 4; j++) {
			System.out.println(j);
			valeurs[j][2] = tableau_niveau1[j][0];
			valeurs[j][3] = tableau_niveau1[j][1];
			valeurs[j][5] = tableau_niveau2[j][0];
			valeurs[j][6] = tableau_niveau2[j][1];
		}
	}

	public FenetreScore() throws IOException {

		// this.setContentPane(new ImagePanel(new ImageIcon(
		// "/home/ann2/daviaudl/Bureau/bulle1.jpg").getImage()));
		this.setTitle("La case a bulles"); //
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //
		this.setLocationRelativeTo(null);
		Object[][] valeurs = {
				{ "Pallier 1", null, null, null, null, null, null },
				{ "Pallier 2", null, null, null, null, null, null },
				{ "Pallier 3", null, null, null, null, null, null },
				{ "Pallier 4", null, null, null, null, null, null }, };
		String[] titre = { "Pallier", "niveau 1", "nombre de clics",
				"nombre de bulles", "niveau 2", "nombre de clics",
				"nombre de bulles" };
		JTable table = new JTable(valeurs, titre); // <<<<<<<<<<<<<<<<<<<<<
		initialization(valeurs);
		/*
		 * Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		 * table.setPreferredScrollableViewportSize(screen);
		 */
		// scroller
		JScrollPane scrollpane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.getContentPane().add(scrollpane);
		this.setVisible(true);
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
