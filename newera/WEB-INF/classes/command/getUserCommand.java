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
		
		User u = (User)reqc.getSessionAttribute("userBean");
		
		
		
		try{
			
			u = (User) reqc.getSessionAttribute("userBean");
			System.out.println("getUserCommand"+u);
			
		}catch(NullPointerException e){
			
			System.out.println("getUsertCommand getSession��null�������̂�catch�ɓ����ė�O�����܂���");
			throw new exp.asdfException("���O�C�����Ă��������B", new RuntimeException());
			
		}
		
		
		//System.out.println("User u = (User) reqc.getSessionAttribute("userBean")"+u);
		String id = u.getId();
		System.out.println("getUserCommand��getSessionAttribute�������u.getId() : "+id);
		
		//�g�����U�N�V�������J�n����
		OracleConnectionManager.getInstance().beginTransaction();
		
		//�C���e�O���[�V�������C���̏������Ăяo��
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		UserDao dao=factory.getUserDao();
		
		u =dao.getUser(u.getEmail(), u);
		//�g�����U�N�V�������I������
		OracleConnectionManager.getInstance().commit();
		
		//�R�l�N�V������ؒf����
		OracleConnectionManager.getInstance().closeConnection();
		
		System.out.println("getUserCommand��List��l : "+ u);
		
		resc.setResult(u);

		resc.setTarget("edituser");
		return resc;

	}
}
