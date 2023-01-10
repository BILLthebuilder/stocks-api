package com.stocktrade.controller;

import com.stocktrade.dto.CreateTradeRequest;
import com.stocktrade.model.Trade;
import com.stocktrade.service.TradeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/trades")
public class TradesController {

    private final TradeService tradeService;

    public TradesController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @PostMapping
    public ResponseEntity<String>create(@RequestBody CreateTradeRequest request){
       return tradeService.createTrade(null,request);
    }

    @GetMapping(value="/{id}")
    private ResponseEntity<?> getTradeById(@PathVariable(value="id") Long id){
        return tradeService.findTradeById(id);

    }

    @PutMapping(value = "/{id}")
    private ResponseEntity<?>updateTrade(@PathVariable(value="id") Long id,@RequestBody CreateTradeRequest request){
        return tradeService.createTrade(id,request);
    }

    @GetMapping
    private ResponseEntity<List<Trade>>getAllTrades(){
        return tradeService.getAllTrades();

    }

    @GetMapping(value="/users/{UserId}")
    private ResponseEntity<List<Trade>> getTradeByUserId(@PathVariable(value="UserId") Long UserId ) {
        return tradeService.findTradeByUserId(UserId);

    }

    @GetMapping(value="/date/{date}")
    public ResponseEntity<?> findTradesByDate(@PathVariable(value = "date") String date) throws ParseException {
        return tradeService.findTradesByDatecreated(date);
    }
}
