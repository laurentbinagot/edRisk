package risk;

public class Comportement implements Comparable<Comportement> {

	private int numCode;
	private int mouvement;
	private int heureArrivee;
	private String nomTerritoire;
	private int pp;
	private int pv;
	private int pa;
	private int si;
	private int ic;
	private int ea;
	private int heureMessage;

	public Comportement(int numCode, int mouvement, int heureArrivee,
			String nomTerritoire, int pp, int pv, int pa, int si, int ic,
			int ea, int heureMessage) {
		this.numCode = numCode;
		this.mouvement = mouvement;
		this.heureArrivee = heureArrivee;
		this.nomTerritoire = nomTerritoire;
		this.pp = pp;
		this.pv = pv;
		this.pa = pa;
		this.si = si;
		this.ic = ic;
		this.ea = ea;
		this.heureMessage = heureMessage;
	}

	public int getNumCode() {
		return numCode;
	}

	public int getMouvement() {
		return mouvement;
	}

	public int getHeureArrivee() {
		return heureArrivee;
	}

	public String getNomTerritoire() {
		return nomTerritoire;
	}

	public int getPp() {
		return pp;
	}

	public int getPv() {
		return pv;
	}

	public int getPa() {
		return pa;
	}

	public void setPa(int pa) {
		this.pa = pa;
	}

	public int getSi() {
		return si;
	}

	public int getIc() {
		return ic;
	}

	public int getEa() {
		return ea;
	}

	public int getHeureMessage() {
		return heureMessage;
	}

	public String toString() {
		return numCode + "," + mouvement + "," + heureArrivee + ","
				+ nomTerritoire + "," + pp + "," + pv + "," + pa + "," + si
				+ "," + ic + "," + ea + "," + heureMessage;
	}

	//Methode de comparaison sur le nombre de pp
	public int compareTo(Comportement autreComportement) {
		Integer c0 = new Integer(this.getPp());
		return c0.compareTo(autreComportement.getPp());
	}

}
