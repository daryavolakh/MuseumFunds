package controller;

import model.MuseumsDB;

import java.sql.SQLException;
import java.util.List;
import model.Exhibit;
import model.Movement;

public class Controller {
	private MuseumsDB dataBase;

	public Controller(MuseumsDB dataBase) throws SQLException {
		this.dataBase = dataBase;
	}

	public List<Exhibit> getExhibits() {
		return dataBase.getTableExhibits();
	}

	public void addExhibit(Exhibit exhibit) {
		dataBase.addExhibit(exhibit);
	}

	public Exhibit getExhibit(int index) {
		return dataBase.getTableExhibits().get(index);
	}

	public Exhibit getExhibitByInvNumber(int number) {
		List<Exhibit> list = getExhibits();
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).invNumber == number)
				return list.get(index);
		}

		return null; // ???
	}

	public void editExhibit(Exhibit oldExhibit, Exhibit newExhibit) {
		dataBase.editExhibit(oldExhibit, newExhibit);
	}
	
	public void deleteExhibit(int number) {
		dataBase.deleteExhibit(getExhibitByInvNumber(number));
	}

	public List<Movement> getMovements(int invNumber) {
		return dataBase.getTableMovement(invNumber);
	}
	
	public List<Movement> getMovementsWithInvNumber(int invNumber) {
		return dataBase.getTableMovementWithInvNuber(invNumber);
	}
	
	public Movement getMovement(int index, int invNumber) {
		return getMovementsWithInvNumber(invNumber).get(index);
	}

	public void addMovement(Movement movement) {
		dataBase.addMovement(movement);
	}
	
	public void editMovement(Movement oldMovement, Movement newMovement) {
		dataBase.editMovement(oldMovement,newMovement);
	}
	
	public void deleteMovement(Movement movement) {
		dataBase.deleteMovement(movement);
	}
	
	public List<Exhibit> getExhibitsFromOneKit(String name){
		return dataBase.getExhibitsFromOneKit(name);
	}
}
