package command;

import exe.*;

public class UsersOperateCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		
		//usersoperate.jsp�֓]��
		resc.setTarget("usersoperate");
		
		return resc;
	}
}