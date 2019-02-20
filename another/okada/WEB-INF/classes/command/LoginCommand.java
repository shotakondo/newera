//使ってる
//propertie名 : login


package command;
import javax.servlet.http.HttpServletRequest;


import dao.*;
import beans.*;
import context.*;
import exp.*;


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

			reqc.getSession();
			reqc.setSessionAttribute("userBean",u);
			System.out.println("sessionAttribute Request");
			u = (User)reqc.getSessionAttribute("userBean");
			System.out.println("session.getAttribute()"+ u.getId());
			System.out.println("session.getAttribute()"+ u.getLastName());
			resc.setTarget("mypage");
		}else{
			System.out.println("LoginCommand daoのcheckLoginでfalseが帰ったのでcatchに入って例外投げました");
			throw new exp.asdfException("ログインできませんでした。", new RuntimeException());
		}
		OracleConnectionManager.getInstance().commit();
		
		OracleConnectionManager.getInstance().closeConnection();
		
		return resc;
	}
}
		
		


