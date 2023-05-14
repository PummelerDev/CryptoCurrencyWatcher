package tech.idftechnology.cryptocurrencywatcher.service;

import tech.idftechnology.cryptocurrencywatcher.domain.Cryptocurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.idftechnology.cryptocurrencywatcher.domain.dto.CryptocurrencyDtoPrice;
import tech.idftechnology.cryptocurrencywatcher.exceptions.CryptocurrencyNotFoundException;
import tech.idftechnology.cryptocurrencywatcher.mappers.CryptocurrencyMapper;
import tech.idftechnology.cryptocurrencywatcher.repository.CryptocurrencyRepository;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class CryptocurrencyService {

    private final CryptocurrencyRepository cryptocurrencyRepository;

    @Autowired
    public CryptocurrencyService(CryptocurrencyRepository cryptocurrencyRepository) {
        this.cryptocurrencyRepository = cryptocurrencyRepository;
    }

    public ArrayList<CryptocurrencyDtoPrice> getAllCrypts() {
        ArrayList<Cryptocurrency> cryptocurrencies = (ArrayList<Cryptocurrency>) cryptocurrencyRepository.findAll();
        if (cryptocurrencies.isEmpty()) {
            throw new CryptocurrencyNotFoundException("Cryptocurrencies not found!");
        }
        return (ArrayList<CryptocurrencyDtoPrice>) cryptocurrencies.stream()
                .map(CryptocurrencyMapper::mapCryptocurrencyToCryptocurrencyDtoPrice)
                .collect(Collectors.toList());
    }

    public CryptocurrencyDtoPrice getPrice(String symbol) {
        Cryptocurrency cryptocurrency =
                cryptocurrencyRepository.findBySymbol(symbol).orElseThrow(
                        () -> new CryptocurrencyNotFoundException(
                                "Cryptocurrency with symbol \"" + symbol + "\" not found!"));
        return CryptocurrencyMapper.mapCryptocurrencyToCryptocurrencyDtoPrice(cryptocurrency);
    }
}