package bulles;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;

public class Fenetre extends JFrame {

	
	 JPanel pan = new JPanel();
	 
	 Icon image = new ImageIcon("bulle.png");
	// JButton bouton = new JButton(image);
	 JLabel label;
	 
	
	 

 
		
	
	 
	public Fenetre(){


	    this.setSize(1000, 1000);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
	    this.setVisible(true);
	    label =new JLabel(image);
	    label.addMouseListener(new MouseAdapter(){  public void mousePressed(MouseEvent me){
           
               System.out.println("AVADA KEDAVRAAAAAA");
               pan.setVisible(false);
                    //Do action here
           
        
    }});
	   pan.add(label);
		//pan.add(bouton);
		this.setContentPane(pan);
	  }
	private ImageIcon createImageIcon(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args){
		Fenetre f1 = new Fenetre();
	
		
	
	}
	}

