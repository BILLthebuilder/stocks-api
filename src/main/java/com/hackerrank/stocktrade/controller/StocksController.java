package com.hackerrank.stocktrade.controller;

import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.service.TradeService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/stocks")
public class StocksController {

    private final TradeService tradeService;

    public StocksController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @GetMapping(value="/{symbol}/{startDate}/{endDate}")
    public ResponseEntity<List<Trade>> getTradeByStockSymbolDateRange(@PathVariable(value = "symbol") String symbol, @PathVariable(value = "startDate") String startDate,
                                                                      @PathVariable(value = "endDate")String endDate) throws ParseException {
        return tradeService.findTradesBySymbolAndDateCreatedBetween(symbol,startDate,endDate);
    };
}
