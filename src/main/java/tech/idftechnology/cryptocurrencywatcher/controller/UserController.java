package tech.idftechnology.cryptocurrencywatcher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.idftechnology.cryptocurrencywatcher.domain.dto.UserDtoRegistration;
import tech.idftechnology.cryptocurrencywatcher.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/notify")
    public ResponseEntity<HttpStatus> notify(@RequestBody UserDtoRegistration notify){
        userService.userRegistration(notify);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
