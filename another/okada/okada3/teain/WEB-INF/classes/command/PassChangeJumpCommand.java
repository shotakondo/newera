package command;

import exe.*;

public class PassChangeJumpCommand extends AbstractCommand{
	
	//�p�X���[�h�ύX�\���@�\
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
				
		resc.setTarget("changepass");
		
		return resc;
	}
}


