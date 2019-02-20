//�g���Ă�
//propertie�� : passchange




package command;

import dao.*;
import beans.*;
import context.*;
import exp.*;


public class PasswordChangeCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		
		OracleConnectionManager.getInstance().beginTransaction();
		
		User ub = (User) reqc.getSessionAttribute("userBean");
		
		
		String[] emails = reqc.getParameter("email");
		String email = emails[0];
		
		
		String[] oldpasss = reqc.getParameter("oldpass");
		String oldpass = oldpasss[0];
		
		
		String[] newpasss = reqc.getParameter("newpass");
		String newpass = newpasss[0];
		
	
		System.out.println("PasswordChangeCommand User�^�ɃL���X�g����getSession��userBean : "+ub);
		
		ub.setEmail(email);
		System.out.println("PasswordChangeCommand setEmail : "+email);
		
		ub.setPass(oldpass);
		System.out.println("PasswordChangeCommand setPass(�Â�password�̗\��) : "+oldpass);
		
		
		System.out.println("PasswordChangeCommand getId : " + ub.getId());
		System.out.println("PasswordChangeCommand getPass(�Â�password�̗\��) : " + ub.getPass());
		System.out.println("PasswordChangeCommand getEmail : " + ub.getEmail());
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		UserDao ud = factory.getUserDao();
		
		boolean b = ud.checkPassword(ub);
		System.out.println("PcheckPassword boolean : " + b);
		
		boolean pb;//PasswordReplace��boolean
		if(b == true){
			
			ub.setPass(newpass);
			System.out.println("checkPassword��true����������pass��newpass�ɏ㏑���������ub.getPass() : " + ub.getPass());
			
			pb = ud.PasswordReplace(ub);
			
			if(pb == true){
					
					
				reqc.getSession();
				reqc.setSessionAttribute("userBean",ub);
				System.out.println("setsessionAttribute");
				
				resc.setTarget("passafter");
				
			}else{
				
				System.out.println("PasswordChengeCommand dao��PasswordReplace��false���A�����̂�catch�ɓ����ė�O�����܂���");
				throw new exp.asdfException("�ύX�ł��܂���ł���", new RuntimeException());
				
			}
		}else{
			
			System.out.println("PasswordChengeCommand dao��checkPassword��false���A�����̂�catch�ɓ����ė�O�����܂���");
			throw new exp.asdfException("�ύX�ł��܂���ł���", new RuntimeException());
			
		}
		OracleConnectionManager.getInstance().commit();
		
		OracleConnectionManager.getInstance().closeConnection();
		
		//reqc.setRemoveAttribute("userBean");
		//System.out.println("Pass Change���O�A�E�g����");
		return resc;
	}
}
		
		
		
		
		
