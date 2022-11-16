package org.project.db.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.http.HttpServletResponse;

import org.project.beans.SalaryBean;
import org.project.serviceImpl.GenPaySlipEmpServiceImpl;

public class GenPaySlipEmpDataBase {

	public void connection(HttpServletResponse response,Connection conn,Statement st,SalaryBean bean) throws IOException {
		GenPaySlipEmpServiceImpl service = new GenPaySlipEmpServiceImpl();
		PrintWriter out = response.getWriter();
		try{
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:mukesh","MTNDEVDB","MTNDEVDB");
			st = conn.createStatement();
			service.result(bean, conn, st, response);
			conn.close();
			
			
		}
		catch(Exception e){
			out.println(e);
			out.println("Data failed to load");
		}
		
	}


}
