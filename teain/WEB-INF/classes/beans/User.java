package beans;

import java.io.Serializable;

public class User implements Serializable
{
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String pass;
	private String tel;
	private String postcode;
	private String address;
	private String sex;
	private String birthday;
	
	
	
	
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	
	
	
	
	public String getFirstName(){
		return firstName;
	}
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	
	
	
	public String getLastName(){
		return lastName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
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
	
	
	
	
	
	
	