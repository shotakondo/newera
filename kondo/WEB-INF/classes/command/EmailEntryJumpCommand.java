package command;

import exe.*;

public class EmailEntryJumpCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		
		//subscribe.jsp‚Ö“]‘—
		resc.setTarget("emailentry");
		
		return resc;
	}
}