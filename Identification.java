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
import javax.swing.JTextField;

public class Identification extends JFrame {

	// private JPanel fenetre;

	JLabel myLabel;
	private JButton bouton_seconnecter;
	private JButton bouton_reset;
	private static String a;
	JPanel top;
	private JTextField champ_saisie;
	private static Utilisateur utilisateur;
	private String[] utilisateurs;

	public Identification() throws IOException {
		Utilisateur.recupIdentifiants();
		this.utilisateurs = Utilisateur.getutilisateurs();
		this.setContentPane(new ImagePanel(new ImageIcon(
				"D:\\users\\louis\\desktop\\bulle1.jpg").getImage()));
		this.setTitle("La case a bulles");
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		Font police = new Font("Verdana", Font.BOLD, 20);
		this.setLayout(null);
		JComboBox<String> combo = MainPanel.makeComboBox(this.utilisateurs);
		combo.setEditable(true);
		combo.setSelectedIndex(-1);
		this.champ_saisie = (JTextField) combo.getEditor().getEditorComponent();
		this.champ_saisie.setText("");
		this.champ_saisie.addKeyListener(new ComboKeyHandler(combo));
		champ_saisie.setFont(police);
		JPanel p = new JPanel(new BorderLayout());
		p.setBounds(750, 425, 200, 50);
		p.add(combo, BorderLayout.CENTER);
		this.getContentPane().add(p, BorderLayout.CENTER);
		Insets insets = this.getInsets();
		this.bouton_seconnecter = new JButton("Se connecter");
		this.bouton_seconnecter.setBackground(Color.ORANGE);
		this.bouton_seconnecter.setFont(police);
		this.bouton_seconnecter.setBounds(1000, 400, 200, 75);
		this.getContentPane().add(this.bouton_seconnecter, BorderLayout.CENTER);
		this.bouton_seconnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilisateur = new Utilisateur(
						champ_saisie.getText() == null ? "" : champ_saisie
								.getText());
				try {
					utilisateur.Identification();
				} catch (IOException e1) { // TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(utilisateur.toString());
			}
		});
		this.bouton_reset = new JButton("Reinitialiser les utilisateurs");
		this.bouton_reset.setBackground(Color.RED);
		this.bouton_reset.setFont(police);
		this.bouton_reset.setBounds(1450, 900, 400, 75);
		this.getContentPane().add(this.bouton_reset, BorderLayout.SOUTH);
		this.bouton_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utilisateur.reinitialisation(true);
			}
		});
		this.setVisible(true);

	}

	public Utilisateur getutilisateur() {
		return this.utilisateur;
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
