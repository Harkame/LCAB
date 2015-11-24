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
	private static Icon image = new ImageIcon("bulle.png");	private static Icon image2 = new ImageIcon("bb.png");
        private static int cpt=0;
	
							
	public Bulle(int x, int y, int larg, int haut,JPanel pan){
		int a = (int)(Math.random()+0.5);
		if (a == 0){
			this.label =new JLabel(image);
		}
		else {this.label =new JLabel(image2); 
		}this.x=x;
		this.y=y;
		this.larg=larg;
		this.haut=haut;
		this.pan=pan;
		this.label.addMouseListener(new MouseAdapter(){  public void mousePressed(MouseEvent me){
	          cpt++;
              		System.out.println(cpt);
          	  	label.setVisible(false);
                   	//Do action here    	
   		}});	
	  	this.pan.add(this.label);
	  	this.label.setBounds(this.x,this.y,this.larg,this.haut);
	}

	public char colision(){
		char cote= 'a';
		for (int i =0; i<PlateauBulle.anim.length; i++){
			if (this.x!=PlateauBulle.anim[i].bulle.getX()&&this.y!=PlateauBulle.anim[i].bulle.getY()){
				if(((this.x-PlateauBulle.anim[i].bulle.getX())*(this.x-PlateauBulle.anim[i].bulle.getX())+(this.y-PlateauBulle.anim[i].bulle.getY())*(this.y-PlateauBulle.anim[i].bulle.getY()))<=151*151){
					
					if((this.x-PlateauBulle.anim[i].bulle.getX())>(0-150)&&(this.y+75>PlateauBulle.anim[i].bulle.getY())&&(this.y-75<PlateauBulle.anim[i].bulle.getY())){cote= 'd';}
					else if(((this.x-PlateauBulle.anim[i].bulle.getX())<150)&&(this.y+75>PlateauBulle.anim[i].bulle.getY())&&(this.y-75<PlateauBulle.anim[i].bulle.getY())){cote= 'g';}
					else if((this.y-PlateauBulle.anim[i].bulle.getY())>(0-150)&&(this.x+75>PlateauBulle.anim[i].bulle.getX())&&(this.x-75<PlateauBulle.anim[i].bulle.getX())){cote= 'h';}
					else if(((this.y-PlateauBulle.anim[i].bulle.getY())<150)&&(this.x+75>PlateauBulle.anim[i].bulle.getX())&&(this.x-75<PlateauBulle.anim[i].bulle.getX())){cote= 'b';}
				}
			}
		}
		
		return cote;
	}

	public void animer(){

		
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth();
		this.x=(int)(Math.random()*(width-150));
		this.y=(int)(Math.random()*(height-215));
		int signal=0;
		int signaly=0;
		char coli;
		while(true){
		
			this.label.setBounds(this.x,this.y,151,151);
			coli = this.colision();
			if(this.x==(width-150)||coli=='d'){
				signal=1;	
			}
			else if(this.x==0||coli=='g'){
				signal=0;
			}

			if(this.y==(height-215)||coli=='h'){
				signaly=1;
			}
			else if(this.y==0||coli=='b'){
				signaly=0;
			}
			if(signal==1&&signaly==1){
				this.x=this.x-1;
				this.y=this.y-1;
			}
			else if(signal==1&&signaly==0){
				this.x=this.x-1;
				this.y=this.y+1;
			}
			else if(signal==0&&signaly==1){
				this.x=this.x+1;
				this.y=this.y-1;
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

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}
}
