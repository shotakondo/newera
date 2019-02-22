/*--------------------------*/
/*createUser 23-81*/
/*CheckLogin 75-119*/
/*getUser 126-173*/
/*CheckEmail 235-279*/
/*EmailReplace 443-482*/
/*--------------------------*/

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
	public boolean createUser(User u){
	
		Connection cn = null;
		PreparedStatement st = null;
		boolean b = false;
		
		
		try{
			
			
			cn = OracleConnectionManager.getInstance().getConnection();
			
			// String sql ="INSERT INTO user_table values('?','?','?','?','?','?','?','?','?','?')";
			
			//String sql = "insert into user_table values(?,?,?,?,?,?,?,?,?,?)";
			//String sql = "insert into user_table(user_id,user_firstname,user_lastname,user_email,user_pass,user_pass,user_tel,user_postcode,user_address,user_sex,user_birthday) values(u.getId.product_seq.nextval,
			String sql = "insert into user_table(user_id, user_firstname, user_lastname, user_email, user_pass, user_tel, user_postcode, user_address, user_sex, user_birthday) values (user_seq.nextval ,? ,?  ,? ,? ,? ,? ,? ,? ,?)";

			
			st = cn.prepareStatement(sql);
			
			
			//st.setString(1,u.getId());
			//System.out.println("id : " + u.getId());
			st.setString(1,u.getFirstName());
			System.out.println("firstname : " + u.getFirstName());
			st.setString(2,u.getLastName());
			System.out.println("lastname : " + u.getLastName());
			st.setString(3,u.getEmail());
			System.out.println("email : " + u.getEmail());
			st.setString(4,u.getPass());
			System.out.println("pass : " + u.getPass());
			st.setString(5,u.getTel());		
			System.out.println("tel : " + u.getTel());
			st.setString(6,u.getPostcode());
			System.out.println("postcode : " + u.getPostcode());
			st.setString(7,u.getAddress());	
			System.out.println("address : " + u.getAddress());
			st.setString(8,u.getSex());	
			System.out.println("sex : " + u.getSex());
			st.setString(9,u.getBirthday());	
			System.out.println("birthday : " + u.getBirthday());
			
			
			st.executeUpdate();
			b = true;
			
		}catch(SQLException e){
			// OracleConnectionManager.getInstance().rollback();
			e.printStackTrace();
			b = false;
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
		return b;
	}
		public boolean checkLogin(User u){
			ResultSet rs =null;
			Connection cn = null;
			PreparedStatement ps = null;
			
			boolean b = false;
		try {
			cn = OracleConnectionManager.getInstance().getConnection();
			String sql = "select user_id,user_email,user_pass, user_firstname, user_lastname, user_tel, user_postcode, user_address, user_sex, user_birthday from user_table where user_email='" + u.getEmail() + "'and user_pass='" + u.getPass()+"'";
			
			ps = cn.prepareStatement(sql);
			System.out.println(sql);
			rs = ps.executeQuery();
			System.out.println("rs");
	
			 while(rs.next()){
			 	//User u = new User();
			 	u.setId(rs.getString(1));
			 	u.setEmail(rs.getString(2));
			 	u.setFirstName(rs.getString(4));
			 	u.setLastName(rs.getString(5));
			 	u.setTel(rs.getString(6));
			 	u.setPostcode(rs.getString(7));
			 	u.setAddress(rs.getString(8));
			 	u.setSex(rs.getString(9));
			 	u.setBirthday(rs.getString(10));
			 	
			 	System.out.println("userのgetId()です。"+u.getId());
			 	
			 	System.out.println("while");
			 	if(rs.getString(2).equals(u.getEmail()) && rs.getString(3).equals(u.getPass())){
			 		System.out.println("while(rs.next)"+ rs.getString(1));
					 b=true;
				 }
			 	else{
			 		System.out.println("else 入りました");
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
	
	public List getUser(String id){
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList ar = new ArrayList();
		System.out.println("getUser入りました");
		
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
	
		public boolean checkEmail(User u){
			ResultSet rs =null;
			Connection cn = null;
			PreparedStatement ps = null;
			
			boolean b = false;
		try {
			cn = OracleConnectionManager.getInstance().getConnection();
			String sql = "select user_id,user_email,user_tel from user_table where user_email='" + u.getEmail() + "'and user_tel='" + u.getTel()+"'";
			System.out.println(u.getId() + u.getEmail() + u.getTel());
			ps = cn.prepareStatement(sql);
			System.out.println("Check Email"+sql);
			rs = ps.executeQuery();
			System.out.println("rs");
	
			 while(rs.next()){
			 	System.out.println("rs.next()に入った");
			 	//User u = new User();
			 	u.setId(rs.getString(1));
			 	System.out.println("userのgetId-CheckEmail()です。"+u.getId());
			 	
			 	
			 	if(rs.getString(2).equals(u.getEmail()) && rs.getString(3).equals(u.getTel())){
			 		System.out.println("while(rs.next)"+ rs.getString(1));
					 b=true;
				 }
			 	else{
			 		System.out.println("else 入りました");
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
	public void OracleUpdate(String sql){
    Connection cn = null;
    PreparedStatement st = null;
    try{
      cn = OracleConnectionManager.getInstance().getConnection();
      st = cn.prepareStatement(sql);
      st.executeUpdate();
    }catch(SQLException e){
      OracleConnectionManager.getInstance().rollback();
      e.printStackTrace();
    }finally{
      try{
        if(st!= null){
           st.close();
         }
      }catch(SQLException ex){
         ex.printStackTrace();
      }
    }
  }


	public List editUser(User u){
		PreparedStatement st = null;
		System.out.println("editUser入りました");
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		ArrayList array = new ArrayList();
		try{
			
			String sql = "UPDATE user_table SET user_firstname = ?, user_lastname = ?, user_email = ?, user_tel = ?, user_postcode = ?, user_address = ?, user_sex = ?, user_birthday = ? where user_id = '"+ u.getId() + "'";
			
			st = cn.prepareStatement(sql);

			st.setString(1,u.getFirstName());
			st.setString(2,u.getLastName());
			st.setString(3,u.getEmail());
			st.setString(4,u.getTel());
			st.setString(5,u.getPostcode());
			st.setString(6,u.getAddress());
			st.setString(7,u.getSex());
			st.setString(8,u.getBirthday());
			array.add(u);
			st.executeUpdate();

		}catch(SQLException e){
		
			try{
				cn.rollback();
			}catch(SQLException e2){
				throw new ResourceAccessException(e2.getMessage(), e2);
			}
			throw new ResourceAccessException(e.getMessage(), e);
		}
		return array;
	}
	
	
	
	
	
	
	public boolean PasswordReplace(User u){
		
		PreparedStatement st = null;
		ResultSet rs = null;
		Connection cn = null;
		boolean b = false;

		try{
			cn = OracleConnectionManager.getInstance().getConnection();

			String sql = "UPDATE user_table set user_pass = ? where user_id = ?";
			
			//UPDATE user_table set user_pass = 'asd' where user_id = 'asdf';
			
			System.out.println("OraUserDao PasswordReplace getPass : "+u.getPass());
			System.out.println("OraUserDao PasswordReplace getId : "+u.getId());
			
			st = cn.prepareStatement(sql);
			
			
			st.setString(1,u.getPass());
			st.setString(2,u.getId());
			
			System.out.println(sql);
			
			
			
			st.executeUpdate();
			
			
			b = true;
			
			}catch(SQLException e){
				
				e.printStackTrace();
				b = false;
			}
			finally{
				try{
					if(rs != null){
						rs.close();
					}
					if(st != null){
						st.close();
					}
				}
				catch(SQLException e){
					e.printStackTrace();
				}
			}
		return b;
	}
	
	
	
	
	
	public boolean checkPassword(User u){
		ResultSet rs =null;
			Connection cn = null;
			PreparedStatement st = null;
			
			boolean b = false;
		try {
				cn = OracleConnectionManager.getInstance().getConnection();
				String sql = "select user_id,user_email,user_pass from user_table where user_id='" + u.getId() + "' and user_email='" + u.getEmail() + "'and user_pass='" + u.getPass()+"'";
				System.out.println("checkPassword id : " + u.getId() +  " email : " + u.getEmail() + " pass : " + u.getPass());
				
				st = cn.prepareStatement(sql);
				
				System.out.println("checkPassword sql : "+sql);
				
				rs = st.executeQuery();
				
			
	
				 while(rs.next()){
					System.out.println("rs.next()に入った");
					//User u = new User();
					u.setId(rs.getString(1));
					System.out.println("daoのcheckpassword user_tableのuser_idをbeanにセットした後のu.getId : "+u.getId());
					
			 	
					if(rs.getString(2).equals(u.getEmail()) && rs.getString(3).equals(u.getPass())){
						
						 b=true;
					 }
					else{
						System.out.println("elseに入りました");
						b=false;
					}
				 }
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
		return b;
		
	}
	
	public boolean EmailReplace(User u){
		
		PreparedStatement st = null;
		ResultSet rs = null;
		Connection cn = null;
		boolean b = false;

		try{
			cn = OracleConnectionManager.getInstance().getConnection();

			String sql = "UPDATE user_table set user_email = ? where user_id = ?";
			
			System.out.println("OraUserDao EmailReplace getEmail : "+u.getEmail());
			System.out.println("OraUserDao EmailReplace getId : "+u.getId());
			
			st = cn.prepareStatement(sql);
			
			
			st.setString(1,u.getEmail());
			st.setString(2,u.getId());
			
			System.out.println(sql);
			
			
			
			st.executeUpdate();
			
			
			b = true;
			
			}catch(SQLException e){
				
				e.printStackTrace();
				b = false;
			}
			finally{
				try{
					if(rs != null){
						rs.close();
					}
					if(st != null){
						st.close();
					}
				}
				catch(SQLException e){
					e.printStackTrace();
				}
			}
		return b;
	}
		
	public void updateUser(User u){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		
		try{
			//select文
			String sql = "update user_table set user_firstname = ?, user_lastname = ?, user_email = ?, user_pass = ?, user_tel = ?, user_postcode = ?, user_address = ?, user_sex = ? where user_email = '"+ u.getEmail() + "'";
			
			//PreparedStatementインターフェイスを実装するクラスの
			//インスタンスを取得する
			st = cn.prepareStatement(sql);
			
			//パラメータをセットする
			st.setString(1,u.getFirstName());
			System.out.println("firstname : " + u.getFirstName());
			st.setString(2,u.getLastName());
			System.out.println("lastname : " + u.getLastName());
			st.setString(3,u.getEmail());
			System.out.println("email : " + u.getEmail());
			st.setString(4,u.getPass());
			System.out.println("pass : " + u.getPass());
			st.setString(5,u.getTel());		
			System.out.println("tel : " + u.getTel());
			st.setString(6,u.getPostcode());
			System.out.println("postcode : " + u.getPostcode());
			st.setString(7,u.getAddress());	
			System.out.println("address : " + u.getAddress());
			st.setString(8,u.getSex());	
			System.out.println("sex : " + u.getSex());
			st.setString(9,u.getBirthday());	
			System.out.println("birthday : " + u.getBirthday());
			
			
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
