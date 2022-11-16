package org.project.db.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.http.HttpServletResponse;

import org.project.beans.EmployeeBean;



public class NewDataBaseConnection {
	public void connection(EmployeeBean employeebean,HttpServletResponse response) throws IOException {
		String FIRSTNAME = employeebean.getFirstName();
		String LASTNAME = employeebean.getLastName();
		String EMAIL = employeebean.getEmail();
		String ID = employeebean.getID();
		PrintWriter out = response.getWriter();
		try{
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:mukesh","MTNDEVDB","MTNDEVDB");
			Statement st = conn.createStatement();
			st.executeUpdate("insert into EMPLOYEE values('"+FIRSTNAME+"','"+LASTNAME+"','"+EMAIL+"','"+ID+"')");
			conn.close();
			out.println(FIRSTNAME);
			out.println(LASTNAME);
			out.println(EMAIL);
			out.println(ID);
			
			out.println("Data inserted successfully");
		}
		catch(Exception e){
			out.println(e);
			out.println("Data failed to insert");
		}
	}

}
