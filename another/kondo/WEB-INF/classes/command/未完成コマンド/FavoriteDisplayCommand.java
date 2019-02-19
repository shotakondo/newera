package command;

import exe.*;

public class FavoriteDisplayCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//お気に入り表示機能
		
		//favoritedisplay.jspへ転送
		resc.setTarget("favoritedisplay");
		
		return resc;
	}
}
