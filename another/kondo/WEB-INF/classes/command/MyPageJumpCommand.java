package command;

import exe.*;

public class MyPageJumpCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		
		//mypage.jsp‚Ö“]‘—
		resc.setTarget("mypage");
		
		return resc;
	}
	
}