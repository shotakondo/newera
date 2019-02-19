package command;

import exe.*;
import beans.PaymentBean;

public class OrderConfirmCommand extends AbstractCommand{
	
	//íçï∂ämíËèàóù
	public ResponseContext execute(ResponseContext resc){
RequestContext reqc = getRequestContext();		
		String dds = reqc.getParameter("deliverydate");
		String[] dd = dds[0];
		String dts = reqc.getParameter("deliverytime");
		String[] dt = dts[0];
String cocs = reqc.getParameter("couponcode");
	String[] coc = cocs[0];
	String cacs = reqc.getParameter("campaigncode");
	String[] cac = cacs[0];
	String methods = reqc.getParameter("method");
	String method = methods[0];
	String wrappings = reqc.getParameter("wrapping");
	String wrapping = wrappings[0];
PaymentBean  payb = new PaymentBean();
	payb.setDeliverydate(dd);payb.setDeliverytime(dt);
	payb.setCouponcode(coc);
		
		
		
		
		
		
		
		
	payb.setCampaigncode(cac);
	payb.setMethod(method);
	payb.setWrapping(wrapping);
	
	session.setAttribute("payb", payb);	
	//orderconfirm.jspÇ÷ì]ëó
		resc.setTarget("orderconfirm");
		
		
	return resc;
	}
}