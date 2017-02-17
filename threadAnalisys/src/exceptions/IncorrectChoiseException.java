package exceptions;

/**
 * Created by Ihar_Rubanovich on 2/17/2017.
 */
public class IncorrectChoiseException extends Exception {
    public IncorrectChoiseException(){

    }
    public IncorrectChoiseException(Throwable cause) {
        super(cause);
    }

    protected IncorrectChoiseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public IncorrectChoiseException (String message) {
    super(message);
}
}


