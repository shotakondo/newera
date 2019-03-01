package exp;

public class cartaddException extends RuntimeException{
	public cartaddException(String mess,Throwable cause){
		super(mess,cause);
		System.out.println("cartaddExceptionの中に来たよ");
	}
}