package cus.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cus.register.Customer;

public class CustomerDBUtil {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static boolean isSuccess = false;
	
	public static boolean validate(String username, String password) {
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from customer where c_username ='"+username+"' and c_password = '"+password+"' ";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
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
	
	public static boolean registercustomer(String name, String email, String phone, String username, String password) {
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "insert into customer values(0, '"+name+"', '"+email+"', '"+phone+"', '"+username+"', '"+password+"')";
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
	
	public static ArrayList<Customer> getCustomer(String username){
		ArrayList<Customer> cus = new ArrayList<>();
		
		try {
			 con = DBConnect.getConnection();
			 stmt = con.createStatement();
			 String sql = "select * from customer where c_username ='"+username+"'";
			 rs = stmt.executeQuery(sql);
			 
			 while(rs.next()) {
				 int s_id = rs.getInt(1);
				 String s_name = rs.getString(2);
				 String s_email = rs.getString(3);
				 String s_phone = rs.getString(4);
				 String s_user2 = rs.getString(5);
				 String s_pass2 = rs.getString(6);
				 
				 Customer cu = new Customer(s_id, s_name, s_email, s_phone, s_user2, s_pass2);
				 cus.add(cu);
			 }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return cus;
	}
	
	public static boolean updatecustomer(String id, String name, String email, String phone, String username, String password) {
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "update customer set c_name='"+name+"', c_email='"+email+"', c_phone='"+phone+"', c_username='"+username+"', c_password='"+password+"' where c_id='"+id+"'";
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
	
	public static List<Customer> getCusDetails(String id){
		
		int convID = Integer.parseInt(id);
		
		ArrayList<Customer> cus = new ArrayList<>();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from customer where c_id='"+convID+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id1 = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String user3 = rs.getString(5);
				String pass3 = rs.getString(6);
				
				Customer c = new Customer(id1, name, email, phone, user3, pass3);
				cus.add(c);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return cus;
	}
	
	public static boolean deletecustomer(String id) {
		int convID = Integer.parseInt(id);
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "delete from customer where c_id='"+convID+"'";
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
