package command;

import exe.*;

public class PurchaseProcedureCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//購入手続き機能
		
		//purchaseprocedure.jspへ転送
		resc.setTarget("purchaseprocedure");
		
		return resc;
	}
}