package command;

import exe.*;

public class FavoriteDeleteCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//���C�ɓ���폜�@�\
		
		//favoritedisplay.jsp�֓]��
		resc.setTarget("favoritedisplay");
		
		return resc;
	}
}