package com.credibanco.service.impl;

import com.credibanco.dto.CreditCardDto;
import com.credibanco.entities.CreditCard;
import com.credibanco.service.CreditCardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreditCardImpl implements CreditCardService {
    @Override
    public CreditCardDto create(CreditCard creditCard) {
        return null;
    }
}
