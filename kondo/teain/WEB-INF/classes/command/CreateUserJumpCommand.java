package command;

import exe.*;

public class CreateUserJumpCommand extends AbstractCommand{
	
	//���[�U�[�쐬�\���@�\
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		resc.setTarget("register");
		
		return resc;
	}
}


