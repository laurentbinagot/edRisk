package risk;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class OrganiseComportement {

	private ArrayList<Comportement> alComportement;

	private HashMap<String, ArrayList<Comportement>> hashMap;

	public OrganiseComportement() {
		alComportement = new ArrayList<Comportement>();

		hashMap = new HashMap<String, ArrayList<Comportement>>();

		lireFichier();

		// construction de la HashMap a partir de l'ArrayList
		alToHm();
	}

	private void lireFichier() {
		// le repertoire de travail $HOME/workspace/edRisk
		// en remplacant $HOME par sa valeur
		String nomFichier = System.getProperty("user.dir");

		// on ajoute le chemin + le nom du fichier de traces
		nomFichier = nomFichier + "/donnees/traceComportement.txt";

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
		alComportement.add(new Comportement(Integer.parseInt(str[0]), Integer
				.parseInt(str[1]), Integer.parseInt(str[2]), str[3], Integer
				.parseInt(str[4]), Integer.parseInt(str[5]), Integer
				.parseInt(str[6]), Integer.parseInt(str[7]), Integer
				.parseInt(str[8]), Integer.parseInt(str[9]), Integer
				.parseInt(str[10])));
	}

	public void interrogation1() {
		for (Comportement c : alComportement) {
			System.out.println(c);
		}
	}

	public void interrogation2() {
		for (String nomT : hashMap.keySet()) {
			// nb elem de l'AL que l'on recup comme valeur
			int nbElem = hashMap.get(nomT).size();
			System.out.println(nomT + "," + nbElem);
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

	//Methode qui renvoit une HashMap avec un nom de territoire comme clé et une ArrayList de comportement triée
	public HashMap<String, ArrayList<Comportement>> interrogation4() {
		
		//Declaration de la HashMap
		HashMap<String, ArrayList<Comportement>> hmComportement = new HashMap<String, ArrayList<Comportement>>();

		//Parcours de l'ArrayList de comportement
		for (Comportement c : alComportement) {
			String cle = c.getNomTerritoire();
			//Si la HashMap ne contient pas encore ce nom de territoire comme clé
			if (!hmComportement.containsKey(cle))
				//On l'ajoute à la HashMap et on y associe une ArrayList de comportement
				hmComportement.put(cle, new ArrayList<Comportement>());
			ArrayList<Comportement> alC = hmComportement.get(cle);
			alC.add(c);
			//Trie de l'ArrayList
			Collections.sort(alC);
		}
		return hmComportement;
	}

	private void alToHm() {
		for (Comportement c : alComportement) {
			String cle = c.getNomTerritoire();
			if (!hashMap.containsKey(cle))
				hashMap.put(cle, new ArrayList<Comportement>());
			ArrayList<Comportement> alC = hashMap.get(cle);
			alC.add(c);
		}
	}

	public String toString() {
		return "ArrayList " + alComportement.toString() + "\nHashMap "
				+ hashMap.toString();
	}

	public static void main(String[] arg) {
		OrganiseComportement organiseComportement = new OrganiseComportement();

		// organiseComportement.interrogation1();
		// organiseComportement.interrogation2();
		// System.out.println(organiseComportement.interrogation3());
		System.out.println(organiseComportement.interrogation4());

	}
}