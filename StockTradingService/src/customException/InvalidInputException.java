package customException;

@SuppressWarnings("serial")
public class InvalidInputException extends Exception {

	public InvalidInputException(String msg) {
		super(msg);
	}

}
