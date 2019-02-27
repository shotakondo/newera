package command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import context.*;
import beans.*;

public class OrderConfirmCommand extends AbstractCommand{
	
	//íçï∂ämîFèàóù
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		
		User u = (User)session.getAttribute("userBean");
		
		String dd = reqc.getParameter("deliverydate")[0];
		String dt = reqc.getParameter("deliverytime")[0];
		String coc = reqc.getParameter("couponcode")[0];
		String cac = reqc.getParameter("campaigncode")[0];
		String method = reqc.getParameter("method")[0];
		String wrapping = reqc.getParameter("wrapping")[0];
		
		PaymentBean  payb = new PaymentBean();
		payb.setDeliverydate(dd);
		payb.setDeliverytime(dt);
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