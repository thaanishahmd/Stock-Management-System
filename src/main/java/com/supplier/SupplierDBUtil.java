package com.supplier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cus.register.DBConnect;


public class SupplierDBUtil {
		private static boolean isSuccess=false;
		private static Connection con=null;
		private static Statement stmt=null;
		private static ResultSet rs=null;
		
	public static boolean validate(String username, String password) {
			
			try {
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql = "select * from supplier where sup_user='"+username+"' and sup_pass='"+password+"'";
				rs = stmt.executeQuery(sql);
				
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
	
	    public static ArrayList<Supplier> getSupplier(String userName) {
	    	ArrayList<Supplier> sup = new ArrayList<>();
	    	
	    	try {
	    		con = DBConnect.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "select * from supplier where sup_user='"+userName+"'";
	    		rs = stmt.executeQuery(sql);
	    		
	    		while(rs.next()) {
	    			 int c_id = rs.getInt(1);
					 String c_name = rs.getString(2);
					 String c_email = rs.getString(3);
					 String c_phone = rs.getString(4);
					 String c_user2 = rs.getString(5);
					 String c_pass2 = rs.getString(6);
	    		
	    			Supplier su = new Supplier(c_id,c_name,c_email,c_phone,c_user2,c_pass2);
	    			sup.add(su);
	    		}
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}	
	    	return sup;	
	    }
	    
	  public static boolean insertsupplier(String name, String username, String password, String email, String phone) {
	    	
	    	boolean isSuccess = false;
	    	
	  
	    	
	    	try {
	    		con=DBConnect.getConnection();
	    		stmt=con.createStatement();
	    	    String sql = "insert into supplier values (0,'"+name+"','"+email+"','"+phone+"','"+username+"','"+password+"')";
	    		int rs=stmt.executeUpdate(sql);
	    		
	    		if(rs > 0) {
	    			isSuccess = true;
	    		} else {
	    			isSuccess = false;
	    		}
	    		
	    	}
	    	catch (Exception e) {
	    		e.printStackTrace();
	    	}
	 	
	    	return isSuccess;
	    }

	  
	public static boolean updatesupplier(String id, String name, String email, String phone, String username, String password) {

		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "update supplier set sup_name='"+name+"',sup_email='"+email+"',sup_phone='"+phone+"', sup_user='"+username+"',sup_pass='"+password+"'where sup_id='"+id+"'";
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

	public static List<Supplier> getSupplierDetails(String Id) {
		
		int convertedID = Integer.parseInt(Id);
		
		ArrayList<Supplier> sup = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from supplier where sup_user='"+convertedID+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id1 = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String user3 = rs.getString(5);
				String pass3 = rs.getString(6);
			
				Supplier s = new Supplier(id1,name,email,phone,user3,pass3);
				sup.add(s);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
		return sup;	
	}
	public static boolean deleteSupplier(String id) {
		
		int convId = Integer.parseInt(id);
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "delete from supplier where sup_id='"+convId+"'";
			int rs = stmt.executeUpdate(sql);
			
			if (rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
}
