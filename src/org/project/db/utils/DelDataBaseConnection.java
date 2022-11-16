package org.project.db.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.http.HttpServletResponse;

import org.project.beans.EmployeeBean;

public class DelDataBaseConnection {
	public void connection(HttpServletResponse response,EmployeeBean employeebean) throws IOException {
		String ID = employeebean.getID();
		PrintWriter out = response.getWriter();
		System.out.println(ID);
		try{
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:mukesh","MTNDEVDB","MTNDEVDB");
			Statement st = conn.createStatement();
			st.executeQuery("DELETE FROM EMPLOYEE WHERE ID ="+ID+"");
			
			conn.close();
			out.println("Data deleted successfully");
		}
		catch(Exception e){
			out.println(e);
			out.println("Data failed to delete");
	    }
	}

}
