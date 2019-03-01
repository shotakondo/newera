package exp;

public class favoriteaddException extends RuntimeException{
	public favoriteaddException(String mess,Throwable cause){
		super(mess,cause);
		System.out.println("favoriteaddExceptionの中に来たよ");
	}
}