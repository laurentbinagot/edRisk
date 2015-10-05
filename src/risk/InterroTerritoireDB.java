package risk;

import java.util.ArrayList;

public class InterroTerritoireDB {

	private DB db;

	public InterroTerritoireDB() {
		db = new DB();

	}

	public ArrayList<Element> interrogation1() {
		return db
				.getElements("select nomjoueur, count(*) from joueur group by nomjoueur");
	}

	public ArrayList<Element> interrogation2() {
		return db
				.getElements("select nomjoueur, count(*) from joueur group by nomjoueur order by count(*)");
	}

	public static void main(String[] args) {
		InterroTerritoireDB interroTerritoireDB = new InterroTerritoireDB();

		System.out.println(interroTerritoireDB.interrogation1());
		System.out.println(interroTerritoireDB.interrogation2());

	}

}
