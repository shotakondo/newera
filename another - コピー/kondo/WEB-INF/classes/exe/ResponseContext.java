package exe;

public interface ResponseContext{
	public void setTarget(String transferInfo);
	public String getTarget();
	public void setResult(Object bean);
	public Object getResult();
	public void setResponse(Object obj);
	public Object getResponse();
}
