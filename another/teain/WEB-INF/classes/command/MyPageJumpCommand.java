package command;

import dao.*;
import beans.*;
import context.*;

public class MyPageJumpCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
				
		resc.setTarget("mypage");
		return resc;
	}
}


