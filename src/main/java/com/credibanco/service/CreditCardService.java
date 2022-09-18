package com.credibanco.service;

import com.credibanco.dto.CreditCardDto;
import com.credibanco.entities.CreditCard;
import com.credibanco.exception.CreditCardException;

import java.util.List;

public interface CreditCardService {
    CreditCardDto create(CreditCard creditCard) throws CreditCardException;

    CreditCardDto findByNumberCardAndNumberValidation(Long numberCard, Integer numberValidation)throws CreditCardException;

    List<CreditCard> findByNumberCard(Long numberCard) throws CreditCardException;

    void delete(Long numberCard, Integer numberValidation)throws CreditCardException;


}
