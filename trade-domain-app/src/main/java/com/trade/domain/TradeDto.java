package com.trade.domain;

/**
 * @author Viju Joseph (vijujoseph@gmail.com)
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author Viju Joseph (vijujoseph@gmail.com)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TradeDto extends BaseRequest {

    @NotBlank(message = "tradeId is null or empty")
    private String tradeId;

    @NotNull(message = "version is null or empty")
    @Pattern(regexp = "\\d+", message = "version should match the regex (\\d+)")
    private String version;

    @NotBlank(message = "counterPartyId is null or empty")
    private String counterPartyId;

    @NotBlank(message = "bookId is null or empty")
    private String bookId;

    @NotNull(message = "maturityDate is null or empty")
    @Pattern(regexp = "\\d+", message = "maturityDate should match the regex (\\d+)")
    private String maturityDate;

    private boolean expired;

}