package exe;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public class WebRequestContext implements RequestContext{
	private Map parameters;
	private HttpServletRequest request;
	public WebRequestContext(){}
	
	public String getCommandPath(){
		
		//�T�[�u���b�g�p�X���擾����
		String servletPath = request.getServletPath();
		
		//2�����ڈȍ~���擾����
		String commandPath = servletPath.substring(1);
		
		return commandPath;
	}
	
	public String[] getParameter(String key){
		return (String[])parameters.get(key);
	}
	public Object getRequest(){
		return request;
	}
	public void setRequest(Object req){
		
		//�L���X�g����K�v������
		request = (HttpServletRequest) req;
		
		parameters = request.getParameterMap();
	}
}