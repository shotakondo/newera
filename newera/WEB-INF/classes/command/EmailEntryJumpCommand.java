package command;

import exe.*;

public class EmailEntryJumpCommand extends exe.AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		
		//subscribe.jsp�֓]��
		resc.setTarget("emailentry");
		
		return resc;
	}
}