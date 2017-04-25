package com.ibm.migr.inventory;

public class CalculationResult {
	private int simpleWars = 0;
	private int appClients  = 0;
	
	private int moderateWars = 0;
	private int moderateEJBs = 0;
	private int rars = 0;
	
	private int complexWars = 0;
	private int complexEJBs = 0;
	
	
	public int getSimpleWars() {
		return simpleWars;
	}
	public void setSimpleWars(int simpleWars) {
		this.simpleWars = simpleWars;
	}
	public int getAppClients() {
		return appClients;
	}
	public void setAppClients(int appClients) {
		this.appClients = appClients;
	}
	public int getModerateWars() {
		return moderateWars;
	}
	public void setModerateWars(int moderateWars) {
		this.moderateWars = moderateWars;
	}
	public int getModerateEJBs() {
		return moderateEJBs;
	}
	public void setModerateEJBs(int moderateEJBs) {
		this.moderateEJBs = moderateEJBs;
	}
	public int getRars() {
		return rars;
	}
	public void setRars(int rars) {
		this.rars = rars;
	}
	public int getComplexWars() {
		return complexWars;
	}
	public void setComplexWars(int complexWars) {
		this.complexWars = complexWars;
	}
	public int getComplexEJBs() {
		return complexEJBs;
	}
	public void setComplexEJBs(int complexEJBs) {
		this.complexEJBs = complexEJBs;
	}
	
// DHV: added to support unit tests

	@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + appClients;
	result = prime * result + complexEJBs;
	result = prime * result + complexWars;
	result = prime * result + moderateEJBs;
	result = prime * result + moderateWars;
	result = prime * result + rars;
	result = prime * result + simpleWars;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	CalculationResult other = (CalculationResult) obj;
	if (appClients != other.appClients)
		return false;
	if (complexEJBs != other.complexEJBs)
		return false;
	if (complexWars != other.complexWars)
		return false;
	if (moderateEJBs != other.moderateEJBs)
		return false;
	if (moderateWars != other.moderateWars)
		return false;
	if (rars != other.rars)
		return false;
	if (simpleWars != other.simpleWars)
		return false;
	return true;
}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result = "{\"simpleWars\":" + getSimpleWars() + "," +
		                 "\"appClients\":" + getAppClients() + "," +
		                 "\"moderateWars\":" + getModerateWars() + "," +
		                 "\"moderateEJBs\":" + getModerateEJBs() + "," +
		                 "\"rars\":" + getRars() + "," +
		                 "\"complexWars\":" + getComplexWars() + "," +
		                 "\"complexEJBs\":" + getComplexEJBs() + "}";
		return result;
	}
    
	
}
