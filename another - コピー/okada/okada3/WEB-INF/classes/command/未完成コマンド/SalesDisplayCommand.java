package command;

import exe.*;

public class SalesDisplayCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//����\���@�\
		
		//salesdisplay.jsp�֓]��
		resc.setTarget("salesdisplay");
		
		return resc;
	}
}