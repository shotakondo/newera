package command;

import exe.*;

public class ProductUpdateCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//���i�X�V����
		
		//productupdate.jsp�֓]��
		resc.setTarget("productupdate");
		
		return resc;
	}
}