package command;

import exe.*;

public class ProductAddCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//商品追加処理
		
		//productoperate.jspへ転送
		resc.setTarget("productoperate");
		
		return resc;
	}
}