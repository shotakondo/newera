package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exp.ResourceAccessException;

import beans.UserBean;

public class OraUserDao implements UserDao{
	
	public String authUser(String email, String pass){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		ResultSet rs = null;
		PreparedStatement st = null;
		String auth = null;
		
		try{
			//select文
			String sql = "select * from user_table where user_email ='"+ email +"' AND user_pass ='"+ pass +"'";
			
			//PreparedStatementインターフェイスを実装するクラスの
			//インスタンスを取得する
			st = cn.prepareStatement(sql);
			
			//SQLの実行
			rs = st.executeQuery();
			
			//パターン別にauth変数に値を代入
			if(rs.next()){
				auth = "ok";
			}
			
		//getConnection, prepareStatement, executeQueryで例外発生の場合
		}catch(SQLException e){
			//ロールバックする
			try{
				cn.rollback();
			}catch(SQLException e2){
				//独自例外にラップして送出する
				throw new ResourceAccessException(e2.getMessage(), e2);
			}
			//独自例外にラップして送出する
			throw new ResourceAccessException(e.getMessage(), e);
		}
		return auth;
	}
	
	public UserBean selectUser(String email){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		ResultSet rs = null;
		PreparedStatement st = null;
		UserBean ub = new UserBean();
		
		try{
			//select文
			String sql = "select * from user_table where user_email ='"+ email+"'";
			
			//PreparedStatementインターフェイスを実装するクラスの
			//インスタンスを取得する
			st = cn.prepareStatement(sql);
			
			//SQLの実行
			rs = st.executeQuery();
			
			rs.next();
			
			ub.setUid(rs.getString(1));
			ub.setFirstname(rs.getString(2));
			ub.setLastname(rs.getString(3));
			ub.setEmail(rs.getString(4));
			ub.setPass(rs.getString(5));
			ub.setTel(rs.getString(6));
			ub.setPostcode(rs.getString(7));
			ub.setAddress(rs.getString(8));
			ub.setSex(rs.getString(9));
			ub.setBirthday(rs.getString(10));
			
		//getConnection, prepareStatement, executeQueryで例外発生の場合
		}catch(SQLException e){
			//ロールバックする
			try{
				cn.rollback();
			}catch(SQLException e2){
				//独自例外にラップして送出する
				throw new ResourceAccessException(e2.getMessage(), e2);
			}
			
			//独自例外にラップして送出する
			throw new ResourceAccessException(e.getMessage(), e);
		}
		return ub;
	}
	
	public void insertUser(UserBean ub){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		
		try{
			//select文
			String sql = "insert into user_table(user_id, user_firstname, user_lastname, user_email, user_pass, user_tel, user_postcode, user_address, user_sex, user_birthday) values (user_sequence.nextval ,? ,?  ,? ,? ,? ,? ,? ,? ,?)";
			
			//PreparedStatementインターフェイスを実装するクラスの
			//インスタンスを取得する
			st = cn.prepareStatement(sql);
			
			//パラメータをセットする
			st.setString(1,ub.getFirstname());
			st.setString(2,ub.getLastname());
			st.setString(3,ub.getEmail());
			st.setString(4,ub.getPass());
			st.setString(5,ub.getTel());
			st.setString(6,ub.getPostcode());
			st.setString(7,ub.getAddress());
			st.setString(8,ub.getSex());
			st.setString(9,ub.getBirthday());
			
			//SQLの実行
			st.executeQuery();
			
		//getConnection, prepareStatement, executeQueryで例外発生の場合
		}catch(SQLException e){
			//ロールバックする
			try{
				cn.rollback();
			}catch(SQLException e2){
				//独自例外にラップして送出する
				throw new ResourceAccessException(e2.getMessage(), e2);
			}
			
			//独自例外にラップして送出する
			throw new ResourceAccessException(e.getMessage(), e);
		}
	}
	
	public void updateUser(UserBean ub){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		
		try{
			//select文
			String sql = "update user_table set user_firstname = ?, user_lastname = ?, user_email = ?, user_pass = ?, user_tel = ?, user_postcode = ?, user_address = ?, user_sex = ? where user_email = '"+ ub.getEmail() + "'";
			
			//PreparedStatementインターフェイスを実装するクラスの
			//インスタンスを取得する
			st = cn.prepareStatement(sql);
			
			//パラメータをセットする
			st.setString(1,ub.getFirstname());
			st.setString(2,ub.getLastname());
			st.setString(3,ub.getEmail());
			st.setString(4,ub.getPass());
			st.setString(5,ub.getTel());
			st.setString(6,ub.getPostcode());
			st.setString(7,ub.getAddress());
			st.setString(8,ub.getSex());
			
			//SQLの実行
			st.executeQuery();
			
		//getConnection, prepareStatement, executeQueryで例外発生の場合
		}catch(SQLException e){
			//ロールバックする
			try{
				cn.rollback();
			}catch(SQLException e2){
				//独自例外にラップして送出する
				throw new ResourceAccessException(e2.getMessage(), e2);
			}
			
			//独自例外にラップして送出する
			throw new ResourceAccessException(e.getMessage(), e);
		}
	}
}