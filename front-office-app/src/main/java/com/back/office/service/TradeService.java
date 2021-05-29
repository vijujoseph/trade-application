package com.back.office.service;

import com.trade.domain.TradeDto;

/**
 * @author Viju Joseph (vijujoseph@gmail.com)
 */
public interface TradeService {

    boolean tradeOrder(TradeDto trade);
}
