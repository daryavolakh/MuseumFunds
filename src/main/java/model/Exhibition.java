package model;

import java.util.Date;

public class Exhibition {
	private String name;
	private Date beginExhibition;
	private Date endExhibition;
	
	public String getName()
	{
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getBeginExhibition()
	{
		return beginExhibition;
	}

	public void setBeginExhibition(Date beginExhibition) {
		this.beginExhibition = beginExhibition;
	}
	
	public Date getEndExhibition()
	{
		return endExhibition;
	}

	public void setEndExhibition(Date endExhibition) {
		this.endExhibition = endExhibition;
	}
}
