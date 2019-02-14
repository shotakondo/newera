package command;

import dao.*;
import beans.*;
import context.*;

public class ChangePassCompleteJumpCommand extends AbstractCommand{
	
	//パスワード変更完了表示機能
	public ResponseContext execute(ResponseContext resc){		RequestContext reqc = getRequestContext();
						resc.setTarget("changepasscomplete");
		return resc;
	}
}
