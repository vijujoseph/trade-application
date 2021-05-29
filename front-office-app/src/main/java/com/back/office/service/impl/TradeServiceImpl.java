package com.back.office.service.impl;

import com.back.office.service.PublisherService;
import com.back.office.service.TradeService;
import com.trade.domain.TradeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Viju Joseph (vijujoseph@gmail.com)
 */
@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    private PublisherService publisherService;

    @Override
    public boolean tradeOrder(TradeDto trade) {
        publisherService.publishMessage(trade);
        return true;
    }
}
