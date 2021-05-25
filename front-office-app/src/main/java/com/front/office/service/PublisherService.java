package com.front.office.service;

import com.front.office.dto.Trade;

/**
 * @author Viju Joseph (vijujoseph@gmail.com)
 */
public interface PublisherService {

    boolean publishMessage(Trade trade);
}
