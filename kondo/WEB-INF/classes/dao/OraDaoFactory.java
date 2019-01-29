package dao;

public class OraDaoFactory extends AbstractDaoFactory{
	
	public ProductDao getProductDao(){
		return new OraProductDao();
	}
	public RecordDao getRecordDao(){
		return new OraRecordDao();
	}
	public UserDao getUserDao(){
		return new OraUserDao();
	}
	public CartDao getCartDao(){
		return new OraCartDao();
	}
	public FavoriteDao getFavoriteDao(){
		return new OraFavoriteDao();
	}
}