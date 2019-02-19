package exe;

import java.util.Map;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.*;

public class WebRequestContext implements RequestContext{
	
	private Map _parameters;
	private Map _id;
	private HttpServletRequest _request;
	
	public WebRequestContext(){}
	
	public String getCommandPath(){
		String servletPath = _request.getServletPath();
		
		String commandPath = servletPath.substring(1);
		
		return commandPath;
	}
	
	public String[] getParameter(String key){
		return (String[])_parameters.get(key);
	}
	
	public Object getRequest(){
		return _request;
	}
	
	public void setRequest(Object req){
		_request = (HttpServletRequest)req;
		
		_parameters = _request.getParameterMap();
	}
	
	public HttpSession getSession(){
		return _request.getSession();
	}
	
	public Object getSessionAttribute(String param){
		HttpSession session = getSession();
		Object beanObject = (User) session.getAttribute(param);
		return beanObject;
	}
	
	public Object getSessionObject(String object){
		return _request.getSession().getAttribute(object);
	}
	
	public void setSessionAttribute(String name, Object beanobject){
		HttpSession session = getSession();
		session.setAttribute(name, beanObject);
	}
	
	public void setRemoveAttribute(String beanname){
		HttpSession session = getSession();
		session.removeAttribute(beanname);
	}
	
	public String[] getUrlParameter(){
		_id = _request.getParameterMap();
		Iterator it = _id.keySet().iterator();
		String[] val = null;
		
		while(it.hasNext()){
			String id = (String)it.next();
			val = (String[])_id.get(id);
		}
		return val;
	}
	
}