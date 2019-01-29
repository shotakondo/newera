package command;

import exe.*;

public class TopPageJumpCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		
		//toppage.jsp‚Ö“]‘—
		resc.setTarget("toppage");
		
		return resc;
	}
}