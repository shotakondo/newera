package command;

import exe.*;

public class OrderDisplayCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//��������\������
		
		//orderdisplay.jsp
		resc.setTarget("orderdisplay");
		
		return resc;
	}
}