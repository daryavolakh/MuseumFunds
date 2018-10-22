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
	
	public List<Exhibit> getExhibits()
	{
		return dataBase.getTableExhibits();
	}
	
	public void addExhibit(Exhibit exhibit)
	{
		dataBase.addExhibit(exhibit);
	}
	
	public Exhibit getExhibit(int index)
	{
		return dataBase.getTableExhibits().get(index);
	}
	
	public List<Movement> getMovements(){
		return dataBase.getMovements();
	}
}
