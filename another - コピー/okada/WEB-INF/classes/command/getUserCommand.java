package command;
import java.util.List;

import dao.*;
import context.*;
import beans.*;
import exp.*;

public class getUserCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		
		OracleConnectionManager.getInstance().beginTransaction();
		
		User u = new User();
		
		try{
			
			u = (User) reqc.getSessionAttribute("userBean");
			System.out.println("getUserCommand"+u);
			
		}catch(NullPointerException e){
			
			System.out.println("getUsertCommand getSessionがnullだったのでcatchに入って例外投げました");
			throw new exp.asdfException("ログインしてください。", new RuntimeException());
			
		}
		
		
		//System.out.println("User u = (User) reqc.getSessionAttribute("userBean")"+u);
		String id = u.getId();
		System.out.println("getUserCommandでgetSessionAttributeした後のu.getId() : "+id);
		
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		UserDao dao=factory.getUserDao();
		
		List l=dao.getUser(id);
		
		System.out.println("getUserCommandのListのl : "+ l);
		
		resc.setResult(l);

		resc.setTarget("view");
		return resc;

	}
}
