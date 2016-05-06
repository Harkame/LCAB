package model;

import javax.swing.JPanel;

public class Annimation extends Thread {
	private JPanel	pan;	// Conteneur courant.
	public Bulle	bulle;	// Bulle courante.

	public Annimation(String nom, JPanel pan, int taille, int vitesse) {
		super(nom); // initialisation de la classe de supÃ©rieur.
		this.pan = pan; // initialisation du conteneur.
		this.bulle = new Bulle(500, 500, taille, vitesse, this.pan); // creation
																		// de la
																		// bulle
																		// a
																		// annimer
																		// ou
																		// pas.
	}

	public void run() { // Fonction run appeler par la methode start de Thread.
		this.bulle.animer(); // fonction annimer implementer dans notre classe
								// Bulle.
		Thread.yield(); // fonction implementer pour tout Thread permentant
						// d'alterner les Thread en rendant la main.
	}

	public Bulle getBulle() { // fonction qui nous permettra de recuperer notre
								// bulle courante.
		return this.bulle;
	}
}
