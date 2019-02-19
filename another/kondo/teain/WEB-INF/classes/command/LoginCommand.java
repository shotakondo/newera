package command;

import dao.*;
import exe.*;
import beans.*;

public class LoginCommand extends AbstractCommand{
	
	//ログイン機能
	public ResponseContext execute(ResponseContext resc){
RequestContext reqc = getRequestContext();
String[] emails = reqc.getParameter("email");
String email = emails[0];String[] passs = reqc.getParameter("pass");
String pass = passs[0];UserBean ub = new UserBean();

ub.setEmail(email);
ub.setPass(pass);OracleConnectionManager.getInstance().beginTransaction();
AbstractDaoFactory factory = AbstractDaoFactory.getFactory();UserDao ud = factory.getUserDao();
boolean judge = ud.checkLogin(ub);

OracleConnectionManager.getInstance().commit();

		OracleConnectionManager.getInstance().closeConnection();
		
		if(judge == true){
			reqc.setSessionAttribute("ub",ub);
			resc.setTarget("mypage");
		}else{
			resc.setTarget("login?err=1");
		}
		return resc;
	}
}
