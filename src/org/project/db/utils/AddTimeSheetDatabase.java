package org.project.db.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


import javax.servlet.http.HttpServletResponse;


import org.project.beans.TimeSheetBean;

public class AddTimeSheetDatabase {

	public void connection(TimeSheetBean bean,HttpServletResponse response) throws IOException {
		String ID = bean.getId();
		String DATE = bean.getDate();
		int TIMEIN = Integer.parseInt(bean.getTimein());
		int TIMEOUT = Integer.parseInt(bean.getTimeout());
		int WORKHOURS = (TIMEOUT-TIMEIN);
		PrintWriter out = response.getWriter();
		try{
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:mukesh","MTNDEVDB","MTNDEVDB");
			Statement st = conn.createStatement();
			st.executeQuery("insert into EMPLOYEETIMESHEET values('"+ID+"','"+DATE+"','"+TIMEIN+"','"+TIMEOUT+"','"+WORKHOURS+"')");
			conn.close();
			
			out.println("Data inserted successfully");
		}
		catch(Exception e){
			out.println(e);
			out.println("Data failed to insert");
		}
		
	}

}
