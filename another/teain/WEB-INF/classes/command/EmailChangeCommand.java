package command;

import dao.*;
import beans.*;
import context.*;


public class EmailChangeCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		
		OracleConnectionManager.getInstance().beginTransaction();
		
		User ub = (User) reqc.getSessionAttribute("userBean");
		
		
		String[] emails = reqc.getParameter("email");
		String email = emails[0];
		
		String[] passs = reqc.getParameter("pass");
		String pass = passs[0];
		
		
		String[] oldemails = reqc.getParameter("oldemail");
		String oldemail = oldemails[0];
		
		
		String[] newemails = reqc.getParameter("newemail");
		String newemail = newemails[0];
		
	
		System.out.println("EmailChangeCommand User�^�ɃL���X�g����getSession��userBean : "+ub);
		
		ub.setEmail(oldemail);
		System.out.println("EmailChangeCommand setEmail(�Â��C���[��) : "+oldemail);
		
		ub.setPass(pass);
		System.out.println("EmailChangeCommand setPass : "+pass);
		
		
		
		System.out.println("EmailChangeCommand getId : " + ub.getId());
		System.out.println("EmailChangeCommand getEmail(�Â��C���[��) : " + ub.getEmail());
		System.out.println("EmailChangeCommand getPass : " + ub.getPass());
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		UserDao ud = factory.getUserDao();
		
		boolean b = ud.checkEmail(ub);
		System.out.println("EmailCheck boolean : " + b);
		
		boolean pb;
		if(b == true){
			
			ub.setEmail(newemail);
			System.out.println("checkEmail��true����������pass��newpass�ɏ㏑���������ub.getEmail() : " + ub.getEmail());
			
			pb = ud.EmailReplace(ub);
			
			if(pb == true){
					
					
				reqc.getSession();
				reqc.setSessionAttribute("EmailChangeCommand-userBean",ub);
				System.out.println("EmailChangeCommand-setsessionAttribute");
				
				resc.setTarget("emailafter");
				
			}else{
				
				resc.setTarget("");
				System.out.println("EmailChangeCommand-update�ł��Ȃ�����");
				
			}
		}else{
			resc.setTarget("error");
			System.out.println("email��pass���Ԉ���Ă�");
		}
		OracleConnectionManager.getInstance().commit();

		OracleConnectionManager.getInstance().closeConnection();
		reqc.setRemoveAttribute("userBean");

		//System.out.println("EmailChangeAfter���O�A�E�g����");
		return resc;
	}
}
