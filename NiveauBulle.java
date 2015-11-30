import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;


public  abstract class NiveauBulle {
	private int tailleB;
	private int nombreB;
	private PlateauBulle monPlateau;

	
	public NiveauBulle( int nombreB) {
		//this.tailleB=tailleB; à voir !!
		this.nombreB=nombreB;
	    this.monPlateau=new PlateauBulle(this.nombreB);
	}
	
	public PlateauBulle getPlateauBulle(){
		return this.monPlateau;
	}


		
	
}
