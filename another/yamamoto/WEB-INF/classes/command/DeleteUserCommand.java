package command;
import java.util.List;

import dao.*;
import context.*;
import beans.*;
import exp.*;

public class DeleteUserCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		
		OracleConnectionManager.getInstance().beginTransaction();
		
		reqc.getSession();
		boolean b = reqc.attributeCheck("userBean");
		System.out.println("DeleteCommandAttributeCheck" + b);
		
		User ub = new User();
		
		try{
			
			ub = (User) reqc.getSessionAttribute("userBean");
			System.out.println((User) reqc.getSessionAttribute("userBean"));
			
		}catch(NullPointerException e){
			
			System.out.println("DeleteUserCommand getSessionがnullだったのでcatchに入って例外投げました");
			throw new exp.NotLoginException("ログインしてください", new RuntimeException());
			
		}
		
		String id = ub.getId();
		System.out.println(id);
		
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		UserDao dao=factory.getUserDao();
		
		if(id!=null){
			System.out.println("ub!=null 入った");
			dao.DeleteUser(id);
			System.out.println("DeleteUser(id)"+id);
			
			reqc.setRemoveAttribute("userBean");
			System.out.println("退会しました");
			resc.setTarget("home");
			
		}else{
			
			System.out.println("DeleteUserCommand idがnullだったのでcatchに入って例外投げました");
			throw new exp.asdfException("退会できませんでした", new RuntimeException());
			
		}
		
		
		
		return resc;
	}
}
