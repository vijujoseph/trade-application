package com.trade.domain;

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
public class BaseResponse {

    private String errorResponseCode;

    private String errorDescription;

}
