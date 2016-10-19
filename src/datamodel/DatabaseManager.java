package datamodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager {
	private Connection connection = null;
	
	public Connection getConnection() {
		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/SDA", "postgres",
					"admin");

		} catch (SQLException e) {
			System.out.println("Error connecting to database!");
			e.printStackTrace();
		}
		return connection;
	}
	public void closeDBConnection() {
        if (connection != null) {
        	System.out.println("Closing database connection");
            try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }

	}
	
	public void registerNewUser(String firstName, String lastName, UserSex sex) {
        PreparedStatement pst = null;

		String stm = "INSERT INTO filmy.uzytkownik(imie,nazwisko,plec) VALUES(?, ?, ?)";
        try {
			pst = connection.prepareStatement(stm);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        
        try {
			pst.setString(1, firstName);
	        pst.setString(2, lastName);
	        pst.setString(3, sex.toString());
	        pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}                    
        try {
            if (pst != null) {
                pst.close();
            }
        } catch (SQLException e) {
            System.out.println("Blad zamykania polaczenia");
			e.printStackTrace();
			return;
        }

	}
//	publi

}
