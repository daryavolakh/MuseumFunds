package model;

public class Movement {
	public Exhibit exhibit;
	public String dateOfTransfer;
	public String dateOfReturn;
	public String organization;
	
	public Exhibit getExhibit() {
		return exhibit;
	}
	
	public void setExhibit(Exhibit newExhibit) {
		exhibit = newExhibit;
	}
	
	public String getDateOfTransfer()
	{
		return dateOfTransfer;
	}

	public void setDateOfTransfer(String dateOfTransfer) {
		this.dateOfTransfer = dateOfTransfer;
	}
	
	public String getDateOfReturn()
	{
		return dateOfReturn;
	}

	public void setDateOfReturn(String dateOfReturn) {
		this.dateOfReturn = dateOfReturn;
	}
	
	public String getOrganization()
	{
		return organization;
	}
	
	public void setOrganization(String organization)
	{
		this.organization = organization;
	}
//	
//	public String getOrganizationName()
//	{
//		return organization.getName();
//	}
//	
//	public void setOrganizationName(String name)
//	{
//		organization.setName(name);
//	}
}
