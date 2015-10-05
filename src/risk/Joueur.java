package risk;

public class Joueur implements Comparable<Joueur> {

	private String nomJoueur;
	private int nbTerritoire;
	private int mouvement;
	private int heureArrivee;

	public Joueur(String nomJoueur, int nbTerritoire, int mouvement,
			int heureArrivee) {
		this.nomJoueur = nomJoueur;
		this.nbTerritoire = nbTerritoire;
		this.mouvement = mouvement;
		this.heureArrivee = heureArrivee;
	}

	public String getNomJoueur() {
		return nomJoueur;
	}

	public int getNbTerritoire() {
		return nbTerritoire;
	}

	public int getMouvement() {
		return mouvement;
	}

	public int getHeureArrivee() {
		return heureArrivee;
	}

	public String toString() {
		return nomJoueur + "," + nbTerritoire + "," + mouvement + ","
				+ heureArrivee;
	}

	public int compareTo(Joueur autreJoueur) {
		Integer i0 = new Integer(this.getNbTerritoire());
		return i0.compareTo(autreJoueur.getNbTerritoire());
	}

}
