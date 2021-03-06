package command;
import java.util.List;

import dao.*;
import context.*;
import beans.*;

public class DeleteUserCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		OracleConnectionManager.getInstance().beginTransaction();
		reqc.getSession();
		boolean b = reqc.attributeCheck("userBean");
		System.out.println("DeleteCommandAttributeCheck" + b);
		User ub = (User) reqc.getSessionAttribute("userBean");
		System.out.println((User) reqc.getSessionAttribute("userBean"));
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
			resc.setTarget("start");
		}else{
			resc.setTarget("error");
			System.out.println("ユーザ一ないよ");
		}
		
		
		//resc.setTarget("start");
		return resc;
	}
}
