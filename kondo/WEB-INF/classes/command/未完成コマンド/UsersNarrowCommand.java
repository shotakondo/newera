package command;

import exe.*;

public class UsersNarrowCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//���[�U�[�i�荞�ݏ���
		
		//usersoperate.jsp�֓]��
		resc.setTarget("usersoperate");
		
		return resc;
	}
}