package command;

import exe.*;

public class PasswardRemindCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//�p�X���[�h���}�C���h����
		
		//conplete.jsp�֓]��
		resc.setTarget("remindcomplete");
		
		return resc;
	}
}