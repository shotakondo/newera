//使ってる
//propertie名 : jumppassreplace




package command;

import dao.*;
import beans.*;
import context.*;

public class PasswordReplaceJumpCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		User u = new User();
		
		String[] vals = reqc.getUrlParameter();
		
		String val = vals[0];
		
		u.setId(val);
		System.out.println("PasswordReplaceJumpCommand setId : "+u.getId());
		
		
		reqc.setSessionAttribute("userBean",u);
		User ub = (User) reqc.getSessionAttribute("userBean");
		System.out.println("パスワードリマインダー"+(User) reqc.getSessionAttribute("userBean"));
		
		
		
		resc.setTarget("newemail");
		return resc;
	}
}


