package command;

import exe.*;

public class NGUserReleaseCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//NG���[�U�[��������
		
		//usersoperate.jsp�֓]��
		resc.setTarget("usersoperate");
		
		return resc;
	}
}