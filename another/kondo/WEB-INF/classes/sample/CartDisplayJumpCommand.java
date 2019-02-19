package command;

public class  CartDisplayJump extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		
		resc.setTarget("cartdisplay");
		
		return resc;
	}
}