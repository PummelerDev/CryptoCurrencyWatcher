package tech.idftechnology.cryptocurrencywatcher.controller;

import tech.idftechnology.cryptocurrencywatcher.domain.Cryptocurrency;
import tech.idftechnology.cryptocurrencywatcher.service.CryptocurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cryptocurrency")
public class CryptocurrencyController {

    private final CryptocurrencyService cryptocurrencyService;

    @Autowired
    public CryptocurrencyController(CryptocurrencyService cryptocurrencyService) {
        this.cryptocurrencyService = cryptocurrencyService;
    }

    @GetMapping
    public ResponseEntity<List<Cryptocurrency>> getAllCrypts() {
        List<Cryptocurrency> cryptocurrencies = cryptocurrencyService.getAllCrypts();
        return new ResponseEntity<>(cryptocurrencies, HttpStatus.OK);
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<Cryptocurrency> getPrice(@PathVariable String symbol){
        Cryptocurrency cryptocurrency = cryptocurrencyService.getPrice(symbol);
        return new ResponseEntity<>(cryptocurrency, HttpStatus.OK);
    }
}
