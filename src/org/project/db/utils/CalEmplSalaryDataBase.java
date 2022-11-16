package org.project.db.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

import javax.servlet.http.HttpServletResponse;

import org.project.beans.SalaryBean;
import org.project.serviceImpl.CalEmplSalaryServiceImpl;


public class CalEmplSalaryDataBase{

	public void connection(SalaryBean bean,HttpServletResponse response,Connection conn,Statement st) throws IOException {
		PrintWriter out = response.getWriter();
		try{
			
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:mukesh","MTNDEVDB","MTNDEVDB");
			st = conn.createStatement();
			CalEmplSalaryServiceImpl service = new CalEmplSalaryServiceImpl();
			service.salResult(bean, response, st);
			conn.close();
		}
		catch(Exception e){
			out.println(e);
			out.println("Failed to calculate");
		}
		
	}

}
