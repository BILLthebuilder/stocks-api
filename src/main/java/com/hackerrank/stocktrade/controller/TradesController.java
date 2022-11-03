package com.hackerrank.stocktrade.controller;

import com.hackerrank.stocktrade.dto.CreateTradeRequest;
import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.service.TradeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
       return tradeService.createTrade(request);
    }

    @GetMapping(value="/{id}")
    private ResponseEntity<Trade> getTradeById(@PathVariable(value="id") Long id){
        return tradeService.findTradeById(id);

    }

    @GetMapping
    private ResponseEntity<List<Trade>>getAllTrades(){
        return tradeService.getAllTrades();

    }

    @GetMapping(value="/users/{UserId}")
    private ResponseEntity<List<Trade>> getTradeByUserId(@PathVariable(value="UserId") Long UserId ) {
        return tradeService.findTradeByUserId(UserId);

    }
}
