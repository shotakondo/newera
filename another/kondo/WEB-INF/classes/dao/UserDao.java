package dao;

import beans.UserBean;

public interface UserDao{
	
	public String authUser(String email, String pass);
	public UserBean selectUser(String email);
	public void insertUser(UserBean ub);
	public void updateUser(UserBean ub);
	
}