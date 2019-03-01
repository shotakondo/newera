package command;

import exe.*;

public class UsersNarrowCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//ユーザー絞り込み処理
		
		//usersoperate.jspへ転送
		resc.setTarget("usersoperate");
		
		return resc;
	}
}