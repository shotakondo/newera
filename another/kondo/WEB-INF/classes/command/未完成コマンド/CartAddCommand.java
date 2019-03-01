package command;

import exe.*;

public class CartAddCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//カート追加処理
		
		//productdetaildisplay.jspへ転送
		resc.setTarget("productdetaildisplay");
		
		return resc;
	}
}