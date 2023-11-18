package com.employee.login;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.employee.EmployeeDao;
import com.project.employee.EmployeeDto;
@WebServlet("/employeein")
public class LoginStud extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("pass");
		
		EmployeeDao dao = new EmployeeDao();
		
		try {
			EmployeeDto dto = dao.findByName(name);
			
			if (dto.getPassword().equals(password)) {
				HttpSession sess = req.getSession();
				sess.setAttribute("name", name);
				sess.setAttribute("password", password);
				req.setAttribute("employee", dto);
				RequestDispatcher rd = req.getRequestDispatcher("homestu.jsp");
				rd.include(req, resp);
			}
			else {
				req.setAttribute("message", "user name or password mismatch");
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
