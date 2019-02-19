package command;

import exe.*;

public class UnSubscribeJumpCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		
		//unsubscirbe.jsp‚Ö“]‘—
		resc.setTarget("unsubscribe");
		
		return resc;
	}
}