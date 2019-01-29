package beans;

import java.io.Serializable;

public class User implements Serializable {
	private String email;
	private String pass;
	private String id;
	private String sei;
	private String mei;
	private String tel;
	private String birthday;
	public User(String email, String pass, String id, String sei, String mei, String tel, String birthday) {
			super();
			this.email = email;
			this.pass = pass;
			this.id = id;
			this.sei = sei;
			this.mei = mei;
			this.tel = tel;
			this.birthday  = birthday;
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

		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
	public String getSei(){
		return sei;
	}
	public void setSei(String sei){
		this.sei = sei;
	}

	public String getMei(){
		return mei;
	}
	public void setMei(String mei){
		this.mei = mei;
	}

	public String getTel(){
		return tel;
	}
	public void setTel(String tel){
		this.tel = tel;
	}

	public String getBirthday(){
		return birthday;
	}
	public void setBirthday(String birthday){
		this.birthday = birthday;
	}
		public String toString() {
			return "User [email=" + email + ", pass=" + pass + ", ID=" + id + "]";
		}
		
}
