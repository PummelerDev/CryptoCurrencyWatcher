package tech.idftechnology.cryptocurrencywatcher.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tech.idftechnology.cryptocurrencywatcher.domain.Cryptocurrency;
import tech.idftechnology.cryptocurrencywatcher.repository.CryptocurrencyRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.URL;
import java.util.List;

@Component
public class CryptocurrencyUpdateScheduler {

    @Value(value = "${CoinLoreApi.URL}")
    public String URL;

    private final CryptocurrencyRepository cryptocurrencyRepository;

    @Autowired
    public CryptocurrencyUpdateScheduler(CryptocurrencyRepository cryptocurrencyRepository) {
        this.cryptocurrencyRepository = cryptocurrencyRepository;
    }

    @Scheduled(fixedRate = 60000)
    @Async
    public void update() throws IOException {
        URL url = new URL(URL);
        try (InputStream stream = url.openStream();
             InputStreamReader inputStreamReader = new InputStreamReader(stream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            StringBuilder jsonString = new StringBuilder();
            int line;
            while ((line = bufferedReader.read()) != -1) {
                jsonString.append((char) line);
            }
            System.out.println(jsonString);
            ObjectMapper objectMapper = new ObjectMapper();
            List<Cryptocurrency> cryptocurrencies = objectMapper
                    .readValue(jsonString.toString(), new TypeReference<>() {
                    });
            cryptocurrencyRepository.saveAll(cryptocurrencies);
        }
    }

}