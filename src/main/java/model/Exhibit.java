package model;

import java.util.Date;
import java.util.List;

public class Exhibit {
	public int invNumber;
	public String name;
	public String dateOfCreation;
	public Author author;
	public Movement movement;  //подумать!
	
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
	
	public String getDateOfCreation() {
		return dateOfCreation;
	}
	
	public void setDateOfCreation(String dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	
	public String getAuthor() {
		String authorNS = author.getSurname() + " " + author.getName();
		return authorNS;
	}
//	
//	public String getAuthorName() {
//		return author.getName();
//	}
	
	public void setAuthorName(String name) {
		author.setName(name);
	}
	
//	public String getAuthorSurname() {
//		return author.getSurname();
//	}
	
	public void setAuthorSurname(String surname) {
		author.setName(surname);
	}

	public Movement getMovement() {
		return movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}
	
}
