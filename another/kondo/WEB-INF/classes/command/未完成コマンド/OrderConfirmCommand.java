package command;

import exe.*;

public class OrderConfirmCommand extends AbstractCommand{

	//�����m�菈��
	public ResponseContext execute(ResponseContext resc){
		
		//orderconfirm.jsp�֓]��
		resc.setTarget("orderconfirm");
		
		return resc;
	}
}