package org.project.serviceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.beans.BenefitBean;
import org.project.db.utils.FetEmpBenefitDatabase;

public class FetEmpBenefitServiceImpl {

	public void validation(BenefitBean bean, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		Statement st = null;
		if (bean.getID() != "") {
			FetEmpBenefitDatabase data = new FetEmpBenefitDatabase();
			data.connection(conn, st, bean, response);
		} else {
			request.setAttribute("errorFEBCID", "ID cannot be empty");
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			rs.include(request, response);
		}
	}

	public void dataValidation(Connection conn, Statement st, BenefitBean bean, HttpServletResponse response)
			throws SQLException, IOException {
		PrintWriter out = response.getWriter();
		String ID = bean.getID();
		ResultSet rs = st.executeQuery("SELECT SUM(DEDUCTION) from EMPLOYEESALARY WHERE ID=" + ID + "");
		if (rs.next()) {
			double deduction = rs.getDouble(1);
			double mbenefits = (deduction * 0.8);
			ResultSet rt = st.executeQuery("SELECT * from EMPLOYEEBENEFIT WHERE ID=" + ID + "");
			if (rt.next()) {
				double used = rt.getDouble(3);
				double avail = rt.getDouble(4);
				st.executeQuery("insert into EMPLOYEEBENEFIT values('" + ID + "','" + mbenefits + "','" + used + "','"
						+ avail + "')");
			} else {
				double used = 0;
				double avail = mbenefits;
				st.executeQuery("insert into EMPLOYEEBENEFIT values('" + ID + "','" + mbenefits + "','" + used + "','"
						+ avail + "')");
			}
			out.println("Employee ID:" + ID);
			out.println("Total Medical benefits upto date:" + mbenefits);
		}
	}

}
