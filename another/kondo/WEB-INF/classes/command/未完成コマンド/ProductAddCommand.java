package command;

import exe.*;

public class ProductAddCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//���i�ǉ�����
		
		//productoperate.jsp�֓]��
		resc.setTarget("productoperate");
		
		return resc;
	}
}