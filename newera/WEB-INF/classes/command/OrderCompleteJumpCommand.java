package command;

import dao.*;
import beans.*;
import context.*;

public class OrderCompleteJumpCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
				
		resc.setTarget("ordercomplete");
		return resc;
	}
}