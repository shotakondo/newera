package command;

import java.util.List;

import dao.*;
import exe.*;

import beans.UserBean;

public class DeleteUserCommand extends AbstractCommand{
	
	//ユーザー削除機能
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		UserBean ub = (UserBean) reqc.getSessionAttribute("ub");
		String uid = ub.getUid();
		
		OracleConnectionManager.getInstance().beginTransaction();
		
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		UserDao ud = factory.getUserDao();
		
		if(uid != null){
			
			ub.DeleteUser(uid);
			reqc.setRemoveAttribute("ub");
			resc.setTarget("toppage");
			
		}else{
			
			resc.setTarget("error");
			
		}
		
		OracleConnectionManager.getInstance().commit();
		
		OracleConnectionManager.getInstance().closeConnection();
		
		return resc;
	}
}
