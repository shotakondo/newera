//package
package beans;

//import
import java.io.Serializable;

//RecordBeanƒNƒ‰ƒX
public class RecordBean implements Serializable{
	
	private String pid;
	private String uid;
	private String name;
	private String price;
	private String uname;
	private String date;
	
	public String getPid(){
		return pid;
	}
	public void setPid(String pid){
		this.pid = pid;
	}
	public String getUid(){
		return uid;
	}
	public void setUid(String uid){
		this.uid = uid;
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
	public String getUname(){
		return uname;
	}
	public void setUname(String uname){
		this.uname = uname;
	}
	public String getDate(){
		return date;
	}
	public void setDate(String date){
		this.date = date;
	}
}