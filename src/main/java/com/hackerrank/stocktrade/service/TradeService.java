package com.hackerrank.stocktrade.service;

import com.hackerrank.stocktrade.dto.CreateTradeRequest;
import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.model.User;
import com.hackerrank.stocktrade.repository.TradeRepository;
import com.hackerrank.stocktrade.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
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
        User user = new User();
//        trade.setType(request.getType());
//        trade.setUser(request.getUser());
//        trade.setSymbol(request.getSymbol());
//        trade.setShares(request.getShares());
//        trade.setPrice(request.getPrice());
//        tradeRepository.save(trade);
        Optional<Trade> tradeFind = tradeRepository.findById(request.getId());
        if (!tradeFind.isPresent()) {
            userRepository.save(request.getUser());
                    trade.setType(request.getType());
        trade.setUser(request.getUser());
        trade.setSymbol(request.getSymbol());
        trade.setShares(request.getShares());
        trade.setPrice(request.getPrice());
        trade.setTimestamp(Timestamp.valueOf((String)request.getTimestamp()));
            tradeRepository.save(trade);
            return new ResponseEntity<>(HttpStatus.CREATED);

        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @Transactional
    public ResponseEntity<Trade> findTradeById(long id){
        if (tradeRepository.findById(id).isPresent()) {
            return new ResponseEntity<>(tradeRepository.findById(id).get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @Transactional
    public ResponseEntity<List<Trade>> getAllTrades(){
        return new ResponseEntity<>(tradeRepository.findAllByOrderByIdAsc(), HttpStatus.OK);
    }
    @Transactional
    public ResponseEntity<List<Trade>>  findTradeByUserId(long id){
        Optional<User> user = userRepository.findById(id);
        System.out.println("ISpresent>>>>>>>>"+user.get());
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
    public Optional<Trade> getTradeBySymbolTypeDate(String symbol, String type, Date timestamp){
        return tradeRepository.findTradesBySymbolAndTypeAndTimestamp(symbol,type,timestamp);
    }
    public void findByhighestLowestPrice(){

    }
}
