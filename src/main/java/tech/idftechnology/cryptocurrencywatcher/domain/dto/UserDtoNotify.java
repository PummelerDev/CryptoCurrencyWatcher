package tech.idftechnology.cryptocurrencywatcher.domain.dto;

import java.util.Objects;

public class UserDtoNotify {
    private String username;
    private String symbol;

    public UserDtoNotify(String username, String symbol) {
        this.username = username;
        this.symbol = symbol;
    }

    public UserDtoNotify() {
    }

    @Override
    public String toString() {
        return "UserDtoNotify{" +
                "username='" + username + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDtoNotify that = (UserDtoNotify) o;
        return Objects.equals(username, that.username) && Objects.equals(symbol, that.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, symbol);
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
}
