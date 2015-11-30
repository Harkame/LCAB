package projet_bulles;

import java.awt.Canvas;

import java.io.IOException;






public class Jeu extends Canvas implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private static int SCALE = 2;
	public static final int WIDTH  = 1000;
	public static final int HEIGHT =  750;

	
	public static enum STATE {
		MENU,
		GAME,
		IDENTIFICATIONS,
		OPTIONS;
	}
	public final String Title = "Jeu de Bulles";
	public static STATE	State = STATE.IDENTIFICATIONS;
	
	
	
	static Identification identification;
	PlateauBulle plateau;
	Utilisateur utilisateur;

	public Jeu () throws IOException {
		
		controller();
		this.addMouseListener(new MouseInput());
	}
	

// Gére l'état du jeu : Fait les transitions avec les états enum
	public static void controller() throws IOException {
		if (State == STATE.IDENTIFICATIONS) {
			try {
				identification = new Identification();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (State == STATE.MENU) {
		Menu m = new Menu();
			//System.exit(0);
		
		
		}
		else if (State == STATE.GAME) {
			// !!!!!!! IMPORTANT, il faudra faire le bouton jouer pour revenir au niveau joué à la dernière fois par le joueur
			NiveauBulle N1= new NiveauBulleStatic(9,4);
		}

	}

	
	

	



	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) throws IOException {
		Jeu g1 = new Jeu();
		
		
		
	
	}

}
