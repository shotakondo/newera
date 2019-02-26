package command;

import exe.*;

public class EmailChangeJumpCommand extends AbstractCommand{
	
	//メール変更表示画面
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		resc.setTarget("changeemail");
		
		return resc;
	}
}


