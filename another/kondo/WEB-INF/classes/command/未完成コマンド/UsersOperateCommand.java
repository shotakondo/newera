package command;

import exe.*;

public class UsersOperateCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		
		//usersoperate.jsp‚Ö“]‘—
		resc.setTarget("usersoperate");
		
		return resc;
	}
}