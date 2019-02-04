package dao;

import java.io.InputStream;
import java.util.List;

import beans.User;

public interface UserDao{
	public void createUser(User u);
	public boolean checkLogin(User u);
	public boolean DeleteUser(String id);
	public List getUser(String id);

}