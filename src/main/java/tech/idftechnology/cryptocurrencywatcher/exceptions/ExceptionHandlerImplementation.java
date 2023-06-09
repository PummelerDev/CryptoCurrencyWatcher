package tech.idftechnology.cryptocurrencywatcher.exceptions;

import com.fasterxml.jackson.core.JsonParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ValidationException;
import java.io.IOException;

@ControllerAdvice
public class ExceptionHandlerImplementation {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(CryptocurrencyNotFoundException.class)
    public ResponseEntity<HttpStatus> exceptionCryptocurrencyNotFound(CryptocurrencyNotFoundException e) {
        logger.error(e.getMessage(), e);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<HttpStatus> exceptionUser(UserException e) {
        logger.error(e.getMessage(), e);
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<HttpStatus> exceptionValidation(ValidationException e) {
        logger.error(e.getMessage(), e);
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @ExceptionHandler(IOException.class)
    public void exceptionIO(IOException e) {
        logger.error(e.getMessage(), e);
    }

    @ExceptionHandler(JsonParseException.class)
    public ResponseEntity<HttpStatus> exceptionJsonParse (JsonParseException e){
        logger.error(e.getMessage(), e);
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

}