package tech.idftechnology.cryptocurrencywatcher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.idftechnology.cryptocurrencywatcher.domain.dto.UserDtoRegistration;
import tech.idftechnology.cryptocurrencywatcher.service.CryptocurrencyService;
import tech.idftechnology.cryptocurrencywatcher.service.UserService;

import javax.validation.Valid;
import javax.validation.ValidationException;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final CryptocurrencyService cryptocurrencyService;

    @Autowired
    public UserController(UserService userService, CryptocurrencyService cryptocurrencyService) {
        this.userService = userService;
        this.cryptocurrencyService = cryptocurrencyService;
    }

    @PostMapping("/notify")
    public ResponseEntity<HttpStatus> notify(@RequestBody @Valid UserDtoRegistration notify, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.toString());
        }
        cryptocurrencyService.getPrice(notify.getSymbol());
        userService.userRegistration(notify);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}