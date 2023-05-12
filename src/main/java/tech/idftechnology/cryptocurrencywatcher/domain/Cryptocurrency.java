package tech.idftechnology.cryptocurrencywatcher.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "cryptocurrency")
public class Cryptocurrency {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cryptocurrency_seq")
    @SequenceGenerator(name = "cryptocurrency_seq", sequenceName = "cryptocurrency_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "price")
    private BigDecimal price;

    public Cryptocurrency() {
    }

    public Cryptocurrency(Long id, String symbol, BigDecimal price) {
        this.id = id;
        this.symbol = symbol;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cryptocurrency that = (Cryptocurrency) o;
        return Objects.equals(id, that.id) && Objects.equals(symbol, that.symbol) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, symbol, price);
    }

    @Override
    public String toString() {
        return "Cryptocurrency{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", price=" + price +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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