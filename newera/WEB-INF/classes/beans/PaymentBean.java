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
	private int option;
	private int postage;
	private int total;
	
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
	public int getOption(){
		return option;
	}
	public void setOption(int option){
		this.option = option;
	}
	public int getPostage(){
		return postage;
	}
	public void setPostage(int postage){
		this.postage = postage;
	}
	public int getTotal(){
		return total;
	}
	public void setTotal(int total){
		this.total = total;
	}
}