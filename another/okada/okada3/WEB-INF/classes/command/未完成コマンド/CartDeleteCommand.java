package command;

import exe.*;

public class CartDeleteCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//�J�[�g�폜�@�\
		
		//cartdisplay.jsp�֓]��
		resc.setTarget("cartdisplay");
		
		return resc;
	}
}