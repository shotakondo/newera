package command;

public class SalesDisplayJumpCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		
		//salesdisplay.jsp‚Ö“]‘—
		resc.setTarget("selesdisplay");
		
		return resc;
	}
}