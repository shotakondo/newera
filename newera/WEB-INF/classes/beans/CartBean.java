package beans;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

public class CartBean implements Serializable{
	
	private ArrayList _products =new ArrayList();
	private int subtotal;
	
	public CartBean(){}
	
	public void addProduct(ProductBean product){
		
		boolean judge = false;
		int num = 1;
		
		for(int i = 0; i < getProducts().size(); i++){
			
			ProductBean pb = (ProductBean)getProducts().get(i);
			System.out.println("ループ内");
			if(pb.getPid().equals(product.getPid())){
				System.out.println(pb.getPid()+"pb.getPid()"+product.getPid()+"product.getPid()");
				num = pb.getNum() + 1;
				judge = true;
				System.out.println(num);
				pb.setNum(num);
			}
		}
		
		
		if(judge == false){
		product.setNum(num);
			_products.add(product);
		}
	}
	
	public void deleteProduct(String pid){
		
		for(int i = 0; i < getProducts().size(); i++){
			
			ProductBean pb = (ProductBean)_products.get(i);
			
			if(pb.getPid().equals(pid)){
				_products.remove(_products.indexOf(_products.get(i)));
			}
		}
	}
	public void alterProductsNum(int[] numlist){
		System.out.println("中");
		System.out.println(getProducts().size());
		for(int i = 0; i < getProducts().size(); i++){
			ProductBean pb = (ProductBean)_products.get(i);
			pb.setNum(numlist[i]);
			System.out.println(pb.getNum());
		}
		
	}
	
	public void alldeleteProduct(){
		_products.clear();
	}
	
	public void setProduct(ArrayList products){
		this._products=products;
	}
	
	public ArrayList getProducts(){
		return _products;
	}
	public void setSubtotal(int subtotal){
		this.subtotal = subtotal;
	}
	public int getSubtotal(){
		return subtotal;
	}
	
}