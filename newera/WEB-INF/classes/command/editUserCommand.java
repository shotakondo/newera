package command;
import java.util.List;

import dao.*;
import context.*;
import beans.*;
import exp.*;

public class editUserCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		
		OracleConnectionManager.getInstance().beginTransaction();
		
		User u = (User)reqc.getSessionAttribute("userBean");
		
		
		
		try{
			
			u = (User) reqc.getSessionAttribute("userBean");
			System.out.println("getUserCommand"+u);
			
		}catch(NullPointerException e){
			
			System.out.println("editUsertCommand getSession��null�������̂�catch�ɓ����ė�O�����܂���");
			throw new exp.asdfException("���O�C�����Ă��������B", new RuntimeException());
			
		}
		
		
		//System.out.println("User u = (User) reqc.getSessionAttribute("userBean")"+u);
		String id = u.getId();
		System.out.println("editUserCommand��getSessionAttribute�������u.getId() : "+id);
		
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		UserDao dao=factory.getUserDao();
		
		u =dao.editUser(u.getEmail(), u);
		
		System.out.println("getUserCommand��List��l : "+ u);
		
		resc.setResult(u);

		resc.setTarget("mypage");
		return resc;

	}
}

