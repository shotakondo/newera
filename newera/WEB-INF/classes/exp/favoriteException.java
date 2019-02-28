package exp;

public class favoriteException extends RuntimeException{
	public favoriteException(String mess,Throwable cause){
		super(mess,cause);
		System.out.println("favoriteExceptionの中に来たよ");
	}
}