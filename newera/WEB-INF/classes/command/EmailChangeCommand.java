package command;

import dao.*;
import beans.*;
import context.*;


public class EmailChangeCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		
		OracleConnectionManager.getInstance().beginTransaction();
		
		User u = (User) reqc.getSessionAttribute("userBean");
		
		
		String[] emails = reqc.getParameter("email");
		String email = emails[0];
		
		String[] passs = reqc.getParameter("pass");
		String pass = passs[0];
		
		
		String[] newemails = reqc.getParameter("newemail");
		String newemail = newemails[0];
		
	
		System.out.println("EmailChangeCommand User�^�ɃL���X�g����getSession��userBean : "+u);
		
		
		u.setPass(pass);
		System.out.println("EmailChangeCommand setPass : "+pass);
		
		
		
		System.out.println("EmailChangeCommand getId : " + u.getId());
		System.out.println("EmailChangeCommand getEmail(�Â��C���[��) : " + u.getEmail());
		System.out.println("EmailChangeCommand getPass : " + u.getPass());
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		UserDao ud = factory.getUserDao();
		
		boolean b = ud.checkEmail(u);
		System.out.println("EmailCheck boolean : " + b);
		
		boolean pb;
		if(b == true){
			
			u.setEmail(newemail);
			System.out.println("checkEmail��true����������pass��newpass�ɏ㏑���������u.getEmail() : " + u.getEmail());
			
			pb = ud.EmailReplace(u);
			
			if(pb == true){
					
				System.out.println("EmailChangeCommand-setsessionAttribute");
				
				resc.setTarget("emailafter");
				
				User ub = new User();
				
				reqc.setSessionAttribute("userBean", ub);
			}else{
				
				resc.setTarget("changeemail");
				System.out.println("EmailChangeCommand-update�ł��Ȃ�����");
				
			}
		}else{
			resc.setTarget("changeemail");
			System.out.println("email��pass���Ԉ���Ă�");
		}
		OracleConnectionManager.getInstance().commit();

		OracleConnectionManager.getInstance().closeConnection();
		

		//System.out.println("EmailChangeAfter���O�A�E�g����");
		return resc;
	}
}
