package com.back.office.repository;

import com.back.office.entity.Trade;
import com.back.office.utils.DateUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Viju Joseph (vijujoseph@gmail.com)
 */
@DataJpaTest
class TradeRepositoryTest {

    @Autowired
    private TradeRepository tradeRepository;

    @Test
    @DisplayName("Test save with valid result scenario")
    void testSaveAllWithValidResult() {
        List<Trade> initialData = populateTradeOrders();
        Trade trade = tradeRepository.save(initialData.get(0));

        // Assert the response
        assertEquals("4",trade.getVersion());
    }

    private List<Trade> populateTradeOrders() {
        List<Trade> trades = new ArrayList<>();
        Trade trade = new Trade();
        trade.setBookId("B4");
        trade.setTradeId("T4");
        trade.setCounterPartyId("CP-4");
        trade.setExpired(true);
        trade.setVersion("4");
        trade.setMaturityDate(DateUtils.convertToTimeStamp("1621891595261"));
        trade.setCreatedDate(DateUtils.getCurrentTimeStampInUTC());
        trades.add(trade);
        return trades;
    }

}
