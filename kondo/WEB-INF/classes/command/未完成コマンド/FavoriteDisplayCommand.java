package command;

import exe.*;

public class FavoriteDisplayCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//���C�ɓ���\���@�\
		
		//favoritedisplay.jsp�֓]��
		resc.setTarget("favoritedisplay");
		
		return resc;
	}
}
