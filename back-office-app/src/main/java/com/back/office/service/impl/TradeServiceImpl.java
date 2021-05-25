package com.back.office.service.impl;

import com.back.office.dto.TradeDto;
import com.back.office.entity.Trade;
import com.back.office.repository.TradeRepository;
import com.back.office.service.TradeService;
import com.back.office.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Viju Joseph (vijujoseph@gmail.com)
 */
@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    private TradeRepository tradeRepository;

    @Override
    public boolean saveTradeOrder(TradeDto tradeDto) {
        Trade trade = populateTradeOrder(tradeDto);
        tradeRepository.save(trade);
        return true;
    }

    private Trade populateTradeOrder(TradeDto tradeDto) {
        Trade trade = new Trade();
        trade.setBookId(tradeDto.getBookId());
        trade.setTradeId(tradeDto.getTradeId());
        trade.setCounterPartyId(tradeDto.getCounterPartyId());
        trade.setExpired(tradeDto.isExpired());
        trade.setVersion(tradeDto.getVersion());
        trade.setMaturityDate(DateUtils.convertToTimeStamp(tradeDto.getMaturityDate()));
        trade.setCreatedDate(DateUtils.getCurrentTimeStampInUTC());
        System.out.println("Domain Trade saving : " + trade);
        return trade;
    }
}
