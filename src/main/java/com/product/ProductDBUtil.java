package com.product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.product.*;
import cus.register.DBConnect;

public class ProductDBUtil {
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static boolean isSuccess = false;
	
	public static boolean addproduct(String pname, String pdesc, int pprice, String category) {
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "insert into product values(0, '"+pname+"', '"+pdesc+"', '"+pprice+"', '"+category+"')";
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static List<product> getprodDetails(String pid){
		
		int convID = Integer.parseInt(pid);
		
		ArrayList<product> pr = new ArrayList();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from product where p_id='"+convID+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int pid1 = rs.getInt(1);
				String pname = rs.getString(2);
				String pdesc = rs.getString(3);
				int pprice = Integer.parseInt(rs.getString(4));
				String category = rs.getString(5);
				
				product p = new product(pid1, pname, pdesc, pprice, category);
				pr.add(p);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return pr;
	}
	
	public static List<product> getproduct(String prname){
		
		ArrayList<product> pr = new ArrayList();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from product where p_name='"+prname+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int pid1 = rs.getInt(1);
				String pname = rs.getString(2);
				String pdesc = rs.getString(3);
				int pprice = Integer.parseInt(rs.getString(4));
				String category = rs.getString(5);
				
				product p = new product(pid1, pname, pdesc, pprice, category);
				pr.add(p);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return pr;
	}

	public static boolean deleteproduct(String pid) {
		int convID = Integer.parseInt(pid);
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "delete from product where p_id='"+convID+"'";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public static boolean updateproduct(String pid, String pname, String pdesc, int pprice, String category) {
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "update product set p_name='"+pname+"', p_description='"+pdesc+"', p_price='"+pprice+"', category='"+category+"' where p_id='"+pid+"'";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
}
