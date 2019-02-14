package command;

import exe.*;

public class CreateUserJumpCommand extends AbstractCommand{
	
	//ユーザー作成表示機能
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		resc.setTarget("register");
		
		return resc;
	}
}


