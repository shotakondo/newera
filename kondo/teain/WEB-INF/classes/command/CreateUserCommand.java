package command;

import java.util.List;

import dao.*;
import exe.*;

import beans.User;

public class CreateUserCommand extends AbstractCommand{
	
	//ユーザー作成機能
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		String[] uids = reqc.getParameter("uid");
		String uid = uids[0];
		String[] firstnames = reqc.getParameter("firstname");
		String firstname = firstnames[0];
		String[] lastnames = reqc.getParameter("lastname");
		String lastname = lastnames[0];
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
		
		UserBean ub = new UserBean();
	
		ub.setUid(uid);
		ub.setFirstname(firstname);
		ub.setLastname(lastname);
		ub.setEmail(email);
		ub.setPass(pass);
		ub.setTel(tel);
		ub.setPostcode(postcode);
		ub.setAddress(address);
		ub.setSex(sex);
		ub.setBirthday(birthday);
		
		OracleConnectionManager.getInstance().beginTransaction();
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		UserDao ud = factory.getUserDao();
		ud.createUser(ub);
		
		OracleConnectionManager.getInstance().commit();
		
		OracleConnectionManager.getInstance().closeConnection();
		
		resc.setTarget("toppage");
		
		return resc;
	}
}