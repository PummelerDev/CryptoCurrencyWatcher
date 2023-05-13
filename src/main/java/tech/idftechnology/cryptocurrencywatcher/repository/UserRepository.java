package tech.idftechnology.cryptocurrencywatcher.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.idftechnology.cryptocurrencywatcher.domain.User;
import tech.idftechnology.cryptocurrencywatcher.domain.dto.UserDtoNotify;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(nativeQuery = true,
            value = "insert into users(id, username, cryptocurrency_id, starting_price) values(default, :#{#notify.username}, (select id from cryptocurrencies where symbol =:#{#notify.symbol}), (select price_usd from cryptocurrencies where symbol =:#{#notify.symbol})) on conflict(username,cryptocurrency_id) do update set starting_price=(select price_usd from cryptocurrencies where symbol =:#{#notify.symbol}) returning *")
    Optional<User> notify(@Param("notify") UserDtoNotify notify);
}
