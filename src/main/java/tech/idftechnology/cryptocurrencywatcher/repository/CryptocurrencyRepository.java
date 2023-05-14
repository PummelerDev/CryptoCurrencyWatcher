package tech.idftechnology.cryptocurrencywatcher.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.idftechnology.cryptocurrencywatcher.domain.Cryptocurrency;

import java.util.Optional;

@Repository
public interface CryptocurrencyRepository extends CrudRepository<Cryptocurrency, Long> {

    Optional<Cryptocurrency> findBySymbol(String symbol);

}