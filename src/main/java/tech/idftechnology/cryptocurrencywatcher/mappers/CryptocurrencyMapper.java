package tech.idftechnology.cryptocurrencywatcher.mappers;

import tech.idftechnology.cryptocurrencywatcher.domain.Cryptocurrency;
import tech.idftechnology.cryptocurrencywatcher.domain.dto.CryptocurrencyDtoPrice;

public class CryptocurrencyMapper {

    public static CryptocurrencyDtoPrice mapCryptocurrencyToCryptocurrencyDtoPrice(Cryptocurrency cryptocurrency) {
        CryptocurrencyDtoPrice price = new CryptocurrencyDtoPrice();
        price.setPrice(cryptocurrency.getPriceUsd());
        price.setSymbol(cryptocurrency.getSymbol());
        return price;
    }

}