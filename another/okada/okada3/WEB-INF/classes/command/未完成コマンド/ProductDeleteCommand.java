package command;

import exe.*;

public class ProductDeleteCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//���i�폜����
		
		//productdelete.jsp�֓]��
		resc.setTarget("productdelete");
		
		return resc;
	}
}