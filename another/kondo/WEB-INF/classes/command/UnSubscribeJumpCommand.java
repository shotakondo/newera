package command;

import exe.*;

public class UnSubscribeJumpCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		
		//unsubscirbe.jsp�֓]��
		resc.setTarget("unsubscribe");
		
		return resc;
	}
}