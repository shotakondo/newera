//使ってる
//propertie名 : jumplogin




package command;

import dao.*;
import beans.*;
import context.*;
import exp.*;

public class LoginJumpCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		
		//login.jspへ転送
		resc.setTarget("login");
		
		return resc;
	}
	
}
		
		