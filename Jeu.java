package projet_bulles;

public class Jeu {
	Identification identification;
	PlateauBulle plateau;
	Utilisateur utilisateur;

	public Jeu() {
		this.identification = new Identification();
		this.utilisateur = this.identification.getutilisateur();
		this.plateau = new PlateauBulle();
	}

	public static void main(String[] Args) {
		Jeu jeu = new Jeu();
	}
}
