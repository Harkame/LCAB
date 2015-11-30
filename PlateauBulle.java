import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;



public class PlateauBulle extends JFrame { // création de ma fenêtre 
	private static JPanel pan;	
	private static Annimation[] anim;
	private int nb;
	
	/**
	 */
	public PlateauBulle(int nb){
		this.setTitle("La case à bulles");
		this.setSize(1000, 1000);
		this.setExtendedState(Frame.MAXIMIZED_BOTH); // fenetre plein écrant
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // stopper le programme en au click sur la croix
		this.pan =new JPanel(); // instanciation de mon conteneur
		this.setContentPane(pan); // je choisi mon contenneur 
		this.setVisible(true); // rentdre ma fenêtre visible
		this.pan.setLayout(null); // aucune disposition par défault dans mon conteneur ce qui permet de déplacer comme on veut notre label
		this.nb=nb;
	
											
	}
	public void afficherBulleMobile(int tailleB,long vitesseBulles){
		
		 anim = new Annimation[this.nb];
		for (int i = 0; i<this.nb; i++){
			  anim[i] = new Annimation("anim", pan);
			 anim[i].getBulle().setTailleBulle(tailleB);
			 anim[i].getBulle().setVitesseBulle(vitesseBulles); 
		}
		for (int i = 0; i<this.nb; i++){
			anim[i].start();
		}
	}
	
	
	
	public void afficherBulleStatic(int tailleB){
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth();
		int x,y;
		for(int i=0;i<this.nb;i++){
			x=(int)(Math.random()*(width-215));
			y=(int)(Math.random()*(height-215));
			new Bulle(x,y,0,tailleB,pan);
		}
	}
	
	public static void main(String[]args){
	NiveauBulle N1= new NiveauBulleStatic(9,4);
	//NiveauBulle N2= new NiveauBulleMobile(3,5,3);
		
	}
}


