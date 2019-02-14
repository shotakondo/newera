package command;

import exe.*;

public class OrderDisplayCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//’•¶—š—ğ•\¦ˆ—
		
		//orderdisplay.jsp
		resc.setTarget("orderdisplay");
		
		return resc;
	}
}