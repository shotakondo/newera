package command;

public class OrderDisplayJumpCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		
		resc.setTarget("orderdisplay");
		
		return resc;
	}
}