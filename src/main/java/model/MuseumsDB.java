package model;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class MuseumsDB {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "summernothot";
	private static final String URL = "jdbc:mysql://localhost:3306/MYSQL?useSSL=false";
	
	public MuseumsDB() { //throws SQLException
		Connection connection;
		Driver driver;
		
		try {
			driver = new FabricMySQLDriver();
		}
		catch(SQLException ex) {
			System.out.println("Creating driver error!");
			return;
		}
		
		try {
			DriverManager.registerDriver(driver);
		}
		catch (SQLException ex) {
			System.out.println("Can't register driver!");
			return;
		}
		
		try {
			connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);			
			System.out.println("Get connection!");
		}
		catch (SQLException ex) {
			System.out.println("Can't create connection!");
			return;
		}
		
//		finally {
//			if(connection!=null) {
//				connection.close();
//			}
//		}
	}
}
