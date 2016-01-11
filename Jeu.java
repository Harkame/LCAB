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
		MENU,
		GAME, 
		IDENTIFICATIONS,
		SCORES,
		SELECTION_NIVEAU;
	}

	public final String Title = "Jeu de Bulles";
	public static STATE State = STATE.IDENTIFICATIONS;

	static Identification identification;
	PlateauBulle plateau;
	private static Utilisateur utilisateur;
	static {
		utilisateur = Identification.getutilisateur();
	}
           
	public Jeu() throws IOException {
 		/*try{
			//File fichierSon=new File ("JeuxDenfants.wav");
			AudioInputStream sound;
			sound = AudioSystem.getAudioInputStream(getClass().getResource("/JeuxDenfants.wav"));
			DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
			this.son  = (Clip) AudioSystem.getLine(info);
			this.son.open(sound);
			this.son.loop(300);
			} catch (UnsupportedAudioFileException|LineUnavailableException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} */	
		controller();
	//	this.addMouseListener(new MouseInput());
	}

	// GÃƒÆ’Ã‚Â©re l'ÃƒÆ’Ã‚Â©tat du jeu : Fait les transitions
	public static void controller() throws IOException {
		if (State == STATE.IDENTIFICATIONS) {
			try {
				identification = new Identification();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (State == STATE.MENU) {
			Menu m = new Menu();
			utilisateur = identification.getutilisateur();
			// System.exit(0);

		} else if (State == STATE.GAME) {
			
			String identifiant = utilisateur.getIdentifiant();
			Utilisateur u1 = new Utilisateur(identifiant);
			
			
			
			int pallier = u1.getpallier_actuel();
			if (pallier == 0) {
				PlateauBulle N1 = new PlateauBulle(5, 1, 0);
			}
			if (pallier == 1) {
				PlateauBulle N1 = new PlateauBulle(5, 1, 0);
			}
			if (pallier == 2) {
				PlateauBulle N2 = new PlateauBulle(7, 2, 0);
			}
			if (pallier == 3) {
				PlateauBulle N3 = new PlateauBulle(9, 3, 0);
			}
			if (pallier == 4) {
				PlateauBulle N4 = new PlateauBulle(11, 3, 0);
			}
			if (pallier == 5) {
				PlateauBulle N5 = new PlateauBulle(5, 1, 1);
			}
			if (pallier == 6) {
				PlateauBulle N6 = new PlateauBulle(7, 2, 1);
			}
			if (pallier == 7) {
				PlateauBulle N7 = new PlateauBulle(9, 2, 1);
			}
			if (pallier == 8) {
				PlateauBulle N8 = new PlateauBulle(11, 3, 1);
			}
			
			// !!!!!!! IMPORTANT, il faudra faire le bouton jouer pour revenir
			// au niveau jouÃƒÆ’Ã‚Â© ÃƒÆ’Ã‚Â  la derniÃƒÆ’Ã‚Â¨re fois par le joueur
			// NiveauBulle N1= new NiveauBulleStatic(9,4);
		//	PlateauBulle N1 = new PlateauBulle(9, 4, 0); // niveau bulle static
		
// State inutilisable puisque l'appel de getpallier ici fait des bugs d'affichage
		} else if (State == STATE.SELECTION_NIVEAU) {
			ChoisirNiveau ch1 = new ChoisirNiveau();
		}
		else if (State == STATE.SCORES){
			FenetreScore Recup_Score_user = new FenetreScore();
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public static Utilisateur getutilisateur() {
		return utilisateur;
	}

	public static void main(String[] args) throws IOException {
		Jeu g1 = new Jeu();

	}

}

