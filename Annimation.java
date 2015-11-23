import javax.swing.JPanel;


public class Annimation extends Thread {
		private JPanel pan;

		 public Annimation(String nom, JPanel pan) {
		  super(nom);
		 this.pan=pan;
		 }
	 
		
		 public void run() {
			 Bulle maBulle2=new Bulle(500,500,151,151,this.pan);
				maBulle2.animer();
		   Thread.yield();
		  
		 }
	  
		
}
