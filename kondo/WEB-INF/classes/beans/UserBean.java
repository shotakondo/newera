//package
package beans;

//import
import java.io.Serializable;

//UserBeanƒNƒ‰ƒX
public class UserBean implements Serializable{
	
	private String uid;
	private String firstname;
	private String lastname;
	private String email;
	private String pass;
	private String tel;
	private String postcode;
	private String address;
	private String sex;
	private String birthday;
	
	public String getUid(){
		return uid;
	}
	public void setUid(String uid){
		this.uid = uid;
	}
	public String getFirstname(){
		return firstname;
	}
	public void setFirstname(String firstname){
		this.firstname = firstname;
	}
	public String getLastname(){
		return lastname;
	}
	public void setLastname(String lastname){
		this.lastname = lastname;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getPass(){
		return pass;
	}
	public void setPass(String pass){
		this.pass = pass;
	}
	public String getTel(){
		return tel;
	}
	public void setTel(String tel){
		this.tel = tel;
	}
	public String getPostcode(){
		return postcode;
	}
	public void setPostcode(String postcode){
		this.postcode = postcode;
	}
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public String getSex(){
		return sex;
	}
	public void setSex(String sex){
		this.sex = sex;
	}
	public String getBirthday(){
		return birthday;
	}
	public void setBirthday(String birthday){
		this.birthday = birthday;
	}
}