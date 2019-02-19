package command;

import exe.*;

public class OrderConfirmCommand extends AbstractCommand{

	//’•¶Šm’èˆ—
	public ResponseContext execute(ResponseContext resc){
		
		//orderconfirm.jsp‚Ö“]‘—
		resc.setTarget("orderconfirm");
		
		return resc;
	}
}