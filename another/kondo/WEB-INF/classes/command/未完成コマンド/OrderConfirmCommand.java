package command;

import exe.*;

public class OrderConfirmCommand extends AbstractCommand{

	//注文確定処理
	public ResponseContext execute(ResponseContext resc){
		
		//orderconfirm.jspへ転送
		resc.setTarget("orderconfirm");
		
		return resc;
	}
}