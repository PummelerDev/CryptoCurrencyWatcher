package tech.idftechnology.cryptocurrencywatcher.domain.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class CryptocurrencyDtoPrice {

    private String symbol;
    private BigDecimal price;

    public CryptocurrencyDtoPrice() {
    }

    public CryptocurrencyDtoPrice(String symbol, BigDecimal price) {
        this.symbol = symbol;
        this.price = price;
    }

    @Override
    public String toString() {
        return "CryptocurrencyDtoPrice{" +
                "symbol='" + symbol + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CryptocurrencyDtoPrice that = (CryptocurrencyDtoPrice) o;
        return Objects.equals(symbol, that.symbol) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, price);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
