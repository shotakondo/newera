package command;

import exe.*;

public class PassRemindJumpCommand extends AbstractCommand{
	
	//�p�X���[�h���}�C���h�\���@�\
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		resc.setTarget("email");
		
		return resc;
	}
}
