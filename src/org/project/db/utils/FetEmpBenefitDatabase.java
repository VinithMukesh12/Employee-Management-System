package org.project.db.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

import javax.servlet.http.HttpServletResponse;

import org.project.beans.BenefitBean;
import org.project.serviceImpl.FetEmpBenefitServiceImpl;

public class FetEmpBenefitDatabase {

	public void connection(Connection conn, Statement st, BenefitBean bean, HttpServletResponse response)
			throws IOException {
		PrintWriter out = response.getWriter();
		FetEmpBenefitServiceImpl service = new FetEmpBenefitServiceImpl();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:mukesh", "MTNDEVDB", "MTNDEVDB");
			st = conn.createStatement();
			service.dataValidation(conn, st, bean, response);
			out.println("Data inserted successfully");
			conn.close();
		} catch (Exception e) {
			out.println(e);
			out.println("Data failed to insert");
		}

	}

}
