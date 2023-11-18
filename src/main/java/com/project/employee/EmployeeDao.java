package com.project.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empproj?user=root&password=root");
		return conn;
	}

	public int saveStudent(EmployeeDto emp) throws ClassNotFoundException, SQLException {
		PreparedStatement pst = getConnection().prepareStatement("insert into empproj values(?,?,?,?,?,?)");
		pst.setInt(1, emp.getId());
		pst.setString(2, emp.getName());
		pst.setString(3, emp.getDept());
		pst.setLong(4, emp.getContact());
		pst.setString(5, emp.getCity());
		pst.setString(6, emp.getPassword());

		return pst.executeUpdate();
	}

	public EmployeeDto findById(int id) throws ClassNotFoundException, SQLException {
		PreparedStatement pst = getConnection().prepareStatement("select * from empproj where id=?");
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		EmployeeDto dto = new EmployeeDto();

		while (rs.next()) {
			dto.setId(rs.getInt(1));
			dto.setName(rs.getString(2));
			dto.setDept(rs.getString(3));
			dto.setContact(rs.getLong(4));
			dto.setCity(rs.getString(5));
			dto.setPassword(rs.getString(6));
		}

		return dto;
	}

	public int updateEmployeeById(EmployeeDto emp) throws ClassNotFoundException, SQLException {
		PreparedStatement pst = getConnection()
				.prepareStatement("update empproj set name=?,dept=?,contact=?,city=?,password=? where id=?");
		pst.setString(1, emp.getName());
		pst.setString(2, emp.getDept());
		pst.setLong(3, emp.getContact());
		pst.setString(4, emp.getCity());
		pst.setString(5, emp.getPassword());
		pst.setInt(6, emp.getId());

		return pst.executeUpdate();
	}

	public int deleteStudent(int id) throws ClassNotFoundException, SQLException {
		PreparedStatement pst = getConnection().prepareStatement("delete from empproj where id=?");
		pst.setInt(1, id);
		return pst.executeUpdate();
	}

	public List<EmployeeDto> getAllEmployee() throws ClassNotFoundException, SQLException {
		PreparedStatement pst = getConnection().prepareStatement("select * from empproj");
		ResultSet rs = pst.executeQuery();

		List<EmployeeDto> employee = new ArrayList<>();

		while (rs.next()) {
			EmployeeDto emp = new EmployeeDto();
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setDept(rs.getString(3));
			emp.setContact(rs.getLong(4));
			emp.setCity(rs.getString(5));
			emp.setPassword(rs.getString(6));
			employee.add(emp);
		}
		return employee;
	}

	public EmployeeDto findByName(String name) throws ClassNotFoundException, SQLException {
		PreparedStatement pst = getConnection().prepareStatement("select * from empproj where name = ?");
		pst.setString(1, name);
		ResultSet rs = pst.executeQuery();
		EmployeeDto dto = new EmployeeDto();

		while (rs.next()) {
			dto.setId(rs.getInt(1));
			dto.setName(rs.getString(2));
			dto.setDept(rs.getString(3));
			dto.setContact(rs.getLong(4));
			dto.setCity(rs.getString(5));
			dto.setPassword(rs.getString(6));
		}
		return dto;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		EmployeeDto dto =  new EmployeeDto();
		EmployeeDao dao = new EmployeeDao();
		dto.setId(2);
		dto.setName("Saro");
		dto.setContact(55555);
		dto.setDept("java");
		dto.setCity("chennai");
		dto.setPassword("123@1");
		dao.saveStudent(dto); 
	}

}
