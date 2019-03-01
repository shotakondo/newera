package command;

import exe.*;

public class NGUserReleaseCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//NGユーザー解除処理
		
		//usersoperate.jspへ転送
		resc.setTarget("usersoperate");
		
		return resc;
	}
}