package risk;

import java.util.ArrayList;

public class InterroJoueurDB {

	private DB db;
	
	public InterroJoueurDB() {
		db = new DB();
		
	}
	
	public ArrayList<Element> interrogation1(){
		return db.getElements("select nomterritoire, count(*) from territoire group by nomterritoire");		
	}
	
	public ArrayList<Element> interrogation2(){
		return db.getElements("select nomterritoire, count(*) from territoire group by nomterritoire order by count(*)");		
	} 
	
	public static void main(String[] args) {
		InterroJoueurDB interroJoueurDB = new InterroJoueurDB();

		System.out.println(interroJoueurDB.interrogation1());
		System.out.println(interroJoueurDB.interrogation2());

	}

}
