package command;

import exe.*;

public class NGUserReleaseCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//NGƒ†[ƒU[‰ğœˆ—
		
		//usersoperate.jsp‚Ö“]‘—
		resc.setTarget("usersoperate");
		
		return resc;
	}
}