package projet_bulles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import projet_bulles.Jeu.STATE;

public class ChoisirNiveau extends JFrame implements KeyListener {

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int width = (int) screenSize.getWidth();
	int height = (int) screenSize.getHeight();
	private JButton NiveauStatique1;
	private JButton NiveauStatique2;
	private JButton NiveauStatique3;
	private JButton NiveauStatique4;
	private JButton NiveauMobile1;
	private JButton NiveauMobile2;
	private JButton NiveauMobile3;
	private JButton NiveauMobile4;
	private JButton MenuPrincipal;
	double w = width / 1.75;
	double h = height / 1.5;

	public ChoisirNiveau() {

		super("Jeu De Bulles");
		setSize(width, height);

		/* Redimensionner les images pour travailler sur tous les Ã©crans */
		// if(width == 1920 && height == 1080) {
		this.setContentPane(new ImagePanel(new ImageIcon("wallpaper.jpg").getImage())); // Ã 
																						// reprendre
		// }
		this.setVisible(true);
		this.setLayout(null); // permet le position correcte des boutons

		Font police = new Font("Verdana", Font.BOLD, 15);

		this.NiveauStatique1 = new JButton("Niveau Statique1");
		this.NiveauStatique1.setBackground(Color.WHITE);
		this.NiveauStatique1.setFont(police);
		this.NiveauStatique1.setBounds(width / 10, height / 6, width / 5, height / 10);
		this.getContentPane().add(this.NiveauStatique1);

		this.NiveauStatique2 = new JButton("Niveau Statique2");
		this.NiveauStatique2.setBackground(Color.WHITE);
		this.NiveauStatique2.setFont(police);
		this.NiveauStatique2.setBounds(width / 10, height / 3, width / 5, height / 10);
		this.getContentPane().add(this.NiveauStatique2);

		this.NiveauStatique3 = new JButton("Niveau Statique3");
		this.NiveauStatique3.setBackground(Color.WHITE);
		this.NiveauStatique3.setFont(police);
		this.NiveauStatique3.setBounds(width / 10, height / 2, width / 5, height / 10);
		this.getContentPane().add(this.NiveauStatique3);

		this.NiveauStatique4 = new JButton("Niveau Statique4");
		this.NiveauStatique4.setBackground(Color.WHITE);
		this.NiveauStatique4.setFont(police);
		this.NiveauStatique4.setBounds(width / 10, (int) h, width / 5, height / 10);
		this.getContentPane().add(this.NiveauStatique4);

		this.NiveauMobile1 = new JButton("Niveau mobile1");
		this.NiveauMobile1.setBackground(Color.WHITE);
		this.NiveauMobile1.setFont(police);
		this.NiveauMobile1.setBounds((int) w, height / 6, width / 5, height / 10);
		this.getContentPane().add(this.NiveauMobile1);

		this.NiveauMobile2 = new JButton("Niveau mobile2");
		this.NiveauMobile2.setBackground(Color.WHITE);
		this.NiveauMobile2.setFont(police);
		this.NiveauMobile2.setBounds((int) w, height / 3, width / 5, height / 10);
		this.getContentPane().add(this.NiveauMobile2);

		this.NiveauMobile3 = new JButton("Niveau mobile3");
		this.NiveauMobile3.setBackground(Color.WHITE);
		this.NiveauMobile3.setFont(police);
		this.NiveauMobile3.setBounds((int) w, height / 2, width / 5, height / 10);
		this.getContentPane().add(this.NiveauMobile3);

		this.NiveauMobile4 = new JButton("Niveau mobile4");
		this.NiveauMobile4.setBackground(Color.WHITE);
		this.NiveauMobile4.setFont(police);
		this.NiveauMobile4.setBounds((int) w, (int) h, width / 5, height / 10);
		this.getContentPane().add(this.NiveauMobile4);

		this.MenuPrincipal = new JButton("Menu Principal");
		this.MenuPrincipal.setBackground(Color.WHITE);
		this.MenuPrincipal.setFont(police);
		this.MenuPrincipal.setBounds((int) (width / 3 * 1.05), height / 2, width / 6, height / 10);
		this.getContentPane().add(this.MenuPrincipal, BorderLayout.CENTER);

		this.NiveauStatique1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				dispose();

				PlateauBulle N1 = new PlateauBulle(5, 1, 0);

			}
		});

		this.NiveauStatique2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				dispose();

				PlateauBulle N1 = new PlateauBulle(7, 2, 0);

			}
		});

		this.NiveauStatique3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				dispose();

				PlateauBulle N1 = new PlateauBulle(9, 3, 0);

			}
		});

		this.NiveauStatique4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				dispose();

				PlateauBulle N1 = new PlateauBulle(11, 3, 0);

			}
		});

		this.NiveauMobile1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				dispose();

				PlateauBulle N1 = new PlateauBulle(5, 1, 1);

			}
		});

		this.NiveauMobile2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				dispose();

				PlateauBulle N1 = new PlateauBulle(7, 2, 1);

			}
		});

		this.NiveauMobile3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				dispose();

				PlateauBulle N1 = new PlateauBulle(9, 2, 1);

			}
		});

		this.NiveauMobile4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				dispose();

				PlateauBulle N1 = new PlateauBulle(11, 3, 1);

			}
		});

		this.setVisible(true);

		this.MenuPrincipal.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Jeu.State = STATE.MENU;
				dispose(); // efface l'écran de connexion
				try {
					Jeu.controller();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		ChoisirNiveau ch1 = new ChoisirNiveau();
	}

}
