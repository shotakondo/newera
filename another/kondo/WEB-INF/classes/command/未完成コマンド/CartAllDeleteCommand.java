package command;

import exe.*;

public class CartAllDeleteCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//カート全削除機能
		
		//cartdisplay.jspへ転送
		resc.setTarget("cartdisplay");
		
		return resc;
	}
}