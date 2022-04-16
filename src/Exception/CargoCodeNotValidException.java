package Exception;
//exception class with three constructors.
public class CargoCodeNotValidException extends Exception {
	  private int code;

	    public  CargoCodeNotValidException(int code) {
	        super("CARGO CODE NOT CORRECT EXCEPTION");
	        this.code = code;
	    }

	    public  CargoCodeNotValidException(String message) {
	        super(message);

	    }

	    public  CargoCodeNotValidException() {
	        super();

	    }



	    public int getCode() {
	        return this.code;
	    }
}
