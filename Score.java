package projet_bulles;

import java.io.File;

public class Score {
	private int nombre_clics;
	private int nombre_bulles;
	private static File fichier = new File("D:\\utilisateurs.txt");
	private String[][] scores;

	/*
	 * Constructeur à vide, le score est de 0 clic - 0 bulle
	 */
	public Score() {
		this.nombre_clics = 0;
		this.nombre_bulles = 0;
	}

	/*
	 * Décompose le score de la ligne passé en paramètre enlève cette
	 * information de cette dernière afin de "l'alléger", moins lourde pour les
	 * prochains traitement dessus
	 */
	public void recupScore(StringBuilder ligne) {
		ligne.delete(0, 1);
		int i = 0;
		StringBuilder nombre_clics = new StringBuilder();
		StringBuilder nombre_bulles = new StringBuilder();
		while (ligne.charAt(i) != '-') {
			nombre_clics.append(ligne.charAt(i));
			i++;
		}
		i++;
		while (ligne.charAt(i) != '|') {
			nombre_bulles.append(ligne.charAt(i));
			i++;
		}
		this.nombre_clics = Integer.parseInt(nombre_clics.toString());
		this.nombre_bulles = Integer.parseInt(nombre_bulles.toString());
		ligne.delete(0, i);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() toString() classic
	 */
	public String toString() {
		StringBuilder score = new StringBuilder();
		score.append("clics : ");
		switch (String.valueOf(this.nombre_clics).length()) {
		case 1:
			score.append(this.nombre_clics + "  ");
			break;
		case 2:
			score.append(this.nombre_clics + " ");
			break;
		case 3:
			score.append(this.nombre_clics);
			break;
		}
		score.append(" - ");
		switch (String.valueOf(this.nombre_bulles).length()) {
		case 1:
			score.append("  " + this.nombre_bulles);
			break;
		case 2:
			score.append(" " + this.nombre_bulles);
			break;
		case 3:
			score.append(this.nombre_bulles);
			break;
		}
		score.append(" : bulles");
		return score.toString();
	}

	/*
	 * Getter nombre_clics d'un score (this)
	 */
	public int getnombre_clics() {
		return this.nombre_clics;
	}

	/*
	 * Getter nombre_bulles d'un score (this)
	 */
	public int getnombre_bulles() {
		return this.nombre_bulles;
	}

	public static void main(String[] Args) {
		Score s1 = new Score();
		Score s2 = new Score();
		Score s3 = new Score();
		System.out.println(s1.toString());
		StringBuilder str = new StringBuilder();
		str.append("|4-1|12-145|4-13|||||");
		s1.recupScore(str);
		s2.recupScore(str);
		s3.recupScore(str);
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		System.out.println(s3.toString());
	}
}
