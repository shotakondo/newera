package command;

import exe.*;

public class PurchaseProcedureCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//�w���葱���@�\
		
		//purchaseprocedure.jsp�֓]��
		resc.setTarget("purchaseprocedure");
		
		return resc;
	}
}