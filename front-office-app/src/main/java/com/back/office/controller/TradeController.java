package com.back.office.controller;

/**
 * @author Viju Joseph (vijujoseph@gmail.com)
 */

import com.back.office.exception.ApplicationException;
import com.back.office.service.TradeService;
import com.trade.domain.BaseResponse;
import com.trade.domain.TradeDto;
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
    public ResponseEntity<?> bookOrder(@Valid @RequestBody TradeDto trade, Errors errors) throws ApplicationException {

        try {
            validateRequest(trade, errors);
        } catch (ApplicationException ex) {
            return handleValidationErrors(new BaseResponse(), ex);
        }
        tradeService.tradeOrder(trade);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}