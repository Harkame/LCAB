package projet_bulles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
impor5t javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Identification extends JFrame {

	// private JPanel fenetre;

	JLabel myLabel;
	private JButton bouton_seconnecter;
	private JButton bouton_reset;
	private static String a;
	JPanel top;
	private JPanel fenetre = new JPanel();
	private JTextField champ_saisie;
	private JLabel label = new JLabel("Identifiant");
	private static Utilisateur utilisateur;
	private String[] utilisateurs;

	public Identification() {
		try {
			Utilisateur.recupIdentifiants();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.utilisateurs = Utilisateur.getutilisateurs();

		JComboBox<String> combo = MainPanel.makeComboBox(this.utilisateurs);
		combo.setEditable(true);
		combo.setSelectedIndex(-1);
		JPanel p = new JPanel(new BorderLayout());
		p.add(combo, BorderLayout.CENTER);
		this.add(p);
		this.champ_saisie = (JTextField) combo.getEditor().getEditorComponent();
		this.champ_saisie.setText("");
		this.champ_saisie.addKeyListener(new ComboKeyHandler(combo));

		this.setTitle("La case a bulles"); // Donne un titre à la fenêtre
		this.setExtendedState(Frame.MAXIMIZED_BOTH); // Met la fenêtre en plein
														// écran
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Si on clic sur
																// la croix
																// rouge, le
																// process se
																// termine
		this.setLocationRelativeTo(null); // La fenêtre est "independante"
		fenetre.setBackground(Color.white); // Le fond est bleu
		// fenetre.setLayout(new BorderLayout());
		Font police = new Font("Arial", Font.BOLD, 20); // Définition de la
														// police d'écriture et
														// de sa taille
		// champ_saisie.setFont(police); // On active la police dans le champ
		// champ_saisie.setPreferredSize(new Dimension(150, 30));
		this.bouton_seconnecter = new JButton("Se connecter");
		this.bouton_reset = new JButton("Reinitialiser les utilisateurs");
		this.bouton_seconnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilisateur = new Utilisateur(
						champ_saisie.getText() == null ? "" : champ_saisie
								.getText());
				try {
					utilisateur.Identification();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(utilisateur.toString());
			}
		});
		this.bouton_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utilisateur.reinitialisation();
			}
		});
		// champ_saisie.setForeground(Color.BLACK);
		fenetre.add(p, BorderLayout.SOUTH);
		fenetre.add(bouton_seconnecter, BorderLayout.SOUTH);
		fenetre.add(bouton_reset, BorderLayout.SOUTH);
		this.setContentPane(fenetre);
		this.setVisible(true);
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
	 */
	public static void main(String[] args) {
		Identification id1 = new Identification();
		// id1.execute();
	}
}
