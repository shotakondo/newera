package command;

import exe.*;

public class AgreeCheckJumpCommand extends AbstractCommand{
	
	//�F�؃`�F�b�N�\���@�\
						public ResponseContext execute(ResponseContext resc){
					
		RequestContext reqc = getRequestContext();
				
		resc.setTarget("agree");
		return resc;
						}
			}
