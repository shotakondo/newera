//package
package beans;

//import
import java.io.Serializable;

//UserBeanƒNƒ‰ƒX
public class PaymentBean implements Serializable{
	
	private String deliverydate;
	private String deliverytime;
	private String couponcode;
	private String campaigncode;
	private String method;
	private String wrapping;
	
	public PaymentBean(){}
	
	public String getDeliverydate(){
		return deliverydate;
	}
	public void setDeliverydate(String deliverydate){
		this.deliverydate = deliverydate;
	}
	public String getDeliverytime(){
		return deliverytime;
	}
	public void setDeliverytime(String deliverytime){
		this.deliverytime = deliverytime;
	}
	public String getCouponcode(){
		return couponcode;
	}
	public void setCouponcode(String couponcode){
		this.couponcode = couponcode;
	}
	public String getCampaigncode(){
		return campaigncode;
	}
	public void setCampaigncode(String campaigncode){
		this.campaigncode = campaigncode;
	}
	public String getMethod(){
		return method;
	}
	public void setMethod(String method){
		this.method = method;
	}
	public String getWrapping(){
		return wrapping;
	}
	public void setWrapping(String wrapping){
		this.wrapping = wrapping;
	}
}