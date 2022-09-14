package com.credibanco.exception;

import com.credibanco.utils.CreditCardError;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String id) {
        super(String.format(CreditCardError.RESOURCE_ERROR_TYPE_ID.getMessage() + id));
    }
}
