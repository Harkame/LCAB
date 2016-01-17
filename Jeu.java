package projet_bulles;

import java.awt.Canvas;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Jeu extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private static int SCALE = 2;
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 750;
	public Clip son;

	public static enum STATE {
		MENU, GAME, IDENTIFICATIONS, SCORES, SELECTION_NIVEAU;
	}

	public final String Title = "Jeu de Bulles";
	public static STATE State = STATE.IDENTIFICATIONS;

	static Identification identification;
	PlateauBulle plateau;
	private static Utilisateur utilisateur;

	public Jeu() throws IOException {
		try {
			// File fichierSon=new File ("JeuxDenfants.wav");
			AudioInputStream sound;
			sound = AudioSystem.getAudioInputStream(getClass().getResource(
					"/JeuxDenfants.wav"));
			DataLine.Info info = new DataLine.Info(Clip.class,
					sound.getFormat());
			this.son = (Clip) AudioSystem.getLine(info);
			this.son.open(sound);
			this.son.loop(300);
		} catch (UnsupportedAudioFileException | LineUnavailableException
				| IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		controller();
		// this.addMouseListener(new MouseInput());
	}

	// Gere l'etat du jeu : Fait les transitions
	public static void controller() throws IOException {
		if (State == STATE.IDENTIFICATIONS) {
			try {
				new Identification();
			} catch (IOException e) {
			}
		} else if (State == STATE.MENU) {
			new Menu();

		} else if (State == STATE.GAME) {
			/*
			 * String identifiant = utilisateur.getIdentifiant();// recupere //
			 * l'identifiant // de // l'utilisateur // courant Utilisateur u1 =
			 * new Utilisateur(identifiant); // Instancie // l'utilisateur
			 */// courant

			utilisateur.maj();

			int pallier = utilisateur.getpallier_actuel(); // rÃƒÂ©cupÃƒÂ©re le
															// pallier
			// actuel de l'utilisateur
			// courant
			// execute tel niveau selon tel pallier
			switch (pallier) {
			case 1:
				new PlateauBulle(5, 1, 0);
				break;
			case 2:
				new PlateauBulle(7, 2, 0);
				break;
			case 3:
				new PlateauBulle(9, 3, 0);
				break;
			case 4:
				new PlateauBulle(11, 3, 0);
				break;
			case 5:
				new PlateauBulle(5, 1, 1);
				break;
			case 6:
				new PlateauBulle(7, 2, 1);
				break;
			case 7:
				new PlateauBulle(9, 2, 1);
				break;
			case 8:
				new PlateauBulle(11, 3, 1);
				break;

			}
		} else if (State == STATE.SELECTION_NIVEAU) {
			utilisateur.maj();
			new ChoisirNiveau();
		} else if (State == STATE.SCORES) {
			utilisateur.maj();
			new FenetreScore();
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	// mÃƒÂ©thode pour retourner l'utilisateur courant
	public static Utilisateur getutilisateur() {
		return utilisateur;
	}

	public static void setutilisateur(Utilisateur p_utilisateur) {
		utilisateur = p_utilisateur;
	}

	public static void main(String[] args) throws IOException {
		Jeu g1 = new Jeu();

	}

}
