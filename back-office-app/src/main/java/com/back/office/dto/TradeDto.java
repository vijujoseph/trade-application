package com.back.office.dto;

/**
 * @author Viju Joseph (vijujoseph@gmail.com)
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Viju Joseph (vijujoseph@gmail.com)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TradeDto {

    private String tradeId;

    private String version;

    private String counterPartyId;

    private String bookId;

    private String maturityDate;

    private String createdDate;

    private boolean expired;

}