package com.ty.Employemanagent.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.Employemanagent.Entity.Employe;


public class EmpService {

	private static String url="jdbc:postgresql://localhost:5432/user?user=postgres&password=123";
	private static String driverpath="org.postgresql.Driver";
	private static Connection connection;
	
	
	
	
static {
	try {
		Class.forName(driverpath);
		connection=DriverManager.getConnection(url);
		System.out.println(connection);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public int save(Employe e)
	{
		int reslt=0;
		String sql="INSERT INTO employe VALUES(?,?,?,?,?)";
		try {
			PreparedStatement pstm=connection.prepareStatement(sql);
			pstm.setInt(1, e.getId());
			pstm.setString(2, e.getName());
			pstm.setInt(3, e.getAge());
			pstm.setString(4, e.getEmailid());
			pstm.setInt(5, e.getSalary());
			
			 reslt=pstm.executeUpdate();
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return reslt;
		
	}
	public int update(Employe e)
	{
		int reslt=0;
		String sql="UPDATE employe SET  name=?,age=?,emailid=?,salary=? WHERE id=?";
		try {
			PreparedStatement pstm=connection.prepareStatement(sql);
			
			pstm.setString(1, e.getName());
			pstm.setInt(2, e.getAge());
			pstm.setString(3, e.getEmailid());
			pstm.setInt(4, e.getSalary());
			pstm.setInt(5, e.getId());
			 reslt=pstm.executeUpdate();
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return reslt;	
	}
	public int delete(int id)
	{
		int reslt=0;
		String sql="DELETE FROM employe WHERE id=?";
		try {
			PreparedStatement pstm=connection.prepareStatement(sql);
			
			pstm.setInt(1, id);
			 reslt=pstm.executeUpdate();
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return reslt;		
	}
	public List<Employe> fetchAll()
	{
		System.out.println("dasdsad");
		List<Employe> emp=new ArrayList<>();
		
		String sql="SELECT * FROM employe";
		
		try {
			PreparedStatement pstm=connection.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			while (rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int age=rs.getInt(3);
				String email=rs.getString(4);
			int	salary=rs.getInt(5);
			
			emp.add(new Employe(id, name, age, email, salary));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;	
	}
}

