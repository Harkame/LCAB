package bulles;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;



public class Menu {

		public	Rectangle JouerBoutton = new Rectangle(Game.WIDTH / 2 + 120, 150, 300, 50);
		public	Rectangle ChoixNiveauBoutton = new Rectangle(Game.WIDTH / 2 + 120, 250, 300, 50);
		public	Rectangle QuitterBoutton = new Rectangle(Game.WIDTH / 2 + 120, 350, 300, 50);
			
			
				
				Graphics g2d = (Graphics2D) g;
			Font fnt0= new Font("arial", Font.BOLD, 50);
			g.setFont(fnt0);
			g.setColor(Color.white);
			g.drawString("Jeu de bulles", Game.WIDTH / 2, 100); // Game variable à créer ou taille à définir
			Font fnt1 = new Font("arial", Font.BOLD, 30);
			g.setFont(fnt1);
			g.drawString("Jouer", JouerBoutton.x + 19,JouerBoutton.y + 30);
			((Graphics2D) g2d).draw(JouerBoutton);
			g.drawString("Choix Niveau", ChoixNiveauBoutton.x + 19, ChoixNiveauBoutton.y + 30);
			((Graphics2D) g2d).draw(ChoixNiveauBoutton);
			g.drawString("Quitter", QuitterBoutton.x + 19, QuitterBoutton.y + 30);
			((Graphics2D) g2d).draw(QuitterBoutton);
			
	}
	
}
