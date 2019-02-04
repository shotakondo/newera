package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import beans.User;
import exp.*;


public class OraUserDao implements UserDao{
	public void createUser(User u){
	
		Connection cn = null;
		PreparedStatement st = null;
		
		
		try{
			
			
			cn = OracleConnectionManager.getInstance().getConnection();
			
			// String sql ="INSERT INTO user_table values('?','?','?','?','?','?','?','?','?','?')";
			
			String sql = "insert into user_table values(?,?,?,?,?,?,?,?,?,?)";
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
		public boolean checkLogin(User u){
			ResultSet rs =null;
			Connection cn = null;
			PreparedStatement ps = null;
			
			boolean b = false;
		try {
			cn = OracleConnectionManager.getInstance().getConnection();
			String sql = "select user_id,user_email,user_pass from user_table where user_email='" + u.getEmail() + "'and user_pass='" + u.getPass()+"'";
			System.out.println(u.getId() + u.getEmail() + u.getPass());
			ps = cn.prepareStatement(sql);
			System.out.println(sql);
			rs = ps.executeQuery();
			System.out.println("rs");
	
			 while(rs.next()){
			 	//User u = new User();
			 	u.setId(rs.getString(1));
			 	System.out.println("userÇÃgetId()Ç≈Ç∑ÅB"+u.getId());
			 	
			 	System.out.println("while");
			 	if(rs.getString(2).equals(u.getEmail()) && rs.getString(3).equals(u.getPass())){
			 		System.out.println("while(rs.next)"+ rs.getString(1));
					 b=true;
				 }
			 	else{
			 		System.out.println("else ì¸ÇËÇ‹ÇµÇΩ");
			 		b=false;
			 	}
			 }
			 }catch(SQLException e){
			// OracleConnectionManager.getInstance().rollback();
			e.printStackTrace();
			}finally{
			try{
				if(ps != null){
					ps.close();
					ps = null;
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return b;
	}
	
	public static List<User> queryUser(Connection conn){
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList ar = new ArrayList();
		System.out.println("getUserì¸ÇËÇ‹ÇµÇΩ");
		
		try{
			Connection cn = null;
			cn = OracleConnectionManager.getInstance().getConnection();
			
			String sql = "SELECT user_id,user_firstName,user_lastName,user_email,user_pass,user_tel,user_postcode,user_address,user_sex,user_birthday from user_table where user_id='" + id + "'";
			
			st = cn.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			while(rs.next()){
				User  u = new User();
				
				u.setId(rs.getString(1));
				u.setFirstName(rs.getString(2));
				u.setLastName(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setPass(rs.getString(5));
				u.setTel(rs.getString(6));
				u.setPostcode(rs.getString(7));
				u.setAddress(rs.getString(8));
				u.setSex(rs.getString(9));
				u.setBirthday(rs.getString(10));
				
				ar.add(u);
			}
		}catch(SQLException e){
			OracleConnectionManager.getInstance().rollback();
			e.printStackTrace();
			throw new ResourceAccessException(e.getMessage(), e);
		}finally{
			try{
				if(st!=null){
					st.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			throw new ResourceAccessException(e.getMessage(), e);
			}
		return ar;
		}
	}
	public boolean DeleteUser(String id){
		PreparedStatement st = null;
		boolean b = false;
		try{
			Connection cn = null;
			cn = OracleConnectionManager.getInstance().getConnection();
			
			String sql = "DELETE from user_table where user_id=?";
			System.out.println(sql);
			st = cn.prepareStatement(sql);
			st.setString(1,id);
			st.executeUpdate();
			cn.commit();
			b = true;
		}catch(SQLException e){
			OracleConnectionManager.getInstance().rollback();
			b = false;
		}finally{
			try{
				
				if(st!=null){
					st.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
				b = false;
			}
		}
		return b;
	}
}
