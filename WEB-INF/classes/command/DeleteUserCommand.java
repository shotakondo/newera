package command;
import java.util.List;

import dao.*;
import context.*;
import beans.*;

public class DeleteUserCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		OracleConnectionManager.getInstance().beginTransaction();
		boolean b = reqc.attributeCheck("userBean");
		System.out.println("DeleteCommandAttributeCheck" + b);
		User u = (User) reqc.getSessionAttribute("userBean");
		System.out.println((User) reqc.getSessionAttribute("userBean"));
		String id = u.getId();
		System.out.println(id);
		
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		UserDao dao=factory.getUserDao();
		
		dao.DeleteUser(id);
		reqc.setRemoveAttribute("userBean");
		System.out.println("‘Þ‰ï‚µ‚Ü‚µ‚½");
		resc.setTarget("start");
		return resc;
	}
}
