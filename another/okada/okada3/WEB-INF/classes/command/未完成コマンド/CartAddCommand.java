package command;

import exe.*;

public class CartAddCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//�J�[�g�ǉ�����
		
		//productdetaildisplay.jsp�֓]��
		resc.setTarget("productdetaildisplay");
		
		return resc;
	}
}