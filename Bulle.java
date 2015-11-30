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
	private int margx;
	private int margy;
	private int x;
	private int y;
	private int taille; 
	private long vitesseBul;
	private static Icon image;	//private static Icon image2 = new ImageIcon("bb.png");
    private static int cpt=0;
	
							
	public Bulle(int x, int y, long vitesseBul,int taille,JPanel pan){
		/*int a = (int)(Math.random()+0.5);
		if (a == 0){
			this.label =new JLabel(image);
		}
		else {this.label =new JLabel(image2); 
		}*/
			this.taille=taille;
			switch(this.taille){
			case 1:
				this.margx=115;
				this.margy=115;
				image= new ImageIcon("bulle.png");
			break;
			case 2:
				this.margx=151;
				this.margy=151;
				image= new ImageIcon("bulle2.png");
			break;
			case 3:
				this.margx=255;
				this.margy=255;
				image= new ImageIcon("bulle3.png");
			break;
			case 4:
				this.margx=350;
				this.margy=353;
				image= new ImageIcon("bulle4.png");
			break;
			case 5:
				this.margx=520;
				this.margy=523;
				image= new ImageIcon("bulle5.png");
			break;
			 default:
				this.margx=115;
				this.margy=115;
				image= new ImageIcon("bulle.png");
			break;
			
		}
			
			
		this.label =new JLabel(image);
		this.vitesseBul=vitesseBul;
		this.x=x;
		this.y=y;
		this.pan=pan;
		this.label.addMouseListener(new MouseAdapter(){  public void mousePressed(MouseEvent me){
	          cpt++;
              		System.out.println(cpt);
          	  	label.setVisible(false);
                   	//Do action here    	
   		}});	
	  	this.pan.add(this.label);
	  	this.label.setBounds(this.x,this.y,this.margx,this.margy);
	}


	/*public char colision(){
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
		
			this.label.setBounds(this.x,this.y,this.margx,this.margy);
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

				Thread.sleep(this.vitesseBul);

			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}	// fin tant que
	}*/

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}
	public int getMargx(){
		return this.margx;
	}
	public int getMargy(){
		return this.margy;
	}
	public int getTailleBulle(){
		return this.taille;
	}
	public void setTailleBulle(int newTaille){
		this.taille=newTaille;
		switch(this.taille){
		case 1:
			this.margx=115;
			this.margy=115;
			image= new ImageIcon("bulle.png");
		break;
		case 2:
			this.margx=151;
			this.margy=151;
			image= new ImageIcon("bulle2.png");
		break;
		case 3:
			this.margx=255;
			this.margy=255;
			image= new ImageIcon("bulle3.png");
		break;
		case 4:
			this.margx=350;
			this.margy=353;
			image= new ImageIcon("bulle4.png");
		break;
		case 5:
			this.margx=520;
			this.margy=523;
			image= new ImageIcon("bulle5.png");
		break;
		 default:
			this.margx=115;
			this.margy=115;
			image= new ImageIcon("bulle.png");
		break;
		
	}
		this.label.setIcon(image);
	}
	public long getVitesseBulle(){
		return this.vitesseBul;
	}
	public void setVitesseBulle(long newVitesseBulle){
		this.vitesseBul=newVitesseBulle;
	}
}

