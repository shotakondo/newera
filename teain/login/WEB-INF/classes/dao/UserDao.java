package dao;

public interface UserDao {
		public boolean creatUser(Object obj);
		public boolean checkLogin(String email,String pass);
		public boolean checkEmail(String email,String tel);
}
