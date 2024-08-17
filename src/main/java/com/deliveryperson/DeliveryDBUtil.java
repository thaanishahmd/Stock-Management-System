package com.deliveryperson;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import cus.register.DBConnect;

public class DeliveryDBUtil {
	private static boolean isSuccess=false;
	private static Connection con=null;
	private static Statement stmt=null;
	private static ResultSet rs=null;
	
public static boolean validate(String username, String password) {
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from deliveryperson where db_user='"+username+"' and db_pass='"+password+"'";
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

    public static ArrayList<DeliveryPerson> getDeliveryPerson(String userName) {
    	ArrayList<DeliveryPerson> dp = new ArrayList<>();
    	
    	try {
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "select * from deliveryperson where db_user='"+userName+"'";
    		rs = stmt.executeQuery(sql);
    		
    		while(rs.next()) {
    			 int db_id = rs.getInt(1);
				 String db_name = rs.getString(2);
				 String db_email = rs.getString(3);
				 String db_phone = rs.getString(4);
				 String db_user2 = rs.getString(5);
				 String db_pass2 = rs.getString(6);
    		
    			DeliveryPerson d = new DeliveryPerson(db_id,db_name,db_email,db_phone,db_user2,db_pass2);
    			dp.add(d);
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}	
    	return dp;	
    }
    
  public static boolean insertdeliveryperson (String name, String username, String password, String email, String phone) {
    	
    	boolean isSuccess = false;
    	
  
    	
    	try {
    		con=DBConnect.getConnection();
    		stmt=con.createStatement();
    	    String sql = "insert into deliveryperson values (0,'"+name+"','"+email+"','"+phone+"','"+username+"','"+password+"')";
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

  
public static boolean updatedeliveryperson(String id, String name, String email, String phone, String username, String password) {

	try {
		
		con = DBConnect.getConnection();
		stmt = con.createStatement();
		String sql = "update deliveryperson set db_name='"+name+"',db_email='"+email+"',db_phone='"+phone+"', db_user='"+username+"',db_pass='"+password+"'where db_id='"+id+"'";
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

public static List<DeliveryPerson> getDeliveryPersonDetails(String Id) {
	
	int convertedID = Integer.parseInt(Id);
	
	ArrayList<DeliveryPerson> d = new ArrayList<>();
	
	try {
		
		con = DBConnect.getConnection();
		stmt = con.createStatement();
		String sql = "select * from deliveryperson where db_user='"+convertedID+"'";
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			int id1 = rs.getInt(1);
			String name = rs.getString(2);
			String email = rs.getString(3);
			String phone = rs.getString(4);
			String user3 = rs.getString(5);
			String pass3 = rs.getString(6);
		
			DeliveryPerson db = new DeliveryPerson(id1,name,email,phone,user3,pass3);
			d.add(db);
		}
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}	
	return d;	
}
public static boolean deletedeliveryperson(String id) {
	
	int convId = Integer.parseInt(id);
	
	try {
		
		con = DBConnect.getConnection();
		stmt = con.createStatement();
		String sql = "delete from deliveryperson where db_id='"+convId+"'";
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

