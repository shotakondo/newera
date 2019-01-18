package dao;

import java.io.InputStream;
import java.util.List;

import beans.User;

public interface UserDao{
	public void createUser(User u);
	public User getUser(String email, String pass);

}