package command;

import exe.*;

public class LogoutCommand extends AbstractCommand{
	
	//���O�A�E�g�@�\
	public ResponseContext execute(ResponseContext resc){RequestContext reqc = getRequestContext();
		reqc.setRemoveAttribute("ub");
				resc.setTarget("logout");		return resc;
	}
}
