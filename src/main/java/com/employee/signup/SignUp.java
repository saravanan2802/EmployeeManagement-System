package com.employee.signup;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.employee.EmployeeDao;
import com.project.employee.EmployeeDto;

@WebServlet("/signup")
public class SignUp extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String dept = req.getParameter("dept");
		long Contact = Long.parseLong(req.getParameter("contact"));
		String city = req.getParameter("city");
		String pass = req.getParameter("password");

		EmployeeDto dto = new EmployeeDto();
		dto.setId(id);
		dto.setName(name);
		dto.setDept(dept);
		dto.setContact(Contact);
		dto.setCity(city);
		dto.setPassword(pass);

		EmployeeDao dao = new EmployeeDao();

		try {
			int result = dao.saveStudent(dto);
			if (result == 1) {
				req.setAttribute("name", name);
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.include(req, resp);
			}
			else {
				RequestDispatcher rd = req.getRequestDispatcher("signup.jsp");
				rd.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
