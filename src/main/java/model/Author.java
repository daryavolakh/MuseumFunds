package model;

import java.util.Date;

public class Author {
	private String name;
	private String surname;
	private Date dateOfBirth;
	private String country;

	public String getName() {
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}

	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country)
	{
		this.country = country;
	}
}