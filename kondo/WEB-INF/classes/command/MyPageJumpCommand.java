package command;

import exe.*;

public class MyPageJumpCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		
		//mypage.jsp�֓]��
		resc.setTarget("mypage");
		
		return resc;
	}
	
}