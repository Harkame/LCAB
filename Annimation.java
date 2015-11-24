import javax.swing.JPanel;

public class Annimation extends Thread {
		private JPanel pan;
		private Bulle bulle;

	public Annimation(String nom, JPanel pan) {
		super(nom);
		this.pan=pan;
	}
	 
		
	 public void run() {
		this.bulle=new Bulle(500,500,151,151,this.pan);
		this.bulle.animer();
	   	Thread.yield();	  
	 }	
}
