package com.credibanco.service;

import com.credibanco.dto.CreditCardDto;
import com.credibanco.entities.CreditCard;
import com.credibanco.exception.CreditCardException;

public interface CreditCardService {
    CreditCardDto create(CreditCard creditCard) throws CreditCardException;
}
