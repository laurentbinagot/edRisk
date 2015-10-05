package risk;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import riskAfficheCarte.CarteRisk;

public class RiskTpARPartieA {
	static CarteRisk cr = new CarteRisk();
	static OrganiseJoueur oJ = new OrganiseJoueur();
	static OrganiseTerritoire oT = new OrganiseTerritoire();
	static OrganiseComportement oC = new OrganiseComportement();

	public static void question1() {
		// Pour ajouter un titre à la fenetre de l'IHM
		cr.setTitre("Partie A - Question 1");

		// On recupere le temps max auquel le joueur black possede son maximum
		// de territoire
		int tpsMaxT = (oJ.interrogation4().get("black").get(oJ.interrogation4()
				.get("black").size() - 1)).getHeureArrivee();

		// On met à jour la couleur pour chaque territoire
		// Pour faire ça on teste savoir si le joueur qui possede le territoire
		// à cet instant est le meme que celui qu'on teste dans le equals()
		// Si le deux sont identiques, on sait qu'on a la bonne couleur pour le
		// bon territoire
		// On fait ce test 6 fois (1 pour chaque joueur)
		for (int i = 0; i < oT.carteFinal(tpsMaxT).size(); i++) {
			if (oT.carteFinal(tpsMaxT).get(i).getNomJoueur().equals("black"))
				cr.majCouleur(oT.carteFinal(tpsMaxT).get(i).getNomTerritoire(),
						Color.BLACK);
		}
		for (int i = 0; i < oT.carteFinal(tpsMaxT).size(); i++) {
			if (oT.carteFinal(tpsMaxT).get(i).getNomJoueur().equals("blue"))
				cr.majCouleur(oT.carteFinal(tpsMaxT).get(i).getNomTerritoire(),
						Color.BLUE);
		}
		for (int i = 0; i < oT.carteFinal(tpsMaxT).size(); i++) {
			if (oT.carteFinal(tpsMaxT).get(i).getNomJoueur().equals("green"))
				cr.majCouleur(oT.carteFinal(tpsMaxT).get(i).getNomTerritoire(),
						Color.GREEN);
		}
		for (int i = 0; i < oT.carteFinal(tpsMaxT).size(); i++) {
			if (oT.carteFinal(tpsMaxT).get(i).getNomJoueur().equals("yellow"))
				cr.majCouleur(oT.carteFinal(tpsMaxT).get(i).getNomTerritoire(),
						Color.YELLOW);
		}
		for (int i = 0; i < oT.carteFinal(tpsMaxT).size(); i++) {
			if (oT.carteFinal(tpsMaxT).get(i).getNomJoueur().equals("purple"))
				cr.majCouleur(oT.carteFinal(tpsMaxT).get(i).getNomTerritoire(),
						Color.MAGENTA);
		}
		for (int i = 0; i < oT.carteFinal(tpsMaxT).size(); i++) {
			if (oT.carteFinal(tpsMaxT).get(i).getNomJoueur().equals("red"))
				cr.majCouleur(oT.carteFinal(tpsMaxT).get(i).getNomTerritoire(),
						Color.RED);
		}
		// Une fois les couleurs des territoires misent, il reste la valeur à
		// mettre
		// Cette valeur est égale au nombre d'armée présente sur le territoire
		// Nous regardons donc à l'instant "tpsMaxT" combien d'armée il y a sur
		// chaque territoire et on mets ce nombre
		for (int i = 0; i < oT.carteFinal(tpsMaxT).size(); i++) {
			cr.majValeur(oT.carteFinal(tpsMaxT).get(i).getNomTerritoire(), ""
					+ oT.carteFinal(tpsMaxT).get(i).getNbArmee());
		}

		// Cette méthode sert à afficher l'IHM
		cr.affiche();
	}

	public static void question2() {
		cr.setTitre("Partie A - Question 2");

		int tpsMaxT = 0;

		// On fait une boucle sur l'ArrayList du joueur bleu
		for (int j = 0; j < oJ.interrogation4().get("blue").size() - 1; j++) {
			// On test pour savoir à quelle instant le joueur bleu possede 14
			// territoires
			if (oJ.interrogation4().get("blue").get(j).getNbTerritoire() == 14)
				tpsMaxT = oJ.interrogation4().get("blue").get(j)
						.getHeureArrivee();
		}

		for (int i = 0; i < oT.carteFinal(tpsMaxT).size(); i++) {
			if (oT.carteFinal(tpsMaxT).get(i).getNomJoueur().equals("blue"))
				cr.majCouleur(oT.carteFinal(tpsMaxT).get(i).getNomTerritoire(),
						Color.BLUE);
		}
		for (int i = 0; i < oT.carteFinal(tpsMaxT).size(); i++) {
			if (oT.carteFinal(tpsMaxT).get(i).getNomJoueur().equals("green"))
				cr.majCouleur(oT.carteFinal(tpsMaxT).get(i).getNomTerritoire(),
						Color.GREEN);
		}
		for (int i = 0; i < oT.carteFinal(tpsMaxT).size(); i++) {
			if (oT.carteFinal(tpsMaxT).get(i).getNomJoueur().equals("yellow"))
				cr.majCouleur(oT.carteFinal(tpsMaxT).get(i).getNomTerritoire(),
						Color.YELLOW);
		}
		for (int i = 0; i < oT.carteFinal(tpsMaxT).size(); i++) {
			if (oT.carteFinal(tpsMaxT).get(i).getNomJoueur().equals("purple"))
				cr.majCouleur(oT.carteFinal(tpsMaxT).get(i).getNomTerritoire(),
						Color.MAGENTA);
		}
		for (int i = 0; i < oT.carteFinal(tpsMaxT).size(); i++) {
			if (oT.carteFinal(tpsMaxT).get(i).getNomJoueur().equals("black"))
				cr.majCouleur(oT.carteFinal(tpsMaxT).get(i).getNomTerritoire(),
						Color.BLACK);
		}
		for (int i = 0; i < oT.carteFinal(tpsMaxT).size(); i++) {
			if (oT.carteFinal(tpsMaxT).get(i).getNomJoueur().equals("red"))
				cr.majCouleur(oT.carteFinal(tpsMaxT).get(i).getNomTerritoire(),
						Color.RED);
		}
		for (int i = 0; i < oT.carteFinal(tpsMaxT).size(); i++) {
			cr.majValeur(oT.carteFinal(tpsMaxT).get(i).getNomTerritoire(), ""
					+ oT.carteFinal(tpsMaxT).get(i).getNbArmee());
		}

		cr.affiche();
	}

