package com.front.office.service.impl;

import com.front.office.dto.Trade;
import com.front.office.service.PublisherService;
import com.front.office.service.TradeService;
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
    public boolean tradeOrder(Trade trade) {
        publisherService.publishMessage(trade);
        return true;
    }
}
