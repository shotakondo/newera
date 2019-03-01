package context;

import java.util.Map;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.*;

public class WebRequestContext implements RequestContext{
	private Map _parameters;
	private Map _id;
	private HttpServletRequest _request;
	//private HttpSession session;
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
	
	public HttpSession getSession(){
		return _request.getSession();
	}
	public Object getSessionAttribute(String a){
		HttpSession session = getSession();
		System.out.println("getSessionAttribute");
		System.out.println("JSESSIONID="+_request.getSession().getId());
		Object beanObject = (User) session.getAttribute(a);
		System.out.println("getSessionAttribute USER="+beanObject);
		User ub = (User) beanObject;
		System.out.println("USER.getId()="+ub.getId());
		return beanObject;
	}

	public void setRemoveAttribute(String n){
		HttpSession session = getSession();
		session.removeAttribute(n);
		String getId = session.getId();
		System.out.println("RemoveAttribute" + getId);
	}
	public void setSessionAttribute(String name, Object o){
		HttpSession session = getSession();
		System.out.println("setSessionAttribute(String name, Object o)"+name+o);
		session.setAttribute(name, o);
		System.out.println("setSessionAttribute"+session.getAttribute("userBean"));
		String getId = session.getId();
		System.out.println("setSessionAttribute(String name, Object o)" + getId);
		
	}
	public boolean attributeCheck(String beanname){
		System.out.println("attributeCheck");
		HttpSession session = getSession();
		System.out.println("getSession‚µ‚½");
		User ub= (User)session.getAttribute(beanname);
		
		if(ub==null){
			System.out.println("getAttribute = false");
			return false;
		}else{
			System.out.println("getAttribute = true");
			return true;		
		}
	}
	public void setRequest(Object req){
		_request = (HttpServletRequest)req;
		
		_parameters = _request.getParameterMap();
	}
	public Object getSessionObject(String object){
		return _request.getSession().getAttribute(object);
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