//package
package beans;

//import
import java.io.Serializable;

//ProductBeanƒNƒ‰ƒX
public class FavoriteBean implements Serializable{
	
	private String pid;
	private String name;
	private String price;
	private String path;
	private String date;
	private String comment;
	
	public FavoriteBean(){}
	
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
	public String getDate(){
		return date;
	}
	public void setDate(String date){
		this.date = date;
	}
	public String getComment(){
		return comment;
	}
	public void setComment(String comment){
		this.comment = comment;
	}
	
}