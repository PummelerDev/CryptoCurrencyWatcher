package tech.idftechnology.cryptocurrencywatcher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.idftechnology.cryptocurrencywatcher.domain.User;
import tech.idftechnology.cryptocurrencywatcher.domain.dto.UserDtoNotify;
import tech.idftechnology.cryptocurrencywatcher.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User userRegistration(UserDtoNotify notify) {
       return userRepository.notify(notify).orElseThrow();
        // TODO: 13.05.2023 create exception!!
    }
}
