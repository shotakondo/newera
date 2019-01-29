package dao;

import java.util.List;
import beans.*;

public abstract class AbstractDao implements ProductDao, RecordDao, UserDao, CartDao, FavoriteDao{
	
	public abstract void addProduct(ProductBean pb);
	public abstract ProductBean getProduct(String pid);
	public abstract List getAllProducts();
	public abstract List getProducts();
	public abstract List getProductsName();
	public abstract List getProductsCheap();
	public abstract List getProductsExpensive();
	
	
	public abstract void addRecord(RecordBean rb);
	public abstract RecordBean getRecord(String pid, String uid);
	public abstract List getAllRecords();
	
	public abstract String authUser(String email, String pass);
	public abstract UserBean selectUser(String email);
	public abstract void insertUser(UserBean ub);
	
	public abstract List getCart(List pidlist);
	
	public abstract List getFavorites(String email);
	public abstract void setFavorite(String pid, String email);
	
}