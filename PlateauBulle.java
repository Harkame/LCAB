package projet_bulles;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JWindow;
import javax.swing.KeyStroke;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;

import projet_bulles.Jeu.STATE;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.io.IOException;



public class PlateauBulle extends JFrame { // creation de la fenetre
	public static JPanel pan;	// notre conteneur
	this.setContentPane(new ImagePanel(new ImageIcon(getClass().getResource("/lefond.jpg"))
				.getImage())); //on met le fond
	public static Annimation[] anim; // tableau animmation qui contiendra tout nos objets animmation
	private int countClick = 0;      // le nombre de click total
	private int countBulleEclat=0;  // nombre de click total sur les bulles
        private	Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); // recuperation des dimensions de l'ecrant 
	private int height = (int)dimension.getHeight(); 
	private int width  = (int)dimension.getWidth();
	private JButton palierSuivant;
	private JButton MenuPrincipal;
	Font police = new Font("Verdana", Font.BOLD, 15);
	
	
	
	

	/**
	 */
	public PlateauBulle(int nb, int taille, int vitesse){
		
		this.MenuPrincipal = new JButton("Menu Principal");
		this.MenuPrincipal.setBackground(Color.WHITE);
		this.MenuPrincipal.setFont(police);
		this.MenuPrincipal.setBounds((int) (width / 3 * 1.05), height / 3, width / 6, height / 10);
		//this.getContentPane().add(this.MenuPrincipal);
		//this.MenuPrincipal.setVisible(false);
		
		
		this.MenuPrincipal.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Jeu.State = STATE.MENU;
				dispose(); // efface l'Ã©cran de connexion
				try {
					Jeu.controller();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		
		this.setTitle("La case Ã  bulles");
		this.setSize(1000, 1000);
		this.setExtendedState(Frame.MAXIMIZED_BOTH); // fenetre plein Ã©crant
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // stopper le programme en au click sur la croix
		this.pan =new JPanel(); // instanciation de mon conteneur
		this.setContentPane(pan); // je choisi mon contenneur 
		this.setVisible(true); // rentdre ma fenÃªtre visible
		this.pan.setLayout(null); // aucune disposition par dÃ©fault dans mon conteneur ce qui permet de dÃ©placer comme on veut notre label
		anim = new Annimation[nb];
		
		this.palierSuivant = new JButton("Palier Suivant");  // crÃ©ation du bouton palier suivant
		this.palierSuivant.setBackground(Color.WHITE);
		this.palierSuivant.setBounds((width /2)-115, (height/2)+200, 300, 75); // Ã  replacer
		this.palierSuivant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				if (nb+2 <=11 ){ // si on est pas dÃ©jÃ  au dernier palier (donc Ã  9 bulles prÃ©sentes)
					if(vitesse==0){  // envoie au palier "statique" ou "mobile" suivant l'actuel
						if(taille+1<=3){
						
						PlateauBulle N1= new PlateauBulle(nb+2,taille+1,0);
						}
						else{ PlateauBulle N1= new PlateauBulle(nb+2,taille,0);
					}
					}
					else if(taille+1<=3){
						PlateauBulle N1= new PlateauBulle(nb+2,taille+1,1);
					}
				
					else{PlateauBulle N1= new PlateauBulle(nb+2,taille,1);}
					
				}
					
				}
				

				
				
			}
		);
		
		this.getContentPane().add(this.palierSuivant);
		this.palierSuivant.setVisible(false);
		
		
		for (int i = 0; i<nb; i++){
			anim[i] = new Annimation("anim", pan, taille, vitesse);
		}
		for (int i = 0; i<nb; i++){
			anim[i].start();
		}
		for (int i = 0; i<nb; i++){ // Une action a chaque bulle
			        anim[i].getBulle().getLabel().addMouseListener(new MouseAdapter() {
				    public void mousePressed(MouseEvent me) {
					     countBulleEclat++;
					if(nb-countBulleEclat==0){  // quand il n'y a plus de bulle
						 Icon imageFelicitation = new ImageIcon(getClass().getResource("/feuDartifice.gif")); // mettre ici le gif Ã  la place
						 JLabel labelFelicit = new JLabel(imageFelicitation);
						 pan.add(labelFelicit); 
						 labelFelicit.setBounds(width/3,height/8,500,500);
						
						 int palier;
						 int nombre_clics = 0;
						
						 if (vitesse>0){
							 if(nb==11){palier=8;}
							 else{palier=taille+4;}
							 nombre_clics = countClick;
						 try {
							Identification.getutilisateur().modifieScore(palier, nombre_clics);
						} catch (IOException e) {
							e.getMessage();
							e.printStackTrace();
						}
						 if(taille+1>3 && nb+2>11){
								JLabel fin = new JLabel("Vous avez terminé ce mode de jeu, bravo !!!");
								pan.add(fin);
								fin.setBounds(width/2,height/3,500,500);
								MenuPrincipal.setBounds((int) (width /2)-115, (height/2)+200, 300, 75);
								pan.add(MenuPrincipal);
								
							}
						 else{
						 palierSuivant.setVisible(true);}
						 } else{
							 if(nb==11){palier=4;}
							 else{palier=taille;}
							 nombre_clics = countClick;
							 try {
								Identification.getutilisateur().modifieScore(palier, nombre_clics);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
							 if(taille+1>3 && nb+2>11){
									JLabel fin = new JLabel("Vous avez terminé ce mode de jeu, bravo !!!");
									pan.add(fin);
									fin.setBounds(width/2,height/3,500,500);
									MenuPrincipal.setBounds((int) (width /2)-115, (height/2)+200, 300, 75);
									pan.add(MenuPrincipal);
									
								}
							 else{
							 palierSuivant.setVisible(true);}
							 
						 }
						
						
					}
						
					

				}
					
			}); 
		}
		this.pan.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				countClick++;
				System.out.println(countClick);
					// TODO Auto-generated catch block
				

			}
		}); 
		

		this.setVisible(true);// rentdre ma fenÃƒÂªtre visible
		//this.getContentPane().setBackground(Color.BLACK);
		this.getContentPane().setBackground(Color.WHITE);
		Action action = new AbstractAction("Echap") {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				/*Jeu.State = STATE.MENU;
				dispose();
				try {
					Jeu.controller();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				
				final JFrame MenuBox = new JFrame(); // Fait le menu echap 
				MenuBox.setSize(600, 600);
				MenuBox.getContentPane().setBackground(Color.BLACK);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				MenuBox.setLocation(dim.width/2-MenuBox.getSize().width/2, dim.height/2-MenuBox.getSize().height/2); // met la taille
				MenuBox.setUndecorated(true);
				MenuBox.setContentPane(new ImagePanel(new ImageIcon(getClass().getResource("/MenuBox_Wallpaper.png")).getImage()));
				MenuBox.setVisible(true);
				
				JButton RevenirJeu;
				JButton MenuPrincipal;
				JButton ChoisirNiveau;
				JButton QuitterJeu;
				
			
			MenuBox.setLayout(null);
			Font police = new Font("Verdana", Font.BOLD, 20);
				
			RevenirJeu = new JButton("Reprendre le jeu");
			RevenirJeu.setBackground(Color.CYAN);
			RevenirJeu.setFont(police);
			RevenirJeu.setBounds(215-25, 50, 250, 75);	//-25 pour le mettre au milieu
			
			RevenirJeu.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					MenuBox.dispose();
				
					
					
				}
				
			});
			
			
			MenuPrincipal = new JButton("Menu principal");
			MenuPrincipal.setBackground(Color.CYAN);
			MenuPrincipal.setFont(police);
			MenuPrincipal.setBounds(215, 175, 200, 75);

			MenuPrincipal.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					MenuBox.dispose(); // Le Menu disparaît
					try {
						RevenirMenuPrincipal();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				
			});
			
			
			ChoisirNiveau = new JButton("Niveaux");
			ChoisirNiveau.setBackground(Color.CYAN);
			ChoisirNiveau.setFont(police);
			ChoisirNiveau.setBounds(215, 300, 200, 75);
			
			
			ChoisirNiveau.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					MenuBox.dispose();
					try {
						RevenirEcranSelectionNiveau();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				
			});

			QuitterJeu = new JButton("Quitter le jeu");
			QuitterJeu .setBackground(Color.CYAN);
			QuitterJeu .setFont(police);
			QuitterJeu .setBounds(215, 425,200, 75);
			
			QuitterJeu.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
					
					
				}
				
			});

			MenuBox.getContentPane().add(MenuPrincipal, BorderLayout.CENTER); // Ajoute le bouton à la fenetre MenuBox
			MenuBox.getContentPane().add(ChoisirNiveau, BorderLayout.CENTER);
			MenuBox.getContentPane().add(QuitterJeu, BorderLayout.CENTER);
			MenuBox.getContentPane().add(RevenirJeu, BorderLayout.CENTER);
			
			RevenirJeu.setVisible(true); // rend visisible le bouton
			QuitterJeu.setVisible(true);
			ChoisirNiveau.setVisible(true);
			MenuPrincipal.setVisible(true);
				
			/*	Ã  faire pour plus tard Pop up menu en plein jeu plus propre que revenir au menu et pause le jeu en cours plutot que de le quitter
			 *
				JWindow w = new JWindow();
				w.setLayout(null);
				w.setBounds(JeuTest.WIDTH/2 + 150, JeuTest.HEIGHT/2 - 150, 600, 600);
				w.setVisible(true);
				*/
				//ExecuteMenu();
				
				
			}

	

			 };
		KeyStroke key = KeyStroke.getKeyStroke((char) KeyEvent.VK_ESCAPE); // KeyHandler pour echap pour afficher le menuBox
		pan.getActionMap().put("Echap", action);
		pan.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(key, "Echap");
		
		
		
		this.pan.setLayout(null); // aucune disposition par dÃƒÂ©fault dans mon conteneur ce qui permet de dÃƒÂ©placer comme on veut notre label
		this.countClick=nb;
		/***/
								
	}

	public void RevenirMenuPrincipal() throws IOException { // RevenirMenuprincipal
		Jeu.State = STATE.MENU;
		this.dispose();
		Jeu.controller();
	}
	
	public void RevenirEcranSelectionNiveau() throws IOException { // RevenirEcranSelectionNiveau
		Jeu.State = STATE.SELECTION_NIVEAU;
		this.dispose();
		Jeu.controller();
	}
	
	public static void main(String[]args){
	new PlateauBulle(9,5,0);
		// aprÃ¨s cette instruction rien ne peut s'excuter car j'utilise un true dans la condition d'un tant que 

	}
}
