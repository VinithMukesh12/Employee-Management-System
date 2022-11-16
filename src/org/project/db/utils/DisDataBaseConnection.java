package org.project.db.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletResponse;

import org.project.beans.EmployeeBean;

public class DisDataBaseConnection {
	public void connection(EmployeeBean employeebean,HttpServletResponse response) throws IOException {
		String ID = employeebean.getID();
		PrintWriter out = response.getWriter();
		try{
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:mukesh","MTNDEVDB","MTNDEVDB");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from EMPLOYEE WHERE ID="+ID+"");
			while(rs.next()) {
				
				out.println(rs.getString(1));
				
				out.println(rs.getString(2));
				
				out.println(rs.getString(3));
				
				out.println(rs.getString(4));
				
			}
			conn.close();
		}
		catch(Exception e){
			out.println(e);
			out.println("Data failed to display");
		}
	}

}
