package command;

import dao.*;
import beans.*;
import context.*;


public class PasswordReplaceCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		
		OracleConnectionManager.getInstance().beginTransaction();
		
		User ub = (User) reqc.getSessionAttribute("userBean");
		
		
		String[] emails = reqc.getParameter("email");
		String email = emails[0];
		
		
		String[] passs = reqc.getParameter("pass1");
		String pass = passs[0];
		
		
		// String[] vals = reqc.getUrlParameter();
		
		// String val = vals[0];
		
		System.out.println("PasswordReplaceCommand User : "+ub);
		ub.setEmail(email);
		System.out.println("PasswordReplaceCommand setEmail : "+email);
		ub.setPass(pass);
		System.out.println("PasswordReplaceCommand setPass : "+pass);
		
		
		System.out.println("PasswordReplaceCommand getId : " + ub.getId());
		System.out.println("PasswordReplaceCommand getPass : " + ub.getPass());
		System.out.println("PasswordReplaceCommand getEmail : " + ub.getEmail());
		
		
		// String[] vals = reqc.getUrlParameter();
		
		// String val = vals[0];
		
		// u.setId(val);
		// System.out.println("PasswordReplaceCommand setId : "+val);		
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		UserDao ud = factory.getUserDao();
		boolean b = ud.PasswordReplace(ub);
		System.out.println("PasswordReplace boolean 確認した" + b);
		if(b == true){
			reqc.getSession();
			reqc.setSessionAttribute("userBean",ub);
			System.out.println("sessionAttribute Request");

			resc.setTarget("login");
		}else{
			resc.setTarget("error");
			System.out.println("ログインできないよ");
		}
		OracleConnectionManager.getInstance().commit();
		
		OracleConnectionManager.getInstance().closeConnection();
		reqc.setRemoveAttribute("userBean");
		return resc;
	}
}
		
		


