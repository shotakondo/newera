package command;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import context.*;
import beans.*;


public class LogoutCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
	
		reqc.sessionInvalidate();
		User u = new User();
		reqc.setSessionAttribute("userBean", u);
		
		System.out.println("ログアウトしました");
		resc.setTarget("logout");
		return resc;
	}
}
		
		


