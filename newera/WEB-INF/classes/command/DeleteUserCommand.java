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
			
			System.out.println("DeleteUserCommand getSession��null�������̂�catch�ɓ����ė�O�����܂���");
			throw new exp.NotLoginException("���O�C�����Ă�������", new RuntimeException());
			
		}
		
		String id = ub.getId();
		System.out.println(id);
		
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		UserDao dao=factory.getUserDao();
		
		if(id!=null){
			System.out.println("ub!=null ������");
			dao.DeleteUser(id);
			System.out.println("DeleteUser(id)"+id);
			
			reqc.setRemoveAttribute("userBean");
			System.out.println("�މ�܂���");
			resc.setTarget("home");
			
		}else{
			
			System.out.println("DeleteUserCommand id��null�������̂�catch�ɓ����ė�O�����܂���");
			throw new exp.asdfException("�މ�ł��܂���ł���", new RuntimeException());
			
		}
		
		
		
		return resc;
	}
}
