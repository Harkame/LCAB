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



public class PlateauBulle extends JFrame { // création de ma fenêtre 
	public static JPanel pan;	
	public static Annimation[] anim;
	private int countClick = 0;
	private int countBulleEclat=0;
        private	Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	private int height = (int)dimension.getHeight();
	private int width  = (int)dimension.getWidth();

	/**
	 */
	public PlateauBulle(int nb, int taille, int vitesse){
		this.setTitle("La case à bulles");
		this.setSize(1000, 1000);
		this.setExtendedState(Frame.MAXIMIZED_BOTH); // fenetre plein écrant
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // stopper le programme en au click sur la croix
		this.pan =new JPanel(); // instanciation de mon conteneur
		this.setContentPane(pan); // je choisi mon contenneur 
		this.setVisible(true); // rentdre ma fenêtre visible
		this.pan.setLayout(null); // aucune disposition par défault dans mon conteneur ce qui permet de déplacer comme on veut notre label
		anim = new Annimation[nb];
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
					if(nb-countBulleEclat==0){
						 Icon imageFelicitation = new ImageIcon("feuDartifice.gif");
						 JLabel labelFelicit = new JLabel(imageFelicitation);
						 pan.add(labelFelicit); 
						 labelFelicit.setBounds(width/3,height/8,500,500);
						 JLabel instruction = new JLabel("Appuyez sur ECHAP");
						 pan.add(instruction); 
						 instruction.setBounds(width/2,height-500,500,500);						 
						
						/*		try { // Le sleep est enclanché avant l'apparition de l'image 
							
							Thread.sleep();
						
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}*/
						
						
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
		

		this.setVisible(true);// rentdre ma fenÃªtre visible
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
				
				
				final JFrame MenuBox = new JFrame();
				MenuBox.setSize(600, 600);
				MenuBox.getContentPane().setBackground(Color.BLACK);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				MenuBox.setLocation(dim.width/2-MenuBox.getSize().width/2, dim.height/2-MenuBox.getSize().height/2);
				MenuBox.setUndecorated(true);
				MenuBox.setContentPane(new ImagePanel(new ImageIcon("MenuBox_Wallpaper.jpg").getImage()));
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
					MenuBox.dispose();
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

			MenuBox.getContentPane().add(MenuPrincipal, BorderLayout.CENTER);
			MenuBox.getContentPane().add(ChoisirNiveau, BorderLayout.CENTER);
			MenuBox.getContentPane().add(QuitterJeu, BorderLayout.CENTER);
			MenuBox.getContentPane().add(RevenirJeu, BorderLayout.CENTER);
			
			RevenirJeu.setVisible(true);
			QuitterJeu.setVisible(true);
			ChoisirNiveau.setVisible(true);
			MenuPrincipal.setVisible(true);
				
			/*	à faire pour plus tard Pop up menu en plein jeu plus propre que revenir au menu et pause le jeu en cours plutot que de le quitter
			 *
				JWindow w = new JWindow();
				w.setLayout(null);
				w.setBounds(JeuTest.WIDTH/2 + 150, JeuTest.HEIGHT/2 - 150, 600, 600);
				w.setVisible(true);
				*/
				//ExecuteMenu();
				
				
			}

	

			 };
		KeyStroke key = KeyStroke.getKeyStroke((char) KeyEvent.VK_ESCAPE);
		pan.getActionMap().put("Echap", action);
		pan.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(key, "Echap");
		
		
		
		this.pan.setLayout(null); // aucune disposition par dÃ©fault dans mon conteneur ce qui permet de dÃ©placer comme on veut notre label
		this.countClick=nb;
		/***/
								
	}

	public void RevenirMenuPrincipal() throws IOException {
		Jeu.State = STATE.MENU;
		this.dispose();
		Jeu.controller();
	}
	
	public void RevenirEcranSelectionNiveau() throws IOException {
		Jeu.State = STATE.SELECTION_NIVEAU;
		this.dispose();
		Jeu.controller();
	}
	
	public static void main(String[]args){
	new PlateauBulle(15, 1, 2);
		// après cette instruction rien ne peut s'excuter car j'utilise un true dans la condition d'un tant que 

	}
}
