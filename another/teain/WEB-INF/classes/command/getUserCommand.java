package command;
import java.util.List;

import dao.*;
import context.*;
import beans.*;

public class getUserCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		OracleConnectionManager.getInstance().beginTransaction();
		User u = (User) reqc.getSessionAttribute("userBean");
		//System.out.println("User u = (User) reqc.getSessionAttribute("userBean")"+u);
		String id = u.getId();
		System.out.println(id);
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		UserDao dao=factory.getUserDao();
		
		List l=dao.getUser(id);
		
		resc.setResult(l);

		resc.setTarget("view");
		return resc;

	}
}