	public static void question3() {
		cr.setTitre("Partie A - Question 3");

		int tpsMaxT = 0;

		// On fait une boucle sur l'ArrayList du joueur rouge
		for (int j = 0; j < oJ.interrogation4().get("red").size() - 1; j++) {
			// On cherche à quel instant le joueur rouge meurt (= quand le
			// joueur rouge n'a plus de territoire)
			if (oJ.interrogation4().get("red").get(j).getNbTerritoire() == 0)
				tpsMaxT = oJ.interrogation4().get("red").get(j)
						.getHeureArrivee();
		}

		for (int i = 0; i < oT.carteFinal(tpsMaxT).size(); i++) {
			if (oT.carteFinal(tpsMaxT).get(i).getNomJoueur().equals("blue"))
				cr.majCouleur(oT.carteFinal(tpsMaxT).get(i).getNomTerritoire(),
						Color.BLUE);
		}
		for (int i = 0; i < oT.carteFinal(tpsMaxT).size(); i++) {
			if (oT.carteFinal(tpsMaxT).get(i).getNomJoueur().equals("green"))
				cr.majCouleur(oT.carteFinal(tpsMaxT).get(i).getNomTerritoire(),
						Color.GREEN);
		}
		for (int i = 0; i < oT.carteFinal(tpsMaxT).size(); i++) {
			if (oT.carteFinal(tpsMaxT).get(i).getNomJoueur().equals("yellow"))
				cr.majCouleur(oT.carteFinal(tpsMaxT).get(i).getNomTerritoire(),
						Color.YELLOW);
		}
		for (int i = 0; i < oT.carteFinal(tpsMaxT).size(); i++) {
			if (oT.carteFinal(tpsMaxT).get(i).getNomJoueur().equals("purple"))
				cr.majCouleur(oT.carteFinal(tpsMaxT).get(i).getNomTerritoire(),
						Color.MAGENTA);
		}
		for (int i = 0; i < oT.carteFinal(tpsMaxT).size(); i++) {
			if (oT.carteFinal(tpsMaxT).get(i).getNomJoueur().equals("black"))
				cr.majCouleur(oT.carteFinal(tpsMaxT).get(i).getNomTerritoire(),
						Color.BLACK);
		}
		for (int i = 0; i < oT.carteFinal(tpsMaxT).size(); i++) {
			if (oT.carteFinal(tpsMaxT).get(i).getNomJoueur().equals("red"))
				cr.majCouleur(oT.carteFinal(tpsMaxT).get(i).getNomTerritoire(),
						Color.RED);
		}
		for (int i = 0; i < oT.carteFinal(tpsMaxT).size(); i++) {
			cr.majValeur(oT.carteFinal(tpsMaxT).get(i).getNomTerritoire(), ""
					+ oT.carteFinal(tpsMaxT).get(i).getNbArmee());
		}

		cr.affiche();
	}

	public static void question4() {
		cr.setTitre("Partie A - Question 4");

		// la hashmap est allouée et remplie par l'interrogation4 de
		// organiseComportement
		HashMap<String, ArrayList<Comportement>> hm = oC.interrogation4();

		for (String cle : hm.keySet()) {
			// La cle est le nom de territoire

			// L'ArrayList de comportement est trié par nombre de pp
			// On attribue le nombre de pp max à chaque territoire (=le nombre
			// de pp de la fin de l'ArrayList)
			cr.majValeur(hm.get(cle).get(hm.get(cle).size() - 1)
					.getNomTerritoire(),
					"" + hm.get(cle).get(hm.get(cle).size() - 1).getPp());
			// Attribution des couleurs aux territoires (bleu <= 200, rouge
			// entre 200 et 600 et blanc pour les autres
			if (hm.get(cle).get(hm.get(cle).size() - 1).getPp() <= 200)
				cr.majCouleur(hm.get(cle).get(hm.get(cle).size() - 1)
						.getNomTerritoire(), Color.GREEN);
			else if (hm.get(cle).get(hm.get(cle).size() - 1).getPp() >= 201
					&& hm.get(cle).get(hm.get(cle).size() - 1).getPp() <= 600)
				cr.majCouleur(hm.get(cle).get(hm.get(cle).size() - 1)
						.getNomTerritoire(), Color.RED);
			else
				cr.majCouleur(hm.get(cle).get(hm.get(cle).size() - 1)
						.getNomTerritoire(), Color.WHITE);
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