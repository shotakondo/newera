package command;

import exe.*;

public class EmailChangeJumpCommand extends AbstractCommand{
	
	//���[���ύX�\�����
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		resc.setTarget("changeemail");
		
		return resc;
	}
}


