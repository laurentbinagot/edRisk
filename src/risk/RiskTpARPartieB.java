package risk;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import riskAfficheCarte.CarteRisk;

public class RiskTpARPartieB {
	static CarteRisk cr = new CarteRisk();
	static DB db = new DB();

	public static void question1() {
		// On done un nom à la fenetre
		cr.setTitre("Partie B - Question 1");

		// On passe une requete à une fonction de db afin de recuperer le temps
		// max auquel le joueur black à son max de territoire
		int tpsMaxT = db
				.getTpsMaxT("select heurearrivee from joueur where nomjoueur='black' and nbterritoire=(select max(nbterritoire) from joueur where nomjoueur='black') ");

		// On passe une requete à une fonction de db pour recuperer une
		// ArrayList de String contenant les noms des joueurs jusqu'au tpsMaxT
		// triée par heurearrivee
		ArrayList<String> nomJoueur = db
				.getAL("select nomjoueur from territoire where heurearrivee< "
						+ tpsMaxT + " order by heurearrivee");

		// On passe une requete à une fonction de db pour recuperer une
		// ArrayList de String contenant les nomd des territoires jusqu'au
		// tpsMaxT triée par heurearrivee
		ArrayList<String> nomTerritoire = db
				.getAL("select nomterritoire from territoire where heurearrivee< "
						+ tpsMaxT + " order by heurearrivee");

		// On passe une requete à une fonction de db pour recuperer une
		// ArrayList de String contenant le nombre d'armee jusqu'au tpsMaxT
		// triée par heurearrivee
		ArrayList<String> nbArmee = db
				.getAL("select nbarmee from territoire where heurearrivee<"
						+ tpsMaxT + "order by heurearrivee");

		// Les 3 ArrayList font la même taille
		// Pour tous les territoires qu'on a recupéré(plus que 42 car
		// apparaissent plusieurs fois)
		// On teste si le joueur qui possede le territoire est(black,blue,etc)
		// Ensuite on attribue la bonne couleur et le bon nombre d'armée à
		// chaque territoire
		// !!!Dans cet exemple les ArrayList ont une taille de 506 cependant
		// elles sont triées donc les 42 dernieres modifications seront les
		// bonnes
		for (int i = 0; i < nomTerritoire.size(); i++) {
			if (nomJoueur.get(i).equals("black"))
				cr.majCouleur(nomTerritoire.get(i), Color.BLACK);
			if (nomJoueur.get(i).equals("red"))
				cr.majCouleur(nomTerritoire.get(i), Color.RED);
			if (nomJoueur.get(i).equals("purple"))
				cr.majCouleur(nomTerritoire.get(i), Color.MAGENTA);
			if (nomJoueur.get(i).equals("green"))
				cr.majCouleur(nomTerritoire.get(i), Color.GREEN);
			if (nomJoueur.get(i).equals("blue"))
				cr.majCouleur(nomTerritoire.get(i), Color.BLUE);
			if (nomJoueur.get(i).equals("yellow"))
				cr.majCouleur(nomTerritoire.get(i), Color.YELLOW);
			cr.majValeur(nomTerritoire.get(i), nbArmee.get(i));
		}

		cr.affiche();
	}

