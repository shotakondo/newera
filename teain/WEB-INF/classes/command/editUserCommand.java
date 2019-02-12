package command;
import java.util.List;

import dao.*;
import context.*;
import beans.*;

public class editUserCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		OracleConnectionManager.getInstance().beginTransaction();
		User u = (User) reqc.getSessionAttribute("userBean");
		
		String[] firstnames = reqc.getParameter("firstname");
		String firstname = firstnames[0];
		System.out.println("String[] firstnames"+firstname);
		
		String[] lastnames = reqc.getParameter("lastname");
		String lastname = lastnames[0];
		System.out.println("String[] lastnames"+lastname);
		
		String[] emails = reqc.getParameter("email");
		String email = emails[0];
		System.out.println("String[] emails"+email);
		
		String[] tels = reqc.getParameter("tel");
		String tel = tels[0];
		System.out.println("String[] tels"+tel);
		
		String[] postcodes = reqc.getParameter("postcode");
		String postcode = postcodes[0];
		System.out.println("String[] postcodes"+postcode);
		
		String[] addresss = reqc.getParameter("address");
		String address = addresss[0];
		System.out.println("String[] addresss"+address);
		
		String[] sexs = reqc.getParameter("sex");
		String sex = sexs[0];
		System.out.println("String[] sexs"+sex);
		
		String[] birthdays = reqc.getParameter("birthday");
		String birthday = birthdays[0];
		System.out.println("String[] birthdays"+birthday);
		
		u.setFirstName(firstname);
		u.setLastName(lastname);
		u.setEmail(email);
		u.setTel(tel);
		u.setPostcode(postcode);
		u.setAddress(address);
		u.setSex(sex);
		u.setBirthday(birthday);
		
		String id = u.getId();
		System.out.println("editUser"+id);
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		UserDao dao=factory.getUserDao();
		
		List array=dao.editUser(u);
		
		resc.setResult(array);

		resc.setTarget("view");
		return resc;

	}
}
