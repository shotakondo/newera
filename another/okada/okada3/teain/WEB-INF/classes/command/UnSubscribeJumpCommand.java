package command;

import exe.*;

public class UnSubscribeJumpCommand extends AbstractCommand{
	
	//退会表示機能
	public ResponseContext execute(ResponseContext resc){
				
		resc.setTarget("unsubscribe");
		return resc;
	}
}
