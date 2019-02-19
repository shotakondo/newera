package command;

import exe.*;

public class MyPageJumpCommand extends AbstractCommand{
	
	//マイページ表示機能
	public ResponseContext execute(ResponseContext resc){
		
		//mypage.jspへ転送
		resc.setTarget("mypage");
		
		return resc;
	}
	
}