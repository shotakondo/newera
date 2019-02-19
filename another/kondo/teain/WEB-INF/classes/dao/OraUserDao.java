package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import exp.*;
import beans.User;

public class OraUserDao implements UserDao{
	
	public void createUser(UserBean ub){
						Connection cn = null;
		PreparedStatement st = null;

		try{
		cn = OracleConnectionManager.getInstance().getConnection();
			
	String sql = "insert into user_table values(?,?,?,?,?,?,?,?,?,?)";
		
		st = cn.prepareStatement(sql);
	
		st.setString(1,ub.getId());
st.setString(2,ub.getFirstName());
	st.setString(3,ub.getLastName());
		st.setString(4,ub.getEmail());
	st.setString(5,ub.getPass());
			st.setString(6,ub.getTel());
		st.setString(7,ub.getPostcode());
	st.setString(8,ub.getAddress());
			st.setString(9,ub.getSex());
			st.setString(10,ub.getBirthday());			
			st.executeUpdate();
		}catch(SQLException e){
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
		public boolean checkLogin(UserBean ub){
		
		ResultSet rs =null;
		Connection cn = null;
	PreparedStatement ps = null;	
		boolean judge = false;

		try {		cn = OracleConnectionManager.getInstance().getConnection();
	String sql = "select * from user_table where user_email='" + ub.getEmail() + "'and user_pass='" + ub.getPass()+"'";
			
		ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
	
			while(rs.next()){
	ub.setUid(rs.getString(1));
				ub.setEmail(rs.getString(2));
		ub.setFirstName(rs.getString(4));
				ub.setLastName(rs.getString(5));
		ub.setTel(rs.getString(6));
				ub.setPostcode(rs.getString(7));
	ub.setAddress(rs.getString(8));			ub.setSex(rs.getString(9));
				ub.setBirthday(rs.getString(10));
	}
			
	if(rs.getString(2).equals(ub.getEmail()) && rs.getString(3).equals(ub.getPass())){
	judge=true;			}else{
		judge=false;
	}
		}catch(SQLException e){
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
	return judge;
}
	
public UserBean getUser(String uid){
		
		PreparedStatement st = null;
		Connection cn = null;
		ResultSet rs = null;
		
		UserBean  ub = new UserBean();
		
		try{
			cn = OracleConnectionManager.getInstance().getConnection();
			
			String sql = "SELECT * from user_table where user_id='" + id + "'";
			
								st = cn.prepareStatement(sql);
							rs = st.executeQuery();
			
			rs.next();
					
			ub.setId(rs.getString(1));
			ub.setFirstName(rs.getString(2));
			ub.setLastName(rs.getString(3));
			ub.setEmail(rs.getString(4));
			ub.setPass(rs.getString(5));
			ub.setTel(rs.getString(6));
ub.setPostcode(rs.getString(7));
	ub.setAddress(rs.getString(8));
	ub.setSex(rs.getString(9));
	ub.setBirthday(rs.getString(10));
			
		}catch(SQLException e){	OracleConnectionManager.getInstance().rollback();
			e.printStackTrace();
			throw new ResourceAccessException(e.getMessage(), e);
		}finally{
			try{				if(st!=null){
		st.close();
		}
			}catch(SQLException e){		e.printStackTrace();
				throw new ResourceAccessException(e.getMessage(), e);
			}
		}
		return ub;
	}
	public void DeleteUser(String uid){
		Connection cn = null;
		PreparedStatement st = null;
		
		boolean judge = false;try{
			cn = OracleConnectionManager.getInstance().getConnection();			
			String sql = "DELETE from user_table where user_id='"+uid+"'";
			
			st = cn.prepareStatement(sql);
			st.executeUpdate();			
		}catch(SQLException e){
			OracleConnectionManager.getInstance().rollback();
		}finally{
			try{				if(st!=null){
			st.close();
				}
			}catch(SQLException e){
			e.printStackTrace();
	}
	}
}
	public boolean checkEmail(UserBean ub){
		
	ResultSet rs =null;
	Connection cn = null;		PreparedStatement ps = null;
		
		boolean judge = false;
		
		try {	cn = OracleConnectionManager.getInstance().getConnection();
			String sql = "select user_id,user_email,user_tel from user_table where user_email='" + u.getEmail() + "'and user_tel='" + u.getTel()+"'";	ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			rs.next();
			ub.setUid(rs.getString(1));
						if(rs.getString(2).equals(ub.getEmail()) && rs.getString(3).equals(ub.getTel())){
				judge=true;
			}
			else{
				judge=false;}
					}catch(SQLException e){
			
			e.printStackTrace();
		}finally{
			try{	if(ps != null){
					ps.close();
	ps = null;			}
			}catch(SQLException e){
	e.printStackTrace();
			}
	}
	return judge;
}
	public void OracleUpdate(String sql){
		Connection cn = null;
		PreparedStatement st = null;		try{
			cn = OracleConnectionManager.getInstance().getConnection();
			st = cn.prepareStatement(sql);
			st.executeUpdate();		}catch(SQLException e){
			OracleConnectionManager.getInstance().rollback();
			e.printStackTrace();
		}finally{			try{
				if(st!= null){
					st.close();
				}			}catch(SQLException ex){
				ex.printStackTrace();
			}		}
	}	
	public void EditUser(UserBean ub){
		
	PreparedStatement st = null;
	Connection cn = OracleConnectionManager.getInstance().getConnection();
			
	try{			String sql = "UPDATE user_table SET user_firstname = ?, user_lastname = ?, user_email = ?, user_tel = ?, user_postcode = ?, user_address = ?, user_sex = ?, user_birthday = ? where user_id = '"+ ub.getUid() + "'";
				st = cn.prepareStatement(sql);			st.setString(1,ub.getFirsname());
			st.setString(2,ub.getLastname());
			st.setString(3,ub.getEmail());
			st.setString(4,ub.getTel());			st.setString(5,ub.getPostcode());
			st.setString(6,ub.getAddress());
			st.setString(7,ub.getSex());			st.setString(8,ub.getBirthday());			st.executeUpdate();
			
		}catch(SQLException e){
		try{
				cn.rollback();
		}catch(SQLException e2){
				throw new ResourceAccessException(e2.getMessage(), e2);
			}
	throw new ResourceAccessException(e.getMessage(), e);
		}
	}
	
public void PasswordReplace(UserBean ub){
		
PreparedStatement st = null;
	ResultSet rs = null;
		Connection cn = null;
				try{
		cn = OracleConnectionManager.getInstance().getConnection();
			
	String sql = "UPDATE user_table set user_pass = ? where user_id = ?";
			
			st = cn.prepareStatement(sql);
		
		st.setString(1,ub.getPass());
		st.setString(2,ub.getUid());
		
	st.executeUpdate();		
		}catch(SQLException e){
			
			e.printStackTrace();
			b = false;
		}finally{
			try{				if(rs != null){
					rs.close();}
				if(st != null){					st.close();
				}			}catch(SQLException e){
				e.printStackTrace();
			}
		}	}
		public boolean CheckPassword(UserBean ub){
		
		ResultSet rs =null;
	Connection cn = null;	PreparedStatement st = null;
			
		boolean judge= false;		try {
			cn = OracleConnectionManager.getInstance().getConnection();
			String sql = "select user_id,user_email,user_pass from user_table where user_id='" + ub.getId() + "' and user_email='" + ub.getEmail() + "'and user_pass='" + ub.getPass()+"'";
			
			st = cn.prepareStatement(sql);			rs = st.executeQuery();
			
			rs.next();
			
			ub.setUid(rs.getString(1));
			
			if(rs.getString(2).equals(ub.getEmail()) && rs.getString(3).equals(ub.getPass())){
								judge = true;
			}else{judge = false;
			}		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(st != null){
					st.close();		st = null;
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}		return judge;
	}
}
