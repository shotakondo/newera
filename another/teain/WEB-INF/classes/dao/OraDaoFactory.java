package dao;

public class OraDaoFactory extends AbstractDaoFactory{

	/*----------------------------------------------------*/
	
	public UserDao getUserDao(){
		return new OraUserDao();
	}

	
	
}