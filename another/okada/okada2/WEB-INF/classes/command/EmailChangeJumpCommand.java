package command;

import dao.*;
import beans.*;
import context.*;

public class EmailChangeJumpCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
				
		resc.setTarget("changeemail");
		return resc;
	}
}


