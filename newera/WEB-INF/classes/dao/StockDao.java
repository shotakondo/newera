package dao;

import java.util.List;

public interface StockDao{
	
	public int getStock(String pid);
	public void setStock(int num, String pid);
	public void alterStock(int num, String pid);
	
}