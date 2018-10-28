package model;

public class Exhibit {
	public int invNumber;
	public String name;
	public String dateOfCreation;
	public String author;
	public Movement movement; 
	public String kit;
	public String responsible;
	
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
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getKit() {
		return kit;
	}
	
	public void setKit(String kit) {
		this.kit = kit;
	}
	
	public String getResponsible() {
		return responsible;
	}
	
	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

	public Movement getMovement() {
		return movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}
	
}
