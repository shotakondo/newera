package command;

import exe.*;

public class ProductUpdateCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//商品更新処理
		
		//productupdate.jspへ転送
		resc.setTarget("productupdate");
		
		return resc;
	}
}