package command;

import dao.*;
import beans.*;
import context.*;

public class ChangePassCompleteJumpCommand extends AbstractCommand{
	
	//�p�X���[�h�ύX�����\���@�\
	public ResponseContext execute(ResponseContext resc){		RequestContext reqc = getRequestContext();
						resc.setTarget("changepasscomplete");
		return resc;
	}
}
