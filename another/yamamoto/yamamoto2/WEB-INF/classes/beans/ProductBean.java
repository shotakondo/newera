//package
package beans;

//import
import java.io.Serializable;

//ProductBeanƒNƒ‰ƒX
public class ProductBean implements Serializable{
	
	private String pid;
	private String name;
	private String price;
	private String path;
	private String num;
	
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
	public String getPrice(){
		return price;
	}
	public void setPrice(String price){
		this.price = price;
	}
	public String getPath(){
		return path;
	}
	public void setPath(String path){
		this.path = path;
	}
	public String getNum(){
		return num;
	}
	public void setNum(String num){
		this.num = num;
	}
	
}