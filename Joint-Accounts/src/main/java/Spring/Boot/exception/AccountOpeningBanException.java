package Spring.Boot.exception;

public class AccountOpeningBanException extends RuntimeException{
    public AccountOpeningBanException(String message) {
        super(message);
    }
}
