package command;

import exe.*;

public class SalesNarrowCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//����i�荞�ݏ���
		
		//salesdisplay.jsp�֓]��
		resc.setTarget("salesdisplay");
		
		return resc;
	}
}