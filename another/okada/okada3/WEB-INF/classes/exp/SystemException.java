package exp;

public class SystemException extends RuntimeException{
	public SystemException(String mess,Throwable cause){
		super(mess,cause);
	}
}