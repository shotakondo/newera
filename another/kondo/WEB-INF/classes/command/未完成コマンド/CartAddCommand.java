package command;

import exe.*;

public class CartAddCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//ƒJ[ƒg’Ç‰Áˆ—
		
		//productdetaildisplay.jsp‚Ö“]‘—
		resc.setTarget("productdetaildisplay");
		
		return resc;
	}
}