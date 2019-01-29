package exe;

import javax.servlet.http.HttpServletResponse;

public class WebResponseContext implements ResponseContext{
	
	private Object result;
	private String target;
	
	//HttpServletResponseインターフェイスの実装クラスのインスタンスを格納する
	private HttpServletResponse response;
	
	public WebResponseContext(){}
	public void setTarget(String transferInfo){
		target="/WEB-INF/jsp/"+transferInfo+".jsp";
	}
	public String getTarget(){
		return target;
	}
	public void setResult(Object bean){
		result=bean;
	}
	public Object getResult(){
		return result;
	}
	public Object getResponse(){
		return response;
	}
	public void setResponse(Object obj){
		//キャストする必要がある
		response=(HttpServletResponse)obj;
	}
}