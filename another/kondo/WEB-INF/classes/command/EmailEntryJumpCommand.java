package command;

import context.*;

public class EmailEntryJumpCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		
		//subscribe.jsp�֓]��
		resc.setTarget("emailentry");
		
		return resc;
	}
}