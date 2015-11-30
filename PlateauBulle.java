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
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.io.IOException;



public class PlateauBulle extends JFrame implements KeyListener { // crÃ©ation de ma fenÃªtre 
	private static JPanel pan;	
	private static Annimation[] anim;
	private int nb;

	
	/**
	 */
	public PlateauBulle(int nb){
		this.setTitle("La case à  bulles");
		this.setSize(1000, 1000);
		this.setExtendedState(Frame.MAXIMIZED_BOTH); // fenetre plein Ã©crant
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // stopper le programme en au click sur la croix
		this.pan =new JPanel(); // instanciation de mon conteneur
		this.setContentPane(pan); // je choisi mon contenneur 
		this.pan.setLayout(null); // aucune disposition par défault dans mon conteneur ce qui permet de déplacer comme on veut notre label
		this.setVisible(true);// rentdre ma fenÃªtre visible
		//this.getContentPane().setBackground(Color.BLACK);
		this.getContentPane().setBackground(Color.WHITE);
		Action action = new AbstractAction("Echap") {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Jeu.State = STATE.MENU;
				dispose();
				try {
					Jeu.controller();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			/*	à faire pour plus tard Pop up menu en plein jeu plus propre que revenir au menu et pause le jeu en cours plutot
			que de le quitter
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
		this.nb=nb;
		/***/
								
	}
	/* a faire pour plus tard
	private void ExecuteFloatMenu() {
		
		
		JButton MenuPrincipal;
		JButton ChoisirNiveau;
		JButton QuitterJeu;
		
	
		this.setLayout(null);
		Font police = new Font("Verdana", Font.BOLD, 20);
		
		
		MenuPrincipal = new JButton("Menu principal");
		MenuPrincipal.setBackground(Color.BLACK);
		MenuPrincipal.setFont(police);
		MenuPrincipal.setBounds(1000, 400, 200, 75);

	
	ChoisirNiveau = new JButton("Sélection du niveau");
	ChoisirNiveau.setBackground(Color.BLACK);
	ChoisirNiveau.setFont(police);
	ChoisirNiveau.setBounds(1000, 400, 200, 75);
	

	QuitterJeu = new JButton("Quitter le jeu");
	QuitterJeu .setBackground(Color.BLACK);
	QuitterJeu .setFont(police);
	QuitterJeu .setBounds(1000, 400, 200, 75);

	this.getContentPane().add(MenuPrincipal, BorderLayout.CENTER);
	this.getContentPane().add(ChoisirNiveau, BorderLayout.CENTER);
	this.getContentPane().add(QuitterJeu, BorderLayout.CENTER);
	
	QuitterJeu.setVisible(true);
	ChoisirNiveau.setVisible(true);
	MenuPrincipal.setVisible(true);

	
	}
	
*/
	
	
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
	
	

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == KeyEvent.VK_ESCAPE) {
			
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[]args){
		NiveauBulle N1= new NiveauBulleStatic(9,4);
		//NiveauBulle N2= new NiveauBulleMobile(3,5,3);
			
		}
}
