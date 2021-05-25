package com.back.office.controller;

import com.back.office.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Viju Joseph (vijujoseph@gmail.com)
 */
@RestController
public class TradeController {

    @Autowired
    private TradeRepository tradeRepository;

    @GetMapping("/trade/orders")
    public @ResponseBody
    ResponseEntity<Object> viewTradeOrders() {
        return new ResponseEntity<>(tradeRepository.findAll(), HttpStatus.OK);
    }
}
