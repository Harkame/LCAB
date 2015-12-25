 package projet_bulles;
import javax.swing.JPanel;

public class Annimation extends Thread {
	private JPanel pan;
	public Bulle bulle;

	public Annimation(String nom, JPanel pan, int taille, int vitesse) {
		super(nom);
		this.pan=pan;
		this.bulle=new Bulle(500,500,taille,vitesse,this.pan);
	}

	public void run() {
		this.bulle.animer();
	   	Thread.yield();	  
	}
		public Bulle getBulle(){
		return this.bulle;
	}
}
