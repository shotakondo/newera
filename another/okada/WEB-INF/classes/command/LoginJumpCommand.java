//�g���Ă�
//propertie�� : jumplogin




package command;

import dao.*;
import beans.*;
import context.*;
import exp.*;

public class LoginJumpCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		
		//login.jsp�֓]��
		resc.setTarget("login");
		
		return resc;
	}
	
}
		
		