package risk;

import java.io.File;
import java.util.Scanner;

public class InitTerritoireDB {
	private DB db;

	public InitTerritoireDB() {
		db = new DB();

		lireFichier();
	}

	private void lireFichier() {
		String nomFichier = System.getProperty("user.dir");

		nomFichier = nomFichier + "/donnees/traceEntreeTerritoire.txt";

		Scanner fichier = null;

		try {
			fichier = new Scanner(new File(nomFichier));

			while (fichier.hasNext()) {
				traiteLigne(fichier.next());
			}

			fichier.close();
		} catch (Exception exc) {
			System.out.println("Erreur fichier" + exc);
		}
	}

	private void traiteLigne(String ligne) {
		String[] tabChamp = ligne.split(",");

		Territoire j = new Territoire(tabChamp[0], tabChamp[1],
				Integer.parseInt(tabChamp[2]), Integer.parseInt(tabChamp[3]),
				Integer.parseInt(tabChamp[4]));

		// db.insert(j);
	}

	public static void main(String[] args) {
		new InitTerritoireDB();
	}
}