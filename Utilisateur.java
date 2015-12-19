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

	/*
	 * Bout de code nono dÃ©finitif, si windows crÃ©er dans tel rÃ©pertoire,
	 * sinon si sur linux, crÃ©er ailleur
	 */
	static {
		switch (System.getProperty("os.name")) {
		case "Windows 7":
		case "Windows 8":
		case "Windows 10":
			fichier = new File("C:\\utilisateurs.txt");
			break;
		case "Linux":
			fichier = new File("/home/ann2/daviaudl/Bureau/utilisateurs.txt");
			break;
		}
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
	private int pallier_actuel;

	/*
	 * Constructeur de base
	 */
	public Utilisateur(String p_identifiant) {
		this.identifiant = p_identifiant.toLowerCase();
		this.scores = new Score[10];
		for (int i = 0; i < this.scores.length; i++) {
			this.scores[i] = new Score();
		}
		this.recuppallier_actuel();
		this.recupNumeroLigne();
	}

	/*
	 * RÃ©cupÃ¨re toute la ligne concercernant l'utilisateur dans la base de
	 * donnÃ©e sous forme de String, content l'identifiant, les 10 scores pour
	 * chacun des palliers
	 */
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

	public void recuppallier_actuel() {
		for (int i = 0; i < this.scores.length; i++) {
			if (this.scores[i].getnombre_clics() == 0) {
				this.pallier_actuel = i + 1;
				return;
			}
		}
		this.pallier_actuel = 10;
	}

	/*
	 * Dit si l'identifiant est valide, sa retourne un int car je me base sur le
	 * code ASCII, sa permet de rÃ©cupÃ©rÃ© le code ASCII du caractÃ¨re interdit
	 * et d'afficher se dernier en message d'Ã©rreure
	 */
	private static int identifiantValide(String identifiant) {
		if (identifiant == null || identifiant == ""
				|| identifiant.length() <= 1) {
			return 1;
		}
		for (int i = 0; i < identifiant.length(); i++) {
			if ((int) identifiant.charAt(i) < 97
					|| (int) identifiant.charAt(i) > 123) {
				return i;
			} else {

			}
		}
		return -1;
	}

	/*
	 * Getter du score correspondant Ã  l'attribut scores[pallier] de
	 * l'utilisateur (this)
	 */
	public String getScore(int pallier) {
		return this.scores[pallier].toString();
	}

	/*
	 * Retourne le numÃ©ro de ligne de l'utilisateur dans la base de donnÃ©e,
	 * utiliser pour pouvoirs accelerer l'accÃ¨s a la base de donnÃ©e au lieu de
	 * faire un parcour partiel ligne par ligne
	 */
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

	/*
	 * Renvoit l'identifiant de la ligne passÃ© en paramÃ¨tre, utiliser pour
	 * savoir si la ligne de la base de donnÃ©e est bien celle de l'utilisateur
	 * (this)
	 */
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

	/*
	 * RÃ©cupÃ¨re tous les identifiants dans la base de donnÃ©e, utilisÃ© pour
	 * faire les suggestion des utilisateur sur la page d'identification
	 */
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

	/*
	 * RecupÃ¨re le scores de l'utilisateur pour chacun des pallier depÃ»is la
	 * base de donnÃ©e, et assosciÃ© Ã  l'utilisateur (this)
	 */
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

	/*
	 * Enregistre un nouvel utilisateur avec un score initial de 0 partout
	 */
	private void sauvegarderUtilisateur() throws IOException {
		FileWriter fw = new FileWriter(fichier, true);
		fw.write(this.identifiant.toString() + '|');
		for (int i = 0; i < 10; i++) {
			fw.write("0-0|");
		}
		fw.write(System.getProperty("line.separator"));
		fw.close();
	}

	/*
	 * Methode principal, elle fait 2 choses : Si l'utilisateur this n'existe
	 * pas dans la base de donnÃ©e, il est rajoutÃ© avec des scores initiaux de
	 * 0 partout, sinon ses scores sont recupÃ©rÃ©s et attribuÃ© Ã 
	 * l'utilisateur (this)
	 */
	public void Identification() throws IOException {
		if (identifiantValide(this.identifiant) == -1) {
			if (this.UtilisateurExistant()) {
				StringBuilder informations = this.recupLigne();
				this.recupIdentifiant(informations.toString());
				this.recupScores(informations);
				this.recuppallier_actuel();
			} else {
				Confirmation c1 = new Confirmation(this.identifiant);
				if (c1.getreponse() == 0) {
					this.sauvegarderUtilisateur();
				} else {

				}
			}
		} else {
			new JOptionPane().showMessageDialog(null, "Caractere interdit : \""
					+ identifiant.charAt(identifiantValide(this.identifiant))
					+ "\"", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}

	/*
	 * Indique si l'utilisateur (this) est prÃ©sent dans la base de donnÃ©e, on
	 * compare les identifiant
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() toString() classic
	 */
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

	/*
	 * Reinitialise la base de donnÃ©e en Ã©ffacant son contenu intÃ©gralement
	 * Un demande de confirmation apprais, si oui alors reset, sinon rien n'est
	 * fait
	 */
	public static void reinitialisation(boolean confirmation) {
		// fichier.delete();
		if (confirmation == true) {
			Confirmation c1 = new Confirmation();
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

	/*
	 * Modifie le score d'un utilisateur (this), en passant en parametre le
	 * pallier Ã  modifier, et le nouveau nombre de clics StratÃ©gie : On
	 * rÃ©cupÃ¨re toute la base de donnÃ©e en mÃ©moire, on modifie la ligne
	 * souhaitÃ©, puis on recopie le tout dans un nouveau fichier
	 */
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
		StringBuilder informations = this.recupLigne();
		this.recupIdentifiant(informations.toString());
		this.recupScores(informations);
	}

	public static String[] getutilisateurs() {
		return utilisateurs;
	}

	public Score[] getscores() {
		return this.scores;
	}

	public int getpallier_actuel() {
		return this.pallier_actuel;
	}

	public void niveausupp() {
		this.pallier_actuel++;
	}

	/*
	 * Transforme les scores du niveau 1 en matrice
	 * [nombre_clics][nombre_bulles] Necessaire pour l'affichage des scores
	 */
	public String[][] niveau1toMatrice() {
		String[][] matrice = new String[5][2];
		for (int i = 0; i < 5; i++) {
			matrice[i][0] = "" + this.scores[i].getnombre_clics();
		}
		for (int i = 0; i < 5; i++) {
			matrice[i][1] = "" + this.scores[i].getnombre_bulles();
		}
		return matrice;
	}

	/*
	 * Transforme les scores du niveau 2 en matrice
	 * [nombre_clics][nombre_bulles] NÃ©cessaire pour l'affichage des scores
	 */
	public String[][] niveau2toMatrice() {
		String[][] matrice = new String[5][2];
		for (int i = 0; i < 5; i++) {
			matrice[i][0] = "" + this.scores[i + 5].getnombre_clics();
		}
		for (int i = 0; i < 5; i++) {
			matrice[i][1] = "" + this.scores[i + 5].getnombre_bulles();
		}
		return matrice;
	}

	public static void main(String[] Args) throws IOException {
		Utilisateur u = new Utilisateur("lee");
		u.Identification();
		System.out.println(u.toString());
		// System.out.println(u.UtilisateurExistant());
		// System.out.println(u.numero_ligne);
		// System.out.println(u.scores[5]);
		// String[][] b = u.niveau1toMatrice();
		// u6.Identification();
		// reinitialisation();
		// System.out.println(u1.toString());
		// generer_utilisateur(25);
		System.out.println("Pallier actuel : " + u.pallier_actuel);
	}
}
