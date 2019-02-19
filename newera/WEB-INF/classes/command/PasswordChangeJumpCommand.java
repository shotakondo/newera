package command;

import dao.*;
import beans.*;
import context.*;

public class PasswordChangeJumpCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
				
		resc.setTarget("changepass");
		return resc;
	}
}


