package dao;

import java.sql.ResultSet;

import beans.User;
import dao.OracleConnectionManager;

public class OraUserDao implements UserDao{
	public boolean creatUser(Object obj) {
		User u = (User) obj;
		try {
			new OracleConnectionManager().getSQL("insert into usertable values('"+u.getEmail()+"','"+u.getPass()+"','"+u.getId()+"','"+u.getSei()+"','"+u.getMei()+"','"+u.getTel()+"','"+u.getBirthday()+"','"u.getPostcode()+"','"u.getSex()+"')");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public User getUser(String email){
		try {
			ResultSet  rs=new OracleConnectionManager().getResultSet("select * from usertable where Email='"+email+"'");
			 while(rs.next()){
			 	
				String user = rs.getString(1);
				String pass = rs.getString(2);
				String id = rs.getString(3);
			 	String sei = rs.getString(4);
				String mei = rs.getString(5);
				String tel = rs.getString(6);
				String birthday = rs.getString(7);
			 	String postcode = rs.getString(8);
			 	String sex = rs.getString(9);
				return new User(user,pass,id,sei,mei,tel,birthday,postcode,sex);
			 }
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
		
	}
	
	public boolean checkLogin(String email,String pass) {
		
		try {
			ResultSet  rs=new OracleConnectionManager().getResultSet("select * from usertable where email='"+email+"'");
			 while(rs.next()){
				 if(rs.getString(1).equals(email) && rs.getString(2).equals(pass)){
					 return true;
				 }
			 	else{
			 		return false;
			 	}
			 }
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		return false;
	}
	public boolean checkEmail(String email,String tel) {
		
		try {
			ResultSet  rs=new OracleConnectionManager().getResultSet("select * from usertable where email='"+email+"'");
			 while(rs.next()){
				 if(rs.getString(1).equals(email) && rs.getString(2).equals(tel)){
					 return true;
				 }
			 }
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		return false;
	}
	//public static void main(String[] args) {
	//	User u = new User("theanh@gmail.com", "123", "ANH", " TOKYO", "VIP", "111-2222-3333", "2018/02");
	//	System.out.println(new OraUserDao().checkLogin("theanh@gmail.com", "123"));
//	}
}
