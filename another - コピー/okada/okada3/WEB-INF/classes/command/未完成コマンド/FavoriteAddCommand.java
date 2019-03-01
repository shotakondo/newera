package command;

import exe.*;

public class FavoriteAddCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//‚¨‹C‚É“ü‚è’Ç‰Áˆ—
		
		//productdetaildisplay.jsp‚Ö“]‘—
		resc.setTarget("productdetaildisplay");
		
		return resc;
	}
}