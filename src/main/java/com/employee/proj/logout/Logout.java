package com.employee.proj.logout;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/logout")
public class Logout extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession(false);
		if (sess!=null) {
			sess.invalidate();
			req.setAttribute("name", "log Out SucessFul");
			RequestDispatcher rd = req.getRequestDispatcher("adminlogin.jsp");
			rd.include(req, resp);
		}
	}
}
