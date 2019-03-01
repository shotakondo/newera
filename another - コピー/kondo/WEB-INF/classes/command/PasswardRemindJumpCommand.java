package command;

import exe.*;

public class PasswardRemindJumpCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		
		//passwardremind.jsp‚Ö“]‘—
		resc.setTarget("passwardremind");
		
		return resc;
	}
}