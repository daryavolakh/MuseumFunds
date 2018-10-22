package model;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.util.List;

public class MuseumsDB {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "summernothot";
	private static final String URL = "jdbc:mysql://localhost:3306/MYSQL?useSSL=false";
	private List<Exhibit> exhibits;
	private PreparedStatement preparedStatement;
	private Connection connection;
	private Driver driver;

	private static final String INSERT_EXHIBIT = "INSERT INTO exhibits VALUES(?,?,?,?);";
	private static final String INSERT_MOVEMENT = "INSERT INTO organizations VALUES(?,?,?);";
	private static final String DELETE_EXHIBIT = "DELETE FROM exhibits WHERE "
			+ "invNumber=? AND name=? AND dateOfCreation=? AND author=? ;";
	private static final String DELETE_MOVEMENT = "DELETE FROM exhibits WHERE "
			+ "dateOfTransfer=? AND dateOfReturn=? AND organization=? ;";

	// private static final String UPDATE_EXHIBIT = "UPDATE exhibits SET " +
	// "surname=?,name=?,phone=?,city=?,street=?,house=?,reg_date=?" +
	// "WHERE surname=? AND name=? AND phone=? AND city=? AND street=? AND house=?
	// AND reg_date=?;"; //???????
	//
	public MuseumsDB() { // throws SQLException
		try {
			driver = new FabricMySQLDriver();
		} catch (SQLException ex) {
			System.out.println("Creating driver error!");
			return;
		}

		try {
			DriverManager.registerDriver(driver);
		} catch (SQLException ex) {
			System.out.println("Can't register driver!");
			return;
		}

		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Get connection!");
		} catch (SQLException ex) {
			System.out.println("Can't create connection!");
			return;
		}

		// finally {
		// if(connection!=null) {
		// connection.close();
		// }
		// }
	}

	public List<Exhibit> getExhibits() {
		return exhibits;
	}

	public void addExhibit(Exhibit exhibit) {
		try {
			preparedStatement = connection.prepareStatement(INSERT_EXHIBIT);

			preparedStatement.setInt(1, exhibit.getInvNumber());
			preparedStatement.setString(2, exhibit.getName());
			preparedStatement.setString(3, exhibit.getDateOfCreation());
			preparedStatement.setString(4, exhibit.getAuthor());

			preparedStatement.execute();

			exhibits.add(exhibit);
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	public void deleteExhibit(Exhibit exhibit){
        try{
            preparedStatement=connection.prepareStatement(DELETE_EXHIBIT);

            preparedStatement.setInt(1, exhibit.getInvNumber());
			preparedStatement.setString(2, exhibit.getName());
			preparedStatement.setString(3, exhibit.getDateOfCreation());
			preparedStatement.setString(4, exhibit.getAuthor());

            preparedStatement.execute();
            
            exhibits.remove(exhibit);
        }catch(SQLException e){
            e.getMessage();
            e.printStackTrace();
        }
    }

	public void addMovement(Exhibit exhibit) {
		try {
			preparedStatement = connection.prepareStatement(INSERT_EXHIBIT);

			preparedStatement.setInt(1, exhibit.getInvNumber());
			preparedStatement.setString(2, exhibit.getName());
			preparedStatement.setString(3, exhibit.getDateOfCreation());
			preparedStatement.setString(4, exhibit.getAuthor());

			preparedStatement.execute();

			exhibits.add(exhibit);
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	public void deleteMovement(Exhibit exhibit) {
		try {
			preparedStatement = connection.prepareStatement(INSERT_EXHIBIT);

			preparedStatement.setInt(1, exhibit.getInvNumber());
			preparedStatement.setString(2, exhibit.getName());
			preparedStatement.setString(3, exhibit.getDateOfCreation());
			preparedStatement.setString(4, exhibit.getAuthor());

			preparedStatement.execute();

			exhibits.remove(exhibit);
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
}
