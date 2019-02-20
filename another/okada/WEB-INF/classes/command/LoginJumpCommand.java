//Žg‚Á‚Ä‚é
//propertie–¼ : jumplogin




package command;

import dao.*;
import beans.*;
import context.*;
import exp.*;

public class LoginJumpCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		
		//login.jsp‚Ö“]‘—
		resc.setTarget("login");
		
		return resc;
	}
	
}
		
		