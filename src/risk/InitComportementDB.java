package risk;

import java.io.File;
import java.util.Scanner;

public class InitComportementDB {
	private DB db;

	public InitComportementDB() {
		db = new DB();

		lireFichier();
	}

	private void lireFichier() {
		String nomFichier = System.getProperty("user.dir");

		nomFichier = nomFichier + "/donnees/traceComportement.txt";

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

		Comportement c = new Comportement(Integer.parseInt(tabChamp[0]),
				Integer.parseInt(tabChamp[1]), Integer.parseInt(tabChamp[2]),
				tabChamp[3], Integer.parseInt(tabChamp[4]),
				Integer.parseInt(tabChamp[5]), Integer.parseInt(tabChamp[6]),
				Integer.parseInt(tabChamp[7]), Integer.parseInt(tabChamp[8]),
				Integer.parseInt(tabChamp[9]), Integer.parseInt(tabChamp[10]));

		// db.insert(c);
	}

	public static void main(String[] args) {
		new InitComportementDB();
	}
}