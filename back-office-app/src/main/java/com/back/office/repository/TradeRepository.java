package com.back.office.repository;

import com.back.office.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Viju Joseph (vijujoseph@gmail.com)
 */
@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {

}
