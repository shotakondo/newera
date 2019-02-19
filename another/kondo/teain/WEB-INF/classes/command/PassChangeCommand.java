package command;

import dao.*;
import exe.*;
import beans.UserBean;

public class PassChangeCommand extends AbstractCommand{
	
	//パスワード変更機能
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		boolean judge = false;
		
		String[] emails = reqc.getParameter("email");
		String email = emails[0];
		String[] oldpasss = reqc.getParameter("oldpass");
		String oldpass = oldpasss[0];
		String[] newpasss = reqc.getParameter("newpass");
		String newpass = newpasss[0];
		
		UserBean ub = (UserBean) reqc.getSessionAttribute("ub");
		
		ub.setEmail(email);
		ub.setPass(oldpass);
		
		OracleConnectionManager.getInstance().beginTransaction();
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		UserDao ud = factory.getUserDao();
		
		judge = ud.CheckPassword(ub);
		
		if(judge == true){
			
			ub.setPass(newpass);
			ud.PasswordReplace(ub);
			
			reqc.setSessionAttribute("ub",ub);
			resc.setTarget("home");
			
		}else{
			resc.setTarget("error");
		}
		
		OracleConnectionManager.getInstance().commit();
		
		OracleConnectionManager.getInstance().closeConnection();
		
		return resc;
	}
}
