package com.front.office.exception;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Viju Joseph (vijujoseph@gmail.com)
 */
@Data
@NoArgsConstructor
@ToString
public class ApplicationException extends Throwable {

    private String responseMessage;

    public ApplicationException(String errorMessage) {
        super();
        this.responseMessage = errorMessage;
    }

}
