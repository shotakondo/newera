package command;

import exe.*;

public class CartAllDeleteCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//�J�[�g�S�폜�@�\
		
		//cartdisplay.jsp�֓]��
		resc.setTarget("cartdisplay");
		
		return resc;
	}
}