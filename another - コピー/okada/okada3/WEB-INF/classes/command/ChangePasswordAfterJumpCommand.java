package command;

import dao.*;
import beans.*;
import context.*;

public class ChangePasswordAfterJumpCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
				
		resc.setTarget("passafter");
		return resc;
	}
}
