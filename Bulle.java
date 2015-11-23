import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Bulle {
	private JPanel pan;
	private JLabel label;	
	private int larg;
	private int haut;
	private int x;
	private int y;
	private static Icon image = new ImageIcon("bulle.png");
	
							
	public Bulle(int x, int y, int larg, int haut,JPanel pan){
		
		this.label =new JLabel(image); 
		this.x=x;
		this.y=y;
		this.larg=larg;
		this.haut=haut;
		this.pan=pan;
		  this.label.addMouseListener(new MouseAdapter(){  public void mousePressed(MouseEvent me){
	          
              System.out.println("lol");
          	  label.setVisible(false);
                   //Do action here    	
   }});	
	  		 this.pan.add(this.label);
	  		 this.label.setBounds(this.x,this.y,this.larg,this.haut);
	}

	/*public void afficherBulle(JPanel pan){
		pan.add(this.label);
		this.label.setBounds(this.x,this.y,this.larg,this.haut);
	}*/
	public void animer(){
	
		
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth();
		this.x=(int)(Math.random()*(width-150));
		this.y=(int)(Math.random()*(height-215));
		int signal=0;
		int signaly=0;
		while(true){
			
				this.label.setBounds(this.x,this.y,151,151);
				if(this.x==(width-150)&&signaly==0){
					signal=1;	
				}
				if(this.y==(height-215)&&signal==0){
					signaly=1;
				}
				if(signal==1&&signaly==1){
					this.x=this.x-1;
					this.y=this.y-1;
					if(this.x==0){
						signal=0;
					}
					if(this.y==0){
						signaly=0;
					}
				}
				else if(signal==1&&signaly==0){
					this.x=this.x-1;
					this.y=this.y+1;
					if(this.x==0){
						signal=0;
					}
				}
				else if(signal==0&&signaly==1){
					this.x=this.x+1;
					this.y=this.y-1;
					if(this.y==0){
						signaly=0;
					}
				}
				else if(signal==0&&signaly==0){
					this.x=this.x+1;
					this.y=this.y+1;
				}
				try {

					Thread.sleep(3);

				} catch (InterruptedException e) {

					e.printStackTrace();

				}
				}	// fin tant que
		}



}
