package command;

import exe.*;

public class SalesNarrowCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//”„ãi‚è‚İˆ—
		
		//salesdisplay.jsp‚Ö“]‘—
		resc.setTarget("salesdisplay");
		
		return resc;
	}
}