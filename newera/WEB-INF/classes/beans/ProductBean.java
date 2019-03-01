//package
package beans;

//import
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

//ProductBeanƒNƒ‰ƒX
public class ProductBean implements Serializable{
	
	private String pid;
	private String name;
	private int price;
	private String path;
	private int num;
	private List paths;
	
	public ProductBean(){}
	
	public String getPid(){
		return pid;
	}
	public void setPid(String pid){
		this.pid = pid;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getPrice(){
		return price;
	}
	public void setPrice(int price){
		this.price = price;
	}
	public int getNum(){
		return num;
	}
	public void setNum(int num){
		this.num = num;
	}
	public String getPath(){
		return path;
	}
	public void setPath(String path){
		this.path = path;
	}
	public List getPaths(){
		return paths;
	}
	public void setPaths(List paths){
		this.paths = paths;
	}
}