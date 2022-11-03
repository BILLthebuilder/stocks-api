package com.hackerrank.stocktrade.repository;

import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TradeRepository extends JpaRepository<Trade,Long>{
Optional<List<Trade>> findByUserOrderByIdAsc(User user);
    List<Trade>  findAllByOrderByIdAsc();
    Optional<Trade> findTradesBySymbolAndTypeAndTimestamp(String symbol, String type, Date timestamp);
}