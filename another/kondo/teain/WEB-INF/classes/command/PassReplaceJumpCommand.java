package command;

import dao.*;
import exe.*;
import beans.UserBean;

public class PassReplaceJumpCommand extends AbstractCommand{
	
	//パスワード置き換え表示機能
	public ResponseContext execute(ResponseContext resc){	
		RequestContext reqc = getRequestContext();
	UserBean ub = new UserBean();
		String[] vals = reqc.getUrlParameter();
		String val = vals[0];		ub.setUid(val);
		
		reqc.setSessionAttribute("ub",ub);UserBean ub = (UserBean) reqc.getSessionAttribute("ub");
				resc.setTarget("newemail");		return resc;
	}
}
