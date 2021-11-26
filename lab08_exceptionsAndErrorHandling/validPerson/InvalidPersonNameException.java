package lab08_exeptionsAndErrorHandling.validPerson;

public class InvalidPersonNameException extends RuntimeException {

    public InvalidPersonNameException(String message) {
        super(message);
    }
}
