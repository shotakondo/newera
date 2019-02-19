package command;

import dao.*;
import beans.*;
import context.*;


public class LogoutCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		
		OracleConnectionManager.getInstance().beginTransaction();
		//User u = new User();
		
		//AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		//UserDao ud = factory.getUserDao();
		
		reqc.setRemoveAttribute("userBean");
		System.out.println("ログアウトしました");
		resc.setTarget("logout");
		return resc;
	}
}
		
		


