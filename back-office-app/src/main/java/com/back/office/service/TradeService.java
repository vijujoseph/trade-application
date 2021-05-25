package com.back.office.service;

import com.back.office.dto.TradeDto;

/**
 * @author Viju Joseph (vijujoseph@gmail.com)
 */
public interface TradeService {

    boolean saveTradeOrder(TradeDto tradeDto);
}
