package command;

import exe.*;

public class FavoriteAddCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//お気に入り追加処理
		
		//productdetaildisplay.jspへ転送
		resc.setTarget("productdetaildisplay");
		
		return resc;
	}
}