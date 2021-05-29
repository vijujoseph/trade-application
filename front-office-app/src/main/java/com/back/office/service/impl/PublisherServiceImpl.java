package com.back.office.service.impl;

import com.back.office.service.PublisherService;
import com.trade.domain.TradeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Viju Joseph (vijujoseph@gmail.com)
 */
@Service
public class PublisherServiceImpl implements PublisherService {

    private static final Logger logger = LoggerFactory.getLogger(PublisherServiceImpl.class);

    @Value("${trade.queue}")
    private String tradeQueue;

    @Value("${trade.exchange}")
    private String tradeExchange;

    @Value("${trade.route.key}")
    private String tradeRoutingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public boolean publishMessage(TradeDto trade) {
        logger.info("Publishing message to queue : " + trade);
        rabbitTemplate.convertAndSend(tradeExchange, tradeRoutingKey, trade);
        return true;
    }
}
