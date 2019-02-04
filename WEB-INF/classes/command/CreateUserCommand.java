package command;

import dao.*;
import java.util.List;

import context.*;
import beans.User;

public class CreateUserCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		
		OracleConnectionManager.getInstance().beginTransaction();
		
		// String[] ids = reqc.getParameter("id");
		// String id = ids[0];
			
		String[] firstNames = reqc.getParameter("firstname");
		String firstName = firstNames[0];
		
		String[] lastNames = reqc.getParameter("lastname");
		String lastName = lastNames[0];
		
		String[] emails = reqc.getParameter("email");
		String email = emails[0];
		
		String[] passs = reqc.getParameter("pass");
		String pass = passs[0];
		
		String[] tels = reqc.getParameter("tel");
		String tel = tels[0];
		
		String[] postcodes = reqc.getParameter("postcode");
		String postcode = postcodes[0];
		
		String[] addresss = reqc.getParameter("address");
		String address = addresss[0];
		
		
		String[] sexs = reqc.getParameter("sex");
		String sex = sexs[0];
		
		
		String[] birthdays = reqc.getParameter("birthday");
		String birthday = birthdays[0];
		
		
		
		User u = new User();
	
		// u.setId(id);
		// System.out.println("setid : " + id);
		
		
		
		u.setFirstName(firstName);
		System.out.println("setfname : " +firstName);
		u.setLastName(lastName);
		System.out.println("setlname : " + lastName);
		u.setEmail(email);
		System.out.println("setemail : " + email);
		u.setPass(pass);
		System.out.println("setpass : " + pass);
		u.setTel(tel);
		System.out.println("settel : " + tel);
		u.setPostcode(postcode);
		System.out.println("setpostcode : " + postcode);
		u.setAddress(address);
		System.out.println("setaddress : " + address);
		u.setSex(sex);
		System.out.println("setsex : " + sex);
		u.setBirthday(birthday);
		System.out.println("birthday : " + birthday);
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		UserDao userdao = factory.getUserDao();
		userdao.createUser(u);
		
		
		// List products = dao.getSelect();
		// resc.setResult(products);
		
		
		
		OracleConnectionManager.getInstance().commit();
		System.out.println("createcommit");
		
		OracleConnectionManager.getInstance().closeConnection();
		
		
		resc.setTarget("start");
		
		return resc;
	}
}