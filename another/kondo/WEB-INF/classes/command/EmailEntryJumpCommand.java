package command;

import exe.*;

public class EmailEntryJumpCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		
		//subscribe.jsp�֓]��
		resc.setTarget("emailentry");
		
		return resc;
	}
}