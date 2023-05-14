package tech.idftechnology.cryptocurrencywatcher.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tech.idftechnology.cryptocurrencywatcher.domain.User;
import tech.idftechnology.cryptocurrencywatcher.repository.UserRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Component
public class CryptocurrencyNotifyScheduler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserRepository userRepository;

    @Autowired
    public CryptocurrencyNotifyScheduler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Scheduled(fixedRate = 60000)
    @Async
    public void checkChanges() {
        List<User> users = userRepository.checkChanges();
        sendNotice(users);
    }

    private void sendNotice(List<User> users) {
        StringBuilder sb = new StringBuilder();
        BigDecimal percentage;
        for (User u :
                users) {
            percentage = u.getCryptocurrency().getPriceUsd()
                    .divide(u.getStartingPrice(), RoundingMode.HALF_UP)
                    .multiply(new BigDecimal("100"))
                    .subtract(new BigDecimal("100"));
            sb.append("Dear ")
                    .append(u.getUsername())
                    .append(", ")
                    .append(u.getCryptocurrency().getSymbol())
                    .append(" was changed on ")
                    .append(percentage)
                    .append("%.");
            logger.warn(sb.toString());
            sb.setLength(0);
        }
    }

}