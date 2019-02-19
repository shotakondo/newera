package command;

import dao.*;
import beans.*;
import context.*;
import exp.*;


public class LogoutCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		
		//OracleConnectionManager.getInstance().beginTransaction();
		User u = new User();
		
		
		try{
			
			u = (User)reqc.getSessionAttribute("userBean");
			System.out.println("session.getAttribute()"+ u.getId());
			System.out.println("session.getAttribute()"+ u.getLastName());		
		
		}catch(NullPointerException e){
			System.out.println("LogoutCommand getSession��null�������̂�catch�ɓ����ė�O�����܂���");
			throw new exp.asdfException("���O�C�����Ă��������B", new RuntimeException());
			
		}
		
		//AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		//UserDao ud = factory.getUserDao();
		
		reqc.setRemoveAttribute("userBean");
		System.out.println("���O�A�E�g���܂���");
		resc.setTarget("logout");
		return resc;
	}
}
		
		


