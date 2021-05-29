package com.back.office.service;

import com.trade.domain.TradeDto;

/**
 * @author Viju Joseph (vijujoseph@gmail.com)
 */
public interface PublisherService {

    boolean publishMessage(TradeDto trade);
}
