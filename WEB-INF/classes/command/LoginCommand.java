package command;

import dao.*;
import beans.*;
import context.*;


public class LoginCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		
		OracleConnectionManager.getInstance().beginTransaction();
		
		String[] emails = reqc.getParameter("email");
		String email = emails[0];
		
		
		String[] passs = reqc.getParameter("pass");
		String pass = passs[0];
		
		User u = new User();
		System.out.println(u);
		u.setEmail(email);
		System.out.println(email);
		u.setPass(pass);
		System.out.println(pass);
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		UserDao ud = factory.getUserDao();
		boolean b = ud.checkLogin(u);
		System.out.println("LoginCommand boolean 確認した" + b);
		if(b == true){
			reqc.setSessionAttribute("userBean",u);
			System.out.println("sessionAttribute Request");
			
			
			reqc.getSession();
						//String name = "email";
			//reqc.setSession(name, u);
			resc.setTarget("start");
		}else{
			resc.setTarget("login?err=1");
			System.out.println("ログインできないよ");
		}
		OracleConnectionManager.getInstance().commit();
		
		OracleConnectionManager.getInstance().closeConnection();
		
		return resc;
	}
}
		
		


