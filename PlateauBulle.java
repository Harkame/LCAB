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
	public static JPanel pan;	

	
	/**
	 */
	public PlateauBulle(){
		this.setTitle("La case à bulles");
		  this.setSize(1000, 1000);
		this.setExtendedState(Frame.MAXIMIZED_BOTH); // fenetre plein écrant
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // stopper le programme en au click sur la croix
		this.pan =new JPanel(); // instanciation de mon conteneur
		this.setContentPane(pan); // je choisi mon contenneur 
		this.setVisible(true); // rentdre ma fenêtre visible
		this.pan.setLayout(null); // aucune disposition par défault dans mon conteneur ce qui permet de déplacer comme on veut notre label

									
	}
	
	
	
		
	
	public static void main(String[]args){
	PlateauBulle plat=new PlateauBulle();
		/*Bulle maBulle=new Bulle(5,9,151,151,plat.pan);
		
		Bulle maBulle2=new Bulle(500,500,151,151,plat.pan);
		
		maBulle.animer();*/
		
		
		Annimation a= new Annimation("anim1",pan);
		Annimation b= new Annimation("anim1",pan);
		Annimation c= new Annimation("anim1",pan);
		Annimation d= new Annimation("anim1",pan);
		a.start();
		b.start();
		c.start();
		d.start();
		
		
		
		
		// après cette instruction rien ne peut s'excuter car j'utilise un true dans la condition d'un tant que 
		
		
				
	}
}
