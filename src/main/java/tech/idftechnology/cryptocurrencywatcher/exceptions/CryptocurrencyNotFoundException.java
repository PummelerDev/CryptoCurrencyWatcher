package tech.idftechnology.cryptocurrencywatcher.exceptions;

public class CryptocurrencyNotFoundException extends RuntimeException{
    public CryptocurrencyNotFoundException() {
    }

    public CryptocurrencyNotFoundException(String message) {
        super(message);
    }

    public CryptocurrencyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CryptocurrencyNotFoundException(Throwable cause) {
        super(cause);
    }

    protected CryptocurrencyNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}