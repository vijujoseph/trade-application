package com.back.office.consumer;

/**
 * @author Viju Joseph (vijujoseph@gmail.com)
 */

import com.back.office.exception.ApplicationException;
import com.back.office.service.TradeService;
import com.trade.domain.TradeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TradeConsumer {

    private static final Logger logger = LoggerFactory.getLogger(TradeConsumer.class);

    @Autowired
    private TradeService tradeService;

    @RabbitListener(queues = "trade_queue")
    public void consumeMessageFromQueue(TradeDto tradeDto) throws ApplicationException {
        logger.info("Received message from queue : " + tradeDto);
        try {
            tradeService.saveTradeOrder(tradeDto);
        } catch (Exception ex) {
            logger.error("Error handling the message : " + tradeDto);
            throw new ApplicationException();
        }
    }

   @RabbitListener(queues = "dlq_trade_queue")
    public void processParkingLotQueue(Message failedMessage) {
        logger.info("Received message in parking lot queue");
        // Save to DB or send a notification.
    }
}