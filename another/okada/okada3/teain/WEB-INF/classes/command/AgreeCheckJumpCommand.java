package command;

import exe.*;

public class AgreeCheckJumpCommand extends AbstractCommand{
	
	//認証チェック表示機能
						public ResponseContext execute(ResponseContext resc){
					
		RequestContext reqc = getRequestContext();
				
		resc.setTarget("agree");
		return resc;
						}
			}
