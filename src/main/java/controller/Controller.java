package controller;

import model.MuseumsDB;
import java.util.List;
import model.Exhibit;

public class Controller {
	private MuseumsDB dataBase;
	
	public Controller(MuseumsDB dataBase) {
		this.dataBase = new MuseumsDB();
	}
	
	public List<Exhibit> getExhibits()
	{
		return dataBase.getExhibits();
	}
	
	public void addExhibit(Exhibit exhibit)
	{
		dataBase.getExhibits().add(exhibit);
	}
	
	public Exhibit getExhibit(int index)
	{
		return dataBase.getExhibits().get(index);
	}
}
