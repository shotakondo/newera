package command;

import exe.*;

public class PasswardRemindJumpCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		
		//passwardremind.jsp�֓]��
		resc.setTarget("passwardremind");
		
		return resc;
	}
}