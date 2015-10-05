package risk;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DB {
	Connection co;
	PreparedStatement ps;

	public DB() {
		try {
			Class.forName("org.postgresql.Driver");
			co = DriverManager.getConnection(
					"jdbc:postgresql://localhost/test", "laurentbinagot",
					"********");
			System.out.println("connexion ok");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void insert(Joueur jo) {
		String req = "INSERT INTO joueur VALUES(?,?,?,?)";
		System.out.println(req + jo);
		try {
			ps = co.prepareStatement(req);

			ps.setString(1, jo.getNomJoueur());
			ps.setInt(2, jo.getNbTerritoire());
			ps.setInt(3, jo.getMouvement());
			ps.setInt(4, jo.getHeureArrivee());

			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void insert(Territoire te) {
		String req = "INSERT INTO territoire VALUES(?,?,?,?,?)";
		System.out.println(req + te);
		try {
			ps = co.prepareStatement(req);

			ps.setString(1, te.getNomTerritoire());
			ps.setString(2, te.getNomJoueur());
			ps.setInt(3, te.getNbArmee());
			ps.setInt(4, te.getMouvement());
			ps.setInt(5, te.getHeureArrivee());

			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void insert(Comportement com) {
		String req = "INSERT INTO comportement VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		System.out.println(req + com);
		try {
			ps = co.prepareStatement(req);

			ps.setInt(1, com.getNumCode());
			ps.setInt(2, com.getMouvement());
			ps.setInt(3, com.getHeureArrivee());
			ps.setString(4, com.getNomTerritoire());
			ps.setInt(5, com.getPp());
			ps.setInt(6, com.getPv());
			ps.setInt(7, com.getPa());
			ps.setInt(8, com.getSi());
			ps.setInt(9, com.getIc());
			ps.setInt(10, com.getEa());
			ps.setInt(11, com.getHeureMessage());

			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public ArrayList<Element> getElements(String req) {
		ArrayList<Element> ale = new ArrayList<Element>();
		Element elt = null;

		try {
			Statement st = co.createStatement();

			ResultSet rs = st.executeQuery(req);

			while (rs.next()) {
				elt = new Element(rs.getString(1), rs.getInt(2));

				ale.add(elt);
			}
		} catch (SQLException e) {
			System.out.println("getElement " + e);
		}

		return ale;
	}

	// Methode qui renvoit un entier correspondant au resultat de la requete
	// passé en parametre
	public int getTpsMaxT(String req) {
		int tps = 0;
		try {
			Statement st = co.createStatement();

			ResultSet rs = st.executeQuery(req);

			while (rs.next()) {
				tps = rs.getInt(1);
			}

		} catch (SQLException e) {
			System.out.println("getElement " + e);
		}
		return tps;
	}

	// Methode qui renvoit une ArrayList correspondant au resultat de la requete
	// passé en parametre
	public ArrayList<String> getAL(String req) {
		ArrayList<String> al = new ArrayList<String>();
		try {
			Statement st = co.createStatement();

			ResultSet rs = st.executeQuery(req);

			while (rs.next()) {
				al.add(rs.getString(1));
			}

		} catch (SQLException e) {
			System.out.println("getElement " + e);
		}
		return al;
	}

	// Methode qui renvoit une HashMap avec une cle correspondant au String
	// renvoyé par la requete
	public HashMap<String, Integer> getPp(String req) {
		HashMap<String, Integer> pp = new HashMap<String, Integer>();
		try {
			Statement st = co.createStatement();

			ResultSet rs = st.executeQuery(req);

			while (rs.next()) {
				String key = rs.getString(1);
				pp.put(key, rs.getInt(2));
			}

		} catch (SQLException e) {
			System.out.println("getElement " + e);
		}
		return pp;
	}

}