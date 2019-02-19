package command;

import exe.*;

public class PasswardRemindCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//パスワードリマインド処理
		
		//conplete.jspへ転送
		resc.setTarget("remindcomplete");
		
		return resc;
	}
}