package risk;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class OrganiseTerritoire {

	private ArrayList<Territoire> alHisto;

	private HashMap<String, ArrayList<Territoire>> hashMap;

	public OrganiseTerritoire() {
		alHisto = new ArrayList<Territoire>();

		hashMap = new HashMap<String, ArrayList<Territoire>>();

		lireFichier();

		// construction de la HashMap a partir de l'ArrayList
		alToHm();
	}

	private void lireFichier() {
		// le repertoire de travail $HOME/workspace/edRisk
		// en remplacant $HOME par sa valeur
		String nomFichier = System.getProperty("user.dir");

		// on ajoute le chemin + le nom du fichier de traces
		nomFichier = nomFichier + "/donnees/traceEntreeTerritoire.txt";

		Scanner fichier = null;

		try { // ouverture
			fichier = new Scanner(new File(nomFichier));

			// traitement
			while (fichier.hasNext()) {
				traiteLigne(fichier.next());
			}

			// fermeture
			fichier.close();
		} catch (Exception exc) {
			System.out.println("Erreur fichier" + exc);
		}
	}

	private void traiteLigne(String ligne) {
		String str[] = ligne.split(",");
		alHisto.add(new Territoire(str[0], str[1], Integer.parseInt(str[2]),
				Integer.parseInt(str[3]), Integer.parseInt(str[4])));
	}

	public void interrogation1() {
		for (Territoire t : alHisto) {
			System.out.println(t);
		}
	}

	public void interrogation2() {
		for (String nomT : hashMap.keySet()) {
			// nb elem de l'AL que l'on recup comme valeur
			int nbElem = hashMap.get(nomT).size();
			System.out.println(nomT + "," + nbElem);
		}
	}

	// tpsMaxT : temps ou le joueur a un max de territoires
	public ArrayList<Territoire> carteFinal(int tpsMaxT) {
		ArrayList<Territoire> alRes = new ArrayList<Territoire>();

		HashSet<String> hs = new HashSet<String>(hashMap.keySet());
		int indiceMaxT = 0;
		for (int i = 0; i < alHisto.size(); i++) {
			if (alHisto.get(i).getHeureArrivee() > tpsMaxT) {
				indiceMaxT = i; // indice de rupture

				break; // sortie de boucle
			}
		}
		for (int i = indiceMaxT - 1; i >= 0; i--) {

			Territoire t = alHisto.get(i);

			if (hs.contains(t.getNomTerritoire())) {
				alRes.add(t);
				hs.remove(t.getNomTerritoire());

				if (hs.isEmpty())
					break;

			}
		}
		return alRes;
	}

	public ArrayList<Element> interrogation3() {
		ArrayList<Element> alE = new ArrayList<Element>();
		Set<String> set = this.hashMap.keySet();
		for (String prov : set)
			alE.add(new Element(prov, this.hashMap.get(prov).size()));
		Collections.sort(alE);
		return alE;
	}

	private void alToHm() {
		for (Territoire t : alHisto) {
			String cle = t.getNomTerritoire();
			if (!hashMap.containsKey(cle))
				hashMap.put(cle, new ArrayList<Territoire>());
			ArrayList<Territoire> alT = hashMap.get(cle);
			alT.add(t);
		}
	}

	public String toString() {
		return "ArrayList " + alHisto.toString() + "\nHashMap "
				+ hashMap.toString();
	}

	public static void main(String[] arg) {
		OrganiseTerritoire organiseTerritoire = new OrganiseTerritoire();

		// organiseTerritoire.interrogation1();
		// organiseTerritoire.interrogation2();
		// System.out.println(organiseTerritoire.interrogation3());
		System.out.println(organiseTerritoire.carteFinal(67456));
		// System.out.println(organiseTerritoire);
	}
}