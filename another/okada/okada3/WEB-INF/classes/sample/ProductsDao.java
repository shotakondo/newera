package dao;

import java.util.List;

import beans.Product;

public interface ProductsDao{
	
	public void addProduct(Product p);
	public Product getProduct(String pid);
	public List getAllProducts();
	
}