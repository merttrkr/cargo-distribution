package Exception;
public class IDNotCorrectException extends Exception {


	private int code;

    public IDNotCorrectException(int code) {
        super("ID NOT CORRECT EXCEPTION");
        this.code = code;
    }

    public IDNotCorrectException(String message) {
        super(message);
        
    }

    public IDNotCorrectException() {
        super();
        
    }

  

    public int getCode() {
        return this.code;
    }
}