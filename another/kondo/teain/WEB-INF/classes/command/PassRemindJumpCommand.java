package command;

import exe.*;

public class PassRemindJumpCommand extends AbstractCommand{
	
	//パスワードリマインド表示機能
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		resc.setTarget("email");
		
		return resc;
	}
}
