package command;

public class SalesDisplayJumpCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		
		//salesdisplay.jsp�֓]��
		resc.setTarget("selesdisplay");
		
		return resc;
	}
}