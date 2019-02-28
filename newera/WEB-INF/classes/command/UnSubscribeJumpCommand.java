package command;

import context.*;

public class UnSubscribeJumpCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		
		//unsubscirbe.jsp‚Ö“]‘—
		resc.setTarget("unsubscribe");
		
		return resc;
	}
}