package command;

import exe.*;

public class ProductsOperateCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//商品表示処理
		
		//productsoperate.jspへ転送
		resc.setTarget("productsoperate");
		
		return resc;
	}
}