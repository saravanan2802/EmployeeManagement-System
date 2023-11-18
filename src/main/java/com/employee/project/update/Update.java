package com.employee.project.update;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.employee.EmployeeDao;
import com.project.employee.EmployeeDto;
@WebServlet("/update")
public class Update extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("it came");
		int id =Integer.parseInt(req.getParameter("id"));
		System.out.println("it not came");
		String name = req.getParameter("name");
		String dept = req.getParameter("dept");
		Long Contact = Long.parseLong(req.getParameter("contact"));
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
			dao.updateEmployeeById(dto);
			List<EmployeeDto> empp=dao.getAllEmployee();
			req.setAttribute("employee", empp);
			
			RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
			rd.include(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
