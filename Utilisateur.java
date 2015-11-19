package projet_bulles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Utilisateur {
	private String identifiant;
	private static File fichier;
	static {
		fichier = new File("D:\\utilisateurs.txt");
		if (!fichier.exists()) {
		} else {
			try {
				fichier.createNewFile();
			} catch (IOException e) {
			}
		}
	}
	private Score[] scores;
	private int numero_ligne;
	private static String[] utilisateurs;

	public Utilisateur(String p_identifiant) {
		if (p_identifiant.indexOf("|") != -1
				|| p_identifiant.indexOf("-") != -1 || p_identifiant.equals("")
				|| p_identifiant.equals(" ")) {
			new JOptionPane().showMessageDialog(null, "Identifiant incorrect",
					"Erreur", JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			this.identifiant = p_identifiant.toLowerCase();
			this.scores = new Score[10];
			for (int i = 0; i < this.scores.length; i++) {
				this.scores[i] = new Score();
			}
			this.recupNumeroLigne();
		}
	}

	/**
	 * public Utilisateur trouverUtilisateur() throws IOException { try { int i
	 * = 0; StringBuilder ligne = new StringBuilder(); BufferedReader lecteur =
	 * new BufferedReader(new FileReader(fichier)); lecteur = new
	 * BufferedReader(new FileReader(fichier)); while (true) {
	 * ligne.setLength(0); try { ligne.append(lecteur.readLine()); i++; } catch
	 * (IOException e) { } } return ligne.toString(); } catch
	 * (FileNotFoundException e) { } return null; } }
	 * 
	 * @throws IOException
	 **/

	private StringBuilder recupLigne() throws IOException {
		String ligne = new String();
		BufferedReader lecteur = new BufferedReader(new FileReader(fichier));
		StringBuilder identifiant = new StringBuilder();
		while ((ligne = lecteur.readLine()) != null) {
			identifiant.append(recupIdentifiant(ligne));
			if (identifiant.toString().equals(this.identifiant)) {
				lecteur.close();
				identifiant.setLength(0);
				identifiant.append(ligne);
				return identifiant;
			} else {
				identifiant.setLength(0);
			}
		}
		lecteur.close();
		return null;
	}

	private void recupNumeroLigne() {
		BufferedReader lecteur = null;
		try {
			lecteur = new BufferedReader(new FileReader(fichier));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		StringBuilder identifiant = new StringBuilder();
		int cpt = 0;
		String ligne;
		try {
			while ((ligne = lecteur.readLine()) != null) {
				identifiant.append(recupIdentifiant(ligne));
				cpt++;
				if (identifiant.toString().equals(this.identifiant)) {
					lecteur.close();
					this.numero_ligne = cpt - 1;
					return;
				} else {
					identifiant.setLength(0);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			lecteur.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static StringBuilder recupIdentifiant(String ligne) {
		StringBuilder identifiant = new StringBuilder();
		int i = 0;
		try {
			while (ligne.charAt(i) != '|') {
				identifiant.append(ligne.charAt(i));
				i++;
			}
		} catch (StringIndexOutOfBoundsException e) {

		}
		return identifiant;
	}

	static void recupIdentifiants() throws IOException {
		BufferedReader lecteur = new BufferedReader(new FileReader(fichier));
		StringBuilder identifiant = new StringBuilder();
		int compteur = 0;
		String ligne;
		while ((ligne = lecteur.readLine()) != null) {
			compteur++;
		}
		utilisateurs = new String[compteur];
		compteur = 0;
		lecteur = new BufferedReader(new FileReader(fichier));
		while ((ligne = lecteur.readLine()) != null) {
			utilisateurs[compteur] = recupIdentifiant(ligne).toString();
			compteur++;
		}
	}

	private void recupScores(StringBuilder ligne) {
		StringBuilder scores = new StringBuilder();
		StringBuilder strb_ligne = new StringBuilder();
		int i = 0;
		while (ligne.charAt(i) != '|') {
			i++;
		}
		strb_ligne.append(ligne);
		strb_ligne.delete(0, i);
		for (i = 0; i < this.scores.length; i++) {
			this.scores[i].recupScore(strb_ligne);
		}
	}

	private void sauvegarderUtilisateur() throws IOException {
		FileWriter fw = new FileWriter(fichier, true);
		fw.write(this.identifiant.toString() + '|');
		for (int i = 0; i < 10; i++) {
			fw.write("0-0|");
		}
		fw.write(System.getProperty("line.separator"));
		fw.close();
	}

	public void Identification() throws IOException {
		if (this.UtilisateurExistant()) {
			StringBuilder informations = this.recupLigne();
			this.recupIdentifiant(informations.toString());
			this.recupScores(informations);
		} else {
			Alerte c1 = new Alerte(this.identifiant);
			if (c1.getreponse() == 0) {
				this.sauvegarderUtilisateur();
			} else {

			}
		}
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean UtilisateurExistant() throws IOException {
		String ligne = new String();
		BufferedReader lecteur = new BufferedReader(new FileReader(fichier));
		StringBuilder identifiant = new StringBuilder();
		while ((ligne = lecteur.readLine()) != null) {
			identifiant.append(recupIdentifiant(ligne));
			if (identifiant.toString().equals(this.identifiant)) {
				lecteur.close();
				return true;
			} else {
				identifiant.setLength(0);
			}
		}
		lecteur.close();
		return false;
	}

	private static String lireFichier(File fichier, int numero_ligne) {
		try {
			int i = 0;
			StringBuilder ligne = new StringBuilder();
			BufferedReader lecteur = new BufferedReader(new FileReader(fichier));
			lecteur = new BufferedReader(new FileReader(fichier));
			while (i <= numero_ligne) {
				ligne.setLength(0);
				try {
					ligne.append(lecteur.readLine());
					i++;
				} catch (IOException e) {
				}
			}
			return ligne.toString();
		} catch (FileNotFoundException e) {
		}
		return null;
	}

	public String toString() {
		StringBuilder utilisateur = new StringBuilder();
		utilisateur.append(this.identifiant
				+ System.getProperty("line.separator"));
		for (int i = 0; i < this.scores.length; i++) {
			switch (i) {
			default:
				utilisateur.append("Pallier " + (i + 1) + "  ~ "
						+ this.scores[i].toString()
						+ System.getProperty("line.separator"));
				break;
			case 9:
				utilisateur.append("Pallier " + (i + 1) + " ~ "
						+ this.scores[i].toString()
						+ System.getProperty("line.separator"));
				break;
			}
		}
		return utilisateur.toString();
	}

	public static void reinitialisation(boolean confirmation) {
		// fichier.delete();
		if (confirmation == true) {
			Alerte c1 = new Alerte();
			if (c1.getreponse() == 0) {
				try {
					FileWriter fw = new FileWriter(fichier, false);
					fichier.createNewFile();
					fw.close();
				} catch (IOException e) {
				}
			}
		} else {
			try {
				FileWriter fw = new FileWriter(fichier, false);
				fichier.createNewFile();
				fw.close();
			} catch (IOException e) {
			}
		}
	}

	public void modifieScore(int pallier, int nouveau_score) throws IOException {
		ArrayList<StringBuilder> tamporaire = new ArrayList<StringBuilder>();
		String ligne = new String();
		BufferedReader lecteur = new BufferedReader(new FileReader(fichier));
		StringBuilder identifiant = new StringBuilder();
		int toto = 0;
		while ((ligne = lecteur.readLine()) != null) {
			tamporaire.add(new StringBuilder(ligne));
		}
		StringBuilder modificateur = new StringBuilder();
		modificateur.append(tamporaire.get(this.numero_ligne));
		int i = 0;
		int j = 0;
		while (i < pallier) {
			if (modificateur.charAt(j) == '|') {
				i++;
				j++;
			} else {
				j++;
			}
		}
		j++;
		String a = modificateur.substring(0, j - 1);
		while (modificateur.toString().charAt(j) != '-') {
			j++;
		}
		modificateur.delete(0, j);
		String b = a + nouveau_score + modificateur.toString();
		tamporaire.get(this.numero_ligne).setLength(0);
		tamporaire.get(this.numero_ligne).append(b);
		reinitialisation(false);
		FileWriter fw = new FileWriter(fichier, true);
		for (int z = 0; z < tamporaire.size(); z++) {
			fw.write(tamporaire.get(z).toString()
					+ System.getProperty("line.separator"));
		}
		fw.close();
		lecteur.close();
	}

	public static void aff() {
		for (String str : utilisateurs) {
			System.out.println(str + ", ");
		}
	}

	public static String[] getutilisateurs() {
		return utilisateurs;
	}

	public static void main(String[] Args) throws IOException {
		Utilisateur u = new Utilisateur("neon");
		u.Identification();
		System.out.println(u.UtilisateurExistant());
		System.out.println(u.numero_ligne);
		u.modifieScore(7, 5698);
		// u6.Identification();
		// reinitialisation();
		// System.out.println(u1.toString());
		// generer_utilisateur(25);
	}
}
