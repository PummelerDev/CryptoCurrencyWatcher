package tech.idftechnology.cryptocurrencywatcher.domain.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Objects;

public class UserDtoRegistration {

    @NotBlank
    @Length(max = 50)
    @Pattern(regexp = "[A-z-_]+")
    private String username;

    @NotBlank
    @Length(max = 20)
    @Pattern(regexp = "[A-Z]+")
    private String symbol;

    public UserDtoRegistration(String username, String symbol) {
        this.username = username;
        this.symbol = symbol;
    }

    public UserDtoRegistration() {
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
        UserDtoRegistration that = (UserDtoRegistration) o;
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
