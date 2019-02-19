package command;

import exe.*;

public class LogoutCommand extends AbstractCommand{
	
	//ログアウト機能
	public ResponseContext execute(ResponseContext resc){RequestContext reqc = getRequestContext();
		reqc.setRemoveAttribute("ub");
				resc.setTarget("logout");		return resc;
	}
}
