package com.employee.proj.image.insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1mb
		maxFileSize = 1024 * 1024 * 10, // 10mb
		maxRequestSize = 1024 * 1024 * 50 // 50mb
)
@WebServlet("/imgs")
public class ImageInsert extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		InputStream is = null;
		Part img = req.getPart("image");

		if (img != null) {
			is = img.getInputStream();
		}

		Database db = new Database();
		try {
			int res = db.writeQuery(name, is);
			if (res == 1) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/imginsert?user=root&password=root");
				PreparedStatement ps = conn.prepareStatement("select * from imgtable");
				ResultSet rs = ps.executeQuery();
				
				req.setAttribute("dats", rs);
				
				RequestDispatcher rd = req.getRequestDispatcher("details.jsp");
				rd.include(req, resp);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
