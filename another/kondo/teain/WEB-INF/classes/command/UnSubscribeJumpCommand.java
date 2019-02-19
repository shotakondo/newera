package command;

import exe.*;

public class UnSubscribeJumpCommand extends AbstractCommand{
	
	//‘Þ‰ï•\Ž¦‹@”\
	public ResponseContext execute(ResponseContext resc){
				
		resc.setTarget("unsubscribe");
		return resc;
	}
}
