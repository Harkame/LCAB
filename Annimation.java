import javax.swing.JPanel;


public class Annimation extends Thread{
		private JPanel pan;
		private Bulle maBulle;
		
		
		 public Annimation(String nom,JPanel pan) {
		  super(nom);
		 this.pan=pan;
		 this.maBulle=new Bulle(500,500,0,0,this.pan);
		 }
	 
		
		 public void run() {
			 
			this.maBulle.animer();
		   Thread.yield();
		  
		 }
		 public Bulle getBulle(){
			 return this.maBulle;
		 }
	  
		
}
