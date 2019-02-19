package command;

import exe.*;

public class FavoriteDeleteCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//‚¨‹C‚É“ü‚èíœ‹@”\
		
		//favoritedisplay.jsp‚Ö“]‘—
		resc.setTarget("favoritedisplay");
		
		return resc;
	}
}