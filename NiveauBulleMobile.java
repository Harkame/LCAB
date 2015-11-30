
public class NiveauBulleMobile extends NiveauBulle {
	private long vitesseBulle;
	
	public NiveauBulleMobile(int nbreBulle,int tailleBulle, long vitesseBulle){
		super(nbreBulle);
		super.getPlateauBulle().afficherBulleMobile(tailleBulle,vitesseBulle);
	}
}
