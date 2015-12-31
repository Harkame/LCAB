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

	
	
	
	
	static boolean connecte = true; // Ã  changer

	public Identification() throws IOException {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		final double w = width/1.5;
		Utilisateur.recupIdentifiants();
		this.utilisateurs = Utilisateur.getutilisateurs();
		this.setContentPane(new ImagePanel(new ImageIcon("bulle1.jpg")
				.getImage()));
		this.setTitle("La case a bulles");
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		Font police = new Font("Verdana", Font.BOLD, 20);
		this.setLayout(null);
		// make userbox to enter users name
		JComboBox<String> combo = MainPanel.makeComboBox(this.utilisateurs);
		combo.setEditable(true);
		combo.setSelectedIndex(-1);
		this.champ_saisie = (JTextField) combo.getEditor().getEditorComponent();
		this.champ_saisie.setText("");
		this.champ_saisie.addKeyListener(new ComboKeyHandler(combo));
		champ_saisie.setFont(police);
		JPanel p = new JPanel(new BorderLayout());
		p.setBounds(width / 2 - width / 8, height / 3, width / 10, height / 20);
		p.add(combo, BorderLayout.CENTER);
		this.getContentPane().add(p, BorderLayout.CENTER);
		// ////////////////////////////////////////
		Insets insets = this.getInsets();
		this.bouton_seconnecter = new JButton("Se connecter");
		this.bouton_seconnecter.setBackground(Color.ORANGE);
		this.bouton_seconnecter.setFont(police);
		this.bouton_seconnecter.setBounds(width / 2, height / 3, width / 5,
				height / 20);
		this.getContentPane().add(this.bouton_seconnecter, BorderLayout.CENTER);

		this.bouton_seconnecter.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Identification.connecte = true;
				utilisateur = new Utilisateur(
						champ_saisie.getText() == null ? "" : champ_saisie
								.getText());
				try {
					utilisateur.Identification();
					dispose();
					new Identification();
				} catch (IOException e1) { // TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(utilisateur.toString());
				if (connecte == true) {
					Jeu.State = STATE.MENU;
					dispose(); // efface l'Ã©cran de connexion
					try {
						Jeu.controller();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}

		});
		this.bouton_reset = new JButton("Reinitialiser les utilisateurs");
		this.bouton_reset.setBackground(Color.WHITE);
		this.bouton_reset.setFont(police);
		this.bouton_reset.setBounds((int)w, height - height / 6,
				(int)(width / 3.5), height / 15);
		this.getContentPane().add(this.bouton_reset, BorderLayout.SOUTH);
		this.bouton_reset.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Utilisateur.reinitialisation(true);
				dispose();
				try {
					new Identification();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		this.setVisible(true);

	}

	public static Utilisateur getutilisateur() {
		return utilisateur;
	}

	public String execute() {
		bouton_seconnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilisateur = new Utilisateur(champ_saisie.getText());
				try {
					utilisateur.Identification();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.out.println(utilisateur.toString());
			}
		});

		return a;

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
