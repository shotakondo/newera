package command;

import exe.*;

public class UnSubscribeJumpCommand extends AbstractCommand{
	
	//�މ�\���@�\
	public ResponseContext execute(ResponseContext resc){
				
		resc.setTarget("unsubscribe");
		return resc;
	}
}
