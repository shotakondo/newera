package dao;

public class OraDaoFactory extends AbstractDaoFactory{
	
	public ProductDao getProductDao(){
		return new OraProductDao();
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
	public StockDao getStockDao(){
		return new OraStockDao();
	}
	public OrderDao getOrderDao(){
		return new OraOrderDao();
	}
	public DetailDao getDetailDao(){
		return new OraDetailDao();
	}
	
}