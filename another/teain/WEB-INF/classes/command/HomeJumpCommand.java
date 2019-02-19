package command;

import dao.*;
import beans.*;
import context.*;

public class HomeJumpCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
				
		resc.setTarget("home");
		return resc;
	}
}


