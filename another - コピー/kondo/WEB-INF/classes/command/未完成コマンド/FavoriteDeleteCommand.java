package command;

import exe.*;

public class FavoriteDeleteCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//お気に入り削除機能
		
		//favoritedisplay.jspへ転送
		resc.setTarget("favoritedisplay");
		
		return resc;
	}
}