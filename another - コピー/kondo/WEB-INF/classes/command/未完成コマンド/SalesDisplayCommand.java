package command;

import exe.*;

public class SalesDisplayCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//売上表示機能
		
		//salesdisplay.jspへ転送
		resc.setTarget("salesdisplay");
		
		return resc;
	}
}