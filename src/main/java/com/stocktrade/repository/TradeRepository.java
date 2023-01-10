package com.stocktrade.repository;

import com.stocktrade.model.Trade;
import com.stocktrade.model.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {

    Pageable sortedBySymbolAndDateCreated =
            PageRequest.of(0, 5, Sort.by("symbol").descending().and(Sort.by("date_created")));
    Optional<List<Trade>> findByUserOrderByIdAsc(User user);

    List<Trade> findAllByOrderByIdAsc();

    List<Trade> findTradeByDateCreated(Date date);
    List<Trade> findTradesBySymbolAndDateCreatedBetween(String symbol,Date startDate, Date endDate);
}