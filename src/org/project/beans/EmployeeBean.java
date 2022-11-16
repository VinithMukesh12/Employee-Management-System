package org.project.beans;

public class EmployeeBean {
	private String FirstName;
	private String LastName;
	private String Email;
	private String ID;
	
	public void setFirstName(String FirstName){
        this.FirstName = FirstName;
	}
	public void setLastName(String LastName){
        this.LastName = LastName;
	}
	public void setEmail(String Email){
        this.Email = Email;
	}
	public void setID(String ID){
        this.ID = ID;
	}
	
	public String getFirstName(){
        return FirstName;
    }
	public String getLastName(){
        return LastName;
    }
	public String getEmail()
    {
        return Email;
    }
	public String getID()
    {
        return ID;
    }


}
