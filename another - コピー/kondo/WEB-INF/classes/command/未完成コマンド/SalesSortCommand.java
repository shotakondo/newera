package command;

import exe.*;

public class SalesSortCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//������בւ�����
		
		//salesdisplay.jsp�֓]��
		resc.setTarget("salesdisplay");
		
		return resc;
	}
}