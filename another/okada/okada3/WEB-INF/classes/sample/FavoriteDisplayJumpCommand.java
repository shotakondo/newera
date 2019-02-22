package command;

public class FavoriteDisplayJumpCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		
		resc.setTarget("favoritedisplay");
		
		return resc;
	}
}