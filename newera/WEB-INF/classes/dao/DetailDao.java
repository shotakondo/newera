package dao;

import beans.ProductBean;

public interface DetailDao{
	
	public void setDetail(String sq, ProductBean pb);
	public void deleteDetails(String oid);
	
}