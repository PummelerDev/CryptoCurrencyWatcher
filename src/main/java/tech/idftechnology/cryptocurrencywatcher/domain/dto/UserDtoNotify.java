package tech.idftechnology.cryptocurrencywatcher.domain.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class UserDtoNotify {
    private Long id;
    private String username;
    private String symbol;
    private BigDecimal startingPrise;
    private BigDecimal priceUsd;

    public UserDtoNotify() {
    }

    public UserDtoNotify(Long id, String username, String symbol, BigDecimal startingPrise, BigDecimal priceUsd) {
        this.id = id;
        this.username = username;
        this.symbol = symbol;
        this.startingPrise = startingPrise;
        this.priceUsd = priceUsd;
    }

    @Override
    public String toString() {
        return "UserDtoNotify{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", symbol='" + symbol + '\'' +
                ", startingPrise=" + startingPrise +
                ", priceUsd=" + priceUsd +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDtoNotify that = (UserDtoNotify) o;
        return Objects.equals(id, that.id) && Objects.equals(username, that.username) && Objects.equals(symbol, that.symbol) && Objects.equals(startingPrise, that.startingPrise) && Objects.equals(priceUsd, that.priceUsd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, symbol, startingPrise, priceUsd);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getStartingPrise() {
        return startingPrise;
    }

    public void setStartingPrise(BigDecimal startingPrise) {
        this.startingPrise = startingPrise;
    }

    public BigDecimal getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(BigDecimal priceUsd) {
        this.priceUsd = priceUsd;
    }
}
