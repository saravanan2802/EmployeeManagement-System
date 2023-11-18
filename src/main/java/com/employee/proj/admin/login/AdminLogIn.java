package com.employee.proj.admin.login;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.employee.EmployeeDao;
import com.project.employee.EmployeeDto;

@WebServlet("/admlogin")
public class AdminLogIn extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = "root";
		String password = "root";
		
		String name1 = req.getParameter("name");
		String password2 = req.getParameter("pass");
		EmployeeDao dao = new EmployeeDao();
		try {
			List<EmployeeDto> empp = dao.getAllEmployee();
			if (name.equals(name1) && password.equals(password2)) {
				HttpSession sess = req.getSession();
				sess.setAttribute("username", name1);
				sess.setAttribute("password", password2);
				req.setAttribute("employee", empp);
				RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
				rd.include(req, resp);
			}
			else {
				req.setAttribute("message", "user name or password mismatch");
				RequestDispatcher rd = req.getRequestDispatcher("adminlogin.jsp");
				rd.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
