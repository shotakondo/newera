package command;

import exe.*;

public class UsersSortCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//���[�U�[���בւ�����
		
		//usersoperate.jsp�֓]��
		resc.setTarget("usersoperate");
		
		return resc;
	}
}