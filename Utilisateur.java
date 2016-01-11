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
	private String identifiant; // L'indentifiant d'un utilisateur
	private static File fichier; // Le fichier contenant les scores de tous les
									// utilisateurs

	/*
	 * Permet de créer le fichier utilisateurs, en fonction du systeme
	 * d'exploitation
	 */

	static {
		fichier = new File("utilisateurs.txt"); // On le dans le dossier courant

		if (fichier.exists()) { // Si il existe
		} else {
			try {
				fichier.createNewFile(); // On creer le fichier
				FileWriter fd = new FileWriter(fichier); // Sa va permetre
															// d'écrire dans le
															// fichier
				fd.write("root|5-5|7-7|9-9|11-11|5-5|7-7|9-9|11-11|"
						+ System.getProperty("line.separator")); // Il y a un
																// scores
				fd.close(); // On ferme le FileWriter
			} catch (IOException e) {
			}
		}
	}
	private Score[] scores; // Les scores sont sous-formes d'un tableau
	private int numero_ligne; // Pour faciliter la lecture, on retient en
								// memoire la ligne correspondant e  celle
								// de l'utilisateur dans le fichier texte
	private static String[] utilisateurs; // Un tableau contenant tous les
											// utilisateurs (simplement leurs
											// idnetifiants)
	private int pallier_actuel; // Le pallier actuel de l'utilisateur, utile
								// pour la fonctionnalite "continuer"

	/*
	 * Constructeur de base
	 */
	public Utilisateur(String p_identifiant) {
		this.identifiant = p_identifiant.toLowerCase(); // Afin d'eviter tout
														// proble¨me du au
														// majuscule lors de la
														// creation/connexion,
														// l'identifiant passera
														// toujours en
														// minuscule, mais si il
														// est saisie avec des
														// majuscules
		this.scores = new Score[8]; // Il y a 8 palliers au total, donc un
									// tableau de 8 scores
		for (int i = 0; i < this.scores.length; i++) { // On initialiser le
														// tableau des scores
														// integralement
			this.scores[i] = new Score(); // Initialisation de chacun des
											// scores, e  0 au departs
		}
		try {
			this.Identification();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.recuppallier_actuel(); // On recupe¨re le pallier actuel de
									// l'utilisateur
		this.recupNumeroLigne(); // On recup_re le numero de ligne de
									// l'utilisateur dans le fichier texte
	}

	/*
	 * Recupe¨re toute la ligne concercernant
	 * l'utilisateur dans la base de donnee sous forme de String,
	 * content l'identifiant, les 10 scores pour chacun des palliers
	 */
	private StringBuilder recupLigne() throws IOException {
		String ligne = new String(); // Variable temporaire qui va eªtre notre
										// lecteur ligne par ligne
		BufferedReader lecteur = new BufferedReader(new FileReader(fichier)); // BufferedReader
																				// qui
																				// va
																				// charger
																				// chacune
																				// des
																				// lignes
																				// du
																				// fichier
																				// dans
																				// la
																				// variable
																				// ligne
		StringBuilder identifiant = new StringBuilder(); // Variable qui va
															// traite la
															// ligne pour savoir
															// si c'est la bonne
															// ligne
		while ((ligne = lecteur.readLine()) != null) { // Tant qu'il reste une
														// ligne dans le fichier
			identifiant.append(recupIdentifiant(ligne)); // On recupe¨re
															// l'identifiant de
															// de la ligne
			if (identifiant.toString().equals(this.identifiant)) { // On regarde
																	// si c'est
																	// le bon
				lecteur.close(); // On ferme le lecteur
				identifiant.setLength(0); // On reinitialise l'analyseur a une
											// taille de 0
				identifiant.append(ligne); // On recupe¨re toute la ligne
				return identifiant; // On la renvoie
			} else { // Se n'est pas la bonne ligne
				identifiant.setLength(0); // On reinitialise l'analyseur a une
											// taille de 0
			}
		}
		lecteur.close(); // On ferme le lecteur
		return null; // On retourne null, la ligne n'as pas ete trouve
	}

	/*
	 * Perme de recupere le pallier actuel de l'utilisateur On va chercher le
	 * premier socre ou le nombre de clics est e  0 (valeur par default et
	 * impossible de faire un score pareil) Si jamais il n'y a pas pas de score
	 * avec un nombre de clics == e  0, l'utilisateur a fini le jeu, on renvoit
	 * donc le dernier pallier
	 */
	public void recuppallier_actuel() {
		for (int i = 0; i < this.scores.length; i++) { // On parcours tous les
														// scores
			if (this.scores[i].getnombre_clics() == 0) { // Si le nombre de
															// clics est
															// egale e  0,
															// donc si c'est le
															// pallier actuel
				this.pallier_actuel = i + 1; // On attribut le pallier actuel
												// e  i car c'est ce pallier
												// le , le +1 viens du fait
												// que compter e  partir du
												// pallier 1 est plus naturel
												// que du pallier 0
				return; // On quitte la fonction
			}
		}
		this.pallier_actuel = 8; // Sinon c'est le dernier pallier
	}

	/*
	 * Dit si l'identifiant est valide, sa retourne un int car je me base sur le
	 * code ASCII, sa permet de
	 * recupere le code ASCII du
	 * caracte¨re interdit et d'afficher se dernier en message
	 * d'erreure
	 */
	private static int identifiantValide(String identifiant) {
		if (identifiant == null || identifiant == ""
				|| identifiant.length() <= 1) { // Si l'attribut est d'une
												// taille trop petite
			return 1; // On retourne 1 (erreure)
		}
		for (int i = 0; i < identifiant.length(); i++) {
			if ((int) identifiant.charAt(i) < 97
					|| (int) identifiant.charAt(i) > 123) { // Pour des raisons
															// fonctionnelle, on
															// interdit certain
															// caractere comme
															// le | et le - qui
															// poserais probleme
															// pour
															// recupere
															// les scores
				return i; // On retourne la position du caracte¨re qui pose
							// proble¨me
			} else {
				// On passe au suivant
			}
		}
		return -1; // -1 signifie qu'il n'y a pas eu de prlble¨me
	}

	/*
	 * Getter du score correspondant a l'attribut scores[pallier]
	 * de l'utilisateur (this)
	 */
	public String getScore(int pallier) {
		return this.scores[pallier].toString();
	}

	/*
	 * Retourne le numero de ligne de l'utilisateur dans la base
	 * de donnee, utiliser pour pouvoirs accelerer
	 * l'acce¨s a la base de donnee au lieu de faire
	 * un parcour partiel ligne par ligne
	 */
	private void recupNumeroLigne() {
		BufferedReader lecteur = null;
		try {
			lecteur = new BufferedReader(new FileReader(fichier)); // Lecteur du
																	// fichier
		} catch (FileNotFoundException e1) {
		}
		StringBuilder identifiant = new StringBuilder(); // Variable temporaire
															// designant
															// l'identifiant de
															// la ligne
		int cpt = 0;
		String ligne; // Ligne qui sera designe par le lecteur
		try {
			while ((ligne = lecteur.readLine()) != null) { // Temps qu'il reste
															// une lignes
				identifiant.append(recupIdentifiant(ligne)); // On
																// recupe¨re
																// l'identifiant
																// le la ligne
				cpt++; // ?
				if (identifiant.toString().equals(this.identifiant)) { // Si
																		// c'est
																		// la
																		// bonne
																		// ligne
					lecteur.close(); // Fermeture du lecteur
					this.numero_ligne = cpt - 1; // on attribut la ligne
					return; // On quitte la fonction
				} else {
					identifiant.setLength(0); // On reinitialiser l'analyseur
												// e  0 pour la prochaine
												// ligne
				}
			}
		} catch (IOException e) {
		}
		try {
			lecteur.close(); // On ferme le lecteur
		} catch (IOException e) {
		}
	}

	/*
	 * Renvoit l'identifiant de la ligne passe en
	 * parame¨tre, utiliser pour savoir si la ligne de la base de
	 * donnee est bien celle de l'utilisateur (this)
	 */
	private static StringBuilder recupIdentifiant(String ligne) {
		StringBuilder identifiant = new StringBuilder(); // Variable temporaire
															// qui designera
															// l'indifiant de la
															// ligne
		int i = 0;
		try {
			while (ligne.charAt(i) != '|') { // Tant qu'on a pas atteinte le
												// separateur |
				identifiant.append(ligne.charAt(i)); // On ajoute le charactere
														// a la variable
														// temporaire
				i++; // On incremente le compteur
			}
		} catch (StringIndexOutOfBoundsException e) {

		}
		return identifiant; // On retourne l'indentifiant de la ligne
	}

	/*
	 * Recupe¨re tous les identifiants dans la base
	 * de donnee, utilise pour faire les suggestion
	 * des utilisateur sur la page d'identification
	 */
	static void recupIdentifiants() throws IOException {
		BufferedReader lecteur = new BufferedReader(new FileReader(fichier)); // On
																				// creer
																				// le
																				// lecteur
																				// du
																				// fichier
		StringBuilder identifiant = new StringBuilder(); // Identifiant de
															// chacune des
															// lignes
		int compteur = 0; // On comptera dans un premier temps le nombre de
							// lignes
		String ligne; // La ligne designe par le lecteur
		while ((ligne = lecteur.readLine()) != null) { // Tant qu'il reste une
														// ligne dans le fichier
			compteur++; // On incremente le compteur
		}
		utilisateurs = new String[compteur]; // On cree un tableau d'une
												// taille = au nombre de lignes
												// du fichier
		compteur = 0; // On recycle la variable compteur
		lecteur = new BufferedReader(new FileReader(fichier)); // On recycle
																// egalement
																// le cteur
		while ((ligne = lecteur.readLine()) != null) { // On refait un parcour
														// du fichier
			utilisateurs[compteur] = recupIdentifiant(ligne).toString(); // On
																			// attribut
																			// dans
																			// chaque
																			// case
																			// du
																			// tableau
																			// des
																			// utilisateurs,
																			// l'identifiant
																			// de
																			// la
																			// ligne
			compteur++; // Incrementation du compteur
		}
	}

	/*
	 * Recupe¨re le scores de l'utilisateur pour chacun des
	 * pallier depe»is la base de donnee, et
	 * assoscie e  l'utilisateur (this)
	 */
	private void recupScores(StringBuilder ligne) {
		StringBuilder scores = new StringBuilder(); // ?
		StringBuilder strb_ligne = new StringBuilder();
		int i = 0; // Variable qui va parcourire la ligne
		while (ligne.charAt(i) != '|') { // Tant qu'on a pas atteint le
											// separateur
			i++; // on incremente le compteur
		}
		strb_ligne.append(ligne); // On ajoute toute la ligne a la variable
									// temporaire
		strb_ligne.delete(0, i); // On enle¨ve tous se qui est innutile, soit
									// l'identifiant, soit le score precedent
									// deje  analyser
		for (i = 0; i < this.scores.length; i++) { // Pour chacun des palliers
			this.scores[i].recupScore(strb_ligne); // On recupe¨re chacun
													// des scores 1 par 1
		}
	}

	/*
	 * Enregistre un nouvel utilisateur avec un score initial de 0 partout
	 */
	private void sauvegarderUtilisateur() throws IOException {
		FileWriter fw = new FileWriter(fichier, true); // La variable qui va
														// ecrire dans le
														// fichier, le true
														// designe qu'on ne
														// veut pas ecraser
														// le fichier, mais
														// ecrire e  la fin
		fw.write(this.identifiant.toString() + '|'); // On ecrit
														// l'identifiant et le
														// separateur | qui
														// marque le debut
														// des scores
		int nombre_bulles = 5; // Au debut il y a 5 bulles
		for (int i = 0; i < 8; i++) { // Pour chacun des palliers
			fw.write("0-" + nombre_bulles + "|"); // On ecrit que le nombre
													// de clics est e  0 (par
													// default), pour un
													// nombre de bulles
													// augmentant de 2 a chaque
													// palliers
			nombre_bulles += 2;
			if (i == 3) { // Si on atteinte le 4eme pallier (3 en java car on
							// compte e  partir de 0, le debut du niveau
							// mobile), le nombre de bulles repassme au minimum
							// 5
				nombre_bulles = 5; // On reinitialise e  5, et on continue
									// decrire mais les palliers du niveau
									// mobiles
			}
		}
		fw.write(System.getProperty("line.separator")); // On met le separateur
														// du system pour que
														// lors du prochain
														// enregistrement se
														// soit a la prochaine
														// ligne et non a la fin
														// de la ligne actuel
		fw.close(); // On ferme le FileWritter
	}

	/*
	 * Methode principal, elle fait 2 choses : Si l'utilisateur this n'existe
	 * pas dans la base de donnee, il est rajoute
	 * avec des scores initiaux de 0 partout, sinon ses scores sont
	 * recuperes et attribue
	 * e  l'utilisateur (this)
	 */
	public void Identification() throws IOException {
		if (identifiantValide(this.identifiant) == -1) { // Si l'identifiant est
															// valide, le
															// verificateur e 
															// retoruner -1
			if (this.UtilisateurExistant()) { // On regarde si il existe, si oui
				StringBuilder informations = this.recupLigne(); // On
																// recupe¨re
																// la ligne
				this.recupIdentifiant(informations.toString()); // On
																// recupe¨re
																// l'identifiant
				this.recupScores(informations); // Recuperation du socres
				this.recuppallier_actuel(); // recuperation du pallier actuel
			} else { // Si l'utilisateur n'est pas encore enregistre
				Confirmation c1 = new Confirmation(this.identifiant); // On
																		// demande
																		// la
																		// confirmation
																		// e 
																		// l'utilisateur
																		// (devant
																		// l'ecran),
																		// de
																		// confirmer
																		// la
																		// creation
																		// de
																		// l'utilisateur
				if (c1.getreponse() == 0) { // Si la reponse est 0 (Bouton
											// oui)
					this.sauvegarderUtilisateur(); // On sauvegarde
													// l'utilisateur
				} else { // Sinon on ne fait rien

				}
			}
		} else { // Si l'identifiant n'est pas valide
			new JOptionPane().showMessageDialog(null, "Caractere interdit : \""
					+ identifiant.charAt(identifiantValide(this.identifiant))
					+ "\"", "Erreur", JOptionPane.ERROR_MESSAGE); // On affiche
																	// une
																	// alerte,
																	// indiquant
																	// quel
																	// caracte¨re
																	// pose
																	// proble¨me
		}
	}

	/*
	 * Indique si l'utilisateur (this) est present dans la base de
	 * donnee, on compare les identifiant
	 */
	public boolean UtilisateurExistant() throws IOException {
		String ligne = new String(); // Ligne indique par le lecteur
		BufferedReader lecteur = new BufferedReader(new FileReader(fichier)); // Lecteur
																				// du
																				// fichier
		StringBuilder identifiant = new StringBuilder(); // Identifiant de
															// chaque ligne
		while ((ligne = lecteur.readLine()) != null) { // Tant qu'il reste une
														// ligne
			identifiant.append(recupIdentifiant(ligne)); // On recupe¨re la
															// ligne de
															// l'utilsateur
															// (this)
			if (identifiant.toString().equals(this.identifiant)) { // Si c'est
																	// bien la
																	// sienne
				lecteur.close(); // On ferme le lecteur
				return true; // On indique que l'utilisateur existe
			} else { // Sinon se n'est pas encore la bonne ligne
				identifiant.setLength(0); // Reinitialiser de l'analyser a une
											// taille de 0
			}
		}
		lecteur.close(); // Fermeture du lecteur
		return false; // L'utilisateur n'est pas enregistre dans le fichier
						// texte
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
	 * @see java.lang.Object#toString() toString() classic Fonction utiliser que
	 * pour des tests ou premie¨res itterations
	 */
	public String toString() {
		StringBuilder utilisateur = new StringBuilder();
		utilisateur.append(this.identifiant
				+ System.getProperty("line.separator")); // On prend
															// l'identifiant et
															// un passage e 
															// la ligne
		for (int i = 0; i < this.scores.length; i++) { // pour chacun des
														// palliers
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
	 * Reinitialise la base de donnee en effacant
	 * son contenu integralement Un demande de confirmation
	 * apprais, si oui alors reset, sinon rien n'est fait
	 */
	public static void reinitialisation(boolean confirmation) {
		// fichier.delete();
		if (confirmation == true) { // Si le parame¨tre est a true, on demande
									// e  l'utilisateur une confirmation
			Confirmation c1 = new Confirmation(); // On demande e 
													// l'utilisateur une
													// confirmation
			if (c1.getreponse() == 0) { // Si la reponse est oui e  la
										// reinitialisation
				try {
					FileWriter fw = new FileWriter(fichier, false); // On fait
																	// un
																	// nouveau
																	// fichier
																	// vide
					fichier.createNewFile();
					fw.close();
				} catch (IOException e) {
				}
			} else { // On ne fait rien

			}
		} else { // Si c'est a false, pas de confirmation, utiliser uniquement
					// pour le developpement du jeu
			try {
				FileWriter fw = new FileWriter(fichier, false); // Reinitialison
																// du fichier
				fichier.createNewFile();
				fw.close();
			} catch (IOException e) {
			}
		}
	}

	/*
	 * Modifie le score d'un utilisateur (this), en passant en parametre le
	 * pallier e  modifier, et le nouveau nombre de clics
	 * Strategie : On recupe¨re toute
	 * la base de donnee en memoire, on modifie la
	 * ligne souhaite, puis on recopie le tout dans un nouveau
	 * fichier
	 */
	public void modifieScore(int pallier, int nouveau_score) throws IOException {
		ArrayList<StringBuilder> tamporaire = new ArrayList<StringBuilder>(); // Va
																				// contenire
																				// toutes
																				// les
																				// lignes
																				// du
																				// fichier
		String ligne = new String(); // Ligne renvoye par le lecteur
		BufferedReader lecteur = new BufferedReader(new FileReader(fichier)); // Lecteur
																				// du
																				// fichier
		StringBuilder identifiant = new StringBuilder(); // Identifiant de la
															// ligne
		int toto = 0;
		while ((ligne = lecteur.readLine()) != null) { // tant qu'il reste une
														// ligne
			tamporaire.add(new StringBuilder(ligne)); // On l'ajoute a
														// tamporaire
		}
		StringBuilder modificateur = new StringBuilder(); // Variable qui va
															// modifie le
															// scores
		modificateur.append(tamporaire.get(this.numero_ligne)); // On ajoute
																// toutes la
																// ligne a cette
																// dernie¨re
		// Debut de la modification
		int i = 0; // Compteur de pallier
		int j = 0; // Compteur de caractere
		while (i < pallier) { // Tant que se n'est pas le bon pallier a modifier
			if (modificateur.charAt(j) == '|') { // Si on passe un separateur
													// sa veut dire qu'on a
													// passe 1 pallier
				i++; // Un pallier en plus
				j++; // Un caractere en plus
			} else { // Sinon c'est juste un caractere
				j++; // Seuelement un caractere en plus
			}
		}
		j++; // On incremente de 1 pour designer le dernier separateur |
		String a = modificateur.substring(0, j - 1); // On recupe¨re les
														// premier scores qui ne
														// seront pas modifie
		while (modificateur.toString().charAt(j) != '-') { // Tant que ce n'est
															// pas le separateur
															// -
			j++; // On incremente
		}
		modificateur.delete(0, j); // on supprime toutes la ligne de 0 au - qui
									// succede au nouveau nombre de cloics
		String b = a + nouveau_score + modificateur.toString(); // On assemble
																// le debut, le
																// nouveau score
																// et le reste
																// de la ligne
		tamporaire.get(this.numero_ligne).setLength(0); // On reinitialise la
														// ligne de la variable
														// tamporaire e  0
														// pour l'ecraser
														// (comme c'est une
														// ArrayList on peut pas
														// faire egale et
														// comme c'est un
														// StringBuilder faut le
														// faire en 2 etapes)
		tamporaire.get(this.numero_ligne).append(b); // On y place la nouvelle
														// ligne
		reinitialisation(false); // On reinitialise directement le fichier sans
									// onfirmation e  l'utilisateur
		FileWriter fw = new FileWriter(fichier, true); // On va reecrire
														// chacune des lignes
														// une par une
		for (int z = 0; z < tamporaire.size(); z++) { // Pour chacune des cases
														// de l'ArrayListe
			fw.write(tamporaire.get(z).toString()
					+ System.getProperty("line.separator")); // on y ecrit la
																// case de
																// tamporaire
																// avec un
																// separateur
																// de ligne pour
																// passer a la
																// ligne
																// suivante
		}
		fw.close(); // on ferme le FileWriter
		lecteur.close(); // On ferme le lecteur
		StringBuilder informations = this.recupLigne(); // On va MAJ les
														// informations
		this.recupIdentifiant(informations.toString()); // On recupe¨re le
														// nouvelle identifiant,
														// sa parait innutile
														// mais c'est pour
														// enlever la partie
														// identifiant de la
														// nouvelle ligne
		this.recupScores(informations); // On recup_re les nouveau scores
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
		String[][] matrice = new String[4][2]; // Une ligne par pallier, colonne
												// 0 = nombre de clics, colonne
												// 1 = nombre de bulles
		for (int i = 0; i < 4; i++) { // Pour la premie¨re colonne
			matrice[i][0] = "" + this.scores[i].getnombre_clics();
		}
		for (int i = 0; i < 4; i++) { // pour la seconde
			matrice[i][1] = "" + this.scores[i].getnombre_bulles();
		}
		return matrice;
	}

	/*
	 * Transforme les scores du niveau 2 en matrice
	 * [nombre_clics][nombre_bulles] Necessaire pour l'affichage
	 * des scores
	 */
	public String[][] niveau2toMatrice() {
		// Meªme chose que pour niveau 1
		String[][] matrice = new String[4][2];
		for (int i = 0; i < 4; i++) {
			matrice[i][0] = "" + this.scores[i + 4].getnombre_clics();
		}
		for (int i = 0; i < 4; i++) {
			matrice[i][1] = "" + this.scores[i + 4].getnombre_bulles();
		}
		return matrice;
	}

	public boolean nouveau() {
		return this.scores[0].getnombre_clics() == 0;
	}

	public String getIdentifiant() {
		return identifiant;
	}



	public static void main(String[] Args) throws IOException {
		Utilisateur u = new Utilisateur("lee");
	}
}
