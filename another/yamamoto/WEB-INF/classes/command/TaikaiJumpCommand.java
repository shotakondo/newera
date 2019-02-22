package command;

import dao.*;
import beans.*;
import context.*;

public class TaikaiJumpCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
				
		resc.setTarget("taikai");
		return resc;
	}
}
