package org.project.db.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.http.HttpServletResponse;

import org.project.beans.EmployeeBean;

public class ModDataBaseConnection {

	public void connection(EmployeeBean bean, HttpServletResponse response) throws IOException {
		String FIRSTNAME = bean.getFirstName();
		String LASTNAME = bean.getLastName();
		String EMAIL = bean.getEmail();
		String ID = bean.getID();
		PrintWriter out = response.getWriter();
		try{
			
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:mukesh","MTNDEVDB","MTNDEVDB");
			Statement st = conn.createStatement();
			st.executeUpdate("UPDATE EMPLOYEE SET FIRSTNAME='"+FIRSTNAME+"',LASTNAME='"+LASTNAME+"',EMAIL='"+EMAIL+"'WHERE ID='"+ID+"'");
			conn.close();
			out.println(FIRSTNAME);
			out.println(LASTNAME);
			out.println(EMAIL);
			out.println(ID);
			
			out.println("Data updated successfully");
		}
		catch(Exception e){
			out.println(e);
			out.println("Data failed to update");
		}
		
	}

}
