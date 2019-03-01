package exp;

public class NotLoginException extends RuntimeException{
	public NotLoginException(String mess,Throwable cause){
		super(mess,cause);
	}
}