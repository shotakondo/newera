package command;

import exe.*;

public class ProductsNarrowCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//商品絞り込み処理
		
		//セッションなしまたはユーザーのセッションを持っている場合→productsdisplay.jspへ転送
		resc.setTarget("productsdisplay");
		
		//管理者のセッションを持っている場合→productsoperate.jspへ転送
		resc.setTarget("productsoperate");
		
		return resc;
	}
}