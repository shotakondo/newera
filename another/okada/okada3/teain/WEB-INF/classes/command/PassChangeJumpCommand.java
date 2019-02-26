package command;

import exe.*;

public class PassChangeJumpCommand extends AbstractCommand{
	
	//パスワード変更表示機能
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
				
		resc.setTarget("changepass");
		
		return resc;
	}
}


