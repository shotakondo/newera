package db;

import sql.*;

public class UserInsert{
	public ArrayList<UserBeans> userInsert(UserBeans ub){
		ArrayList<UserBeans> userList = new ArrayList<UserBeans>();
		
		getConnection();
		
		String sql = "insert into dummy_user_table(user_id, user_mail, user_pass) values (dummy_user_seq.nextval, ?, ?);
		
		st = conn.prepareStatement(sql);
		
		st.setString(1, ub.getUserMail());
		st.setString(2, ub.getUserPass());
		
	}
}