package command;

import exe.*;

public class ProductAddCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//¤•i’Ç‰Áˆ—
		
		//productoperate.jsp‚Ö“]‘—
		resc.setTarget("productoperate");
		
		return resc;
	}
}