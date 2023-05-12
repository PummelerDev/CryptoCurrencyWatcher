package tech.idftechnology.cryptocurrencywatcher.domain;

import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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

    @Column(name = "name")
    private String name;

    @Column(name = "nameid")
    private String nameid;

    @Column(name = "rank")
    private Integer rank;

    @Column(name = "price_usd")
    @JsonSetter(value = "price_usd")
    private String priceUsd;

    @Column(name = "percent_change_24h")
    @JsonSetter(value = "percent_change_24h")
    private String percentChange24h;

    @Column(name = "percent_change_1h")
    @JsonSetter(value = "percent_change_1h")
    private String percentChange1h;

    @Column(name = "percent_change_7d")
    @JsonSetter(value = "percent_change_7d")
    private String percentChange7d;

    @Column(name = "market_cap_usd")
    @JsonSetter(value = "market_cap_usd")
    private String marketCapUsd;

    @Column(name = "volume24")
    private String volume24;

    @Column(name = "volume24_native")
    @JsonSetter(value = "volume24_native")
    private String volume24native;

    @Column(name = "csupply")
    private String csupply;

    @Column(name = "price_btc")
    @JsonSetter(value = "price_btc")
    private String priceBtc;

    @Column(name = "tsupply")
    private String tsupply;

    @Column(name = "msupply")
    private String msupply;

    public Cryptocurrency() {
    }

    public Cryptocurrency(Long id, String symbol, String name, String nameid, Integer rank, String priceUsd, String percentChange24h, String percentChange1h, String percentChange7d, String marketCapUsd, String volume24, String volume24native, String csupply, String priceBtc, String tsupply, String msupply) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.nameid = nameid;
        this.rank = rank;
        this.priceUsd = priceUsd;
        this.percentChange24h = percentChange24h;
        this.percentChange1h = percentChange1h;
        this.percentChange7d = percentChange7d;
        this.marketCapUsd = marketCapUsd;
        this.volume24 = volume24;
        this.volume24native = volume24native;
        this.csupply = csupply;
        this.priceBtc = priceBtc;
        this.tsupply = tsupply;
        this.msupply = msupply;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cryptocurrency that = (Cryptocurrency) o;
        return Objects.equals(id, that.id) && Objects.equals(symbol, that.symbol) && Objects.equals(name, that.name) && Objects.equals(nameid, that.nameid) && Objects.equals(rank, that.rank) && Objects.equals(priceUsd, that.priceUsd) && Objects.equals(percentChange24h, that.percentChange24h) && Objects.equals(percentChange1h, that.percentChange1h) && Objects.equals(percentChange7d, that.percentChange7d) && Objects.equals(marketCapUsd, that.marketCapUsd) && Objects.equals(volume24, that.volume24) && Objects.equals(volume24native, that.volume24native) && Objects.equals(csupply, that.csupply) && Objects.equals(priceBtc, that.priceBtc) && Objects.equals(tsupply, that.tsupply) && Objects.equals(msupply, that.msupply);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, symbol, name, nameid, rank, priceUsd, percentChange24h, percentChange1h, percentChange7d, marketCapUsd, volume24, volume24native, csupply, priceBtc, tsupply, msupply);
    }

    @Override
    public String toString() {
        return "Cryptocurrency{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", nameid='" + nameid + '\'' +
                ", rank=" + rank +
                ", priceUsd='" + priceUsd + '\'' +
                ", percentChange24h='" + percentChange24h + '\'' +
                ", percentChange1h='" + percentChange1h + '\'' +
                ", percentChange7d='" + percentChange7d + '\'' +
                ", marketCapUsd='" + marketCapUsd + '\'' +
                ", volume24='" + volume24 + '\'' +
                ", volume24native='" + volume24native + '\'' +
                ", csupply='" + csupply + '\'' +
                ", priceBtc='" + priceBtc + '\'' +
                ", tsupply='" + tsupply + '\'' +
                ", msupply='" + msupply + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameid() {
        return nameid;
    }

    public void setNameid(String nameid) {
        this.nameid = nameid;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(String priceUsd) {
        this.priceUsd = priceUsd;
    }

    public String getPercentChange24h() {
        return percentChange24h;
    }

    public void setPercentChange24h(String percentChange24h) {
        this.percentChange24h = percentChange24h;
    }

    public String getPercentChange1h() {
        return percentChange1h;
    }

    public void setPercentChange1h(String percentChange1h) {
        this.percentChange1h = percentChange1h;
    }

    public String getPercentChange7d() {
        return percentChange7d;
    }

    public void setPercentChange7d(String percentChange7d) {
        this.percentChange7d = percentChange7d;
    }

    public String getMarketCapUsd() {
        return marketCapUsd;
    }

    public void setMarketCapUsd(String marketCapUsd) {
        this.marketCapUsd = marketCapUsd;
    }

    public String getVolume24() {
        return volume24;
    }

    public void setVolume24(String volume24) {
        this.volume24 = volume24;
    }

    public String getVolume24native() {
        return volume24native;
    }

    public void setVolume24native(String volume24native) {
        this.volume24native = volume24native;
    }

    public String getCsupply() {
        return csupply;
    }

    public void setCsupply(String csupply) {
        this.csupply = csupply;
    }

    public String getPriceBtc() {
        return priceBtc;
    }

    public void setPriceBtc(String priceBtc) {
        this.priceBtc = priceBtc;
    }

    public String getTsupply() {
        return tsupply;
    }

    public void setTsupply(String tsupply) {
        this.tsupply = tsupply;
    }

    public String getMsupply() {
        return msupply;
    }

    public void setMsupply(String msupply) {
        this.msupply = msupply;
    }
}