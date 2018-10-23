package model;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MuseumsDB {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "summernothot";
	private static final String URL = "jdbc:mysql://localhost:3306/lab2?useSSL=false";
	private static final String GET_EXHIBITS = "SELECT name FROM exhibits;";
	private List<Exhibit> exhibits;
	private PreparedStatement statement;
	private Connection connection;
	private Driver driver;

	private static final String SELECT_EXHIBITS = "SELECT * FROM exhibits;";
	private static final String INSERT_EXHIBIT = "INSERT INTO exhibits VALUES(?,?,?,?);";
	private static final String INSERT_MOVEMENT = "INSERT INTO movements VALUES(?,?,?,?);";
	private static final String DELETE_EXHIBIT = "DELETE FROM exhibits WHERE invNumber=?;";
	private static final String DELETE_MOVEMENT = "DELETE FROM movements WHERE "
			+ "invNumber=? AND dateOfTransfer=? AND dateOfReturn=?;";
	private static final String EDIT_EXHIBIT = "UPDATE exhibits SET invNumber=? name=? dateOfCreation=? author=?;";

	// private static final String UPDATE_EXHIBIT = "UPDATE exhibits SET " +
	// "surname=?,name=?,phone=?,city=?,street=?,house=?,reg_date=?" +
	// "WHERE surname=? AND name=? AND phone=? AND city=? AND street=? AND house=?
	// AND reg_date=?;"; //???????
	//
	public MuseumsDB() throws SQLException { // throws SQLException
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
		// if (connection != null) {
		// connection.close();
		// }
		// }
	}
	
	public List<Exhibit> getTableExhibits(){
        List<Exhibit> list = new ArrayList<Exhibit>();
        try {
            Statement statement=connection.createStatement();

            ResultSet resultSet=statement.executeQuery(SELECT_EXHIBITS);
            while(resultSet.next()){
            	Exhibit exhibit = new Exhibit();

            	exhibit.setInvNumber(resultSet.getInt(1));            	
            	exhibit.setName(resultSet.getString(2));
                exhibit.setDateOfCreation(resultSet.getString(3));
                exhibit.setAuthor(resultSet.getString(4));

                list.add(exhibit);
            }
            
        }catch(SQLException e){
            e.getMessage();
            e.printStackTrace();
        }
        return list;
    }

	public List<Exhibit> getExhibits() {
		List<Exhibit> exhibits = new ArrayList<Exhibit>();
		try {
			statement = connection.prepareStatement(GET_EXHIBITS);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Exhibit exhibit = new Exhibit();
				exhibit.setName(resultSet.getString(1));
				exhibits.add(exhibit);
			}
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		return exhibits;
	}

	public void deleteExhibit(Exhibit exhibit) {
		try {
			statement = connection.prepareStatement(DELETE_EXHIBIT);

			statement.setInt(1, exhibit.getInvNumber());
//			statement.setString(2, exhibit.getName());
//			statement.setString(3, exhibit.getDateOfCreation());
//			statement.setString(4, exhibit.getAuthor());

			statement.execute();
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	public void addExhibit(Exhibit exhibit) {
		try {
			statement = connection.prepareStatement(INSERT_EXHIBIT);

			statement.setInt(1, exhibit.getInvNumber());
			statement.setString(2, exhibit.getName());
			statement.setString(3, exhibit.getDateOfCreation());
			statement.setString(4, exhibit.getAuthor());
			
			statement.execute();
			
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	public void editExhibit(Exhibit oldExhibit, Exhibit newExhibit ) {
		try {
			statement = connection.prepareStatement(EDIT_EXHIBIT);

			statement.setInt(1, newExhibit.getInvNumber());
			statement.setString(2, newExhibit.getName());
			statement.setString(3, newExhibit.getDateOfCreation());
			statement.setString(4, newExhibit.getAuthor());
			statement.setInt(7, oldExhibit.getInvNumber());
			statement.setString(8, oldExhibit.getName());
			statement.setString(9, oldExhibit.getDateOfCreation());
			statement.setString(10, oldExhibit.getAuthor());
			
			statement.execute();
			
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	public void addMovement(Movement movement) {
		try {
			statement = connection.prepareStatement(INSERT_MOVEMENT);

			statement.setInt(1, movement.getExhibit().getInvNumber());
			statement.setString(2, movement.getDateOfTransfer());
			statement.setString(3, movement.getDateOfReturn());
			statement.setString(4, movement.getOrganization());

			statement.execute();

		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	public void deleteMovement(Movement movement) {
		try {
			statement = connection.prepareStatement(DELETE_MOVEMENT);

			statement.setInt(1, movement.getExhibit().getInvNumber());
			statement.setString(2, movement.getDateOfTransfer());
			statement.setString(3, movement.getDateOfReturn());
			//statement.setString(4, movement.getOrganization());

			statement.execute();

		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	public List<Movement> getTableMovement(int invNumber){
        List<Movement> list = new ArrayList<Movement>();
        try {
            Statement statement=connection.createStatement();

            ResultSet resultSet=statement.executeQuery("SELECT dateOfTransfer, dateOfReturn, organization FROM movements WHERE invNumber="+ invNumber +";");
            while(resultSet.next()){
            	Movement movement = new Movement();

            	movement.setDateOfTransfer(resultSet.getString(1));            	
            	movement.setDateOfReturn(resultSet.getString(2));
            	movement.setOrganization(resultSet.getString(3));
                
                list.add(movement);
            }
            
        }catch(SQLException e){
            e.getMessage();
            e.printStackTrace();
        }
        return list;
    }
}
