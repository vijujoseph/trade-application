package com.front.office.controller;

/**
 * @author Viju Joseph (vijujoseph@gmail.com)
 */

import com.front.office.dto.BaseResponse;
import com.front.office.dto.Trade;
import com.front.office.exception.ApplicationException;
import com.front.office.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/trade")
public class TradeController extends AbstractBaseController {

    @Autowired
    private TradeService tradeService;

    @PostMapping("/order")
    public ResponseEntity<?> bookOrder(@Valid @RequestBody Trade trade,  Errors errors) throws ApplicationException {

        try {
            validateRequest(trade, errors);
        } catch (ApplicationException ex) {
            return handleValidationErrors(new BaseResponse(), ex);
        }
        tradeService.tradeOrder(trade);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}