package command;

import exe.*;

public class FavoriteAddCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//���C�ɓ���ǉ�����
		
		//productdetaildisplay.jsp�֓]��
		resc.setTarget("productdetaildisplay");
		
		return resc;
	}
}