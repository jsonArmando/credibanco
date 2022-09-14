package com.credibanco.exception;

import com.credibanco.utils.CreditCardError;
import lombok.Getter;

@Getter
public class CreditCardException extends Exception{
    private final CreditCardError creditCardError;
    public CreditCardException(CreditCardError creditCardError){
        super(creditCardError == null ? null : creditCardError.getMessage());
        this.creditCardError = creditCardError;
    }
}
