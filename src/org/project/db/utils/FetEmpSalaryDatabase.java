package org.project.db.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.http.HttpServletResponse;

import org.project.beans.SalaryBean;

public class FetEmpSalaryDatabase {

	public void connection(SalaryBean bean,HttpServletResponse response) throws IOException {
		String id = bean.getId();
		String designation = bean.getDesignation();
		double salary = Double.parseDouble(bean.getSalary());
		double inhand = salary-(salary*0.05);
		double perhour = (inhand/160);
		String MMMYYYY = bean.getMMMYYYY();
		double deduction = (salary-inhand);
		PrintWriter out = response.getWriter();
		
		try{
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:mukesh","MTNDEVDB","MTNDEVDB");
			Statement st = conn.createStatement();
			st.executeUpdate("insert into EMPLOYEESALARY values('"+id+"','"+designation+"','"+salary+"','"+inhand+"','"+perhour+"','"+MMMYYYY+"','"+deduction+"')");
			conn.close();
			
			out.println("Data inserted successfully");
		}
		catch(Exception e){
			out.println(e);
			out.println("Data failed to insert");
		}
		
	}

}
