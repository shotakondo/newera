package command;

import exe.*;

public class ProductsSortCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//¤iÀ×Ö¦
		
		//productsdisplay.jspÖ]
		resc.setTarget("productsdisplay");
		
		return resc;
	}
}