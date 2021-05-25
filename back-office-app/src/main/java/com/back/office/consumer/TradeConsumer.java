package com.back.office.consumer;

/**
 * @author Viju Joseph (vijujoseph@gmail.com)
 */

import com.back.office.dto.TradeDto;
import com.back.office.service.TradeService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TradeConsumer {

    @Autowired
    private TradeService tradeService;

    @RabbitListener(queues = "trade_queue")
    public void consumeMessageFromQueue(TradeDto tradeDto) {
        System.out.println("Message received from queue : " + tradeDto);
        tradeService.saveTradeOrder(tradeDto);
    }
}