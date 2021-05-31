package hust.soict.globalict.aims;
public class PlayerException extends java.lang.Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PlayerException(String error){
		super();
		System.err.println(error);
	}
	@Override
	public String getMessage() {
		return "DVD Error";
	}
	@Override
	public String toString() {
		return "ILLEGAL DVD LENGTH";
	}
	public String getError() {
		return "ERROR: DVD length is non-positive!";
	}
	public static void main(String[] args) {
		
	}
}
