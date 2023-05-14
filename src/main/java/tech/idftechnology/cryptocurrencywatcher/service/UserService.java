package tech.idftechnology.cryptocurrencywatcher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.idftechnology.cryptocurrencywatcher.domain.User;
import tech.idftechnology.cryptocurrencywatcher.domain.dto.UserDtoRegistration;
import tech.idftechnology.cryptocurrencywatcher.exceptions.UserException;
import tech.idftechnology.cryptocurrencywatcher.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User userRegistration(UserDtoRegistration notify) {
        return userRepository.registration(notify).orElseThrow(() -> new UserException("User wasn't created!"));
    }

}