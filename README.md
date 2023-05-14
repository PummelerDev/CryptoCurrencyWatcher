# Cryptocurrency Watcher
___
Project for IDF Technology

# Description:


This is the REST service for viewing cryptocurrency quotes. Allows the user to track changes in the price of a cryptocurrency from one percent. Change messages are output to the log console and log file (..rootProject\logs). The update happens once a minute.


# Database
The server works with PostgreSQL. The database has 3 tables. Cryptocurencies - stores data about cryptocurrency, that downloding from open API CoinLore. Users- stores username and cryptocurrency data they want to track. Also provided is the Flayway schema history table, which is responsible for checking database versions.


# User capabilities

Available endpoints:

"GET http://localhost:8080/cryptocurrency" – gets available cryptocurrencies for tracking with current price.

"GET http://localhost:8080/cryptocurrency/{cryptocurrencySymbol}" – gets the selected cryptocurrency with a price.

# Registration
To register a user, go to "POST http://localhost:8080/user/notify". It is also necessary to send json:( 
{
  "username": "testName",
  "symbol": "cryptocurrencySymbol"
} ).

Warning: if the user is already tracking the cryptocurrency, when requested again, the starting price will change to the current one.
