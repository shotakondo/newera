package command;

import java.util.List;

import dao.*;
import exe.*;
import beans.UserBean;

public class EditUserCommand extends AbstractCommand{
	
	//ユーザー編集機能
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		UserBean ub = (UserBean) reqc.getSessionAttribute("ub");
		
		String[] firstnames = reqc.getParameter("firstname");
		String firstname = firstnames[0];
		String[] lastnames = reqc.getParameter("lastname");
		String lastname = lastnames[0];
		String[] emails = reqc.getParameter("email");
		String email = emails[0];
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
		
		ub.setFirstname(firstname);
		ub.setLastname(lastname);
		ub.setEmail(email);
		ub.setTel(tel);
		ub.setPostcode(postcode);
		ub.setAddress(address);
		ub.setSex(sex);
		ub.setBirthday(birthday);
		
		OracleConnectionManager.getInstance().beginTransaction();
		
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		UserDao ud=factory.getUserDao();
		
		List ul = ud.editUser(ub);
		
		resc.setResult(ul);

		resc.setTarget("view");
		
		return resc;
	}
}
