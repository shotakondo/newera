package command;

import exe.*;

public class OrderDisplayCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//注文履歴表示処理
		
		//orderdisplay.jsp
		resc.setTarget("orderdisplay");
		
		return resc;
	}
}