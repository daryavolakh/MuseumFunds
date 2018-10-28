package model;

public class Movement {
	//public Exhibit exhibit;
	public int invNumber;
	public String dateOfTransfer;
	public String dateOfReturn;
	public String organization;
	
	public int getInvNumber() {
		return invNumber;
	}
	
	public void setInvNumber(int invNumber) {
		this.invNumber = invNumber;
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
}
