package model;

import java.util.Date;

public class Movement {
	private Date dateOfTransfer;
	private Date dateOfReturn;
	private Organization organization;
	
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
	
	public String getOrganizationName()
	{
		return organization.getName();
	}
	
	public void setOrganizationName(String name)
	{
		organization.setName(name);
	}
}
