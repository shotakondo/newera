package command;

import exe.*;

public class LoginJumpCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		
		//login.jsp�֓]��
		resc.setTarget("login");
		
		return resc;
	}
	
}