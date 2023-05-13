package tech.idftechnology.cryptocurrencywatcher.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.idftechnology.cryptocurrencywatcher.domain.User;
import tech.idftechnology.cryptocurrencywatcher.domain.dto.UserDtoNotify;
import tech.idftechnology.cryptocurrencywatcher.domain.dto.UserDtoRegistration;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(nativeQuery = true,
            value = "insert into users(id, username, cryptocurrency_id, starting_price) values(default, :#{#notify.username}, (select id from cryptocurrencies where symbol =:#{#notify.symbol}), (select price_usd from cryptocurrencies where symbol =:#{#notify.symbol})) on conflict(username,cryptocurrency_id) do update set starting_price=(select price_usd from cryptocurrencies where symbol =:#{#notify.symbol}) returning *")
    Optional<User> registration(@Param("notify") UserDtoRegistration notify);

//    @Query(nativeQuery = true,
//            value = "select users.id, username, starting_price, symbol, price_usd from users join cryptocurrencies c on users.cryptocurrency_id = c.id where price_usd > users.starting_price + users.starting_price * 0.01 or price_usd < users.starting_price - users.starting_price * 0.01")
//    List<User> checkChanges();
    @Query(nativeQuery = true,
            value = "select * from users join cryptocurrencies c on users.cryptocurrency_id = c.id where price_usd > users.starting_price + users.starting_price * 0.01 or price_usd < users.starting_price - users.starting_price * 0.01")
    List<User> checkChanges();
}
