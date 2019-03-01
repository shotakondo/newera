package command;

import dao.*;
import exe.*;
import beans.UserBean;

public class PassReplaceCommand extends AbstractCommand{
	
	//パスワード置き換え機能
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		boolean judge = false;
		
		String[] emails = reqc.getParameter("email");
		String email = emails[0];
		String[] passs = reqc.getParameter("pass");
		String pass = passs[0];
		
		UserBean ub = (UserBean) reqc.getSessionAttribute("ub");
		
		ub.setEmail(email);
		ub.setPass(pass);
		
		OracleConnectionManager.getInstance().beginTransaction();
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		UserDao ud = factory.getUserDao();
		
		ud.PasswordReplace(ub);
		judge = ud.CheckPassword(ub);
		
		if(judge == true){
			reqc.setRemoveAttribute("ub");
			resc.setTarget("login");
		}else{
			resc.setTarget("error");
		}
		OracleConnectionManager.getInstance().commit();
		
		OracleConnectionManager.getInstance().closeConnection();
		
		return resc;
	}
}
