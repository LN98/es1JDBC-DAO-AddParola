package es.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ParoleDAO {
	
	public static int n=0;
	
	public static int add(String p) {
		boolean b=true;
		int c=1;
		
		try {
			Connection co = ConnectionDB.getConnectionDB();

			Statement s = co.createStatement();
			ResultSet r = s.executeQuery("SELECT parola FROM parole");
			if (r.next()) {
				do{
					if (r.getString("parola").equalsIgnoreCase(p)) {
						b=false;
						c=0;
						break;
					}
				}while (r.next()); 

				//
				if (c != 0) {
					r = s.executeQuery("SELECT MAX(id),parola FROM parole");
					r.next();
					String r1 = r.getString("parola");
					if (!r1.substring(r1.length() - 2, r1.length()).equalsIgnoreCase(p.substring(0, 2))) {
						b = false;
						c = -1;
					}
				}
			}
			
			if(b) {
				s.execute("INSERT INTO parole (parola) VALUES ('" +p+"')");
				n++;
			}
			
			
			s.close();
			r.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return c;
	}

}
