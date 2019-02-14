package command;

import exe.*;

public class ManagerTopPageJumpCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		
		//managertoppage.jsp‚Ö“]‘—
		resc.setTarget("managertoppage");
		
		return resc;
	}
}