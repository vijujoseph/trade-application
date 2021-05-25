package com.back.office.service;

import com.back.office.entity.Trade;
import com.back.office.repository.TradeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

/**
 * @author Viju Joseph (vijujoseph@gmail.com)
 */
@SpringBootTest
public class TradeOrderServiceTest {

    @Autowired
    private TradeService systemUnderTest;

    @MockBean
    private TradeRepository tradeRepository;

    @Test
    @DisplayName("Test findAll with empty result")
    void testFindAllWithEmptyResult() {
        // Setup our mock repository
        doReturn(Collections.EMPTY_LIST).when(tradeRepository).findAll();

        // Execute the service call
        List<Trade> response = tradeRepository.findAll();

        // Assert the response
        assertEquals(response.size(), 0);
    }

}
