package com.hackerrank.stocktrade.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerrank.stocktrade.dto.CreateTradeRequest;
import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.model.User;
import com.hackerrank.stocktrade.repository.TradeRepository;
import com.hackerrank.stocktrade.repository.UserRepository;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class TradeService {
    private final TradeRepository tradeRepository;

    private final UserRepository userRepository;

    public TradeService(TradeRepository tradeRepository, UserRepository userRepository){
        this.tradeRepository = tradeRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void deleteAll(){
        Trade trade= new Trade();
        tradeRepository.deleteAll();
    }
    @Transactional
    public ResponseEntity<String> createTrade(CreateTradeRequest request){
        Trade trade = new Trade();
        //Optional<Trade> tradeFind = tradeRepository.findById(trade.getId());
        if (!(request == null)) {
            userRepository.save(request.getUser());
                    trade.setType(request.getType());
        trade.setUser(request.getUser());
        trade.setSymbol(request.getSymbol());
        trade.setShares(request.getShares());
        trade.setPrice(request.getPrice());
        //trade.setTimestamp(Timestamp.valueOf((String)request.getTimestamp()));
            tradeRepository.save(trade);
            return new ResponseEntity<>(HttpStatus.CREATED);

        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @Transactional
    public ResponseEntity<?> findTradeById(long id){
        if (tradeRepository.findById(id).isPresent()) {
            return new ResponseEntity<>(tradeRepository.findById(id).get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @Transactional
    public ResponseEntity<List<Trade>> getAllTrades(){
        return new ResponseEntity<>(tradeRepository.findAllByOrderByIdAsc(), HttpStatus.OK);
    }

//    @Transactional
//    public ResponseEntity<?> getAllTrades() throws JsonProcessingException {
//        List<Trade> allTrades = tradeRepository.findAllByOrderByIdAsc();
//        String payload = new ObjectMapper().writeValueAsString(allTrades);
//        return new ResponseEntity<>(payload, HttpStatus.OK);
//    }
    @Transactional
    public ResponseEntity<List<Trade>>  findTradeByUserId(long id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            Optional<List<Trade>> trade = tradeRepository.findByUserOrderByIdAsc(user.get());
            if (trade.isPresent())
                return new ResponseEntity<>(trade.get(), HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

@Transactional
    public ResponseEntity<List<Trade>> findTradesBySymbolAndDateCreatedBetween(String symbol, String startDate, String endDate) throws ParseException {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    Date startDate_ = formatter.parse(startDate);
    Date endDate_ = formatter.parse(endDate);
    Pageable pageable = PageRequest.of(0, 3);
    List<Trade> trades = tradeRepository.findTradesBySymbolAndTypeAndDateCreated(symbol,startDate_,endDate_);
    if(!trades.isEmpty()){
        return new ResponseEntity<>(trades,HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
};
}
