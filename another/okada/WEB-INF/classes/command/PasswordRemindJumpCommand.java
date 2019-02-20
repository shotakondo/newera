//Žg‚Á‚Ä‚é
//propertie–¼ : jumpremind




package command;

import dao.*;
import beans.*;
import context.*;

public class PasswordRemindJumpCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		resc.setTarget("email");
		return resc;
	}
}


