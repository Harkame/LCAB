import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;





public class PlateauBulle extends JFrame { // création de ma fenêtre 
	private JPanel pan;	
	private JLabel label;	
	private int clickCount=0;
	
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
								
	    this.label.addMouseListener(new MouseAdapter(){  public void mousePressed(MouseEvent me){
	        	 clickCount++;
	                 System.out.println(clickCount);
	           		label.setVisible(false);
	                       	
	    }});	
		  		    pan.add(this.label);
		  		    pan.addMouseListener(new MouseAdapter(){  public void mousePressed(MouseEvent me){
	          
	          	clickCount++;
	               System.out.println(clickCount);
	           		
	                    //Do action here    	
	    }});
		this.animer(); // annimer ma bulle
	
		  		
	
		
	}
	
	
		public void animer(){
			int x,y;
			x=500;
			y=0;
			int bi=0;
			while(true){
					
					if(x==800){
						y++;
					}
					if(y==150){
						x--;
						bi=150;
					}
					
					if(x==500 && bi==150){
						y--;
					}
					if(y==0){
						x++;				
					}
					
						
					label.setBounds(x,y,151,151);
					
					this.pan.repaint();
											
					try {

						Thread.sleep(1,5);

					} catch (InterruptedException e) {

						e.printStackTrace();

					}
					}	// fin tant que
			}
		
	
	public static void main(String[]args){
		PlateauBulle plat=new PlateauBulle();
	
				
	}
}
