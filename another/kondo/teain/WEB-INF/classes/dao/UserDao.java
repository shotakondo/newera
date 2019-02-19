package dao;

import java.util.List;

import beans.UserBean;

public interface UserDao{
	public void createUser(UserBean ub);
	public void OracleUpdate(String sql);
	public boolean checkLogin(UserBean ub);
	public void DeleteUser(String uid);
	
	public boolean checkEmail(UserBean ub);
	public List getUser(String uid);
	public List editUser(UserBean ub);
	
	public void PasswordReplace(UserBean ub);
	public boolean checkPassword(UserBean ub);

}