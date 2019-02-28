package command;

import context.*;

public class LoginJumpCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		
		//login.jsp‚Ö“]‘—
		resc.setTarget("login");
		
		return resc;
	}
	
}
		
		