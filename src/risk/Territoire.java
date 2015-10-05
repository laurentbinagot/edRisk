package risk;

public class Territoire {

	private String nomTerritoire;
	private String nomJoueur;
	private int nbArmee;
	private int mouvement;
	private int heureArrivee;

	public Territoire(String nomTerritoire, String nomJoueur, int nbArmee,
			int mouvement, int heureArrivee) {
		this.nomTerritoire = nomTerritoire;
		this.nomJoueur = nomJoueur;
		this.nbArmee = nbArmee;
		this.mouvement = mouvement;
		this.heureArrivee = heureArrivee;
	}

	public String getNomTerritoire() {
		return nomTerritoire;
	}

	public String getNomJoueur() {
		return nomJoueur;
	}

	public int getNbArmee() {
		return nbArmee;
	}

	public int getMouvement() {
		return mouvement;
	}

	public int getHeureArrivee() {
		return heureArrivee;
	}

	public String toString() {
		return nomTerritoire + "," + nomJoueur + "," + nbArmee + ","
				+ mouvement + "," + heureArrivee;
	}

}
