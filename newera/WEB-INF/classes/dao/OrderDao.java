package dao;

import java.util.List;

public interface OrderDao{
	
	public String getSequence();
	public void setOrder(String sq, String id, String method, int total);
	public List getOrders(String id);
	public void deleteOrders(String uid);
	
}