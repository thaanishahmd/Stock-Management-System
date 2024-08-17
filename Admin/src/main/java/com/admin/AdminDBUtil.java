package com.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminDBUtil {
private static boolean isSuccess;
private static Connection con=null;
private static Statement stat=null;
private static ResultSet rs=null;

public static boolean validate(String username, String password) {
	
	try {
		con = DBConnect.getConnection();
		stat = con.createStatement();
		String sql = "select * from admin where username='"+username+"' and password='"+password+"'";
		rs = stat.executeQuery(sql);
		
		if (rs.next()) {
			isSuccess = true;
		} else {
			isSuccess = false;
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return isSuccess;
}
public static List<Admin> getAdmin(String userName) {
	

	ArrayList<Admin> admin = new ArrayList<>();
	
	
	try {
		
		con = DBConnect.getConnection();
		stat = con.createStatement();
		String sql = "select * from admin where username='"+userName+"'";
		rs = stat.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String email = rs.getString(3);
			String phone = rs.getString(4);
			String username = rs.getString(5);
			String password = rs.getString(6);
		
			Admin a = new Admin(id,name,email,phone,username,password);
			admin.add(a);
		}
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}	
	return admin;	
}
}

