package tech.idftechnology.cryptocurrencywatcher.service;

import tech.idftechnology.cryptocurrencywatcher.domain.Cryptocurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.idftechnology.cryptocurrencywatcher.exceptions.CryptocurrencyNotFoundException;
import tech.idftechnology.cryptocurrencywatcher.repository.CryptocurrencyRepository;

import java.util.ArrayList;

@Service
public class CryptocurrencyService {

    private final CryptocurrencyRepository cryptocurrencyRepository;

    @Autowired
    public CryptocurrencyService(CryptocurrencyRepository cryptocurrencyRepository) {
        this.cryptocurrencyRepository = cryptocurrencyRepository;
    }

    public ArrayList<Cryptocurrency> getAllCrypts(){
        return (ArrayList<Cryptocurrency>) cryptocurrencyRepository.findAll();
    }

    public Cryptocurrency getPrice(String symbol) {
        return cryptocurrencyRepository.findBySymbol(symbol).orElseThrow(()-> new CryptocurrencyNotFoundException("Cryptocurrency with symbol " + symbol + " not found!"));
    }
}
