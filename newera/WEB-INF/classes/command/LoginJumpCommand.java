package command;

import dao.*;
import beans.*;
import context.*;
import exp.*;

public class OrderCompleteJumpCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		
		//login.jsp‚Ö“]‘—
		resc.setTarget("ordercomplete");
		
		return resc;
	}
	
}
		
		