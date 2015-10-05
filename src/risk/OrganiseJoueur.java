package risk;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class OrganiseJoueur {

	private ArrayList<Joueur> alHisto;

	private HashMap<String, ArrayList<Joueur>> hashMap;

	public OrganiseJoueur() {
		alHisto = new ArrayList<Joueur>();

		hashMap = new HashMap<String, ArrayList<Joueur>>();

		lireFichier();

		// construction de la HashMap a partir de l'ArrayList
		alToHm();
	}

	private void lireFichier() {
		// le repertoire de travail $HOME/workspace/edRisk
		// en remplacant $HOME par sa valeur
		String nomFichier = System.getProperty("user.dir");

		// on ajoute le chemin + le nom du fichier de traces
		nomFichier = nomFichier + "/donnees/traceEntreeJoueur.txt";

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
		alHisto.add(new Joueur(str[0], Integer.parseInt(str[1]), Integer
				.parseInt(str[2]), Integer.parseInt(str[3])));
	}

	public void interrogation1() {
		for (Joueur j : alHisto) {
			System.out.println(j);
		}
	}

	public void interrogation2() {
		for (String nomJ : hashMap.keySet()) {
			// nb elem de l'AL que l'on recup comme valeur
			int nbElem = hashMap.get(nomJ).size();
			System.out.println(nomJ + "," + nbElem);
		}
	}

	public ArrayList<Element> interrogation3() {
		ArrayList<Element> alE = new ArrayList<Element>();
		Set<String> set = this.hashMap.keySet();
		for (String prov : set)
			alE.add(new Element(prov, this.hashMap.get(prov).size()));
		Collections.sort(alE);
		return alE;
	}

	public HashMap<String, ArrayList<Joueur>> interrogation4() {
		HashMap<String, ArrayList<Joueur>> hmJoueur = new HashMap<String, ArrayList<Joueur>>();

		for (Joueur j : alHisto) {
			String cle = j.getNomJoueur();
			if (!hmJoueur.containsKey(cle))
				hmJoueur.put(cle, new ArrayList<Joueur>());
			ArrayList<Joueur> alJ = hmJoueur.get(cle);
			alJ.add(j);
			Collections.sort(alJ);
		}
		return hmJoueur;
	}

	private void alToHm() {
		for (Joueur j : alHisto) {
			String cle = j.getNomJoueur();
			if (!hashMap.containsKey(cle))
				hashMap.put(cle, new ArrayList<Joueur>());
			ArrayList<Joueur> alJ = hashMap.get(cle);
			alJ.add(j);
		}
	}

	public String toString() {
		return "ArrayList " + alHisto.toString() + "\nHashMap "
				+ hashMap.toString();
	}

	public static void main(String[] arg) {
		OrganiseJoueur organiseJoueur = new OrganiseJoueur();

		// organiseJoueur.interrogation1();
		// organiseJoueur.interrogation2();
		System.out.println(organiseJoueur.interrogation4());

		// System.out.println(organiseJoueur);
	}
}