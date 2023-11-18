package com.employee.proj.delete.servlet;

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

@WebServlet("/delete")
public class DeleteEmp extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		HttpSession session = req.getSession();
		String ss =(String) session.getAttribute("username"); 
		String pp =(String) session.getAttribute("password");
		System.out.println(ss);
		System.out.println(pp);
		if (ss  == null && pp == null) {
			req.setAttribute("message", "please log in");
			RequestDispatcher rs = req.getRequestDispatcher("adminlogin.jsp");
			rs.forward(req, resp);
		}
		else {
		EmployeeDao dao = new EmployeeDao();
		
		try {
			int res = dao.deleteStudent(id);
			req.setAttribute("employee", dao.getAllEmployee());
			RequestDispatcher rs = req.getRequestDispatcher("home.jsp");
			rs.include(req, resp);			
			}
			
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	  }
	}
}
