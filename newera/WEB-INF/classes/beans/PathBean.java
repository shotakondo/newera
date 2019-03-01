//package
package beans;

//import
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

//ProductBeanƒNƒ‰ƒX
public class PathBean implements Serializable{
	
	private String path;
	
	public PathBean(){}
	
	public String getPath(){
		return path;
	}
	public void setPath(String path){
		this.path = path;
	}
}