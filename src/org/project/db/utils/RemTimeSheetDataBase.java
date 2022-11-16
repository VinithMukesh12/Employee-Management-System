package org.project.db.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.http.HttpServletResponse;

import org.project.beans.TimeSheetBean;

public class RemTimeSheetDataBase {

	public void connection(TimeSheetBean bean,HttpServletResponse response) throws IOException {
		String MMMYYYY = bean.getMMMYYYY();
		PrintWriter out = response.getWriter();
		
		try{
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:mukesh","MTNDEVDB","MTNDEVDB");
			Statement st = conn.createStatement();
			st.executeQuery("DELETE FROM EMPLOYEETIMESHEET WHERE EMPSHEETDATE LIKE '%"+MMMYYYY+"'");
			
			conn.close();
			out.println("Data deleted successfully");
		}
		catch(Exception e){
			out.println(e);
			out.println("Data failed to delete");
	    }
	}
		


}
