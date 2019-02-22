package command;

import exe.*;

public class EmailChangeJumpCommand extends AbstractCommand{
	
	//ƒ[ƒ‹•ÏX•\¦‰æ–Ê
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		resc.setTarget("changeemail");
		
		return resc;
	}
}


