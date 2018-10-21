package model;

public class Organization {
	private String name;

	private class Address {
		public String town;
		private String street;
		private String house;
	}

	private Address address;
	private String phoneNumber;

	private class RespPersone {
		private String name;
		private String surname;
	}
	
	private RespPersone respPerson;
	private Exhibition exhibition;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTown() {
		return address.town;
	}
	
	public void setTown(String town) {
		this.address.town = town;
	}
	
	public void setAddress(String town, String street, String house)
	{
		this.address.town = town;
		this.address.street = street;
		this.address.house = house;
	}
	
	public String getStreet() {
		return address.street;
	}
//	
//	public void setStreet(String street) {
//		this.address.street = street;
//	}
	
	public String getHouse() {
		return address.house;
	}
//	
//	public void setHouse(String house) {
//		this.address.house = house;
//	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	public String getRespPersonName() {
		return respPerson.name;
	}
	
	public String getRespPersonSurname() {
		return respPerson.surname;
	}

	public void setRespPerson(String name, String surname) {
		this.respPerson.name = name;
		this.respPerson.surname = surname;
	}
	
	public String getExhibitionName() {
		return exhibition.getName();
	}

	public void setExhibitionName(String name) {
		exhibition.setName(name);
	}
}
