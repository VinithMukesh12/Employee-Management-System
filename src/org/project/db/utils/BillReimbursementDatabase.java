package org.project.db.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.http.HttpServletResponse;

import org.project.beans.BenefitBean;

public class BillReimbursementDatabase {
	
	public void connection(HttpServletResponse response,BenefitBean bean) throws IOException {
		PrintWriter out = response.getWriter();
		try{
			String ID = bean.getID();
			double Amount = bean.getAmount();
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:mukesh","MTNDEVDB","MTNDEVDB");
			Statement st = conn.createStatement();
			st.executeUpdate("UPDATE EMPLOYEEBENEFIT SET AVALI=AVALI-'"+Amount+"',USED=USED+'"+Amount+"' WHERE ID='"+ID+"'");
			conn.close();
			
			out.println("Bill Reimbursement done successfully");
		}
		catch(Exception e){
			out.println(e);
			out.println("Failed");
		}
	}

}
