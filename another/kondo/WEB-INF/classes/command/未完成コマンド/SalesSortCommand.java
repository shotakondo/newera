package command;

import exe.*;

public class SalesSortCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//”„ã•À‚×‘Ö‚¦ˆ—
		
		//salesdisplay.jsp‚Ö“]‘—
		resc.setTarget("salesdisplay");
		
		return resc;
	}
}