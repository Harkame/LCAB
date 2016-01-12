 package projet_bulles;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Bulle {
	private JPanel pan;
	private JLabel label;	
	private int margx;
	private int margy;
	private int x;
	private int y;
	private int vitesse;
    private Clip son;
	
	private static Icon image = new ImageIcon("giphy.gif");	private static Icon image2 = new ImageIcon("giphy2.gif");
        private static int cpt=0;
	
/*
	Méthode de création de bulle où la taille et la vitesse sont données en paramètres.
*/
	
	public Bulle(int x, int y, int taille, int vitesse, JPanel pan){
		try{
			//File fichierSon=new File ("eclatBullebest.wav");
			AudioInputStream sound;
			sound = AudioSystem.getAudioInputStream(getClass().getResource("/eclatBullebest.wav"));
			DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
			son  = (Clip) AudioSystem.getLine(info);
			son.open(sound);
			} catch (UnsupportedAudioFileException|LineUnavailableException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			//Création d'un entier aléatiore pour le choix de la couleur aléatoire
			int rand = (int)(Math.random()*5)+1;
			
			//Ce switch est utilisé pour le choix de la taille définit en paramètre (1,2,3,4 ou 5)
			switch(taille){
				switch(taille){
			case 1:
				this.margx=350;
				this.margy=353;
				// Ici, on choisit la couleur de la bulle en fonction de la valeur aléatoire définie précédement
				// Les couleurs sont: gris, jaune, rouge, vert, violet
				if (rand==1){
					this.label = new JLabel(new ImageIcon(getClass().getResource("bulle4.png")));
				}
				else if (rand ==2){
					this.label = new JLabel(new ImageIcon(getClass().getResource("bulle4b.png")));
				}
				else if (rand ==3){
					this.label = new JLabel(new ImageIcon(getClass().getResource("bulle4r.png")));
				}
				else if (rand ==4){
					this.label = new JLabel(new ImageIcon(getClass().getResource("bulle4v.png")));
				}
				else{
					this.label = new JLabel(new ImageIcon(getClass().getResource("bulle4violet.png")));
				}
			break;
			case 2:
				this.margx=255;
				this.margy=255;
				if (rand==1){
					this.label = new JLabel(new ImageIcon(getClass().getResource("bulle3.png")));
				}
				else if (rand ==2){
					this.label = new JLabel(new ImageIcon(getClass().getResource("bulle3b.png")));
				}
				else if (rand ==3){
					this.label = new JLabel(new ImageIcon(getClass().getResource("bulle3r.png")));
				}
				else if (rand ==4){
					this.label = new JLabel(new ImageIcon(getClass().getResource("bulle3v.png")));
				}
				else{
					this.label = new JLabel(new ImageIcon(getClass().getResource("bulle3violet.png")));
				}
			break;
			case 3:
				this.margx=151;
				this.margy=151;
				if (rand==1){
					this.label = new JLabel(new ImageIcon(getClass().getResource("bulle2.png")));
				}
				else if (rand ==2){
					this.label = new JLabel(new ImageIcon(getClass().getResource("bulle2b.png")));
				}
				else if (rand ==3){
					this.label = new JLabel(new ImageIcon(getClass().getResource("bulle2r.png")));
				}
				else if (rand ==4){
					this.label = new JLabel(new ImageIcon(getClass().getResource("bulle2v.png")));
				}
				else{
					this.label = new JLabel(new ImageIcon(getClass().getResource("bulle2violet.png")));
				}
			break;
			case 4:
				this.margx=115;
				this.margy=115;
				if (rand==1){
					this.label = new JLabel(new ImageIcon(getClass().getResource("bulle1.png")));
				}
				else if (rand ==2){
					this.label = new JLabel(new ImageIcon(getClass().getResource("bulle1j.png")));
				}
				else if (rand ==3){
					this.label = new JLabel(new ImageIcon(getClass().getResource("bulle1r.png")));
				}
				else if (rand ==4){
					this.label = new JLabel(new ImageIcon(getClass().getResource("bulle1v.png")));
				}
				else{
					this.label = new JLabel(new ImageIcon(getClass().getResource("bulle1violet.png")));
				}
			break;
			case 5:
				this.margx=520;
				this.margy=523;
				if (rand==1){
					this.label = new JLabel(new ImageIcon(getClass().getResource("/bulle5.png")));
				}
				else if (rand ==2){
					this.label = new JLabel(new ImageIcon(getClass().getResource("/bulle5j.png")));
				}
				else if (rand ==3){
					this.label = new JLabel(new ImageIcon(getClass().getResource("/bulle5r.png")));
				}
				else if (rand ==4){
					this.label = new JLabel(new ImageIcon(getClass().getResource("/bulle5v.png")));
				}
				else{
					this.label = new JLabel(new ImageIcon(getClass().getResource("/bulle5violet.png")));
				}
			break;
		}
		this.x=x;
		this.y=y;
		this.pan=pan;
		this.vitesse=vitesse;
		// Quand une bulle est cliqué, elle disparait et un son est joué, le compteur de bulles éclaté est incrémenté.
		this.label.addMouseListener(new MouseAdapter(){  public void mousePressed(MouseEvent me){
	          cpt++;
              		System.out.println(cpt);
          	  	label.setVisible(false);
                   	//Do action here    
                   	son.start();
   		}});	
	  	this.pan.add(this.label);
	  	this.label.setBounds(this.x,this.y,this.margx,this.margy);
	}
/*
	public char colision(){
		char cote= 'a';
		for (int i =0; i<PlateauBulle.anim.length; i++){
			if (this.x!=PlateauBulle.anim[i].bulle.getX()&&this.y!=PlateauBulle.anim[i].bulle.getY()){
				if(((this.x-PlateauBulle.anim[i].bulle.getX())*(this.x-PlateauBulle.anim[i].bulle.getX())+(this.y-PlateauBulle.anim[i].bulle.getY())*(this.y-PlateauBulle.anim[i].bulle.getY()))<=151*151){
					
					if((this.x-PlateauBulle.anim[i].bulle.getX())<(-151)){cote= 'd';}
					else if((this.x-PlateauBulle.anim[i].bulle.getX())<151){cote= 'g';}
					else if((this.y-PlateauBulle.anim[i].bulle.getY())<(-151)){cote= 'h';}
					else if((this.y-PlateauBulle.anim[i].bulle.getY())<151){cote= 'b';}
				}
			}
		}
		
		return cote;
	}
*/

/* 
	Méthode d'animation des bulles. Elles bougent en fonction de la vitesse donné en paramètre à la création de l'objet Bulle.
	Elles bougent toute les 15 milièmes de seconde (60 fps environ).
	Les collisions contre les bords de l'écran sont aussi gérées en fonction de la taille de la bulle définie à sa création.
*/
	public void animer(){

		
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth();
		this.x=(int)(Math.random()*(width-this.margx));
		this.y=(int)(Math.random()*(height-(this.margy+65)));
		int signal=0;
		int signaly=0;
		while(true){
		
			this.label.setBounds(this.x,this.y,this.margx,this.margx);
			if(this.x>=(width-this.margx)){
				signal=1;	
			}
			else if(this.x<=0){
				signal=0;
			}

			if(this.y>=(height-this.margx-65)){
				signaly=1;
			}
			else if(this.y<=0){
				signaly=0;
			}
			if(signal==1&&signaly==1){
				this.x=this.x-this.vitesse;
				this.y=this.y-this.vitesse;
			}
			else if(signal==1&&signaly==0){
				this.x=this.x-this.vitesse;
				this.y=this.y+this.vitesse;
			}
			else if(signal==0&&signaly==1){
				this.x=this.x+this.vitesse;
				this.y=this.y-this.vitesse;
			}
			else if(signal==0&&signaly==0){
				this.x=this.x+this.vitesse;
				this.y=this.y+this.vitesse;
			}
			try {

				Thread.sleep(15);

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
	public JLabel getLabel(){
		return this.label;
	}
}
