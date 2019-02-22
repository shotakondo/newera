package dao;

import java.util.ArrayList;
import java.util.List;
import beans.ProductBean;

public interface ProductDao{
	
	public void addProduct(ProductBean pb);
	public ProductBean getProduct(String pid);
	public List getAllProducts();
	public List getProductsWord(String pw);
	public List getProductsName();
	public List getProductsCheap();
	public List getProductsExpensive();
}