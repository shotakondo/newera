package command;

import dao.*;
import beans.*;
import context.*;

public class HistoryJumpCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
				
		resc.setTarget("history");
		return resc;
	}
}


