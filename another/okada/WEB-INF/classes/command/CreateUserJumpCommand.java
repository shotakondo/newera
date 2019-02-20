//Žg‚Á‚Ä‚é
//propertie–¼ : jumpcreate



package command;

import dao.*;
import beans.*;
import context.*;

public class CreateUserJumpCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		resc.setTarget("register");
		return resc;
	}
}


