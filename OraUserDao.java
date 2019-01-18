package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import beans.User;


public class OraUserDao implements UserDao{
	public void createUser(User u){
	
		Connection cn = null;
		PreparedStatement st = null;
		
		try{
			
			
			cn = OracleConnectionManager.getInstance().getConnection();
			
			String sql ="INSERT INTO user_table"+"values('?','?','?','?','?','?','?','?','?','?')";
			
			//(user_id,user_firstname,user_lastname,user_email,user_pass,user_pass,user_tel,user_postcode,user_address,user_sex,user_birthday) 
			
			
			st = cn.prepareStatement(sql);
			
			
			st.setString(1,u.getId());
			System.out.println("id : " + u.getId());
			st.setString(2,u.getFirstName());
			System.out.println("firstname : " + u.getFirstName());
			st.setString(3,u.getLastName());
			System.out.println("lastname : " + u.getLastName());
			st.setString(4,u.getEmail());
			System.out.println("email : " + u.getEmail());
			st.setString(5,u.getPass());
			System.out.println("pass : " + u.getPass());
			st.setString(6,u.getTel());		
			System.out.println("tel : " + u.getTel());
			st.setString(7,u.getPostcode());
			System.out.println("postcode : " + u.getPostcode());
			st.setString(8,u.getAddress());	
			System.out.println("address : " + u.getAddress());
			st.setString(9,u.getSex());	
			System.out.println("sex : " + u.getSex());
			st.setString(10,u.getBirthday());	
			System.out.println("birthday : " + u.getBirthday());
			
			
			st.executeUpdate();
		
			
		}catch(SQLException e){
			// OracleConnectionManager.getInstance().rollback();
			e.printStackTrace();
			}finally{
			try{
				if(st != null){
					st.close();
					st = null;
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
}