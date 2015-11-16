package projet_bulles;

import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Confirmation {
	private int reponse;

	public Confirmation(String nom) {
		JDialog.setDefaultLookAndFeelDecorated(false);
		this.reponse = JOptionPane.showConfirmDialog(null,
				"Creer l'utilisateur : " + nom + " ?", "Confirmation",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (this.reponse == JOptionPane.NO_OPTION) {
		} else if (this.reponse == JOptionPane.YES_OPTION) {
		} else if (this.reponse == JOptionPane.CLOSED_OPTION) {
		}
	}

	public int getreponse() {
		return this.reponse;
	}

	public static void main(String[] args) {
		Confirmation c = new Confirmation("Jean");
	}
}
