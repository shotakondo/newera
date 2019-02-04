package command;

import dao.*;
import beans.*;
import context.*;

public class InputCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		resc.setTarget("login");
		return resc;
	}
}
		
		