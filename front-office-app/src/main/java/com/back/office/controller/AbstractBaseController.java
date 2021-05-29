package com.back.office.controller;

import com.back.office.exception.ApplicationException;
import com.trade.domain.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;

import java.io.Serializable;

/**
 * @author Viju Joseph (vijujoseph@gmail.com)
 */
public abstract class AbstractBaseController {

    protected <REQ extends Serializable> void validateRequest(REQ request, Errors errors) throws ApplicationException {
        StringBuilder errorMessage = new StringBuilder("request is invalid. ");
        if (errors.hasErrors()) {
            if(errors.hasGlobalErrors()) {
                errorMessage.append(errors.getGlobalError().getDefaultMessage());
            } else {
                errorMessage.append(errors.getFieldError().getDefaultMessage());
            }
            throw new ApplicationException(errorMessage.toString());
        }
    }

    protected <Res extends BaseResponse> ResponseEntity<Res> handleValidationErrors(Res response, ApplicationException ex) {
        BaseResponse responseMsg = new BaseResponse();
        responseMsg.setErrorResponseCode(HttpStatus.BAD_REQUEST.toString());
        responseMsg.setErrorDescription(ex.getResponseMessage());
        return (ResponseEntity<Res>) ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMsg);
    }

}
