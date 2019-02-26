package command;

import exe.*;

public class CartDeleteCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//カート削除機能
		
		//cartdisplay.jspへ転送
		resc.setTarget("cartdisplay");
		
		return resc;
	}
}