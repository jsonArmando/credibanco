package com.credibanco.service;

import com.credibanco.dto.CreditCardDto;
import com.credibanco.entities.CreditCard;

public interface CreditCardService {
    CreditCardDto create(CreditCard creditCard);
}
