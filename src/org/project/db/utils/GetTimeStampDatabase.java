package org.project.db.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletResponse;

import org.project.beans.TimeSheetBean;

public class GetTimeStampDatabase {

	public void connection(TimeSheetBean bean,HttpServletResponse response) throws IOException {
		
		String ID = bean.getId();
		PrintWriter out = response.getWriter();
		try{
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:mukesh","MTNDEVDB","MTNDEVDB");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from EMPLOYEETIMESHEET WHERE ID="+ID+"");
			while(rs.next()) {
				
				out.print(" "+rs.getString(1)+" ");
				
				out.print(" "+rs.getString(2)+" ");
				
				out.print(" "+rs.getString(3)+" ");
				
				out.print(" "+rs.getString(4)+" ");
				
				out.println(" "+rs.getString(5)+" ");
				
			}
			conn.close();
		}
		catch(Exception e){
			out.println(e);
			out.println("Data failed to display");
		}
		
	}

}
