package command;

import exe.*;

public class ProductAddJumpCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		
		//productadd.jsp�֓]��
		resc.setTarget("productadd");
		
		return resc;
	}
	
}