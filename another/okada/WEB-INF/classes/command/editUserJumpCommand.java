//Žg‚Á‚Ä‚é
//propertie–¼ : jumpedituser




package command;

import dao.*;
import beans.*;
import context.*;

public class editUserJumpCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		resc.setTarget("edituser");
		return resc;
	}
}


