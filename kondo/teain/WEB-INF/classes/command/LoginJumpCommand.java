package command;

import exe.*;

public class LoginJumpCommand extends AbstractCommand{
	
	//ログイン表示機能
	public ResponseContext execute(ResponseContext resc){
		
		//login.jspへ転送
		resc.setTarget("login");
		
		return resc;
	}
	
}