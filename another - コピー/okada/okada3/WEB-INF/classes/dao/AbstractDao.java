package dao;

import java.util.ArrayList;
import java.util.List;
import beans.*;

public abstract class AbstractDao implements ProductDao, UserDao, CartDao, FavoriteDao, StockDao, OrderDao, DetailDao{
	
	public abstract void addProduct(ProductBean pb);
	public abstract ProductBean getProduct(String pid);
	public abstract List getAllProducts();
	public abstract List getProductsWord();
	public abstract List getProductsName();
	public abstract List getProductsCheap();
	public abstract List getProductsExpensive();
	
	public abstract String authUser(String email, String pass);

	
	public abstract CartBean addCart(CartBean cb);
	
	public abstract List getFavorites(String id);
	public abstract void setFavorite(String id, String pid);
	public abstract void deleteFavorite(String id, String pid);
	public abstract void alterFavorite(String id, String pid);
	
	public abstract int getStock(String pid);
	public abstract void setStock(int num, String pid);
	public abstract void alterStock(int num, String pid);
	
	public abstract String getSequence();
	public abstract void setOrder(String sq, String id, String method, int total);
	public abstract List getOrders(String id);
	
	public abstract void setDetail(String sq, ProductBean pb);
	
}