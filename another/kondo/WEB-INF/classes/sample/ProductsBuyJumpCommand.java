package command;

public class ProductsBuyJumpCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		
		resc.setTarget("productsbuy");
		
		return resc;
	}
}