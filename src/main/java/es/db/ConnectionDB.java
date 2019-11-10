package es.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	
	private static final String DBurl="jdbc:mysql://localhost:3306/esdaofx1";
	
	public static Connection getConnectionDB() {
		
		Connection conn;
		try {
			
			conn=DriverManager.getConnection(DBurl,"root","");
			
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return conn;
		
	}

}
