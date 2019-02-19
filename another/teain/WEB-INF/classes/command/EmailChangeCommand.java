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
		
	
		System.out.println("EmailChangeCommand User型にキャストしたgetSessionのuserBean : "+ub);
		
		ub.setEmail(oldemail);
		System.out.println("EmailChangeCommand setEmail(古いイメール) : "+oldemail);
		
		ub.setPass(pass);
		System.out.println("EmailChangeCommand setPass : "+pass);
		
		
		
		System.out.println("EmailChangeCommand getId : " + ub.getId());
		System.out.println("EmailChangeCommand getEmail(古いイメール) : " + ub.getEmail());
		System.out.println("EmailChangeCommand getPass : " + ub.getPass());
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		UserDao ud = factory.getUserDao();
		
		boolean b = ud.checkEmail(ub);
		System.out.println("EmailCheck boolean : " + b);
		
		boolean pb;
		if(b == true){
			
			ub.setEmail(newemail);
			System.out.println("checkEmailがtrueだったからpassをnewpassに上書きした後のub.getEmail() : " + ub.getEmail());
			
			pb = ud.EmailReplace(ub);
			
			if(pb == true){
					
					
				reqc.getSession();
				reqc.setSessionAttribute("EmailChangeCommand-userBean",ub);
				System.out.println("EmailChangeCommand-setsessionAttribute");
				
				resc.setTarget("emailafter");
				
			}else{
				
				resc.setTarget("");
				System.out.println("EmailChangeCommand-updateできなかった");
				
			}
		}else{
			resc.setTarget("error");
			System.out.println("emailかpassが間違ってる");
		}
		OracleConnectionManager.getInstance().commit();

		OracleConnectionManager.getInstance().closeConnection();
		reqc.setRemoveAttribute("userBean");

		//System.out.println("EmailChangeAfterログアウトした");
		return resc;
	}
}
