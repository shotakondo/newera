package command;

import exe.*;

public class UsersSortCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//ユーザー並べ替え処理
		
		//usersoperate.jspへ転送
		resc.setTarget("usersoperate");
		
		return resc;
	}
}