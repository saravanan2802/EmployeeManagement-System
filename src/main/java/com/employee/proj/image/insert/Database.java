package com.employee.proj.image.insert;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {

	public int writeQuery(String a, InputStream s) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/imginsert?user=root&password=root");
		PreparedStatement ps = conn.prepareStatement("insert into imgtable value(? ,?)");
		ps.setString(1, a);
		ps.setBlob(2, s);

		return ps.executeUpdate();

	}
}
