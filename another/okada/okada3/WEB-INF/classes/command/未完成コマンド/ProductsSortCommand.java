package command;

import exe.*;

public class ProductsSortCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//���i���בւ�����
		
		//productsdisplay.jsp�֓]��
		resc.setTarget("productsdisplay");
		
		return resc;
	}
}