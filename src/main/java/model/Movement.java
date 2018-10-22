package model;

import java.util.Date;

public class Movement {
	public Exhibit exhibit;
	public Date dateOfTransfer;
	public Date dateOfReturn;
	public String organization;
	//public Organization organization;
	
	public Date getDateOfTransfer()
	{
		return dateOfTransfer;
	}

	public void setDateOfTransfer(Date dateOfTransfer) {
		this.dateOfTransfer = dateOfTransfer;
	}
	
	public Date getDateOfReturn()
	{
		return dateOfReturn;
	}

	public void setDateOfReturn(Date dateOfReturn) {
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
