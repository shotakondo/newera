package command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import context.*;
import beans.*;

public class OrderConfirmCommand extends AbstractCommand{
	
	//�����m�F����
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
		
		int option = 0;
		int postage = 540;
		int total = 0;
		
		if(wrapping.equals("1")){
			option = 324;
		}
		
		total = option + postage + u.getCart().getSubtotal();
		
		PaymentBean  payb = new PaymentBean();
		payb.setDeliverydate(dd);
		payb.setDeliverytime(dt);
		payb.setCouponcode(coc);
		payb.setCampaigncode(cac);
		payb.setMethod(method);
		payb.setWrapping(wrapping);
		payb.setOption(option);
		payb.setPostage(postage);
		payb.setTotal(total);
		
		session.setAttribute("payb", payb);
		
		//orderconfirm.jsp�֓]��
		resc.setTarget("orderconfirm");
		
		return resc;
	}
}