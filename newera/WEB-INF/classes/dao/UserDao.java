package dao;

import java.util.List;

import beans.User;

public interface UserDao{
	public boolean createUser(User u);
	public void OracleUpdate(String sql);
	public boolean checkLogin(User u);
	public boolean DeleteUser(String id);
	public void updateUser(User u);
	
	public boolean checkEmail(User u);
	public User getUser(String email, User u);
	public String getUserId(String email);
	public User editUser(String email, User u);
	
	public boolean PasswordReplace(User u);
	public boolean EmailReplace(User u);
	public boolean checkPassword(User u);

}