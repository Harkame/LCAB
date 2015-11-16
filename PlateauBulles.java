import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;


public class PlateauBulle extends JFrame { // création de ma fenêtre 
	private JPanel pan;	
	private JLabel label;
	 ImageIcon monIcon=new ImageIcon("bulle.png");
	JButton bouton=new JButton(monIcon);
	
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
		Icon image = new ImageIcon("bulle.png");
		this.label =new JLabel(image); 
	


		  // label.setSize(20,20);
		    this.label.addMouseListener(new MouseAdapter(){  public void mousePressed(MouseEvent me){
	          
	               System.out.println("lol");
	           		label.setVisible(false);
	                    //Do action here
	           
	        
	    }});	
		  		    pan.add(this.label);
		this.animer(); // annimer ma bulle
	
	
									
	
		
	}
	
	
		public void animer(){
			int x,y;
			x=0;
			y=0;
			int bi=0;
			while(true){
					
					if(x==200){
						y++;
					}
					if(y==150){
						x--;
					}
					if(x==2&&y==150){
						bi=150;
					}
					if(x==5 && bi==150){
						y--;
					}
					if(y==0){
						x++;				
					}
					
						
					label.setBounds(x,y,151,151);
					
					this.pan.repaint();
											
					try {

						Thread.sleep(3);

					} catch (InterruptedException e) {

						e.printStackTrace();

					}
					}	// fin tant que
			}
		
	
	public static void main(String[]args){
		PlateauBulle plat=new PlateauBulle();
	
				
	}
}
