package com.admin.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SpeclialistDao;
import com.db.DBconn;
import com.entity.User;

@WebServlet("/addSpecialist")
public class Addspecialist extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String specName = req.getParameter("specName");
HttpSession session=req.getSession();
		SpeclialistDao dao;
		try {
			dao = new SpeclialistDao(DBconn.getconn());
			boolean f=dao.addSpecialist(specName);
	

				if (f) {
					session.setAttribute("succMsg", "Specialist Added");
					resp.sendRedirect("admin/index.jsp");
				} else {
					session.setAttribute("errorMsg", "something wrong on server");
					resp.sendRedirect("admin/index.jsp");
				}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		}
}

		
		
	

