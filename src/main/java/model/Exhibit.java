package model;

import java.util.Date;
import java.util.List;

public class Exhibit {
	private int invNumber;
	private String name;
	private Date dateOfCreation;
	private Author author;
	private List<Exhibition> exhibitions;  //подумать!
	private Movement movement;  //подумать!
	
	public int getInvNumber() {
		return invNumber;
	}
	
	public void setInvNumber(int invNumber) {
		this.invNumber = invNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDateOfCreation() {
		return dateOfCreation;
	}
	
	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	
	public String getAuthorName() {
		return author.getName();
	}
	
	public void setAuthorName(String name) {
		author.setName(name);
	}
	public String getAuthorSurname() {
		return author.getSurname();
	}
	
	public void setAuthorSurname(String surname) {
		author.setName(surname);
	}

	public Movement getMovement() {
		return movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}

	public List<Exhibition> getExhibitions() {
		return exhibitions;
	}

	public void addExhibition(Exhibition exhibition) {
		exhibitions.add(exhibition);
	}
	
}
