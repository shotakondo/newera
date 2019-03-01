//package
package beans;

//import
import java.io.Serializable;

import java.util.ArrayList;

//ProductBeanƒNƒ‰ƒX
public class OrderBean implements Serializable{
	
	private ArrayList _products =new ArrayList();
	private ArrayList _orders =new ArrayList();
	
	private String date;
	private String oid;
	private String total;
	private String method;
	
	public OrderBean(){}
	
	public String getDate(){
		return date;
	}
	public void setDate(String date){
		this.date = date;
	}
	public String getOid(){
		return oid;
	}
	public void setOid(String oid){
		this.oid = oid;
	}
	public String getTotal(){
		return total;
	}
	public void setTotal(String total){
		this.total = total;
	}
	public String getMethod(){
		return method;
	}
	public void setMethod(String method){
		this.method = method;
	}
	
	public void setProducts(ArrayList products){
		_products=products;
	}
	public ArrayList getProducts(){
		return _products;
	}
	public void setOrders(ArrayList orders){
		_orders=orders;
	}
	public ArrayList getOrders(){
		return _orders;
	}
	
}