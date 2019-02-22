package command;

import dao.*;
import beans.*;
import context.*;

public class AgreeCheckJumpCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
				
		resc.setTarget("agree");
		return resc;
	}
}


