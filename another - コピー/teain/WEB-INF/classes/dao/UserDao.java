package dao;

import java.util.List;

import beans.User;

public interface UserDao{
	public void createUser(User u);
	public void OracleUpdate(String sql);
	public boolean checkLogin(User u);
	public boolean DeleteUser(String id);
	
	public boolean checkEmail(User u);
	public List getUser(String id);
	public List editUser(User u);
	
	public boolean PasswordReplace(User u);
	public boolean EmailReplace(User u);
	public boolean checkPassword(User u);

}