//使ってる
//propertie名 : passchange




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
		
	
		System.out.println("PasswordChangeCommand User型にキャストしたgetSessionのuserBean : "+ub);
		
		ub.setEmail(email);
		System.out.println("PasswordChangeCommand setEmail : "+email);
		
		ub.setPass(oldpass);
		System.out.println("PasswordChangeCommand setPass(古いpasswordの予定) : "+oldpass);
		
		
		System.out.println("PasswordChangeCommand getId : " + ub.getId());
		System.out.println("PasswordChangeCommand getPass(古いpasswordの予定) : " + ub.getPass());
		System.out.println("PasswordChangeCommand getEmail : " + ub.getEmail());
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		UserDao ud = factory.getUserDao();
		
		boolean b = ud.checkPassword(ub);
		System.out.println("PcheckPassword boolean : " + b);
		
		boolean pb;//PasswordReplaceのboolean
		if(b == true){
			
			ub.setPass(newpass);
			System.out.println("checkPasswordがtrueだったからpassをnewpassに上書きした後のub.getPass() : " + ub.getPass());
			
			pb = ud.PasswordReplace(ub);
			
			if(pb == true){
					
					
				reqc.getSession();
				reqc.setSessionAttribute("userBean",ub);
				System.out.println("setsessionAttribute");
				
				resc.setTarget("passafter");
				
			}else{
				
				System.out.println("PasswordChengeCommand daoのPasswordReplaceでfalseが帰ったのでcatchに入って例外投げました");
				throw new exp.asdfException("変更できませんでした", new RuntimeException());
				
			}
		}else{
			
			System.out.println("PasswordChengeCommand daoのcheckPasswordでfalseが帰ったのでcatchに入って例外投げました");
			throw new exp.asdfException("変更できませんでした", new RuntimeException());
			
		}
		OracleConnectionManager.getInstance().commit();
		
		OracleConnectionManager.getInstance().closeConnection();
		
		//reqc.setRemoveAttribute("userBean");
		//System.out.println("Pass Changeログアウトした");
		return resc;
	}
}
		
		
		
		
		