	public static void question2() {
		cr.setTitre("Partie B - Question 2");

		// On passe une requete à une fonction de db afin de recuperer le temps
		// max auquel le joueur blue a 14 territoires
		int tpsMaxT = db
				.getTpsMaxT("select heurearrivee from joueur where nomjoueur='blue' and nbterritoire=14");

		ArrayList<String> nomJoueur = db
				.getAL("select nomjoueur from territoire where heurearrivee< "
						+ tpsMaxT + " order by heurearrivee");

		ArrayList<String> nomTerritoire = db
				.getAL("select nomterritoire from territoire where heurearrivee< "
						+ tpsMaxT + " order by heurearrivee");

		ArrayList<String> nbArmee = db
				.getAL("select nbarmee from territoire where heurearrivee<"
						+ tpsMaxT + "order by heurearrivee");

		for (int i = 0; i < nomTerritoire.size(); i++) {
			if (nomJoueur.get(i).equals("black"))
				cr.majCouleur(nomTerritoire.get(i), Color.BLACK);
			if (nomJoueur.get(i).equals("red"))
				cr.majCouleur(nomTerritoire.get(i), Color.RED);
			if (nomJoueur.get(i).equals("purple"))
				cr.majCouleur(nomTerritoire.get(i), Color.MAGENTA);
			if (nomJoueur.get(i).equals("green"))
				cr.majCouleur(nomTerritoire.get(i), Color.GREEN);
			if (nomJoueur.get(i).equals("blue"))
				cr.majCouleur(nomTerritoire.get(i), Color.BLUE);
			if (nomJoueur.get(i).equals("yellow"))
				cr.majCouleur(nomTerritoire.get(i), Color.YELLOW);
			cr.majValeur(nomTerritoire.get(i), nbArmee.get(i));
		}

		cr.affiche();
	}

	public static void question3() {
		cr.setTitre("Partie B - Question 3");

		// On passe une requete à une fonction de db afin de recuperer le temps
		// max auquel le joueur red est mort soit 0 territoire
		int tpsMaxT = db
				.getTpsMaxT("select heurearrivee from joueur where nomjoueur='red' and nbterritoire=0");

		ArrayList<String> nomJoueur = db
				.getAL("select nomjoueur from territoire where heurearrivee< "
						+ tpsMaxT + " order by heurearrivee");

		ArrayList<String> nomTerritoire = db
				.getAL("select nomterritoire from territoire where heurearrivee< "
						+ tpsMaxT + " order by heurearrivee");

		ArrayList<String> nbArmee = db
				.getAL("select nbarmee from territoire where heurearrivee<"
						+ tpsMaxT + "order by heurearrivee");

		for (int i = 0; i < nomTerritoire.size(); i++) {
			if (nomJoueur.get(i).equals("black"))
				cr.majCouleur(nomTerritoire.get(i), Color.BLACK);
			if (nomJoueur.get(i).equals("red"))
				cr.majCouleur(nomTerritoire.get(i), Color.RED);
			if (nomJoueur.get(i).equals("purple"))
				cr.majCouleur(nomTerritoire.get(i), Color.MAGENTA);
			if (nomJoueur.get(i).equals("green"))
				cr.majCouleur(nomTerritoire.get(i), Color.GREEN);
			if (nomJoueur.get(i).equals("blue"))
				cr.majCouleur(nomTerritoire.get(i), Color.BLUE);
			if (nomJoueur.get(i).equals("yellow"))
				cr.majCouleur(nomTerritoire.get(i), Color.YELLOW);
			cr.majValeur(nomTerritoire.get(i), nbArmee.get(i));
		}

		cr.affiche();
	}

	public static void question4() {
		cr.setTitre("Partie B - Question 4");

		// Envoie d'une requete par une methode de db
		// qui sert à construction une HashMap avec 42 clés distinctes
		// correspondant aux 42 territoires
		// et un entier correspondant au nombre max de pp pour chaque territoire
		HashMap<String, Integer> maxPp = db
				.getPp("select distinct nomterritoire, max(pp) from comportement group by nomterritoire");

		// Boucle sur les 42 territoires
		// Attribution des valeurs des pp
		// Attribution des couleurs selon le nombre de pp
		for (String cle : maxPp.keySet()) {
			cr.majValeur(cle, "" + maxPp.get(cle));
			if (maxPp.get(cle) <= 200)
				cr.majCouleur(cle, Color.GREEN);
			else if (maxPp.get(cle) >= 201 && maxPp.get(cle) <= 600)
				cr.majCouleur(cle, Color.RED);
			else
				cr.majCouleur(cle, Color.WHITE);
		}
		cr.affiche();
	}

	public static void main(String[] args) {

		question1();
		question2();
		question3();
		question4();

	}
}